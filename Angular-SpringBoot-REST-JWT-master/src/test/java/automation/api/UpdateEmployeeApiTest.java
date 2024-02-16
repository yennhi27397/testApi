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

public class UpdateEmployeeApiTest {
  private DatabaseUtil databaseUtil;
  private Header header;

  @BeforeTest
  public void beforeTest() throws Exception {
    this.databaseUtil = new DatabaseUtil();
  }

  @BeforeMethod
  public void prepareStub() throws Exception {
    databaseUtil.executeSQL("script/cleanUp.sql");
    databaseUtil.executeSQL("script/insert_employees.sql");
    header = new Header("Authorization", "Bearer " + CommonUtil.getAccessToken());
  }

  @Test
  public void UpdateEmployeesApi_WhenEmployeesIdIsValid_ThenEmployeesAdded() throws Exception {
    RequestSpecification request = RestAssured.given();
    request.contentType(ContentType.JSON);
    request.header(header);
    request.baseUri("http://localhost:9119/api/Employees/201");
    request.body(CommonUtil.readContentFile("requestBody/UpdateEmployeeApi_WhenEmployeesIDIsValid_ThenUpdateData.json"));
    Response response = request.put();
    Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK);

    String responseString = response.body().asString();
    String expectedString = CommonUtil.readContentFile("expected/UpdateEmployeesApi/UpdateEmployeesApi_WhenEmployeesIdIsValid_ThenEmployeesAdded.json");
    JSONAssert.assertEquals(expectedString, responseString, JSONCompareMode.STRICT);

    List<Map<String, Object>> data = databaseUtil.getRecords("SELECT * FROM employees WHERE id = 201");
    Map<String, Object> expectedRecord = data.get(0);
    Assert.assertEquals(expectedRecord.get("id"), 201);
    Assert.assertEquals(expectedRecord.get("last_name"), "Nhi");
    Assert.assertEquals(expectedRecord.get("first_name"), "Yen");
    Assert.assertEquals(expectedRecord.get("email"), "string");
    Assert.assertEquals(expectedRecord.get("avatar"), "string");
    Assert.assertEquals(expectedRecord.get("job_title"), "string");
    Assert.assertEquals(expectedRecord.get("department"), "string");
    Assert.assertEquals(expectedRecord.get("manager_id"), 0);
    Assert.assertEquals(expectedRecord.get("phone"), "string");
    Assert.assertEquals(expectedRecord.get("address1"), "string");
    Assert.assertEquals(expectedRecord.get("address2"), "string");
    Assert.assertEquals(expectedRecord.get("city"), "string");
    Assert.assertEquals(expectedRecord.get("state"), "string");
    Assert.assertEquals(expectedRecord.get("postal_code"), "string");
    Assert.assertEquals(expectedRecord.get("country"), "string");


  }

  @Test
  public void UpdateEmployeesApi_WhenEmployeesIdIsInvalid_ThenUnableToUpdateResource() throws Exception {
    RequestSpecification request = RestAssured.given();
    request.contentType(ContentType.JSON);
    request.header(header);
    request.baseUri("http://localhost:9119/api/Employees/200");
    request.body(CommonUtil.readContentFile("requestBody/UpdateEmployeesApi_WhenEmployeesIdIsInvalid_ThenUnableToUpdateResource.json"));
    Response response = request.put();
    Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK);

    String responseString = response.body().asString();
    String expectedString = CommonUtil.readContentFile("expected/UpdateEmployeesApi/UpdateEmployeesApi_WhenEmployeesIdIsInvalid_ThenUnableToUpdateResource.json");
    JSONAssert.assertEquals(expectedString, responseString, JSONCompareMode.STRICT);
  }

  @Test
  public void UpdateEmployeesApi_WhenEmployeesIdIsEmpty_ThenNotFound() throws Exception {
    RequestSpecification request = RestAssured.given();
    request.contentType(ContentType.JSON);
    request.header(header);
    request.baseUri("http://localhost:9119/api/Employees/");
    request.body(CommonUtil.readContentFile("requestBody/UpdateEmployeesApi_WhenEmployeesIdIsEmpty_ThenNotFound.json"));
    Response response = request.put();

    Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_NOT_FOUND);
    String responseString = response.body().asString();
    String expectedString = CommonUtil.readContentFile("expected/UpdateEmployeesApi/UpdateEmployeesApi_WhenEmployeesIdIsEmpty_ThenNotFound.json");
    JSONAssert.assertEquals(expectedString, responseString, JSONCompareMode.LENIENT);


  }

  @Test
  public void UpdateEmployeesAPI_WhenRequiredBodyRequestIsEmpty_thenBadRequest() throws Exception {
    RequestSpecification request = RestAssured.given();
    request.contentType(ContentType.JSON);
    request.header(header);
    request.baseUri("http://localhost:9119/api/Employees/201");
    request.body(CommonUtil.readContentFile("requestBody/UpdateEmployeesAPI_WhenRequiredBodyRequestIsEmpty_thenBadRequest.json"));
    Response response = request.put();
    Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_BAD_REQUEST);

    String responseString = response.body().asString();
    String expectedString = CommonUtil.readContentFile("expected/UpdateEmployeesApi/UpdateEmployeesAPI_WhenRequiredBodyRequestIsEmpty_thenBadRequest.json");
    JSONAssert.assertEquals(expectedString, responseString, JSONCompareMode.LENIENT);
  }

  @Test
  public void UpdateEmployeesAPI_WhenRequiredBodyRequestIsMissing_thenBadRequest() throws Exception {
    RequestSpecification request = RestAssured.given();
    request.contentType(ContentType.JSON);
    request.header(header);
    request.baseUri("http://localhost:9119/api/Employees/201");
    request.body(CommonUtil.readContentFile("requestBody/UpdateEmployeesAPI_WhenRequiredBodyRequestIsMissing_thenBadRequest.json"));
    Response response = request.put();
    Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_BAD_REQUEST);

    String responseString = response.body().asString();
    String expectedString = CommonUtil.readContentFile("expected/UpdateEmployeesApi/UpdateEmployeesAPI_WhenRequiredBodyRequestIsMissing_thenBadRequest.json");
    JSONAssert.assertEquals(expectedString, responseString, JSONCompareMode.LENIENT);
  }

}

