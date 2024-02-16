package automation.BuiildPOJOClassByGoogleMapAddApi;

import io.restassured.RestAssured;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class addPlace {
  public static void main(String[] args) {

    RestAssured.baseURI = "https://rahulshettyacademy.com";

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

    String response = given().log().all().queryParam("key","qaclick123")
      .body(googleMap)
      .when().post("/maps/api/place/add/json")
      .then().assertThat().statusCode(200).extract().response().asString();

    System.out.println(response);


  }
}
