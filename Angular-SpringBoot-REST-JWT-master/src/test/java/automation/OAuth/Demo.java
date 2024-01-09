package automation.OAuth;

import automation.PoJo.GetCourses;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;

public class Demo {
  public static void main(String[] args) {

    // Authentication Server
    String response = given()
      .formParam("client_id","692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
      .formParam("client_secret","erZOWM9g3UtwNRj340YYaK_W")
      .formParam("grant_type","grant_type")
      .formParam("scope","trust")

      .when().post("https://rahulshettyacademy.com/oauthapi/oauth2/resourceOwner/token")
      .then().log().all().extract().response().asString();

    System.out.println(response);

    JsonPath json = new JsonPath(response);
    String accessToken = json.getString("access_token");


    // get OAuth by String
    /*String response2 = given().queryParam("access_token",accessToken)
      .when().get("https://rahulshettyacademy.com/oauthapi/getCourseDetails")
      .then().log().all().extract().response().asString();

    System.out.println(response2);*/

    // get OAuth by Object
    GetCourses getCourses = given().queryParam("access_token",accessToken)
      .when().get("https://rahulshettyacademy.com/oauthapi/getCourseDetails")
      .as(GetCourses.class);

    System.out.println(getCourses.getLinkedIn());
    System.out.println(getCourses.getUrl());
  }
}
