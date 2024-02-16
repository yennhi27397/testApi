package cucumber;

import cucumber.resource.TestDataBuild;
import cucumber.resource.Utils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.Assert;

import static io.restassured.RestAssured.given;

public class MyStepdefs extends Utils {
  RequestSpecification requestSpecification;
  ResponseSpecification responseSpecification;
  RequestSpecification request;
  Response response;


  TestDataBuild testDataBuild = new TestDataBuild();

  @Given("Add place payload")
  public void addPlacePayload() {

    //Build spec Response body
    responseSpecification = new ResponseSpecBuilder()
        .expectStatusCode(200)
        .expectContentType(ContentType.JSON)
        .build();


    request = given().spec(req())
        .body(testDataBuild.dataBuild());

  }

  @When("user call {string} with {string} http request")
  public void userCallWithHttpRequest(String arg0, String arg1) {
    response = request.when().post("/maps/api/place/add/json")
        .then().spec(responseSpecification).extract().response();

  }

  @Then("The API call got success with status code {int}")
  public void theAPICallGotSuccessWithStatusCode(int arg0) {
    Assert.assertEquals(response.getStatusCode(), 200);

  }


  @And("{string} in response body is {string}")
  public void inResponseBodyIs(String keyValue, String expectedValue) {
    String resp = response.asString();
    JsonPath jsonPath = new JsonPath(resp);
    Assert.assertEquals(jsonPath.get(keyValue).toString(), expectedValue);

  }


}

