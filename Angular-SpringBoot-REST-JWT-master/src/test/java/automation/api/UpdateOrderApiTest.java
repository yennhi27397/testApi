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

public class UpdateOrderApiTest {
  private DatabaseUtil databaseUtil;
  private Header header;

  @BeforeTest
  public void beforeTest() throws Exception {
    this.databaseUtil = new DatabaseUtil();
  }

  @BeforeMethod
  public void prepareStub() throws Exception {
    databaseUtil.executeSQL("stubdata/cleanUp.sql");
    databaseUtil.executeSQL("stubdata/insert_orders.sql");
    header = new Header("Authorization", "Bearer " + CommonUtil.getAccessToken());
  }

  @Test
  public void UpdateOrderApi_WhereOrderIDIsValid_ThenResourceUpdated() throws Exception {
    RequestSpecification request = RestAssured.given();
    request.contentType(ContentType.JSON);
    request.header(header);
    request.baseUri("http://localhost:9119/api/orders/4004");
    request.body(CommonUtil.readContentFile("requestBody/UpdateOrderApi_WhereOrderIDIsValid_ThenResourceUpdated.json"));
    Response response = request.put();
    Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK);

    String responseString = response.body().asString();
    String expectedString = CommonUtil.readContentFile("expected/UpdateOrderApi/UpdateOrderApi_WhereOrderIDIsValid_ThenResourceUpdated.json");
    JSONAssert.assertEquals(expectedString, responseString, JSONCompareMode.LENIENT);

  }

  @Test
  public void UpdateOrderApi_WhereOrderIDIsInvalid_ThenResourceUpdated() throws Exception {
    RequestSpecification request = RestAssured.given();
    request.contentType(ContentType.JSON);
    request.header(header);
    request.baseUri("http://localhost:9119/api/orders/4006");
    request.body(CommonUtil.readContentFile("requestBody/UpdateOrderApi_WhereOrderIDIsInvalid_ThenResourceUpdated.json"));
    Response response = request.put();
    Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK);

    String responseString = response.body().asString();
    String expectedString = CommonUtil.readContentFile("expected/UpdateOrderApi/UpdateOrderApi_WhereOrderIDIsInvalid_ThenResourceUpdated.json");
    JSONAssert.assertEquals(expectedString, responseString, JSONCompareMode.LENIENT);

  }

  @Test
  public void UpdateOrderApi_WhereOrderIDIsEmpty_ThenMethodNotAllowed() throws Exception {
    RequestSpecification request = RestAssured.given();
    request.contentType(ContentType.JSON);
    request.header(header);
    request.baseUri("http://localhost:9119/api/orders/");
    request.body(CommonUtil.readContentFile("requestBody/UpdateOrderApi_WhereOrderIDIsEmpty_ThenMethodNotAllowed.json"));
    Response response = request.put();

    Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_METHOD_NOT_ALLOWED);
    String responseString = response.body().asString();
    String expectedString = CommonUtil.readContentFile("expected/UpdateOrderApi/UpdateOrderApi_WhereOrderIDIsEmpty_ThenMethodNotAllowed.json");
    JSONAssert.assertEquals(expectedString, responseString, JSONCompareMode.LENIENT);
  }

  @Test
  public void UpdateOrderApi_WhereRequiredBodyRequestIsEmpty_ThenBadRequestData() throws Exception {
    RequestSpecification request = RestAssured.given();
    request.contentType(ContentType.JSON);
    request.header(header);
    request.baseUri("http://localhost:9119/api/orders/4005");
    request.body(CommonUtil.readContentFile("requestBody/UpdateOrderApi_WhereRequiredBodyRequestIsEmpty_ThenBadRequestData.json"));
    Response response = request.put();

    Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_BAD_REQUEST);
    String responseString = response.body().asString();
    String expectedString = CommonUtil.readContentFile("expected/UpdateOrderApi/UpdateOrderApi_WhereRequiredBodyRequestIsEmpty_ThenBadRequestData.json");
    JSONAssert.assertEquals(expectedString, responseString, JSONCompareMode.LENIENT);
  }

  @Test
  public void UpdateOrderApi_WhereRequiredBodyRequestIsMissing_ThenBadRequestData() throws Exception {
    RequestSpecification request = RestAssured.given();
    request.contentType(ContentType.JSON);
    request.header(header);
    request.baseUri("http://localhost:9119/api/orders/4005");
    request.body(CommonUtil.readContentFile("requestBody/UpdateOrderApi_WhereRequiredBodyRequestIsMissing_ThenBadRequestData.json"));
    Response response = request.put();

    Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_BAD_REQUEST);
    String responseString = response.body().asString();
    String expectedString = CommonUtil.readContentFile("expected/UpdateOrderApi/UpdateOrderApi_WhereRequiredBodyRequestIsMissing_ThenBadRequestData.json");
    JSONAssert.assertEquals(expectedString, responseString, JSONCompareMode.LENIENT);

  }

  @Test
  public void UpdateOrderApi_WhereCustomerIDIsValid_ThenResourceUpdated() throws Exception {
    RequestSpecification request = RestAssured.given();
    request.contentType(ContentType.JSON);
    request.header(header);
    request.baseUri("http://localhost:9119/api/orders/4004");
    request.body(CommonUtil.readContentFile("requestBody/UpdateOrderApi_WhereCustomerIDIsValid_ThenResourceUpdated.json"));
    Response response = request.put();

    Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK);
    String responseString = response.body().asString();
    String expectedString = CommonUtil.readContentFile("expected/UpdateOrderApi/UpdateOrderApi_WhereCustomerIDIsValid_ThenResourceUpdated.json");
    JSONAssert.assertEquals(expectedString, responseString, JSONCompareMode.LENIENT);
  }

  @Test
  public void UpdateOrderApi_WhereCustomerIDIsInvalid_ThenConstraintViolationOfResource() throws Exception {
    RequestSpecification request = RestAssured.given();
    request.contentType(ContentType.JSON);
    request.header(header);
    request.baseUri("http://localhost:9119/api/orders/4004");
    request.body(CommonUtil.readContentFile("requestBody/UpdateOrderApi_WhereCustomerIDIsInvalid_ThenConstraintViolationOfResource.json"));
    Response response = request.put();
    Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_BAD_REQUEST);

    String responseString = response.body().asString();
    String expectedString = CommonUtil.readContentFile("expected/UpdateOrderApi/UpdateOrderApi_WhereCustomerIDIsInvalid_ThenConstraintViolationOfResource.json");
    JSONAssert.assertEquals(expectedString, responseString, JSONCompareMode.LENIENT);
  }
}
