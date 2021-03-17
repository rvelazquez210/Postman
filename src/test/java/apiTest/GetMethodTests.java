package apiTest;

import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.*;
import main.UserObject;
import mapeo.Posts;

import org.json.simple.JSONObject;
import org.junit.*;

import com.google.common.graph.ElementOrder.Type;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

import utils.Utils;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class GetMethodTests {
		
		 private static RequestSpecification requestSpec;
		 UserObject obj;
		
		 //@BeforeClass
		    public static void createRequestSpecification() {

			// objecto request que sera usado desde cada test
				requestSpec = new RequestSpecBuilder().
			            setBaseUri(Utils.BASE_URI).
			            setContentType(ContentType.JSON).	            
			            build();
		    }
		
		
		//@Test
		public void getAllUsersTest() {
			Response res = 
					given().
					spec(requestSpec).
					when().
					get("/users").
					then().
					extract().response();
			
			
		}
		
		//@Test
		public void getOnlyOneUserTest() {
			String userFiltered = "/fernandoi_test4";
			Response res = 
					given().
					spec(requestSpec).
					when().
					get("/users" + userFiltered).
					then().
					extract().response();
			
			
			// del response obtengo el body como String
			String object = res.getBody().asString();
			
			// objecto json
			Gson gson = new Gson();
			
			// deserialization usando el objecto String del response y mapeando a la clase UserObject
			UserObject user = gson.fromJson(object, UserObject.class);
			
			// assert al valor de la respuesta
			assertEquals("fernandoi_test4", user.getUsername());
			
			// print en la consola
			System.out.println("\n\t User value de la respuesta:  " + user.getUsername());
			
		}
		
		@Test
		public void getPosts() {
			// https://jsonplaceholder.typicode.com/users
			
			Gson gson = new Gson();
			String titulo = "qui est esse";
			String URL = "https://jsonplaceholder.typicode.com/posts";
			
			RequestSpecification reqSpec;
			reqSpec = new RequestSpecBuilder().
		            setBaseUri(URL).
		            //setContentType(ContentType.JSON).
		            addHeader("Authorization", "asljfalsjd").
		            build();			
			
					// ENVIO GET REQUEST
					Response res = 
								given().
								spec(reqSpec).
								when().
								get().
								then().   
								extract().response();					
					// DESEREALIZACION DE LA RESPUESTA
					Posts[] posts =  gson.fromJson(res.getBody().asString(), Posts[].class);
					
					// CONVERSION A ARRAYLIST
					List <Posts> list = Arrays.asList(posts);
					
					// BUSQUEDA EN LA RESPUESTA					
					list.forEach((nodo) -> {	
						if(nodo.getTitulo().equals(titulo)) {
							System.out.println("El titulo: \"" + titulo + "\" esta incluido");
						}								
					});
					
					//System.out.println(res.getBody().asString());
					
					
		}
		

}
