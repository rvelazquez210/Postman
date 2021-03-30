package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DELETEStepsUnicoLibro {
	
	String eliminar= "Arbol2";
	
	String URL = "https://cursoapitesting2.getsandbox.com:443";
	
	Response respuesta;
	
    RequestSpecification requestSpec = new RequestSpecBuilder().
            setBaseUri(URL).
            setContentType(ContentType.JSON).
            build();
	
	@Given("hago una llamada DELETE al endpoint \\/libors")
	public void hago_una_llamada_DELETE_al_endpoint_libors() {
		
		respuesta =
				
				given().
				spec(requestSpec).
				when().
				delete("/libros/" + eliminar).
				then().
				extract().
				response();
		
	}

	@When("la respuesta envia status code es docientos")
	public void la_respuesta_envia_status_code_es_docientos() {
		
		assertEquals(200, respuesta.statusCode());
		
	}

	@Then("se elimina el registro")
	public void se_elimina_el_registro() {
		
		String body=respuesta.getBody().asString();
		
		assertTrue(body.contains(eliminar));
				
	}

}
