package Req_Res_spec;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;

import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.is;

public class resSpec {

    static ResponseSpecification getCommon(){

        ResponseSpecBuilder builder = new ResponseSpecBuilder();
        builder.expectStatusCode(200);
        ResponseSpecification responseSpec = builder.build();
        return responseSpec;
    }
    static void test_with(){
    String url = "https://reqres.in/api/users?page=2";

        RestAssured
                .when()
                .get(url)
                .then()
                .spec(getCommon());
    }
    static void test_without(){
        String url = "https://reqres.in/api/users?page=2";

        RestAssured
                .when()
                .get(url)
                .then()
                .spec(getCommon())
                .body("page", is(anything()));
    }
}
