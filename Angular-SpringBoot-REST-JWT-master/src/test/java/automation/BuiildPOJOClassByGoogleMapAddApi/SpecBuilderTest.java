package automation.BuiildPOJOClassByGoogleMapAddApi;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class SpecBuilderTest {
  public static void main(String[] args) {


    GoogleMap googleMap = new GoogleMap();

    googleMap.setAccuracy(50);
    googleMap.setName("Frontline house");
    googleMap.setPhone_number("(+91) 983 893 3937");
    googleMap.setAddress("29, side layout, cohen 09");
    googleMap.setWebsite("http://google.com");
    googleMap.setLanguage("French-IN");

    Location location = new Location();
    location.setLat(-38.383494);
    location.setLng(33.427362);

    List<String> types = new ArrayList<>();
    types.add("shoe park");
    types.add("shop");

    googleMap.setTypes(types);

    //Build spec Request body
    RequestSpecification requestSpecification= new RequestSpecBuilder()
      .setBaseUri("https://rahulshettyacademy.com")
      .addQueryParam("key","qaclick123")
      .setContentType(ContentType.JSON)
      .build();

    //Build spec Response body
    ResponseSpecification responseSpecification = new ResponseSpecBuilder()
      .expectStatusCode(200)
      .expectContentType(ContentType.JSON)
      .build();


    String response = given().spec(requestSpecification)
      .body(googleMap)
      .when().post("/maps/api/place/add/json")
      .then().spec(responseSpecification).extract().response().asString();

    System.out.println(response);


  }
}
