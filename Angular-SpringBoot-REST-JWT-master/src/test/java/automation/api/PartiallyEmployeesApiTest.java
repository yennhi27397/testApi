package automation.api;

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
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class PartiallyEmployeesApiTest {
  private DatabaseUtil databaseUtil;

  @BeforeTest
  public void beforeTest() throws Exception {
    this.databaseUtil = new DatabaseUtil();
  }

  @BeforeMethod
  public void prepareData() throws Exception {
    databaseUtil.executeSQL("script/cleanUp.sql");
    databaseUtil.executeSQL("script/insert_employees.sql");
  }

  @Test
  public void PartiallyEmployeesAPI_WhenEmployeesIDIsValid_thenReturnData() throws Exception {
    RequestSpecification request = RestAssured.given();
    request.contentType(ContentType.JSON);
    request.baseUri("http://localhost:9119/api/Employee/202");
    request.body(CommonUtil.readContentFile("requestBody/PartiallyEmployeesAPI_WhenEmployeesIDIsValid_thenReturnData.json"));
    Response response = request.patch();
    Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK);

    String responseString = response.body().asString();
    String expectedString = CommonUtil.readContentFile("expected/PartiallyEmployeesApi/PartiallyEmployeesAPI_WhenEmployeesIDIsValid_thenReturnData.json");
    JSONAssert.assertEquals(expectedString, responseString, JSONCompareMode.STRICT);

    List<Map<String, Object>> data = databaseUtil.getRecords("SELECT * FROM employees WHERE id = 202");
    Map<String, Object> expectedRecord = data.get(0);
    Assert.assertEquals(expectedRecord.get("id"), 202);

  }

  @Test
  public void PartiallyEmployeesAPI_WhenEmployeesIDIsNotValid_thenUnableToUpdateResource() throws Exception {
    RequestSpecification request = RestAssured.given();
    request.contentType(ContentType.JSON);
    request.baseUri("http://localhost:9119/api/Employee/205");
    request.body(CommonUtil.readContentFile("requestBody/PartiallyEmployeesAPI_WhenEmployeesIDIsNotValid_thenUnableToUpdateResource.json"));
    Response response = request.patch();
    Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK);

    String responseString = response.body().asString();
    String expectedString = CommonUtil.readContentFile("expected/PartiallyEmployeesApi/PartiallyEmployeesAPI_WhenEmployeesIDIsNotValid_thenReturnData.json");
    JSONAssert.assertEquals(expectedString, responseString, JSONCompareMode.STRICT);

  }

  @Test
  public void PartiallyEmployeesAPI_WhenEmployeesIDIsEmpty_thenNotFound() throws Exception {
    RequestSpecification request = RestAssured.given();
    request.contentType(ContentType.JSON);
    request.baseUri("http://localhost:9119/api/Employee/");
    request.body(CommonUtil.readContentFile("requestBody/PartiallyEmployeesAPI_WhenEmployeesIDIsEmpty_thenNotFound.json"));
    Response response = request.patch();
    Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_NOT_FOUND);
  }

  @Test
  public void PartiallyEmployeesAPI_WhenRequiredBodyRequestIsEmpty_thenBadRequest() throws Exception {
    RequestSpecification request = RestAssured.given();
    request.contentType(ContentType.JSON);
    request.baseUri("http://localhost:9119/api/Employee/201");
    request.body(CommonUtil.readContentFile("requestBody/PartiallyEmployeesAPI_WhenRequiredBodyRequestIsEmpty_thenBadRequest.json"));
    Response response = request.patch();
    Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_BAD_REQUEST);

    String responseString = response.body().asString();
    String expectedString = CommonUtil.readContentFile("expected/PartiallyEmployeesApi/PartiallyEmployeesAPI_WhenRequiredBodyRequestIsEmpty_thenBadRequest.json");
    JSONAssert.assertEquals(expectedString, responseString, JSONCompareMode.STRICT);

  }

  @Test
  public void PartiallyEmployeesAPI_WhenRequiredBodyRequestIsMissing_thenBadRequest() throws Exception {
    RequestSpecification request = RestAssured.given();
    request.contentType(ContentType.JSON);
    request.baseUri("http://localhost:9119/api/Employee/201");
    request.body(CommonUtil.readContentFile("requestBody/PartiallyEmployeesAPI_WhenRequiredBodyRequestIsMissing_thenBadRequest.json"));
    Response response = request.patch();
    Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_BAD_REQUEST);

    String responseString = response.body().asString();
    String expectedString = CommonUtil.readContentFile("expected/PartiallyEmployeesApi/PartiallyEmployeesAPI_WhenRequiredBodyRequestIsMissing_thenBadRequest.json");
    JSONAssert.assertEquals(expectedString, responseString, JSONCompareMode.LENIENT);
  }
}
