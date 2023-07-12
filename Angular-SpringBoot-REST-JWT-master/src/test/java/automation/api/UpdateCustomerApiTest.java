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

public class UpdateCustomerApiTest {
  private DatabaseUtil databaseUtil;

  @BeforeTest
  public void beforeTest() throws Exception {
    this.databaseUtil = new DatabaseUtil();
  }

  @BeforeMethod
  public void prepareData() throws Exception {
    databaseUtil.executeSQL("script/cleanUp.sql");
    databaseUtil.executeSQL("script/insert_customers.sql");
  }

  @Test
  public void UpdateCustomerApi_WhenCustomerIDIsValid_ThenResultData() throws Exception {
    RequestSpecification request = RestAssured.given();
    request.contentType(ContentType.JSON);
    request.baseUri("http://localhost:9119/api/customers/1");
    request.body(CommonUtil.readFileContent("requestBody/UpdateCustomerApi_WhenCustomerIDIsValid_ThenEditData.json"));
    Response response = request.put();
    Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK);

    String responseString = response.body().asString();
    Assert.assertTrue(CommonUtil.compare(responseString, "expected/UpdateCustomerApi/UpdateCustomerApi_WhenCustomerIDIsValid_ThenResultData.json"));

    List<Map<String, Object>> data = databaseUtil.getRecords("SELECT * FROM customers WHERE id = 1");
    Map<String, Object> expectedRecord = data.get(0);

    Assert.assertEquals(expectedRecord.get("id"), 1);
    Assert.assertEquals(expectedRecord.get("last_name"), "Yen");
    Assert.assertEquals(expectedRecord.get("first_name"), "Nhi");
    Assert.assertEquals(expectedRecord.get("email"), "cgray0@rambler.ru");
    Assert.assertEquals(expectedRecord.get("company"), "Jetpulse");
    Assert.assertEquals(expectedRecord.get("phone"), "1-(260)615-5114");
    Assert.assertEquals(expectedRecord.get("address1"), "02937 Merrick Avenue");
    Assert.assertEquals(expectedRecord.get("city"), "Fort Wayne");
    Assert.assertEquals(expectedRecord.get("state"), "Indiana");
    Assert.assertEquals(expectedRecord.get("postal_code"), "46805");
    Assert.assertEquals(expectedRecord.get("country"), "United States");

  }

  @Test
  public void UpdateCustomerApi_WhenCustomerIDIsNotValid_ThenResourceIsNotExisted() throws Exception {
    RequestSpecification request = RestAssured.given();
    request.contentType(ContentType.JSON);
    request.baseUri("http://localhost:9119/api/customers/4");
    request.body(CommonUtil.readFileContent("requestBody/UpdateCustomerApi_WhenCustomerIDIsNotValid_ThenResourceIsNotExisted.json"));
    Response response = request.put();
    Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK);

    String responseString = response.body().asString();
    Assert.assertTrue(CommonUtil.compare(responseString, "expected/UpdateCustomerApi/UpdateCustomerApi_WhenCustomerIDIsNotValid_ThenResourceIsNotExisted.json"));
  }

  @Test
  public void UpdateCustomerApi_WhenCustomerIDIsEmpty_ThenMethodNotAllowed() throws Exception {
    RequestSpecification request = RestAssured.given();
    request.contentType(ContentType.JSON);
    request.baseUri("http://localhost:9119/api/customers/");
    request.body(CommonUtil.readFileContent("requestBody/UpdateCustomerApi_WhenCustomerIDIsEmpty_ThenMethodNotAllowed.json"));
    Response response = request.put();
    Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_METHOD_NOT_ALLOWED);

    String responseString = response.body().asString();
    Assert.assertTrue(CommonUtil.compareIgnoreFields(responseString, "expected/UpdateCustomerApi/UpdateCustomerApi_WhenCustomerIDIsEmpty_ThenMethodNotAllowed.json"
    , "timestamp","exception","message","path"));
  }

  @Test
  public void UpdateCustomerAPI_WhenRequiredBodyRequestIsEmpty_thenBadRequest() throws Exception {
    RequestSpecification request = RestAssured.given();
    request.contentType(ContentType.JSON);
    request.baseUri("http://localhost:9119/api/customers/3");
    request.body(CommonUtil.readFileContent("requestBody/UpdateCustomerAPI_WhenRequiredBodyRequestIsEmpty_thenBadRequest.json"));
    Response response = request.put();
    Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_BAD_REQUEST);

    String responseString = response.body().asString();
    Assert.assertTrue(CommonUtil.compareIgnoreFields(responseString, "expected/UpdateCustomerApi/UpdateCustomerAPI_WhenRequiredBodyRequestIsEmpty_thenBadRequest.json"
      , "message"));
  }

  @Test
  public void UpdateCustomerAPI_WhenRequiredBodyRequestIsMissing_thenBadRequest() throws Exception {
    RequestSpecification request = RestAssured.given();
    request.contentType(ContentType.JSON);
    request.baseUri("http://localhost:9119/api/customers/3");
    request.body(CommonUtil.readFileContent("requestBody/UpdateCustomerAPI_WhenRequiredBodyRequestIsMissing_thenBadRequest.json"));
    Response response = request.put();

    Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_BAD_REQUEST);
    String responseString = response.body().asString();
    Assert.assertTrue(CommonUtil.compareIgnoreFields(responseString,
      "expected/UpdateCustomerApi/UpdateCustomerAPI_WhenRequiredBodyRequestIsMissing_thenBadRequest.json",
      "message"));
  }
}




