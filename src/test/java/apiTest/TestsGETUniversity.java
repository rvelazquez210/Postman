package apiTest;

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

public class TestsGETUniversity {
	
	boolean existe = false;
	
	@Test
	public void getUniversities() {
		
		String URL = "http://universities.hipolabs.com/search?country=United+States";
		
		String buscar = "Brandman University";
		
		Gson gson = new Gson();
				
		RequestSpecification reqSpec;
		
		reqSpec = new RequestSpecBuilder().
	            setBaseUri(URL).	                        
	            build();			
		
		Response respuesta = 
				
				given().
				spec(reqSpec).
				when().
				get().
				then().
				statusCode(200).
				extract().
				response();
		
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
