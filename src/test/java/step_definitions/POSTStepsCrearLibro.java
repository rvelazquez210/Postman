package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.*;
import mapeo.Libros.Libros;
import mapeo.Libros.LibrosDetalles;
import mapeo.Libros.LibrosPagados;
import mapeo.Libros.LibrosReservado;
import mapeo.Libros.LibrosStock;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.testng.Assert.assertEquals;

import org.json.simple.JSONObject;
import org.junit.jupiter.api.Assertions;

import com.google.gson.Gson;
import static io.restassured.RestAssured.*;

public class POSTStepsCrearLibro {
	
	String existe = "Prueba_Raul";
	
	String URL = "https://cursoapitesting2.getsandbox.com:443";
	
	Gson gson = new Gson();
	
	Response respuesta;
		
	private RequestSpecification reqSpec = new RequestSpecBuilder().
	            setBaseUri(URL).
	            setContentType(ContentType.JSON).
	            build();
	
	@Given("hago una llamada POST al endpoint \\/libros")
	public void hago_una_llamada_POST_al_endpoint_libros() {

		Libros cuerpo = new Libros(existe, 
							new LibrosDetalles(20, "test", 
									new LibrosStock(30, 
											new LibrosReservado(13, 
													new LibrosPagados(7)))));
		/*JSONObject body = new JSONObject();
		
		body.put("nombre_libro", "testRaul");
		body.put(cuerpo, body)*/
			
		respuesta =
								
				given().
				spec(reqSpec).
				body(cuerpo).
				when().
				post("/libros").
				then().
				extract().
				response();
						
		System.out.println("\n\tPOST Responde: " + respuesta.body().asString() + "\t\n");
	
	}

	@When("envio el json con el nuevo registro")
	public void envio_el_json_con_el_nuevo_registro() {

	}

	@When("la respuesta es status code docientos")
	public void la_respuesta_es_status_code_docientos() {
		
		Assertions.assertEquals(200, respuesta.getStatusCode(), "\n\tEl status code es diferente al esperado: " + respuesta.getStatusCode() + "\t\n");
				
		System.out.println("\n\tEl status code es: " + respuesta.getStatusCode()+ "\t\n");
	}

	@Then("verifica que se creo el registro con exito")
	public void verifica_que_se_creo_el_registro_con_exito() {
		
		respuesta = 
				
				given().
				spec(reqSpec).
				when().
				get("/libros/" + existe).
				then().
				extract().
				response();
				
		Libros libro = gson.fromJson(respuesta.getBody().asString(), Libros.class);
		
		assertEquals(existe, libro.getNombre_libro());
		
		System.out.println("\n\t El nombre del libro es: " + libro.getNombre_libro() + "\t\n");
		
	}

}
