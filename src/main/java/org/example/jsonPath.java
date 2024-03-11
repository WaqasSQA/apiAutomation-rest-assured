package org.example;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.testng.Assert.assertEquals;


public class jsonPath {

    @Test
    void json_Path(){

        String URL = "http://localhost:3000/posts";
        Response response = RestAssured.when().get(URL).andReturn();
        response.getBody().prettyPrint();

        assertEquals(response.getStatusCode(), 200);
        JsonPath jpath = response.jsonPath();
        String result = jpath.get("result");
        System.out.println(result);


    }

    @Test
    void Hamcrest(){
        boolean a = false;
        boolean b = false;

        assertThat(a, equalTo(b));
        assertThat(a, is(equalTo(b)));
        assertThat(a, is(b));
    }
}

