package Upload_Download;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;

public class uploadReq {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\dev\\Downloads\\diamond-1857736_1280.png");


        Response response = RestAssured
                .given()
                .multiPart("file", file, "multipart/form-data")
                .post("https://the-internet.herokuapp.com/upload")
                .thenReturn();
        System.out.println(response.prettyPrint());
    }
}
