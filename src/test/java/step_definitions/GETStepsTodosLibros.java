package step_definitions;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GETStepsTodosLibros {
	
	String URL = "https://cursoapitesting2.getsandbox.com:443/libros";

	RequestSpecification reqSpec = new RequestSpecBuilder().
	            setBaseUri(URL).	                        
	            build();			
		
	Response respuesta;
	
	@Given("hago una llamada GET al endpoint \\/libros")
	public void hago_una_llamada_GET_al_endpoint_libros() {
	    
		respuesta = 
				
				given().
				spec(reqSpec).
				when().
				get().
				then().
				statusCode(200).
				extract().
				response();
		
	}

	@When("la respuesta es devuelta el status code es 200")
	public void la_respuesta_es_devuelta_el_status_code_es() {
	
		assertEquals(200, respuesta.getStatusCode(), "El status code es diferente al esperado: " + respuesta.getStatusCode() );

		System.out.println("\t Status code es: " + respuesta.getStatusCode()+"\t");
		
	}

	@Then("me trae todos los user existentes")
	public void me_trae_todos_los_user_existentes() {
		
		assertNotNull(respuesta.getBody().asString());

		System.out.println("\t Body response ==>:  "+ respuesta.getBody().asString()+"\t");
	}

}
