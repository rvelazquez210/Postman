package apiTest;

import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.*;
import org.junit.*;
import utils.Utils;

import java.io.File;
import java.util.List;

public class GetMethodTests {
		
		 private static RequestSpecification requestSpec;
		
		 @BeforeClass
		    public static void createRequestSpecification() {

			// objecto request que sera usado desde cada test
				requestSpec = new RequestSpecBuilder().
			            setBaseUri(Utils.BASE_URI).
			            setContentType(ContentType.JSON).	            
			            build();
		    }
		
		
		@Test
		public void getAllUsersTest() {
			Response res = 
					given().
					spec(requestSpec).
					when().
					get("/users").
					then().
					extract().response();
			
			System.out.print("\n BODY RESPONSE ALL USERS:  " + res.body().asString());
		}
		
		@Test
		public void getOnlyOneUserTest() {
			String userFiltered = "/fernandoi_test4";
			Response res = 
					given().
					spec(requestSpec).
					when().
					get("/users" + userFiltered).
					then().
					extract().response();
			
			System.out.print("\n BODY RESPONSE ONE USER:  " + res.body().asString());			
			
		}
		

}
