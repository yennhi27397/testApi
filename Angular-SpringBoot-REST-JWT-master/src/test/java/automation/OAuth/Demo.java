package automation.OAuth;

import automation.PoJo.GetCourses;
import automation.PoJo.WebAutomation;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class Demo {
  public static void main(String[] args) {

    // Authentication Server
    String response = given()
      .formParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
      .formParam("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
      .formParam("grant_type", "grant_type")
      .formParam("scope", "trust")

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
    GetCourses gc = given().queryParam("access_token", accessToken)
      .when().get("https://rahulshettyacademy.com/oauthapi/getCourseDetails")
      .as(GetCourses.class);

    /*System.out.println(gc.getLinkedIn());
    System.out.println(gc.getUrl());*/

    // get title of courses object
    System.out.println(gc.getCourses().getWebAutomation().get(0).getCourseTitle());

    List<WebAutomation> getWebAutomationList = gc.getCourses().getWebAutomation();
    for (int i = 0; i < getWebAutomationList.size(); i++) {
      if (getWebAutomationList.get(i).getCourseTitle().equalsIgnoreCase("Selenium Webdriver Java")) {
        System.out.println(getWebAutomationList.get(i).getPrice());
      }
    }

    // get all courses title of courses object
    String[] webAutomation = {"Selenium Webdriver Java", "Cypress", "Protractor"};

    List<String> getWebAutomation = new ArrayList<>();
    for (int i = 0; i < getWebAutomationList.size(); i++) {
    getWebAutomation.add(getWebAutomationList.get(i).getCourseTitle());
    }
    System.out.println(getWebAutomation);

    //compare 2 list String
    Assert.assertEqualsNoOrder(List.of(webAutomation), getWebAutomation);



  }
}

