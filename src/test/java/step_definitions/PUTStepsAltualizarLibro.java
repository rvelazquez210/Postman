package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import mapeo.Libros.Libros;
import mapeo.Libros.LibrosDetalles;
import mapeo.Libros.LibrosPagados;
import mapeo.Libros.LibrosReservado;
import mapeo.Libros.LibrosStock;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.testng.Assert.assertEquals;

import com.google.gson.Gson;

import org.junit.jupiter.api.Assertions;

public class PUTStepsAltualizarLibro {
	
	String URL = "https://cursoapitesting2.getsandbox.com:443";
	
	String existe = "NuevoNombreLibro4";
	
	int pagado = 70;

	Gson gson = new Gson();
	
	String prueba;
		
	Response respuesta;
	
    RequestSpecification requestSpec = new RequestSpecBuilder().
            setBaseUri(URL).
            setContentType(ContentType.JSON).
            build();
	
	@Given("hago una llamada PUT al endpoint \\/libros\\/nombre_libro")
	public void hago_una_llamada_PUT_al_endpoint_libros_nombre_libro() {
		
		Libros cuerpo = new Libros(existe, 
				new LibrosDetalles(20, "test", 
						new LibrosStock(30, 
								new LibrosReservado(13, 
										new LibrosPagados(pagado)))));
		
		/*-----OTRA OPCION-----
		 * 
		 * JSONObject nuevoLibro = new JSONObject();
		
		nuevoLibro.put("nombre_libro", "NuevoNombreLibro1");
		nuevoLibro.put("total_pagados", 210);*/
		
		respuesta = 
	    		
	    		given().
	    		spec(requestSpec).
	            header("Content-type", "application/json").
	            and().
	            body(cuerpo).
	            when().
	            put("/libros/NuevoNombreLibro3").
	            then().
	            extract().response();
		
	}

	@When("actualizo las keys nombre_libro y total_pagos")
	public void actualizo_las_keys_nombre_libro_y_total_pagos() {
				
	}

	@When("el status code devuelto es dociento")
	public void el_status_code_devuelto_es_dociento() {
		
		Assertions.assertEquals(200, respuesta.getStatusCode(), "\n\tEl status code es diferente al esperado: " + respuesta.getStatusCode() + "\t\n");
		
		System.out.println("\n\tEl status code es: " + respuesta.getStatusCode()+ "\t\n");
		
	}

	@Then("se actualiza el registro")
	public void se_actualiza_el_registro() {
		
		respuesta = 
				
				given().
				spec(requestSpec).
				when().
				get("/libros/" + existe).
				then().
				extract().
				response();
				
		Libros libro = gson.fromJson(respuesta.getBody().asString(), Libros.class);
		
		assertEquals(existe, libro.getNombre_libro());
		
		System.out.println("\n\t El nombre del libro es: " + libro.getNombre_libro() + "\t\n");
		
	}

}
