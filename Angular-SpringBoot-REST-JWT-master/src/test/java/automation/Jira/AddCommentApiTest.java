package automation.Jira;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class AddCommentApiTest {
  @Test

  public void userAddCommentSuccessfully_WhenValidSessionID_ThenAddCommentSuccessfully() {
    RestAssured.baseURI = "http://localhost:8080";

    //Login
    SessionFilter sessionId = new SessionFilter();

    given().log().all().header("Content-Type", "application/json")
      .body("{ \"username\": \"yennhi27397\", \"password\": \"Phamyn27397\" }")
      .filter(sessionId)
      .when().post("/rest/auth/1/session")
      .then().log().all().assertThat().statusCode(200);


    given().pathParam("id", "10101").header("Content-Type", "application/json").body("{\n" +
        "    \"body\": \"I add my first comment.\",\n" +
        "    \"visibility\": {\n" +
        "        \"type\": \"role\",\n" +
        "        \"value\": \"Administrators\"\n" +
        "    }\n" +
        "}").filter(sessionId)

      .when().post("/rest/api/2/issue/{id}/comment")
      .then().log().all().assertThat().statusCode(201);


  }

  @Test
  public void userCanNotAddCommentSuccessfully_WhenEmptyRequiredFields_ThenCanNotAddCommentSuccessfully() {
    RestAssured.baseURI = "http://localhost:8080";

    SessionFilter sessionFilter = new SessionFilter();

    given().log().all().header("Content-Type", "application/json")
      .body("{ \"username\": \"yennhi27397\", \"password\": \"Phamyn27397\" }")
      .filter(sessionFilter)
      .when().post("/rest/auth/1/session")
      .then().assertThat().statusCode(200);

    given().pathParam("id", "10200").header("Content-Type", "application/json").body("{}").filter(sessionFilter)
      .when().post("/rest/api/2/issue/{id}/comment")
      .then().log().all().assertThat().statusCode(400);
  }
}
