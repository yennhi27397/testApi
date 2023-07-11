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

public class UpdateEmployeeApiTest {
  private DatabaseUtil databaseUtil;

  @BeforeTest
  public void beforeTest() throws Exception {
    this.databaseUtil = new DatabaseUtil();
  }

  @BeforeMethod
  public void prepareStub() throws Exception {
    this.databaseUtil = new DatabaseUtil();
    databaseUtil.executeSQL("script/cleanUp.sql");
    databaseUtil.executeSQL("script/insert_employees.sql");
  }

  @Test
  public void UpdateEmployeesApi_WhenEmployeesIdIsValid_ThenEmployeesAdded() throws Exception {
    RequestSpecification request = RestAssured.given();
    request.contentType(ContentType.JSON);
    request.baseUri("http://localhost:9119/api/Employees/201");
    request.body(CommonUtil.readFileContent("requestBody/UpdateEmployeeApi_WhenEmployeesIDIsValid_ThenUpdateData.json"));
    Response response = request.put();
    Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK);

    String responseString = response.body().asString();
    Assert.assertTrue(CommonUtil.compare(responseString,
      "expected/UpdateEmployeesApi/UpdateEmployeesApi_WhenEmployeesIdIsValid_ThenEmployeesAdded.json"));

    List<Map<String, Object>> data = databaseUtil.getRecords("SELECT * FROM employees WHERE id = 201");
    Map<String, Object> expectedRecord = data.get(0);
    Assert.assertEquals(expectedRecord.get("id"), 201);
  }

  @Test
  public void UpdateEmployeesApi_WhenEmployeesIdIsInvalid_ThenUnableToUpdateResource() throws Exception {
    RequestSpecification request = RestAssured.given();
    request.contentType(ContentType.JSON);
    request.baseUri("http://localhost:9119/api/Employees/200");
    request.body(CommonUtil.readFileContent("requestBody/UpdateEmployeesApi_WhenEmployeesIdIsInvalid_ThenUnableToUpdateResource.json"));
    Response response = request.put();
    Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK);

    String responseString = response.body().asString();
    Assert.assertTrue(CommonUtil.compare(responseString,
      "expected/UpdateEmployeesApi/UpdateEmployeesApi_WhenEmployeesIdIsInvalid_ThenUnableToUpdateResource.json"));
  }

  @Test
  public void UpdateEmployeesApi_WhenEmployeesIdIsEmpty_ThenNotFound() throws Exception {
    RequestSpecification request = RestAssured.given();
    request.contentType(ContentType.JSON);
    request.baseUri("http://localhost:9119/api/Employees/");
    request.body(CommonUtil.readFileContent("requestBody/UpdateEmployeesApi_WhenEmployeesIdIsEmpty_ThenNotFound.json"));
    Response response = request.put();
    Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_NOT_FOUND);
  }

  @Test
  public void UpdateEmployeesAPI_WhenRequiredBodyRequestIsEmpty_thenBadRequest() throws Exception {
    RequestSpecification request = RestAssured.given();
    request.contentType(ContentType.JSON);
    request.baseUri("http://localhost:9119/api/Employees/201");
    request.body(CommonUtil.readFileContent("requestBody/UpdateEmployeesAPI_WhenRequiredBodyRequestIsEmpty_thenBadRequest.json"));
    Response response = request.put();
    Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_BAD_REQUEST);

    String responseString = response.body().asString();
    Assert.assertTrue(CommonUtil.compare(responseString,
      "expected/UpdateEmployeesApi/UpdateEmployeesAPI_WhenRequiredBodyRequestIsEmpty_thenBadRequest.json"));
  }

  @Test
  public void UpdateEmployeesAPI_WhenRequiredBodyRequestIsMissing_thenBadRequest() throws Exception {
    RequestSpecification request = RestAssured.given();
    request.contentType(ContentType.JSON);
    request.baseUri("http://localhost:9119/api/Employees/201");
    request.body(CommonUtil.readFileContent("requestBody/UpdateEmployeesAPI_WhenRequiredBodyRequestIsMissing_thenBadRequest.json"));
    Response response = request.put();
    Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_BAD_REQUEST);

    String responseString = response.body().asString();
    Assert.assertTrue(CommonUtil.compareIgnoreFields(responseString,
      "expected/UpdateEmployeesApi/UpdateEmployeesAPI_WhenRequiredBodyRequestIsMissing_thenBadRequest.json"
      , "message"
    ));
  }

}

