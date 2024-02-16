package automation.cucumber.stepDefinitions;

import common.CommonUtil;
import common.DatabaseUtil;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.testng.Assert;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class AddCustomerDefinitions {
  private static DatabaseUtil databaseUtil;

  @BeforeAll
  public static void beforeTestSuite() throws Exception {
    databaseUtil = new DatabaseUtil();
  }

  @AfterAll
  public static void afterTestSuite() throws Exception {
    databaseUtil.stop();
  }

  @Before
  public void prepareData() throws Exception {
    databaseUtil.executeSQL("script/cleanUp.sql");
    databaseUtil.executeSQL("script/insert_customers.sql");
  }

  @Given("User is not existed on system")
  public void userIsNotExistedOnSystem() throws Exception {
    // User is not existed on system
    System.out.println("should do to make user not existed on system");
  }

  @Given("User is existed on system")
  public void userIsExistedOnSystem() throws Exception {
    // User is existed on system
    System.out.println("should do to make user is existed on system");
  }

  @When("I submit valid request body and valid access token")
  public void iSubmitValidRequestBody() throws IOException {
    // Call RestAssured to send request and check response
    RequestSpecification request = RestAssured.given();
    // Call Header (Content type)
    request.contentType(ContentType.JSON);
    // Call URL
    request.baseUri("http://localhost:9119/api/customers");
    // read request body
    request.body(CommonUtil.readContentFile("requestBody/AddCustomerApi_WhenDataIsValid_ThenAddedCustomer.json"));
    // Call POST method
    Response response = request.post();
    // compare status code
    Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK);
    // get response body
    String responseString = response.body().asString();
    String expectedString = CommonUtil.readContentFile("expected/AddCustomerApi/AddCustomerApi_WhenDataIsValid_ThenAddedCustomer.json");
    // compare String actual response and String expected response
    JSONAssert.assertEquals(expectedString, responseString, JSONCompareMode.STRICT);
  }

  @Then("Create Customer successfully")
  public void createCustomerSuccessfully() throws Exception {
    // pass string query to get list record
    List<Map<String, Object>> data = databaseUtil.getRecords(
      "SELECT * FROM customers WHERE first_name='Doan' and last_name='Pham'"
    );
    // todo:
    Map<String, Object> expectedRecord = data.get(0);
    // check data in all column from record
    Assert.assertEquals(expectedRecord.get("id"), 4);
    Assert.assertEquals(expectedRecord.get("city"), "string");
    Assert.assertEquals(expectedRecord.get("company"), "string");
    Assert.assertEquals(expectedRecord.get("country"), "string");
    Assert.assertEquals(expectedRecord.get("email"), "string");
    Assert.assertEquals(expectedRecord.get("first_name"), "Doan");
    Assert.assertEquals(expectedRecord.get("last_name"), "Pham");
    Assert.assertEquals(expectedRecord.get("phone"), "string");
    Assert.assertEquals(expectedRecord.get("postal_code"), "string");
    Assert.assertEquals(expectedRecord.get("state"), "string");
  }

  @When("I submit invalid request body and valid access token")
  public void iSubmitInvalidRequestBodyAndValidAccessToken() throws IOException {
    // Call Rest Assued to send request and check response
    RequestSpecification request = RestAssured.given();
    // Call Header (Content type)
    request.contentType(ContentType.JSON);
    // Call URL
    request.baseUri("http://localhost:9119/api/customers");
    // read request body
    request.body(CommonUtil.readContentFile("requestBody/AddCustomerApi_WhenDataIsInvalid_ThenCantAddCustomer.json"));
    // Call POST method
    Response response = request.post();

    // compare status code
    Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK);
    // get response body
    String responseString = response.body().asString();
    String expectedString = CommonUtil.readContentFile("expected/AddCustomerApi/AddCustomerApi_WhenDataIsInvalid_ThenCantAddCustomer.json");
    // compare String actual response and String expected response
    JSONAssert.assertEquals(expectedString, responseString, JSONCompareMode.STRICT);
  }

  @Then("Can't create customer")
  public void canTCreateCustomer() throws Exception {
    // test database = 3 records.
    List<Map<String, Object>> data = databaseUtil.getRecords("SELECT * FROM customers");
    Assert.assertEquals(data.size(), 3);
  }
}
