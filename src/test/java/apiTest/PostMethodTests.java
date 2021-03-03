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

import org.apache.commons.lang.RandomStringUtils;
import org.json.simple.JSONObject;
import org.junit.*;
import utils.Utils;

import java.io.File;
import java.util.Optional;
import java.util.Random;

public class PostMethodTests {
	
	// objecto json que sera usado en cada test donde se necesite un body json
		 private JSONObject bodyRequest = new JSONObject();
		
		
	// objecto request que sera usado desde cada test
	private RequestSpecification requestSpec = new RequestSpecBuilder().
	            setBaseUri(Utils.BASE_URI).
	            setContentType(ContentType.JSON).
	            setBody(bodyRequest).
	            build();
	
	 
}
