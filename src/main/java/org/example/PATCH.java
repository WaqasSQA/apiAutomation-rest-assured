package org.example;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class PATCH {

    @Test
    void patch(){
        RestAssured.baseURI = "https://reqres.in/api/users/2";
        String userDataPatch = "{" +
                "\"name\" : \"Wikko\", "+
                "\"job\" : \"Coding\" "+
                "}";
        given().body(userDataPatch)
                .when().
                patch().then().log().all().
                assertThat().
                statusCode(201)
                .body("updatedAt", is(notNullValue()));
    }
}
