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

public class DeleteCustomerApiTest {
  private DatabaseUtil databaseUtil;
  private Header header;


  @BeforeTest
  public void beforeTest() throws Exception {
    this.databaseUtil = new DatabaseUtil();
  }

  @BeforeMethod
  public void prepareData() throws Exception {
    databaseUtil.executeSQL("script/cleanUp.sql");
    databaseUtil.executeSQL("script/insert_customers.sql");
    header = new Header("Authorization", "Bearer " + CommonUtil.getAccessToken());
  }

  @Test
  public void deleteCustomerApi_WhenCustomerIDIsExist_ThenDeleteData() throws Exception {
    String responseString =
      given()
        .header(header)
        .when().delete("http://localhost:9119/api/customers/3")
        .then().log()
        .body()
        .assertThat()
        .statusCode(HttpStatus.SC_OK)
        .extract().asString();

    String expectedString = CommonUtil.readContentFile("expected/DeleteCustomerApi/deleteCustomerApi_WhenCustomerIDIsExist_ThenDeleteData.json");
    JSONAssert.assertEquals(expectedString, responseString, JSONCompareMode.STRICT);

    List<Map<String, Object>> data = databaseUtil.getRecords("SELECT * FROM customers");
    Assert.assertEquals(data.size(), 2);

  }

  @Test
  public void deleteCustomerApi_WhenCustomerIDIsNotExist_ThenRespondNoCustomerExist() throws Exception {
    String responseString =
      given()
        .header(header)
        .when().delete("http://localhost:9119/api/customers/5")
        .then().log()
        .body()
        .assertThat()
        .statusCode(HttpStatus.SC_OK)
        .extract().asString();

    String expectedString = CommonUtil.readContentFile("expected/DeleteCustomerApi/deleteCustomerApi_WhenCustomerIDIsNotExist_ThenRespondNoCustomerExist.json");
    JSONAssert.assertEquals(expectedString, responseString, JSONCompareMode.STRICT);
    List<Map<String, Object>> data = databaseUtil.getRecords("SELECT * FROM customers");
    Assert.assertEquals(data.size(), 3);
  }

  @Test
  public void deleteCustomerApi_WhenCustomerIDIsEmpty_ThenRespondMethodNotAllowed() throws Exception {
    String responseString =
      given()
        .header(header)
        .when().delete("http://localhost:9119/api/customers/")
        .then().log()
        .body()
        .assertThat()
        .statusCode(HttpStatus.SC_METHOD_NOT_ALLOWED)
        .extract().asString();

    String expectedString = CommonUtil.readContentFile("expected/DeleteCustomerApi/deleteCustomerApi_WhenCustomerIDIsEmpty_ThenRespondMethodNotAllowed.json");
    JSONAssert.assertEquals(expectedString, responseString, JSONCompareMode.LENIENT);
    List<Map<String, Object>> data = databaseUtil.getRecords("SELECT * FROM customers");
    Assert.assertEquals(data.size(), 3);
  }
}
