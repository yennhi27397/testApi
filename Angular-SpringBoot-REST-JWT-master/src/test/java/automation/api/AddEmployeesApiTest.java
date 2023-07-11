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

public class AddEmployeesApiTest {
  private DatabaseUtil databaseUtil;

  @BeforeTest
  public void beforeTest() throws Exception {
    this.databaseUtil = new DatabaseUtil();
  }

  @BeforeMethod
  public void prepareData() throws Exception {
    this.databaseUtil = new DatabaseUtil();
    databaseUtil.executeSQL("script/cleanUp.sql");
    databaseUtil.executeSQL("script/insert_employees.sql");
  }

  @Test
  public void AddEmployeesApi_WhenDataIsValid_ThenEmployeeAdded() throws Exception {
    RequestSpecification request = RestAssured.given();
    request.contentType(ContentType.JSON);
    request.baseUri("http://localhost:9119/api/employees");
    request.body(CommonUtil.readFileContent("requestBody/AddEmployeesApi_WhenDataIsValid_ThenEmployeeAdded.json"));
    Response response = request.post();

    Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK);

    String responseString = response.body().asString();
    Assert.assertTrue(CommonUtil.compare(responseString, "expected/AddEmployeesApi/AddEmployeesApi_WhenDataIsValid_ThenEmployeeAdded.json"));

    List<Map<String, Object>> data = databaseUtil.getRecords("SELECT * FROM employees WHERE id = 3");
    Map<String, Object> expectedRecord = data.get(0);
    // field name lay trong table
    Assert.assertEquals(expectedRecord.get("id"), 3);
    Assert.assertEquals(expectedRecord.get("last_Name"), "string");
    Assert.assertEquals(expectedRecord.get("first_Name"), "string");
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
  public void AddEmployeesApi_WhenEmployeeIDExisted_ThenUnableToAddEmployee() throws Exception {
    RequestSpecification request = RestAssured.given();
    request.contentType(ContentType.JSON);
    request.baseUri("http://localhost:9119/api/employees");
    request.body(CommonUtil.readFileContent("requestBody/AddEmployeesApi_WhenEmployeeIDExisted_ThenUnableToAddEmployee.json"));
    Response response = request.post();

    Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK);

    String responseString = response.body().asString();
    Assert.assertTrue(CommonUtil.compare(responseString, "expected/AddEmployeesApi/AddEmployeesApi_WhenEmployeeIDExisted_ThenUnableToAddEmployee.json"));

    List<Map<String, Object>> data = databaseUtil.getRecords("SELECT * FROM employees WHERE id = 203");
    Map<String, Object> expectedRecord = data.get(0);

  }

  @Test
  public void AddEmployeesApi_WhenDataMissedIdField_ThenEmployeeDidNotAdd() throws Exception {
    RequestSpecification request = RestAssured.given();
    request.contentType(ContentType.JSON);
    request.baseUri("http://localhost:9119/api/employees");
    request.body(CommonUtil.readFileContent("requestBody/AddEmployeesApi_WhenDataMissedIdField_ThenEmployeeDidNotAdd.json"));
    Response response = request.post();

    Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_BAD_REQUEST);

    String responseString = response.body().asString();
    Assert.assertTrue(CommonUtil.compareIgnoreFields(responseString
      , "expected/AddEmployeesApi/AddEmployeesApi_WhenDataMissedIdField_ThenEmployeeDidNotAdd.json"
      , "message"
    ));
  }

  @Test
  public void AddEmployeesApi_WhenDataMissedLastNameFirstNameField_ThenEmployeeAdded() throws Exception {
    RequestSpecification request = RestAssured.given();
    request.contentType(ContentType.JSON);
    request.baseUri("http://localhost:9119/api/employees");
    request.body(CommonUtil.readFileContent("requestBody/AddEmployeesApi_WhenDataMissedLastNameFirstNameField_ThenEmployeeAdded.json"));
    Response response = request.post();
    Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK);

    String responseString = response.body().asString();
    Assert.assertTrue(CommonUtil.compare(responseString, "expected/AddEmployeesApi/AddEmployeesApi_WhenDataMissedLastNameFirstNameField_ThenEmployeeAdded.json"));

    List<Map<String, Object>> data = databaseUtil.getRecords("SELECT * FROM Employees WHERE id=2");
    Map<String, Object> expectedRecord = data.get(0);

    Assert.assertEquals(expectedRecord.get("id"), 2);


  }

  @Test
  public void AddEmployeeAPI_WhenRequiredBodyRequestIsEmpty_thenBadRequest() throws Exception {
    RequestSpecification request = RestAssured.given();
    request.contentType(ContentType.JSON);
    request.baseUri("http://localhost:9119/api/employees?employeeid=206");
    request.body(CommonUtil.readFileContent("requestBody/AddEmployeeAPI_WhenRequiredBodyRequestIsEmpty_thenBadRequest.json"));
    Response response = request.post();
    Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_BAD_REQUEST);

    String responseString = response.body().asString();
    Assert.assertTrue(CommonUtil.compareIgnoreFields(responseString
      , "expected/AddEmployeesApi/AddEmployeeAPI_WhenRequiredBodyRequestIsEmpty_thenBadRequest.json"
      , "message"));

  }

  @Test
  public void AddEmployeeAPI_WhenRequiredBodyRequestIsMissing_thenBadRequest() throws Exception {
    RequestSpecification request = RestAssured.given();
    request.contentType(ContentType.JSON);
    request.baseUri("http://localhost:9119/api/employees");
    request.body(CommonUtil.readFileContent("requestBody/AddEmployeeAPI_WhenRequiredBodyRequestIsMissing_thenBadRequest.json"));
    Response response = request.post();
    Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_BAD_REQUEST);

    String responseString = response.body().asString();
    Assert.assertTrue(CommonUtil.compareIgnoreFields(responseString
      , "expected/AddEmployeesApi/AddEmployeeAPI_WhenRequiredBodyRequestIsMissing_thenBadRequest.json"
      , "message"));


  }
}


