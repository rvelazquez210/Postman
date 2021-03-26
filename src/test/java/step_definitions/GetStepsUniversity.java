package step_definitions;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import mapeo.Universities;

public class GetStepsUniversity {
	
	
	String URL = "http://universities.hipolabs.com/search?country=United+States";

	RequestSpecification reqSpec = new RequestSpecBuilder().
	            setBaseUri(URL).	                        
	            build();			
		
	Response respuesta;
			
	@Given("hago una llamada GET al endpoint")
	public void hago_una_llamada_GET_al_endpoint() {
	
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

	@When("envio el request")
	public void envio_el_request() {

	}

	@When("el status code es docientos")
	public void el_status_code_es_docientos() {
	
		assertEquals(200, respuesta.getStatusCode(), "El status code es diferente al esperado: " + respuesta.getStatusCode() );

		System.out.println("\t Status code es: " + respuesta.getStatusCode()+"\t");
		
	}

	@Then("me trae la universidad Brandman University")
	public void me_trae_la_universidad_Brandman_University() {
		
		String buscar = "Brandman University";
		
		boolean existe = false;
		
		Gson gson = new Gson();	
		
		Universities[] universidad = gson.fromJson(respuesta.getBody().asString(), Universities[].class);
		 
		List<Universities> lista = Arrays.asList(universidad);
				
		for (int x = 0; x < lista.size(); x++) {
				
			Universities p = lista.get(x);
				
			if (p.getName().equals(buscar)) {
									
				existe = true;
					
				break;
			}
		}
			
			assertTrue("La universidad no fue encontrada", existe);	
		
		
	}

}
