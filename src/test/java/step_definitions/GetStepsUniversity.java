package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.google.gson.Gson;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import mapeo.Universities;


public class GetStepsUniversity {
	
	boolean existe = false; 
	
	String URL = "http://universities.hipolabs.com/search?country=United+States";
	
	String buscar = "Brandman University";
	
	Gson gson = new Gson();
			
	RequestSpecification reqSpec = new RequestSpecBuilder().
											setBaseUri(URL).	                        
											build();
	
	@Given("hago una llamada GET al endpoint \\/search?country=United+States")
	public void hago_una_llamada_GET_al_endpoint_search_country_United_States() {
		
		Response respuesta = 
				
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
	public void el_status_code_es() {
	    
	}

	@Then("me trae la universidad Brandman University")
	public void me_trae_la_universidad_Brandman_University() {
		
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
