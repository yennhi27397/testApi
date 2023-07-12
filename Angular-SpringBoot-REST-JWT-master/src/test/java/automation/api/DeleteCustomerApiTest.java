package automation.api;

import common.CommonUtil;
import common.DatabaseUtil;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class DeleteCustomerApiTest {
  private DatabaseUtil databaseUtil;

  @BeforeTest
  public void beforeTest() throws Exception {
    this.databaseUtil = new DatabaseUtil();
  }

  @BeforeMethod
  public void prepareData() throws Exception {
    databaseUtil.executeSQL("script/cleanUp.sql");
    databaseUtil.executeSQL("script/insert_customers.sql");
  }

  @Test
  public void deleteCustomerApi_WhenCustomerIDIsExist_ThenDeleteData() throws Exception {
    String response =
      given()
        .when().delete("http://localhost:9119/api/customers/3")
        .then().log()
        .body()
        .assertThat()
        .statusCode(HttpStatus.SC_OK)
        .extract().asString();

    Assert.assertTrue(CommonUtil.compare(response, "expected/DeleteCustomerApi/deleteCustomerApi_WhenCustomerIDIsExist_ThenDeleteData.json"));

    List<Map<String, Object>> data = databaseUtil.getRecords("SELECT * FROM customers");
    Assert.assertEquals(data.size(),2);

  }

  @Test
  public void deleteCustomerApi_WhenCustomerIDIsNotExist_ThenRespondNoCustomerExist() throws Exception {
    String response =
      given()
        .when().delete("http://localhost:9119/api/customers/5")
        .then().log()
        .body()
        .assertThat()
        .statusCode(HttpStatus.SC_OK)
        .extract().asString();

    Assert.assertTrue(CommonUtil.compare(response, "expected/DeleteCustomerApi/deleteCustomerApi_WhenCustomerIDIsNotExist_ThenRespondNoCustomerExist.json"));
    List<Map<String, Object>> data = databaseUtil.getRecords("SELECT * FROM customers");
    Assert.assertEquals(data.size(),3);
  }

  @Test
  public void deleteCustomerApi_WhenCustomerIDIsEmpty_ThenRespondMethodNotAllowed() throws Exception {
    String response =
      given()
        .when().delete("http://localhost:9119/api/customers/")
        .then().log()
        .body()
        .assertThat()
        .statusCode(HttpStatus.SC_METHOD_NOT_ALLOWED)
        .extract().asString();

    Assert.assertTrue(CommonUtil.compareIgnoreFields(response,"expected/DeleteCustomerApi/deleteCustomerApi_WhenCustomerIDIsEmpty_ThenRespondMethodNotAllowed.json"
    ,"timestamp","exception","message","path"));
    List<Map<String, Object>> data = databaseUtil.getRecords("SELECT * FROM customers");
    Assert.assertEquals(data.size(),3);


  }


}
