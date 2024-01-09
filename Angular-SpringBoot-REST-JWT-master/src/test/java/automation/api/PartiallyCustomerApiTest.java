package automation.api;

import common.CommonUtil;
import common.DatabaseUtil;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class PartiallyCustomerApiTest {
  private DatabaseUtil databaseUtil;
  private Header header;


  @BeforeTest
  public void beforeTest() throws Exception {
    this.databaseUtil = new DatabaseUtil();
  }

  @BeforeMethod
  public void prepareData() throws Exception {
    databaseUtil.executeSQL("script/cleanUp.sql");
    databaseUtil.executeSQL("script/insert_customers.sql");
    header = new Header("Authorization", "Bearer " + CommonUtil.getAccessToken());
  }

  @Test
  public void PartiallyCustomerAPI_WhenCustomerIDIsValid_thenReturnData() throws Exception {
    RequestSpecification request = RestAssured.given();
    request.contentType(ContentType.JSON);
    request.header(header);
    request.baseUri("http://localhost:9119/api/customers/3");
    request.body(CommonUtil.readContentFile("requestBody/PartiallyCustomerAPI_WhenCustomerIDIsValid_thenReturnData.json"));
    Response response = request.patch();
    Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK);

    String responseString = response.body().asString();
    String expectedString = CommonUtil.readContentFile("expected/PartiallyCustomerApi/PartiallyCustomerAPI_WhenCustomerIDIsValid_thenReturnData.json");
    JSONAssert.assertEquals(expectedString, responseString, JSONCompareMode.STRICT);

    List<Map<String, Object>> data = databaseUtil.getRecords("SELECT * FROM customers WHERE id = 3");
    Map<String, Object> expectedRecord = data.get(0);
    Assert.assertEquals(expectedRecord.get("id"), 3);
  }

  @Test
  public void PartiallyCustomerAPI_WhenCustomerIDIsNotValid_thenUnableToUpdateResource() throws Exception {
    RequestSpecification request = RestAssured.given();
    request.contentType(ContentType.JSON);
    request.header(header);
    request.baseUri("http://localhost:9119/api/customers/5");
    request.body(CommonUtil.readContentFile("requestBody/PartiallyEmployeesAPI_WhenEmployeesIDIsNotValid_thenUnableToUpdateResource.json"));
    Response response = request.patch();
    Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK);

    String responseString = response.body().asString();
    String expectedString = CommonUtil.readContentFile("expected/PartiallyCustomerApi/PartiallyCustomerAPI_WhenCustomerIDIsNotValid_thenUnableToUpdateResource.json");
    JSONAssert.assertEquals(expectedString, responseString, JSONCompareMode.STRICT);

  }

  @Test
  public void PartiallyCustomerAPI_WhenCustomerIDIsEmpty_thenMethodNotAllowed() throws Exception {
    RequestSpecification request = RestAssured.given();
    request.contentType(ContentType.JSON);
    request.header(header);
    request.baseUri("http://localhost:9119/api/customers/");
    request.body(CommonUtil.readContentFile("requestBody/PartiallyCustomerAPI_WhenCustomerIDIsEmpty_thenMethodNotAllowed.json"));
    Response response = request.patch();
    Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_METHOD_NOT_ALLOWED);


  }

  @Test
  public void PartiallyCustomerAPI_WhenRequiredBodyRequestIsEmpty_thenBadRequest() throws Exception {
    RequestSpecification request = RestAssured.given();
    request.contentType(ContentType.JSON);
    request.header(header);
    request.baseUri("http://localhost:9119/api/customers/3");
    request.body(CommonUtil.readContentFile("requestBody/PartiallyCustomerAPI_WhenRequiredBodyRequestIsEmpty_thenBadRequest.json"));
    Response response = request.patch();
    Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_BAD_REQUEST);

  }

  @Test
  public void PartiallyCustomerAPI_WhenRequiredBodyRequestIsMissing_thenBadRequest() throws Exception {
    RequestSpecification request = RestAssured.given();
    request.contentType(ContentType.JSON);
    request.header(header);
    request.baseUri("http://localhost:9119/api/customers/3");
    request.body(CommonUtil.readContentFile("requestBody/PartiallyCustomerAPI_WhenRequiredBodyRequestIsMissing_thenBadRequest.json"));
    Response response = request.patch();
    Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_BAD_REQUEST);

    String responseString = response.body().asString();
    String expectedString = CommonUtil.readContentFile("expected/PartiallyCustomerApi/PartiallyCustomerAPI_WhenRequiredBodyRequestIsMissing_thenBadRequest.json");
    JSONAssert.assertEquals(expectedString, responseString, JSONCompareMode.LENIENT);
  }

}
