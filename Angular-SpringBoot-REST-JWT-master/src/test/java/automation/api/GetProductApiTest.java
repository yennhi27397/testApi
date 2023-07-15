package automation.api;

import common.CommonUtil;
import common.DatabaseUtil;
import org.apache.http.HttpStatus;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class GetProductApiTest {
  private DatabaseUtil databaseUtil;

  @BeforeTest
  public void beforeTest() throws Exception {
    databaseUtil = new DatabaseUtil();
  }

  @BeforeMethod
  public void prepareData() throws Exception {
    databaseUtil.executeSQL("script/cleanUpProduct.sql");
    databaseUtil.executeSQL("script/insert_product.sql");
  }
  @Test
  public void getOrderStatusApi_WhenOrderStatus_ThenReturnData() throws IOException {
    String responseString =
      given()
        .when().get("http://localhost:9119/api/product-stats-by-quantity")
        .then().log()
        .body()
        .assertThat()
        .statusCode(HttpStatus.SC_OK)
        .extract().asString();

    String expectedString = CommonUtil.readContentFile("expected/GetListProductApi/GetListProductApi_WhenProduct_ThenReturnOrdersbyQuantityOrdered.json");
    JSONAssert.assertEquals(expectedString, responseString, JSONCompareMode.STRICT);
  }

}
