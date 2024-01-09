package automation.Jira;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetIssuesApiTest {

  @Test
  public void getFieldsOfIssue_WhenABC_ThenABC(){
    RestAssured.baseURI = "http://localhost:8080";

    SessionFilter sessionFilter = new SessionFilter();

    given().log().all().header("Content-Type", "application/json")
      .body("{ \"username\": \"yennhi27397\", \"password\": \"Phamyn27397\" }")
      .filter(sessionFilter)
      .when().post("/rest/auth/1/session")
      .then().assertThat().statusCode(200);


    String issueDetails = given().pathParam("id", "10500").filter(sessionFilter)
      .queryParam("fields","priority")
      .when().post("rest/api/2/issue/{id}")
      .then().log().all().extract().response().asString();

    System.out.println(issueDetails);

  }
}
