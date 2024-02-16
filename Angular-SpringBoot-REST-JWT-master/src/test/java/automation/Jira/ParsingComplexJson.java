package automation.Jira;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class ParsingComplexJson {
  @Test
  public void ABC() {
    RestAssured.baseURI = "http://localhost:8080";

//Login Scenario

    SessionFilter session = new SessionFilter();

    String response = given().relaxedHTTPSValidation().header("Content-Type", "application/json")
      .body("{\r\n" + "    \"username\": \"yennhi27397\",\r\n" +
        "    \"password\": \"Phamyn27397\"\r\n" + "}")
      .log().all().filter(session).when().post("/rest/auth/1/session")
      .then().log().all().extract().response().asString();

    String expectedMessage = "I am learning API";

//Add comment

    String addCommentResponse = given().pathParam("id", "10500").log().all()
      .header("Content-Type", "application/json")

      .body("{\r\n" +
        "    \"body\": \"" + expectedMessage + "\",\r\n" +
        "    \"visibility\": {\r\n" +
        "        \"type\": \"role\",\r\n" +
        "        \"value\": \"Administrators\"\r\n" +
        "    }\r\n" +
        "}")

      .filter(session).when().post("/rest/api/2/issue/{id}/comment")
      .then().log().all().assertThat().statusCode(201).extract().response().asString();

    JsonPath js = new JsonPath(addCommentResponse);
    String commentId = js.getString("id");

//Add Attachment

    given().header("X-Atlassian-Token", "no-check").filter(session).pathParam("id", "10500")
      .header("Content-Type", "multipart/form-data")
      .multiPart("file", new File("src/test/resources/file/addFileAttachment.txt"))
      .when().post("rest/api/2/issue/{id}/attachments").then().log().all().assertThat().statusCode(200);

//Get Issue

    String issueDetails = given().filter(session).pathParam("id", "10500")

      .queryParam("fields", "comment")
      .log().all().when().get("/rest/api/2/issue/{id}").then()
      .log().all().extract().response().asString();

    System.out.println(issueDetails);

// Parsing complex json

    JsonPath js1 = new JsonPath(issueDetails);
    int commentsCount = js1.getInt("fields.comment.comments.size()");

    for (int i = 0; i < commentsCount; i++) {
      String commentIdIssue = js1.get("fields.comment.comments[" + i + "].id").toString();
      if (commentIdIssue.equalsIgnoreCase(commentId)) {
        String message = js1.get("fields.comment.comments[" + i + "].body").toString();
        System.out.println(message);

        Assert.assertEquals(message, expectedMessage);

      }

    }

  }
}

