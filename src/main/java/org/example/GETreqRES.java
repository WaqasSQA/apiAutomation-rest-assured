package org.example;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class GETreqRES {

    @Test
    void getReq(){
        RestAssured.baseURI = "https://reqres.in/api/users";
        given().
                queryParam("page", 2)
                .body("")
                .when()
                .get()
                .then().
                assertThat().statusCode(200)
                .body("page", equalTo(2));


    }
}
