package automation.api;

import common.CommonUtil;
import common.DatabaseUtil;
import io.restassured.http.Header;
import org.apache.http.HttpStatus;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class DeleteEmployeesApiTest {
  private DatabaseUtil databaseUtil;
  private Header header;


  @BeforeTest
  public void beforeTest() throws Exception {
    this.databaseUtil = new DatabaseUtil();
  }

  @BeforeMethod
  public void prepareData() throws Exception {
    databaseUtil.executeSQL("script/cleanUp.sql");
    databaseUtil.executeSQL("script/insert_employees.sql");
    header = new Header("Authorization", "Bearer " + CommonUtil.getAccessToken());

  }

  @Test
  public void deleteEmployeesApi_WhenEmployeeIDIsExist_ThenDeleteData() throws Exception {
    String responseString =
      given()
        .header(header)
        .when().delete("http://localhost:9119/api/Employees/201")
        .then().log()
        .body()
        .assertThat()
        .statusCode(HttpStatus.SC_OK)
        .extract().asString();
    String expectedString = CommonUtil.readContentFile("expected/DeleteEmployeesApi/deleteEmployeeApi_WhenEmployeesIDIsExist_ThenDeleteData.json");
    JSONAssert.assertEquals(expectedString, responseString, JSONCompareMode.STRICT);

    List<Map<String, Object>> data = databaseUtil.getRecords("SELECT * FROM employees");
    Assert.assertEquals(data.size(), 2);
  }

  @Test
  public void deleteEmployeesApi_WhenEmployeeIDIsNotExist_ThenNoEmployeeExist() throws Exception {
    String responseString =
      given()
        .header(header)
        .when().delete("http://localhost:9119/api/Employees/204")
        .then().log()
        .body()
        .assertThat()
        .statusCode(HttpStatus.SC_OK)
        .extract().asString();
    String expectedString = CommonUtil.readContentFile("expected/DeleteEmployeesApi/deleteEmployeesApi_WhenEmployeeIDIsNotExist_ThenNoEmployeeExist.json");
    JSONAssert.assertEquals(expectedString, responseString, JSONCompareMode.STRICT);

    List<Map<String, Object>> data = databaseUtil.getRecords("SELECT * FROM employees");
    Assert.assertEquals(data.size(), 3);
  }

  @Test
  public void deleteEmployeesApi_WhenEmployeeIDIsEmpty_ThenNotFound() throws Exception {
    String responseString =
      given()
        .header(header)
        .when().delete("http://localhost:9119/api/Employees/")
        .then().log()
        .body()
        .assertThat()
        .statusCode(HttpStatus.SC_NOT_FOUND)
        .extract().asString();

    String expectedString = CommonUtil.readContentFile("expected/DeleteEmployeesApi/deleteEmployeeApi_WhenEmployeeIDIsEmpty_ThenRespondMethodNotAllowed.json");
    JSONAssert.assertEquals(expectedString, responseString, JSONCompareMode.LENIENT);

    List<Map<String, Object>> data = databaseUtil.getRecords("SELECT * FROM Employees");
    Assert.assertEquals(data.size(), 3);
  }

}
