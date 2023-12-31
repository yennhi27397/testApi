package automation.api;

import automation.service.stub.BankApiStub;
import common.CommonUtil;
import common.DatabaseUtil;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.SQLException;

public class AddCustomerWithdrawApiTest {
  private DatabaseUtil databaseUtil;

  private BankApiStub bankApiStub;

  @BeforeTest
  public void beforeTest() throws Exception {
    this.databaseUtil = new DatabaseUtil();
    // start banking server
    this.bankApiStub = new BankApiStub(9090);
  }

  @BeforeMethod
  public void prepareData() throws Exception {
    // clean up tables.
    databaseUtil.executeSQL("script/cleanUp.sql");
    // prepare data to test.
    databaseUtil.executeSQL("script/insert_customers.sql");
  }

  @AfterTest
  public void afterTest() throws SQLException {
    this.bankApiStub.stop();
    this.databaseUtil.stop();
  }

  @Test
  public void AddCustomerWithdrawApi_WhenCustomerIDIsValid_ThenWithdrawSuccessfully() throws Exception {
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

  @Test
  public void AddCustomerWithdrawApi_WhenAccountInsufficientFund_ThenAccountCanNotWithdraw() throws Exception {
    RequestSpecification request = RestAssured.given();
    request.contentType(ContentType.JSON);
    request.baseUri("http://localhost:9119/api/customers/withdraw");
    request.body(CommonUtil.readContentFile("requestBody/AddCustomerWithdrawApi_WhenAccountInsufficient_ThenAccountCanNotWithdraw.json"));

    Response response = request.post();
    String responseString = response.body().asString();
    Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK);
    String expectedString = CommonUtil.readContentFile("expected/AddCustomerWithdrawApi/WhenAccountInsufficient_ThenAccountCanNotWithdraw.json");
    JSONAssert.assertEquals(expectedString, responseString, JSONCompareMode.STRICT);
  }

  @Test
  public void AddCustomerIDWithdraw_WhenCustomerIDDoesNotExist_ThenAccountCanNotFound() throws Exception {
    RequestSpecification request = RestAssured.given();
    request.contentType(ContentType.JSON);
    request.baseUri("http://localhost:9119/api/customers/withdraw");
    request.body(CommonUtil.readContentFile("requestBody/AddCustomerIDWithdraw_WhenCustomerIDDoesNotExist_ThenAccountCanNotFound.json"));
    Response response = request.post();
    String responseString = response.body().asString();

    Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_BAD_REQUEST);
    String expectedString = CommonUtil.readContentFile("expected/AddCustomerWithdrawApi/WhenCustomerIDDoesNotExist_ThenAccountCanNotFound.json");
    JSONAssert.assertEquals(expectedString, responseString, JSONCompareMode.LENIENT);
  }

  @Test
  public void AddCustomerIDWithdraw_WhenInternalServerError_ThenAccountCanNotWithdraw() throws Exception {
    databaseUtil.executeSQL("script/cleanUp.sql");
    databaseUtil.executeSQL("script/insert_customer_for_withdraw.sql");

    RequestSpecification request = RestAssured.given();
    request.contentType(ContentType.JSON);
    request.baseUri("http://localhost:9119/api/customers/withdraw");
    request.body(CommonUtil.readContentFile("requestBody/AddCustomerIDWithdraw_WhenInternalServerError_ThenAccountCanNotWithdraw.json"));

    Response response = request.post();
    Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_BAD_REQUEST);
    String responseString = response.body().asString();
    String expectedString = CommonUtil.readContentFile("expected/AddCustomerWithdrawApi/WhenInternalServerError_ThenAccountCanNotWithdraw.json");
    JSONAssert.assertEquals(expectedString, responseString, JSONCompareMode.LENIENT);

  }
}
