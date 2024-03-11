package Async;

import org.asynchttpclient.Dsl;
import org.asynchttpclient.Response;
import org.testng.annotations.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Async {


    @Test
            public void tests() throws ExecutionException, InterruptedException {


      Future<Response> responseFuture = Dsl.asyncHttpClient().prepareGet("https://reqres.in/api/users?delay=5").execute();
      Response response = responseFuture.get();
        System.out.println(response);
        System.out.println(response.getStatusCode());
    }
}
