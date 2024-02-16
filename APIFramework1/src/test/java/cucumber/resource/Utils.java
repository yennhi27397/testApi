package cucumber.resource;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Utils {
  RequestSpecification resquest;

  public RequestSpecification req() {

    //Build spec Request body
    resquest = new RequestSpecBuilder()
        .setBaseUri("https://rahulshettyacademy.com")
        .addQueryParam("key", "qaclick123")
        .setContentType(ContentType.JSON)
        .build();
    return req();
  }
}
