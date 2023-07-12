package automation.api;

import common.CommonUtil;
import common.DatabaseUtil;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetListOderDetailApiTest {
  private DatabaseUtil databaseUtil;

  @BeforeTest
  public void beforeTest() throws Exception {
    this.databaseUtil = new DatabaseUtil();
  }

  @BeforeMethod
  public void prepareData() throws Exception {
    this.databaseUtil = new DatabaseUtil();
    databaseUtil.executeSQL("script/cleanUp.sql");
    databaseUtil.executeSQL("script/insert_ordersDetail.sql");
  }

  @Test
  public void GetListOrdersApi_WhenOrderIDIsValid_ThenReturnData() throws Exception {
    String response =
      given()
        .queryParam("orderid", 4005)
        .when().get("http://localhost:9119/api/order-details")
        .then().log()
        .body()
        // check result
        .assertThat()
        .statusCode(HttpStatus.SC_OK)
        .extract().asString();
    Assert.assertTrue(CommonUtil.compare(response, "expected/GetListOrdersDetailApi/GetListOrdersApi_WhenOrderIDIsValid_ThenReturnData.json"));
  }
}
