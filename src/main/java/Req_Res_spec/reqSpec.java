package Req_Res_spec;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class reqSpec {
        static RequestSpecification getCommon(){

            RequestSpecBuilder builder = new RequestSpecBuilder();
            builder.setBaseUri("https://reqres.in/");
            builder.setBasePath("api/users");
            RequestSpecification requestSpec = builder.build();
            return requestSpec;
        }

    public static void main(String[] args) {
        test_withoutPara();
        test_withParam();

    }
    static void test_withoutPara(){
        Response response = RestAssured
                .given()
                .spec(getCommon())
                .when()
                .get();

                response.getBody().prettyPrint();

    }
    static void test_withParam(){
        Response response = RestAssured
                .given()
                .spec(getCommon())
                .queryParam("page", "2")
                .when()
                .get();

        response.getBody().prettyPrint();
    }
}
