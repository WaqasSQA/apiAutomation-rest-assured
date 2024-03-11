package org.example;

import io.restassured.RestAssured;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GETreq {

    @BeforeSuite
    void setup(){
        System.out.println("Setup");
    }
    @Test
    void getReq(){
        RestAssured.baseURI = "http://localhost:3000";
        RestAssured.basePath = "posts";
        given().when().get().then().log().all().statusCode(200).body("result", equalTo("Lucky Sahab"));
    }
    @AfterSuite
    void tearDown(){
        System.out.println("Setup Teared Down");
    }



}
