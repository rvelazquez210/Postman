package step_definitions;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.google.gson.Gson;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import mapeo.Libros.Libros;

public class GETStepsUnicoLibro {
	
	String existe = "PruebaRaul";
	
	String URL = "https://cursoapitesting2.getsandbox.com:443";
	
	Gson gson = new Gson();

	RequestSpecification reqSpec = new RequestSpecBuilder().
	            setBaseUri(URL).	                        
	            build();			
		
	Response respuesta;
	
	@Given("hago una llamada GET al endpoint \\/libros\\/nombre_libro")
	public void hago_una_llamada_GET_al_endpoint_libros() {
		
		respuesta = 
				
				given().
				spec(reqSpec).
				when().
				get("/libros/" + existe).
				then().
				extract().
				response();
		
		System.out.println("\n\tGET Responde: " + respuesta.body().asString() + "\t\n");
						
	}
	
	@When("la respuesta es devuelta el status code es docientos")
	public void la_respuesta_es_devuelta_el_status_code_es() {
	
		assertEquals(200, respuesta.getStatusCode(), "\n\tEl status code es diferente al esperado: " + respuesta.getStatusCode() + "\t\n");

		System.out.println("\n\tStatus code es: " + respuesta.getStatusCode() + "\t\n");
		
	}
	
	@Then("me trae el libro especificado")
	public void me_trae_el_libro_especificado() {
		
		String object = respuesta.getBody().asString();
	
		Libros libro = gson.fromJson(object, Libros.class);
		
		assertEquals(existe, libro.getNombre_libro());
		
		System.out.println("\n\t El nombre del libro es: " + libro.getNombre_libro() + "\t\n");		
	
	}

}
