package health_checks;


import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.BeforeClass;

import org.junit.Test;
import utils.Utils;


import static io.restassured.RestAssured.given;

public class HealthChecks {

    private static RequestSpecification requestSpec;



    //@BeforeClass
    public static void createRequestSpecification() {

        requestSpec = new RequestSpecBuilder().
                setBaseUri(Utils.BASE_URI).
                setContentType(ContentType.JSON).
                build();
    }


    //@Test
    public void get_healthCheck() {



            given().
                    spec(requestSpec).
                    when().
                        get().
                    then().
                        assertThat().
                        statusCode(200);
    }
}