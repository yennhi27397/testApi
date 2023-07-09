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
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class AddCustomerWithdrawApiTest {
  private DatabaseUtil databaseUtil;
  private BankApiStub bankApiStub;

  @BeforeMethod
  public void prepareData() throws Exception {
    this.databaseUtil = new DatabaseUtil();
    // start server
    this.bankApiStub = new BankApiStub(9090);
    // clean up tables.
    databaseUtil.executeSQL("script/cleanUp.sql");
    // prepare data to test.
    databaseUtil.executeSQL("script/insert_customers.sql");
  }

  @AfterTest
  public void cleanUpData() {
  }
  @Test
  public void AddCustomerApi_WhenDataIsValid_ThenAddedCustomer() throws Exception {
    // call API by POST method
    RequestSpecification request = RestAssured.given();
    request.contentType(ContentType.JSON);
    request.baseUri("http://localhost:9119/api/customers");
    request.body(CommonUtil.readBody("requestBody/AddCustomerApi_WhenDataIsValid_ThenAddedCustomer.json"));
    Response response = request.post();
    // test status
    Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK);
    // response
    String responseString = response.body().asString();
    Assert.assertTrue(CommonUtil.compare(responseString, "expected/AddCustomerApi/AddCustomerApi_WhenDataIsValid_ThenAddedCustomer.json"));
    // list record.
    List<Map<String, Object>> data = databaseUtil.getRecords("SELECT * FROM customers WHERE first_name='Doan' and last_name='Pham'");
    // record
    Map<String, Object> expectedRecord = data.get(0);
    // data in column 'id'
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


}
