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

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.json.simple.JSONObject;

import com.google.gson.Gson;

import static io.restassured.RestAssured.*;

public class POSTStepsCrearLibro {
	
	boolean existe = false;
	
	String URL = "https://cursoapitesting2.getsandbox.com:443";
	
	Gson gson = new Gson();
	
	Response respuesta;
		
	private RequestSpecification reqSpec = new RequestSpecBuilder().
	            setBaseUri(URL).
	            setContentType(ContentType.JSON).
	            build();
	
	@Given("hago una llamada POST al endpoint \\/libros")
	public void hago_una_llamada_POST_al_endpoint_libros() {

		Libros cuerpo = new Libros("Arbol3", 
							new LibrosDetalles(20, "test", 
									new LibrosStock(30, 
											new LibrosReservado(13, 
													new LibrosPagados(7)))));
			
		respuesta =
								
				given().
				spec(reqSpec).
				body(cuerpo).
				when().
				post("/libros").
				then().
				assertThat()
				.statusCode(200).
				extract().
				response();
						
		System.out.println("POST Responde: " + respuesta.body().asString());
	}

	@When("envio el json con el nuevo registro")
	public void envio_el_json_con_el_nuevo_registro() {

	}

	@When("la respuesta es status code docientos")
	public void la_respuesta_es_status_code_docientos() {
		
		assertEquals(200, respuesta.getStatusCode(), "El status code es diferente al esperado: " + respuesta.getStatusCode() );

		System.out.println("\t El status code es: " + respuesta.getStatusCode()+"\t");
	}

	@Then("verifica que se creo el registro con exito")
	public void verifica_que_se_creo_el_registro_con_exito() {
		
		/*String buscar = "arbol7";
		
		Libros[] libro = gson.fromJson(respuesta.getBody().asString(), Libros[].class);
		 
		List<Libros> lista = Arrays.asList(libro);
			
		for (int x = 0; x < lista.size(); x++) {
			
			Libros p = lista.get(x);
			
			if (p.getNombre_libro().equals(buscar)) {
								
				existe = true;
				
				break;
			}
		}
		
		assertTrue("El libro no fue encontrada", existe);
	
	*/	
	}

}
