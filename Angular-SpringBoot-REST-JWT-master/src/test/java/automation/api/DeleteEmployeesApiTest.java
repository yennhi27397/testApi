package automation.api;

import common.CommonUtil;
import common.DatabaseUtil;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class DeleteEmployeesApiTest {
  private DatabaseUtil databaseUtil;

  @BeforeMethod
  public void prepareData() throws Exception {
    this.databaseUtil = new DatabaseUtil();
    databaseUtil.executeSQL("script/cleanUp.sql");
    databaseUtil.executeSQL("script/insert_employees.sql");
  }

  @Test
  public void deleteEmployeesApi_WhenEmployeeIDIsExist_ThenDeleteData() throws Exception {
    String respond =
      given()
        .when().delete("http://localhost:9119/api/Employees/201")
        .then().log()
        .body()
        .assertThat()
        .statusCode(HttpStatus.SC_OK)
        .extract().asString();
    Assert.assertTrue(CommonUtil.compare(respond,
      "expected/DeleteEmployeesApi/deleteEmployeeApi_WhenEmployeesIDIsExist_ThenDeleteData.json"));

    List<Map<String, Object>> data = databaseUtil.getRecords("SELECT * FROM employees WHERE id =201");
    Assert.assertEquals(data.size(), 0);
  }

  @Test
  public void deleteEmployeesApi_WhenEmployeeIDIsNotExist_ThenNoEmployeeExist() throws Exception {
    String respond =
      given()
        .when().delete("http://localhost:9119/api/Employees/204")
        .then().log()
        .body()
        .assertThat()
        .statusCode(HttpStatus.SC_OK)
        .extract().asString();
    Assert.assertTrue(CommonUtil.compare(respond,
      "expected/DeleteEmployeesApi/deleteEmployeesApi_WhenEmployeeIDIsNotExist_ThenNoEmployeeExist.json"));
  }

  @Test
  public void deleteEmployeesApi_WhenEmployeeIDIsEmpty_ThenNotFound() throws Exception {
    String respond =
      given()
        .when().delete("http://localhost:9119/api/Employees/")
        .then().log()
        .body()
        .assertThat()
        .statusCode(HttpStatus.SC_NOT_FOUND)
        .extract().asString();
  }

}
