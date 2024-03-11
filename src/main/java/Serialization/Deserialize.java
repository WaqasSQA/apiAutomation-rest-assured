package Serialization;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

public class Deserialize {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static void main(String[] args) {
        //To Deserialize certain endpoint
        String url = "http://localhost:3000/posts/10";
        Pojo obj2_ten = RestAssured.given().get(url).as(Pojo.class);
        System.out.println("post_ten: "+obj2_ten.toString());

        //First Way
        //To Deserialize all the items
        String url2 = "http://localhost:3000/posts";
        Type type = new TypeReference<List<Pojo>>() {}.getType();
        List<Pojo> postsList = RestAssured.get(url2).as(type);
        System.out.println("post_all: "+postsList.toString());

        //Second Way to Deserialize all items
        Pojo[] obj_all = RestAssured.get(url2).as(Pojo[].class);
        System.out.println("post_all_2: "+ Arrays.toString(obj_all));
    }
}
