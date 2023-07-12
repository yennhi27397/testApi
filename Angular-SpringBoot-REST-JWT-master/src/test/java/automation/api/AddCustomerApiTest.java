package automation.api;

import common.CommonUtil;
import common.DatabaseUtil;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class AddCustomerApiTest {
  private DatabaseUtil databaseUtil;

  @BeforeTest
  public void beforeTest() throws Exception {
    this.databaseUtil = new DatabaseUtil();
  }

  @BeforeMethod
  public void prepareData() throws Exception {
    // clean up tables.
    databaseUtil.executeSQL("script/cleanUp.sql");
    // prepare data to test.
    databaseUtil.executeSQL("script/insert_customers.sql");
  }

  @Test
  public void AddCustomerApi_WhenDataIsValid_ThenAddedCustomer() throws Exception {
    // Call RestAssured to send request and check response
    RequestSpecification request = RestAssured.given();
    // Call Header (Content type)
    request.contentType(ContentType.JSON);
    // Call URL
    request.baseUri("http://localhost:9119/api/customers");
    // read request body
    request.body(CommonUtil.readFileContent("requestBody/AddCustomerApi_WhenDataIsValid_ThenAddedCustomer.json"));
    // Call POST method
    Response response = request.post();

    // compare status code
    Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK);
    // get response body
    String responseString = response.body().asString();
    // compare String actual response and String expected response
    Assert.assertTrue(CommonUtil.compare(responseString, "expected/AddCustomerApi/AddCustomerApi_WhenDataIsValid_ThenAddedCustomer.json"));
    // pass string query to get list record
    List<Map<String, Object>> data = databaseUtil.getRecords(
      "SELECT * FROM customers WHERE first_name='Doan' and last_name='Pham'"
    );
    // todo:
    // get record
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

  @Test
  public void AddCustomerApi_WhenDataIsInvalid_ThenCantAddCustomer() throws Exception {
    // Call Rest Assued to send request and check response
    RequestSpecification request = RestAssured.given();
    // Call Header (Content type)
    request.contentType(ContentType.JSON);
    // Call URL
    request.baseUri("http://localhost:9119/api/customers");
    // read request body
    request.body(CommonUtil.readFileContent("requestBody/AddCustomerApi_WhenDataIsInvalid_ThenCantAddCustomer.json"));
    // Call POST method
    Response response = request.post();

    // compare status code
    Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK);
    // get response body
    String responseString = response.body().asString();
    // compare String actual response and String expected response
    Assert.assertTrue(CommonUtil.compare(responseString, "expected/AddCustomerApi/AddCustomerApi_WhenDataIsInvalid_ThenCantAddCustomer.json"));
    // test database = 3 records.
    List<Map<String, Object>> data = databaseUtil.getRecords("SELECT * FROM customers");
    Assert.assertEquals(data.size(),3);
  }

  @Test
  public void AddCustomerApi_WhenDataMissedIDField_ThenCustomerDidNotAdd() throws Exception {
    // Call Rest Assued to send request and check response
    RequestSpecification request = RestAssured.given();
    // Call Header (Content type)
    request.contentType(ContentType.JSON);
    // Call URL
    request.baseUri("http://localhost:9119/api/customers");
    // read request body
    request.body(CommonUtil.readFileContent("requestBody/AddCustomerApi_WhenDataMissedIDField_ThenCantAddCustomer.json"));
    // Call POST method
    Response response = request.post();

    // compare status code
    Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_BAD_REQUEST);
    // get response body
    String responseString = response.body().asString();
    // compare String actual response and String expected response but ignore some field unnecessary
    Assert.assertTrue(CommonUtil.compareIgnoreFields(responseString
      , "expected/AddCustomerApi/AddCustomerApi_WhenDataMissedIDField_ThenCantAddCustomer.json"
      , "message"));
    List<Map<String, Object>> data = databaseUtil.getRecords("SELECT * FROM customers");
    Assert.assertEquals(data.size(),3);
  }

  @Test
  public void AddCustomerApi_WhenDataMissedFirstNameLastNameField_ThenCustomerAdded() throws Exception {
    RequestSpecification request = RestAssured.given();
    request.contentType(ContentType.JSON);
    request.baseUri("http://localhost:9119/api/customers");
    request.body(CommonUtil.readFileContent("requestBody/AddCustomerApi_WhenDataMissedFirstNameLastNameField_ThenCustomerAdded.json"));
    Response response = request.post();
    Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK);

    String responseString = response.body().asString();
    Assert.assertTrue(CommonUtil.compare(responseString, "expected/AddCustomerApi/AddCustomerApi_WhenDataIsValid_ThenAddedCustomer.json"));

    List<Map<String, Object>> data = databaseUtil.getRecords("SELECT * FROM customers");
    Assert.assertEquals(data.size(),4);
  }

  @Test
  public void AddCustomerApi_WhenRequiredRequestBodyIsMissing_ThenBadRequest() throws Exception {
    RequestSpecification request = RestAssured.given();
    request.contentType(ContentType.JSON);
    request.baseUri("http://localhost:9119/api/customers");
    Response response = request.post();
    Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_BAD_REQUEST);

    String responseString = response.body().asString();
    Assert.assertTrue(CommonUtil.compareIgnoreFields(responseString,
      "expected/AddCustomerApi/AddCustomerApi_WhenRequiredRequestBodyIsMissing_ThenBadRequest.json"
      , "message"));

  }

  @Test
  public void AddCustomerApi_WhenRequiredRequestBodyIsEmpty_ThenBadRequestData() throws Exception {
    RequestSpecification request = RestAssured.given();
    request.contentType(ContentType.JSON);
    request.baseUri("http://localhost:9119/api/customers");
    request.body(CommonUtil.readFileContent("requestBody/AddCustomerApi_WhenRequiredRequestBodyIsEmpty_ThenBadRequestData.json"));
    Response response = request.post();

    Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_BAD_REQUEST);
    String responseString = response.body().asString();
    Assert.assertTrue(CommonUtil.compareIgnoreFields(responseString,
      "expected/AddCustomerApi/AddCustomerApi_WhenRequiredRequestBodyIsEmpty_ThenBadRequestData.json"
      , "message"));

    List<Map<String, Object>> data = databaseUtil.getRecords("SELECT * FROM customers");
    Assert.assertEquals(data.size(),3);


  }


}
