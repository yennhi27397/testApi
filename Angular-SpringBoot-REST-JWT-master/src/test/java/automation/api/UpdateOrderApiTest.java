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
import org.testng.annotations.Test;

public class UpdateOrderApiTest {
  private DatabaseUtil databaseUtil;

  @BeforeMethod
  public void prepareStub() throws Exception {
    this.databaseUtil = new DatabaseUtil();
    databaseUtil.executeSQL("script/cleanUpOrders.sql");
    databaseUtil.executeSQL("script/insert_orders.sql");
  }

  @Test
  public void UpdateOrderApi_WhereOrderIDIsValid_ThenResourceUpdated() throws Exception {
    RequestSpecification request = RestAssured.given();
    request.contentType(ContentType.JSON);
    request.baseUri("http://localhost:9119/api/orders/4004");
    request.body(CommonUtil.readBody("requestBody/UpdateOrderApi_WhereOrderIDIsValid_ThenResourceUpdated.json"));
    Response response = request.put();
    Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK);

    String responseString = response.body().asString();
    Assert.assertTrue(CommonUtil.compareIgnoreFields(responseString,
      "expected/UpdateOrderApi/UpdateOrderApi_WhereOrderIDIsValid_ThenResourceUpdated.json"
      , "first", "last", "currentPageNumber", "itemsInPage", "pageSize", "totalPages", "totalItems", "sort", "items"));

  }

  @Test
  public void UpdateOrderApi_WhereOrderIDIsInvalid_ThenResourceUpdated() throws Exception {
    RequestSpecification request = RestAssured.given();
    request.contentType(ContentType.JSON);
    request.baseUri("http://localhost:9119/api/orders/4006");
    request.body(CommonUtil.readBody("requestBody/UpdateOrderApi_WhereOrderIDIsInvalid_ThenResourceUpdated.json"));
    Response response = request.put();
    Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK);

    String responseString = response.body().asString();
    Assert.assertTrue(CommonUtil.compareIgnoreFields(responseString,
      "expected/UpdateOrderApi/UpdateOrderApi_WhereOrderIDIsInvalid_ThenResourceUpdated.json"
      , "first", "last", "currentPageNumber", "itemsInPage", "pageSize", "totalPages", "totalItems", "sort", "items"));

  }

  @Test
  public void UpdateOrderApi_WhereOrderIDIsEmpty_ThenMethodNotAllowed() throws Exception {
    RequestSpecification request = RestAssured.given();
    request.contentType(ContentType.JSON);
    request.baseUri("http://localhost:9119/api/orders/");
    request.body(CommonUtil.readBody("requestBody/UpdateOrderApi_WhereOrderIDIsEmpty_ThenMethodNotAllowed.json"));
    Response response = request.put();
    Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_METHOD_NOT_ALLOWED);

    String responseString = response.body().asString();
    Assert.assertTrue(CommonUtil.compareIgnoreFields(responseString,
      "expected/UpdateOrderApi/UpdateOrderApi_WhereOrderIDIsEmpty_ThenMethodNotAllowed.json"
      , "timestamp", "exception", "message", "path"));
  }

  @Test
  public void UpdateOrderApi_WhereRequiredBodyRequestIsEmpty_ThenBadRequestData() throws Exception {
    RequestSpecification request = RestAssured.given();
    request.contentType(ContentType.JSON);
    request.baseUri("http://localhost:9119/api/orders/4005");
    request.body(CommonUtil.readBody("requestBody/UpdateOrderApi_WhereRequiredBodyRequestIsEmpty_ThenBadRequestData.json"));
    Response response = request.put();
    Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_BAD_REQUEST);

    String responseString = response.body().asString();
    Assert.assertTrue(CommonUtil.compareIgnoreFields(responseString,
      "expected/UpdateOrderApi/UpdateOrderApi_WhereRequiredBodyRequestIsEmpty_ThenBadRequestData.json"
      , "message"));
  }

  @Test
  public void UpdateOrderApi_WhereRequiredBodyRequestIsMissing_ThenBadRequestData() throws Exception {
    RequestSpecification request = RestAssured.given();
    request.contentType(ContentType.JSON);
    request.baseUri("http://localhost:9119/api/orders/4005");
    request.body(CommonUtil.readBody("requestBody/UpdateOrderApi_WhereRequiredBodyRequestIsMissing_ThenBadRequestData.json"));
    Response response = request.put();
    Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_BAD_REQUEST);

    String responseString = response.body().asString();
    Assert.assertTrue(CommonUtil.compareIgnoreFields(responseString,
      "expected/UpdateOrderApi/UpdateOrderApi_WhereRequiredBodyRequestIsMissing_ThenBadRequestData.json"
      , "message"));

  }

  @Test
  public void UpdateOrderApi_WhereCustomerIDIsValid_ThenResourceUpdated() throws Exception {
    RequestSpecification request = RestAssured.given();
    request.contentType(ContentType.JSON);
    request.baseUri("http://localhost:9119/api/orders/4004");
    request.body(CommonUtil.readBody("requestBody/UpdateOrderApi_WhereCustomerIDIsValid_ThenResourceUpdated.json"));
    Response response = request.put();
    Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK);

    String responseString = response.body().asString();
    Assert.assertTrue(CommonUtil.compareIgnoreFields(responseString,
      "expected/UpdateOrderApi/UpdateOrderApi_WhereCustomerIDIsValid_ThenResourceUpdated.json"
      , "first", "last", "currentPageNumber", "itemsInPage", "pageSize", "totalPages", "totalItems", "sort", "items"));
  }

  @Test
  public void UpdateOrderApi_WhereCustomerIDIsInvalid_ThenConstraintViolationOfResource() throws Exception {
    RequestSpecification request = RestAssured.given();
    request.contentType(ContentType.JSON);
    request.baseUri("http://localhost:9119/api/orders/4004");
    request.body(CommonUtil.readBody("requestBody/UpdateOrderApi_WhereCustomerIDIsInvalid_ThenConstraintViolationOfResource.json"));
    Response response = request.put();
    Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_BAD_REQUEST);

    String responseString = response.body().asString();
    Assert.assertTrue(CommonUtil.compareIgnoreFields(responseString,
      "expected/UpdateOrderApi/UpdateOrderApi_WhereCustomerIDIsInvalid_ThenConstraintViolationOfResource.json"
      , "first", "last", "currentPageNumber", "itemsInPage", "pageSize", "totalPages", "totalItems", "sort", "items"));
  }
}
