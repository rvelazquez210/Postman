package apiTest;

import org.json.simple.JSONObject;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import utils.Utils;

public class PutMethodTests {
	
	// objecto json que sera usado en cada test donde se necesite un body json
		 private JSONObject bodyRequest = new JSONObject();
		
		
		// objecto request que sera usado desde cada test
		private RequestSpecification requestSpec = new RequestSpecBuilder().
	            setBaseUri(Utils.BASE_URI).
	            setContentType(ContentType.JSON).
	            setBody(bodyRequest).
	            build();

}
