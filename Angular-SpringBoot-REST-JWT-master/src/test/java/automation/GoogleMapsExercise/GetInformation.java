package automation.GoogleMapsExercise;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

public class GetInformation {
  public static void main(String[] args) {
    RestAssured.baseURI= "https://rahulshettyacademy.com";

    //given: all input data
    given()
      .queryParam("key","qaclick123")
      .queryParam("place_id","2291393548e394611766ffb20441f854")
      .when().get("maps/api/place/get/json")
      .then().assertThat().statusCode(200);
  }
}
