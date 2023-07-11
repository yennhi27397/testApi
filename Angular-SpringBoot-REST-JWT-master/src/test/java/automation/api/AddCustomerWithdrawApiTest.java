package automation.api;

import automation.service.stub.BankApiStub;
import common.CommonUtil;
import common.DatabaseUtil;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.SQLException;

public class AddCustomerWithdrawApiTest {
  private DatabaseUtil databaseUtil;
  private BankApiStub bankApiStub;

  @BeforeMethod
  public void prepareData() throws Exception {
    // clean up tables.
    databaseUtil.executeSQL("script/cleanUp.sql");
    // prepare data to test.
    databaseUtil.executeSQL("script/insert_customers.sql");
  }

  @BeforeTest
  public void beforeTest() throws Exception {
    // start banking server
    this.bankApiStub = new BankApiStub(9090);
    this.databaseUtil = new DatabaseUtil();
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
    request.body(CommonUtil.readBody("requestBody/AddCustomerWithdrawApi_WhenCustomerIDIsValid_ThenWithdrawSuccessfully.json"));
    // call POST method
    Response response = request.post();
    // test status
    Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK);
    // response
    String responseString = response.body().asString();
    // compare actual and expected response
    Assert.assertTrue(CommonUtil.compare(responseString, "expected/AddCustomerWithdrawApi/WhenCustomerIDIsValid_ThenWithdrawSuccessfully.json"));

  }

  @Test
  public void AddCustomerWithdrawApi_WhenAccountInsufficient_ThenAccountCanNotWithdraw() throws Exception {
    // call API by POST method
    RequestSpecification request = RestAssured.given();
    request.contentType(ContentType.JSON);
    request.baseUri("http://localhost:9119/api/customers/withdraw");
    request.body(CommonUtil.readBody("requestBody/AddCustomerWithdrawApi_WhenAccountInsufficient_ThenAccountCanNotWithdraw.json"));
    Response response = request.post();
    // test status
    Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK);
    // response
    String responseString = response.body().asString();
    Assert.assertTrue(CommonUtil.compare(responseString, "expected/AddCustomerWithdrawApi/WhenAccountInsufficient_ThenAccountCanNotWithdraw.json"));
  }
}
