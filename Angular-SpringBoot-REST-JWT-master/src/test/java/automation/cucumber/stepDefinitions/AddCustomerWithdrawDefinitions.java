package automation.cucumber.stepDefinitions;

import automation.service.stub.BankApiStub;
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
import java.sql.SQLException;

public class AddCustomerWithdrawDefinitions {


  private static DatabaseUtil databaseUtil;
  private static BankApiStub bankApiStub;

  @BeforeAll
  public static void beforeTestSuite() throws Exception {
    databaseUtil = new DatabaseUtil();
    // start banking server
    bankApiStub = new BankApiStub(9090);
  }

  @AfterAll
  public static void afterTestSuite() throws SQLException {
    bankApiStub.stop();
    databaseUtil.stop();
  }

  @Before
  public void prepareData() throws Exception {
    // clean up tables.
    databaseUtil.executeSQL("script/cleanUp.sql");
    // prepare data to test.
    databaseUtil.executeSQL("script/insert_customers.sql");
  }


  @Given("Customer ID does not exist")
  public void customerIDDoesNotExist() throws IOException {
    System.out.println("Create customer does not exist");

  }

  @When("I submit valid withdraw request body and valid access token")
  public void iSubmitValidWithdrawRequestBodyAndValidAccessToken() throws IOException {
    // call API by POST method
    RequestSpecification request = RestAssured.given();
    // call header
    request.contentType(ContentType.JSON);
    // call URL
    request.baseUri("http://localhost:9119/api/customers/withdraw");
    // read request body
    request.body(CommonUtil.readContentFile("requestBody/AddCustomerWithdrawApi_WhenCustomerIDIsValid_ThenWithdrawSuccessfully.json"));
    // call POST method
    Response response = request.post();
    // test status
    Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK);
    // response
    String responseString = response.body().asString();
    // compare actual and expected response
    String expectedString = CommonUtil.readContentFile("expected/AddCustomerWithdrawApi/WhenCustomerIDIsValid_ThenWithdrawSuccessfully.json");
    JSONAssert.assertEquals(expectedString, responseString, JSONCompareMode.STRICT);

  }

  @Then("Customer withdraw successfully")
  public void customerWithdrawSuccessfully() throws IOException {
    System.out.println("Customer withdraw successfully");

  }

  @Given("Customer ID existed")
  public void customerIDExisted() {
    System.out.println("Customer ID existed");
  }

  @Then("Customer can not withdraw")
  public void customerCanNotWithdraw() throws IOException {
    // call API by POST method
    RequestSpecification request = RestAssured.given();
    // call header
    request.contentType(ContentType.JSON);
    // call URL
    request.baseUri("http://localhost:9119/api/customers/withdraw");
    // read request body
    request.body(CommonUtil.readContentFile("requestBody/AddCustomerWithdrawApi_WhenCustomerIDIsValid_ThenWithdrawSuccessfully.json"));
    // call POST method
    Response response = request.post();
    // test status
    Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK);
    // response
    String responseString = response.body().asString();
    // compare actual and expected response
    String expectedString = CommonUtil.readContentFile("expected/AddCustomerWithdrawApi/WhenCustomerIDIsValid_ThenWithdrawSuccessfully.json");
    JSONAssert.assertEquals(expectedString, responseString, JSONCompareMode.STRICT);
  }

  @Then("Customer ID can not withdraw")
  public void customerIDCanNotWithdraw() {
    System.out.println("Customer ID can not withdraw");
  }


}
