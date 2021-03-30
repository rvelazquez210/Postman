package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class PUTStepsAltualizarLibro {
	
	String URL = "https://cursoapitesting2.getsandbox.com:443";
	
	Response respuesta;
	
    RequestSpecification requestSpec = new RequestSpecBuilder().
            setBaseUri(URL).
            setContentType(ContentType.JSON).
            build();
	
	@Given("hago una llamada PUT al endpoint \\/libros\\/nombre_libro")
	public void hago_una_llamada_PUT_al_endpoint_libros_nombre_libro() {
		
		respuesta = 
	    		
	    		given().
	            header("Content-type", "application/json").
	            and().
	            body("{\"nombre_libro\": \"Prueba_Raul3\"}" + "{\"total_pagados\": \"4312\"}").
	            when().
	            put("/libros/Prueba_Raul").
	            then().
	            extract().response();
	}

	@When("actualizo las keys nombre_libro y total_pagos")
	public void actualizo_las_keys_nombre_libro_y_total_pagos() {
		
		assertEquals(200, respuesta.getStatusCode(), "El status code es diferente al esperado: " + respuesta.getStatusCode() );

		System.out.println("\t El status code es: " + respuesta.getStatusCode()+"\t");
		
	}

	@When("el status code devuelto es dociento")
	public void el_status_code_devuelto_es_dociento() {

	}

	@Then("se actualiza el registro")
	public void se_actualiza_el_registro() {
				
	}

}
