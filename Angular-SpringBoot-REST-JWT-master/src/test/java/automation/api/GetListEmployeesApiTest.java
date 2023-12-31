package automation.api;

import common.CommonUtil;
import common.DatabaseUtil;
import org.apache.http.HttpStatus;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetListEmployeesApiTest {
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
  public void GetListEmployeesApi_WhenPageIs1AndSizeIs1_ThenReturnData() throws Exception {
    String responseString =
      given()
        .queryParam("page", 1)
        .queryParam("size", 1)
        .when().get("http://localhost:9119/api/employees")
        .then().log()
        .body()
        .assertThat()
        .statusCode(HttpStatus.SC_OK)
        .extract().asString();

    String expectedString = CommonUtil.readContentFile("expected/GetListEmployeesApi/GetListEmployeesApi_WhenPageIs1AndSizeIs1_ThenReturnData.json");
    JSONAssert.assertEquals(expectedString, responseString, JSONCompareMode.STRICT);

  }

  @Test
  public void GetListEmployeesApi_WhenEmployeeID202_ThenReturnData() throws Exception {
    String responseString =
      given()
        .queryParam("employeeid", 202)
        .when().get("http://localhost:9119/api/employees")
        .then().log()
        .body()
        .assertThat()
        .statusCode(HttpStatus.SC_OK)
        .extract().asString();
    String expectedString = CommonUtil.readContentFile("expected/GetListEmployeesApi/GetListEmployeesApi_WhenEmployeeID202_ThenReturnData.json");
    JSONAssert.assertEquals(expectedString, responseString, JSONCompareMode.STRICT);
  }

  @Test
  public void GetListEmployeesApi_WhenEmployeeID204_ThenReturnData() throws Exception {
    String responseString =
      given()
        .queryParam("employeeid", 204)
        .when().get("http://localhost:9119/api/employees")
        .then().log()
        .body()
        .assertThat()
        .statusCode(HttpStatus.SC_OK)
        .extract().asString();
    String expectedString = CommonUtil.readContentFile("expected/GetListEmployeesApi/GetListEmployeesApi_WhenEmployeeID204_ThenReturnData.json");
    JSONAssert.assertEquals(expectedString, responseString, JSONCompareMode.STRICT);
  }

  @Test
  public void GetListEmployeesApi_WhenEmployeeIDIsEmpty_ThenReturnData() throws Exception {
    String responseString =
      given()
        .queryParam("employeeid", "")
        .when().get("http://localhost:9119/api/employees")
        .then().log()
        .body()
        .assertThat()
        .statusCode(HttpStatus.SC_OK)
        .extract().asString();
    String expectedString = CommonUtil.readContentFile("expected/GetListEmployeesApi/GetListEmployeesApi_WhenEmployeeIDIsEmpty_ThenReturnData.json");
    JSONAssert.assertEquals(expectedString, responseString, JSONCompareMode.STRICT);
  }
}
