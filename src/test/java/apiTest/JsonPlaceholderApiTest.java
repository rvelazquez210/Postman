package apiTest;

import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.hamcrest.Matchers.*;


import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.*;
import org.junit.*;
import utils.Utils;

import java.io.File;

public class JsonPlaceholderApiTest {

    private static RequestSpecification requestSpec;

    @BeforeClass
    public static void createRequestSpecification() {

        requestSpec = new RequestSpecBuilder().
                setBaseUri(Utils.BASE_URI).
                setContentType(ContentType.JSON).
                build();
    }


    @Test
    public void getTodo_checkSchema() {

        given().
                spec(requestSpec).
                when().
                get().
                then().
                assertThat().
                body(matchesJsonSchema(new File("src/test/java/apiTest/schema/jsonplaceholder-schema.json")));
    }

    @Test
    public void getTodo_verifyBody() {



        JsonPath jsonPostResponse =
                given().
                        spec(requestSpec).
                        and().
                        when().
                            get().
                        then().
                            assertThat().
                            statusCode(200).
                            extract().
                            body().jsonPath();

        String id = jsonPostResponse.get("title");

        Assert.assertThat(jsonPostResponse.get("userId"), is(1));
        Assert.assertThat(jsonPostResponse.get("title"), is("delectus aut autem"));
        Assert.assertThat(jsonPostResponse.get("completed"), is(false));


    }
}