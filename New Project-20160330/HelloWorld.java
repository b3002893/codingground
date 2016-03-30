import io.vertx.core.Vertx;
import io.vertx.core.http.HttpClient;
import io.vertx.core.http.HttpClientOptions;


public class HelloWorld{

     public static void main(String []args){
        Vertx vertx = Vertx.vertx();
     
      HttpClientOptions options = new HttpClientOptions();
      options.setDefaultHost("charcount.com");
      options.setMaxPoolSize(1);
      HttpClient client = vertx.createHttpClient(options);
     
      client.get("/404", resp -> System.out.println("Got Response. Status: "+resp.statusCode()))
          .exceptionHandler(e -> {System.out.println("1");e.printStackTrace();}).end();
     
     
      client.get("/404", resp -> System.out.println("Got Response. Status: "+resp.statusCode()))
          .exceptionHandler(e -> {System.out.println("2");e.printStackTrace();}).end();
     
      vertx.setTimer(500, t-> vertx.close());

     }
}
