package Upload_Download;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Download {
    public static void main(String[] args) throws IOException {
        Response response = RestAssured
                .given().log().all().when().get("https://reqres.in/api/users?page=2").andReturn();
        byte[] bit = response.getBody().asByteArray();
        File file = new File("C:\\Users\\dev\\Downloads\\waqas.json");
        Files.write(file.toPath(), bit );
    }
}
