package Serialization;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;

import io.restassured.response.Response;

import static org.testng.Assert.assertEquals;


public class Serialization {
    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static void main(String[] args) throws JsonProcessingException {
        Pojo obj1 = new Pojo();
        obj1.setId(10);
        obj1.setTitle("Waqas");
        obj1.setAuthor("Khanzada");

        String url = "http://localhost:3000/posts";
        String json = MAPPER.writeValueAsString(obj1);

        Response response = RestAssured.given().contentType("application/json")
                .log().all(true).body(json).post(url).andReturn();

        assertEquals(response.getStatusCode(), 201, "HTTPS Message");
    }
}
