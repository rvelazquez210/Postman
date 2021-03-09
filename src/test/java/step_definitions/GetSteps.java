package step_definitions;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.Array;
import java.util.ArrayList;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.Utils;


public class GetSteps {
	
	Response res;
	
	private static RequestSpecification requestSpec =
														new RequestSpecBuilder().
											            setBaseUri(Utils.BASE_URI).
											            setContentType(ContentType.JSON).	            
											            build();
	
	@Given("^hago una llamada GET al endpoint \\/users")
	public void get() {
		
		 res = 
				given().
				spec(requestSpec).
				when().
				get("/users").
				then().
				extract().response();
		
	}
	
	@When("^la respuesta es devuelta el status code es 200")
	public void validacionStatusCode() {
		assertEquals(200, res.getStatusCode(), "El status code es diferente al esperado: " + res.getStatusCode() );
		System.out.println("\t Status code obtenido => " + res.getStatusCode());
	}
	
	@Then("^me trae todos los user existentes")
	public void validacionBodyResponse() {
		
		assertNotNull(res.getBody().asString());
		System.out.println("\\tBody response ==>:  "+ res.getBody().asString());
	}
		
	

}
