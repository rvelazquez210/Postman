package apiTest;

import static io.restassured.RestAssured.given;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Test;

import com.google.gson.Gson;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import mapeo.Comments;
import mapeo.Posts;

public class TestsGETComments {

	
	@Test
	public void getPosts() {
		
		// url del servicio
		String URL = "https://jsonplaceholder.typicode.com/comments";
		
		// EJERCICIO : asignar el valor a la variable "valorABuscar" de acuerdo a lo asignado en el board 
		//            del repositorio => https://github.com/i-fer/api-qa/projects
		
		String valorABuscar = "";
		
		// objecto que se va a user para deserealizar la respuesta contra la clase Comments.java
		Gson gson = new Gson();
		
		// creacion del request para hacer la llamada al servicio
		RequestSpecification reqSpec;
		reqSpec = new RequestSpecBuilder().
	            setBaseUri(URL).	                        
	            build();			
		
		// envio el request
				Response res = 
							given().
							spec(reqSpec).
							when().
							get().
							then().   
							extract().response();					
		
		// EJERCICIO: escribir el codigo para la deserealizacion de la respuesta (convierto la respuesta en objectos del tipo "Comments"
		
		 
		// EJERCICIO : escribir el codigo para la conversion a arraylist
		
		
		// VALIDACION : escribir el codigo de acuerdo a la asignacion que cada uno tiene en el dashboard 
		//  => https://github.com/i-fer/api-qa/projects
		//
		//
		
		// imprimo toda la respuesta		
		System.out.println(res.getBody().asString());
				
				
	}
	
}
