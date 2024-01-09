package automation.api;

import common.CommonUtil;
import common.DatabaseUtil;
import io.restassured.http.Header;
import org.apache.http.HttpStatus;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetListOderDetailApiTest {
  private DatabaseUtil databaseUtil;
  private Header header;


  @BeforeTest
  public void beforeTest() throws Exception {
    this.databaseUtil = new DatabaseUtil();
  }

  @BeforeMethod
  public void prepareData() throws Exception {
    this.databaseUtil = new DatabaseUtil();
    databaseUtil.executeSQL("script/cleanUp.sql");
    databaseUtil.executeSQL("script/insert_ordersDetail.sql");
    header = new Header("Authorization", "Bearer " + CommonUtil.getAccessToken());

  }

  @Test
  public void GetListOrdersApi_WhenOrderIDIsValid_ThenReturnData() throws Exception {
    String responseString =
      given()
        .header(header)
        .queryParam("orderid", 4005)
        .when().get("http://localhost:9119/api/order-details")
        .then().log()
        .body()
        // check result
        .assertThat()
        .statusCode(HttpStatus.SC_OK)
        .extract().asString();
    String expectedString = CommonUtil.readContentFile("expected/GetListOrdersDetailApi/GetListOrdersApi_WhenOrderIDIsValid_ThenReturnData.json");
    JSONAssert.assertEquals(expectedString, responseString, JSONCompareMode.STRICT);
  }
}
