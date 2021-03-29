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
	
	String existe = "/test77";
	
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
				get("/libros" + existe).
				then().
				statusCode(200).
				extract().response();
						
	}
	
	@When("la respuesta es devuelta el status code es docientos")
	public void la_respuesta_es_devuelta_el_status_code_es() {
	
		assertEquals(200, respuesta.getStatusCode(), "El status code es diferente al esperado: " + respuesta.getStatusCode() );

		System.out.println("\t Status code es: " + respuesta.getStatusCode()+"\t");
		
	}
	
	@Then("me trae el libro especificado")
	public void me_trae_el_libro_especificado() {
		
		String object = respuesta.getBody().asString();
	
		Libros libro = gson.fromJson(object, Libros.class);
		
		assertEquals("test77", libro.getNombre_libro());
		
		System.out.println("\n\t El nombre del libro es: " + libro.getNombre_libro());		
	}

}
