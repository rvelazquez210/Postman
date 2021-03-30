package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertFalse;

import org.junit.jupiter.api.Assertions;

import com.google.gson.Gson;

public class DELETEStepsUnicoLibro {
	
	String eliminar = "PruebaRaul";
	
	String URL = "https://cursoapitesting2.getsandbox.com:443";
	
	Gson gson = new Gson();
	
	Response respuesta;
	
    RequestSpecification reqSpec = new RequestSpecBuilder().
            setBaseUri(URL).
            setContentType(ContentType.JSON).
            build();
	
	@Given("hago una llamada DELETE al endpoint \\/libors")
	public void hago_una_llamada_DELETE_al_endpoint_libors() {
		
		respuesta =
				
				given().
				spec(reqSpec).
				when().
				delete("/libros/" + eliminar).
				then().
				extract().
				response();
		
		System.out.println("\n\tDELETE Responde: " + respuesta.body().asString() + "\t\n");
		
	}

	@When("la respuesta envia status code es docientos")
	public void la_respuesta_envia_status_code_es_docientos() {
		
		Assertions.assertEquals(200, respuesta.getStatusCode(), "\n\tEl status code es diferente al esperado: " + respuesta.getStatusCode() + "\t\n");
		
		System.out.println("\n\t El status code es: " + respuesta.getStatusCode() + "\t\n");
		
	}

	@Then("se elimina el registro")
	public void se_elimina_el_registro() {
		
		respuesta = 
				
				given().
				spec(reqSpec).
				when().
				get("/libros/" + eliminar).
				then().
				extract().
				response();
				
		String body=respuesta.getBody().asString();
		
		assertFalse(body.contains(eliminar));
		
		System.out.println("\n\t GET Responde: " + respuesta.body().asString() + "\t\n");
				
	}

}
