package Async;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class proxy {
    public static void main(String[] args) {
        RestAssured.given().proxy("127.0.0.1", 8888).when().get("https://reqres.in/api/users?delay=3")
                .then().log().all();
    }
}
