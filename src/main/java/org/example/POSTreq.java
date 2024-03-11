package org.example;

import io.restassured.RestAssured;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class POSTreq {

    @Test
    void POST(){
        RestAssured.baseURI = "https://reqres.in/api/users";
        String userData = "{" +
                "\"name\" : \"Waqas\", " +
                "\"job\" : \"SQA\" "+
                "}";

        given().body(userData)
                .when().
                post().
                then().log().all().
                assertThat()
                .statusCode(201)
                .body("id", is(notNullValue()));

    }

}
