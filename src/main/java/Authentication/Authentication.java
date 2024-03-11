package Authentication;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Authentication {

    public static void main(String[] args) {

        //First Way to do it with Header
        Response response = RestAssured
                .given()
                .header("Authorization", "Bearer 0456304563")
                .get("http://localhost:3000/posts/").andReturn();


        String id = response.jsonPath().getString("data.id");
        String link = response.jsonPath().getString("data.link");

        System.out.println(id);
        System.out.println(link);


        //Second Way to do it with OAuth with Rest Assured
        Response response2 = RestAssured
                .given()
                .auth().oauth2("0456304563")
                .get("http://localhost:3000/posts/").andReturn();


        String link2 = response2.jsonPath().getString("data.link");
        System.out.println(link2);
    }
}
