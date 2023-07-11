package automation.api;

import common.CommonUtil;
import common.DatabaseUtil;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class PartiallyCustomerApi {
  private DatabaseUtil databaseUtil;

  @BeforeTest
  public void beforeTest() throws Exception {
    this.databaseUtil = new DatabaseUtil();
  }

  @BeforeTest
  public void prepareData() throws Exception {
    this.databaseUtil = new DatabaseUtil();
    databaseUtil.executeSQL("cleanUp.sql");
    databaseUtil.executeSQL("insert_customers.sql");
  }

  @Test
  public void PartiallyCustomerAPI_WhenCustomerIDIsValid_thenReturnData() throws Exception {
    RequestSpecification request = RestAssured.given();
    request.contentType(ContentType.JSON);
    request.baseUri("http://localhost:9119/api/customers/3");
    request.body(CommonUtil.readFileContent("PartiallyCustomerAPI_WhenCustomerIDIsValid_thenReturnData.json"));
    Response response = request.patch();
    Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK);

    String responseString = response.body().asString();
    Assert.assertTrue(CommonUtil.compare(responseString, "/PartiallyCustomerApi/PartiallyCustomerAPI_WhenCustomerIDIsValid_thenReturnData.json"));

    List<Map<String, Object>> data = databaseUtil.getRecords("SELECT * FROM customers WHERE id = 3");
    Map<String, Object> expectedRecord = data.get(0);
    Assert.assertEquals(expectedRecord.get("id"), 3);
  }

  @Test
  public void PartiallyCustomerAPI_WhenCustomerIDIsNotValid_thenUnableToUpdateResource() throws Exception {
    RequestSpecification request = RestAssured.given();
    request.contentType(ContentType.JSON);
    request.baseUri("http://localhost:9119/api/customers/5");
    request.body(CommonUtil.readFileContent("PartiallyCustomerAPI_WhenCustomerIDIsNotValid_thenUnableToUpdateResource.json"));
    Response response = request.patch();
    Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK);

    String responseString = response.body().asString();
    Assert.assertTrue(CommonUtil.compare(responseString, "/PartiallyCustomerApi/PartiallyCustomerAPI_WhenCustomerIDIsNotValid_thenUnableToUpdateResource.json"));

  }

  @Test
  public void PartiallyCustomerAPI_WhenCustomerIDIsEmpty_thenMethodNotAllowed() throws Exception {
    RequestSpecification request = RestAssured.given();
    request.contentType(ContentType.JSON);
    request.baseUri("http://localhost:9119/api/customers/");
    request.body(CommonUtil.readFileContent("PartiallyCustomerAPI_WhenCustomerIDIsEmpty_thenMethodNotAllowed.json"));
    Response response = request.patch();
    Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_METHOD_NOT_ALLOWED);


  }
}
