package apiTest;

import org.json.simple.JSONObject;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import utils.Utils;

public class GetMethodTests {
		
		// objecto request que sera usado desde cada test
		private RequestSpecification requestSpec = new RequestSpecBuilder().
	            setBaseUri(Utils.BASE_URI).
	            setContentType(ContentType.JSON).	            
	            build();

}
