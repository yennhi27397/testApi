package automation.Jira;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class AddFileAttachments {
  @Test
  public void userCanAddFileAttachmentSuccessfully_WhenValidFile_ThenAddFileAttachmentSuccessfully() {
    RestAssured.baseURI = "http://localhost:8080";

    SessionFilter sessionFilter = new SessionFilter();
// login
    given().log().all().header("Content-Type","application/json")
      .body("{ \"username\": \"yennhi27397\", \"password\": \"Phamyn27397\" }")
      .filter(sessionFilter)
      .when().post("/rest/auth/1/session")
      .then().log().all().assertThat().statusCode(200);

    //Add Comment
    given().pathParam("id", "10300").header("Content-Type", "application/json").body("{\n" +
        "    \"body\": \"I add my first comment.\",\n" +
        "    \"visibility\": {\n" +
        "        \"type\": \"role\",\n" +
        "        \"value\": \"Administrators\"\n" +
        "    }\n" +
        "}").filter(sessionFilter)
      .when().post("/rest/api/2/issue/{id}/comment")
      .then().log().all().assertThat().statusCode(201);

    //Add Attachment
    given().header("X-Atlassian-Token","no-check")
      .header("Content-Type","multipart/form-data")
      .pathParam("id", "10300")
      .multiPart("file",new File( "src/test/resources/file/addFileAttachment.txt")) // src/test/resources/
      .filter(sessionFilter)
      .when().post("/rest/api/2/issue/{id}/attachments")
      .then().log().all().assertThat().statusCode(200);

  }
}
