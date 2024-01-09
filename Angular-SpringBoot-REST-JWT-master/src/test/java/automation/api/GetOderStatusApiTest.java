package automation.api;

import common.CommonUtil;
import common.DatabaseUtil;
import io.restassured.http.Header;
import org.apache.http.HttpStatus;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class GetOderStatusApiTest {
  private DatabaseUtil databaseUtil;
  private Header header;


  @BeforeTest
  public void beforeTest() throws Exception {
    databaseUtil = new DatabaseUtil();
  }

  @BeforeMethod
  public void prepareStub() throws Exception {
    databaseUtil.executeSQL("script/cleanUp.sql");
    databaseUtil.executeSQL("script/insert_orderStatus.sql");
    header = new Header("Authorization", "Bearer " + CommonUtil.getAccessToken());

  }

  @AfterTest
  public void stopData() throws Exception {
    databaseUtil.stop();
  }

  @Test
  public void getOrderStatusApi_WhenOrderStatus_ThenReturnData() throws IOException {
    String responseString =
      given()
        .header(header)
        .when().get("http://localhost:9119/api/order-stats/status")
        .then().log()
        .body()
        .assertThat()
        .statusCode(HttpStatus.SC_OK)
        .extract().asString();

    String expectedString = CommonUtil.readContentFile("expected/GetOderStatusApi/getOrderStatusApi_WhenOrderStatus_ThenReturnData.json");
    JSONAssert.assertEquals(expectedString, responseString, JSONCompareMode.STRICT);
  }

  @Test
  public void getOrderStatusApi_WhenOrderStatusIsBlank_ThenOrderDoesNotFound() throws IOException {
    String responseString =
      given()
        .header(header)
        .when().get("http://localhost:9119/api/order-stats/")
        .then().log()
        .body()
        .assertThat()
        .statusCode(HttpStatus.SC_NOT_FOUND)
        .extract().asString();

    String expectedString = CommonUtil.readContentFile("expected/GetOderStatusApi/getOrderStatusApi_WhenOrderStatusIsBlank_ThenOrderDoesNotFound.json");
    JSONAssert.assertEquals(expectedString, responseString, JSONCompareMode.LENIENT);
  }

  @Test
  public void getOrderStatusApi_WhenOrderPayType_ThenOrdersByPayType() throws IOException {
    String responseString =
      given()
        .header(header)
        .when().get("http://localhost:9119/api/order-stats/paytype")
        .then().log()
        .body()
        .assertThat()
        .statusCode(HttpStatus.SC_OK)
        .extract().asString();

    String expectedString = CommonUtil.readContentFile("expected/GetOderStatusApi/getOrderStatusApi_WhenOrderPayType_ThenOdersByPayType.json");
    JSONAssert.assertEquals(expectedString, responseString, JSONCompareMode.STRICT);
  }

  @Test

  public void getOrderStatusApi_WhenOrderPayTypeIsBlank_ThenNotReturnData() throws IOException {
    String responseString =
      given()
        .header(header)
        .when().get("http://localhost:9119/api/order-stats/")
        .then().log()
        .body()
        .assertThat()
        .statusCode(HttpStatus.SC_NOT_FOUND)
        .extract().asString();

    String expectedString = CommonUtil.readContentFile("expected/GetOderStatusApi/getOrderStatusApi_WhenOrderStatusIsBlank_ThenOrderDoesNotFound.json");
    JSONAssert.assertEquals(expectedString, responseString, JSONCompareMode.LENIENT);
  }

  @Test
  public void getOrderStatusApi_WhenOrderCountry_ThenReturnData() throws IOException {
    String responseString =
      given()
        .header(header)
        .when().get("http://localhost:9119/api/order-stats/country")
        .then().log()
        .body()
        .assertThat()
        .statusCode(HttpStatus.SC_OK)
        .extract().asString();

    String expectedString = CommonUtil.readContentFile("expected/GetOderStatusApi/getOrderStatusApi_WhenOrderCountry_ThenReturnData.json");
    JSONAssert.assertEquals(expectedString, responseString, JSONCompareMode.STRICT);
  }

  @Test
  public void getOrderStatusApi_WhenOrderCountryIsBlank_ThenNotReturnData() throws IOException {
    String responseString =
      given()
        .header(header)
        .when().get("http://localhost:9119/api/order-stats/")
        .then().log()
        .body()
        .assertThat()
        .statusCode(HttpStatus.SC_NOT_FOUND)
        .extract().asString();

    String expectedString = CommonUtil.readContentFile("expected/GetOderStatusApi/getOrderStatusApi_WhenOrderCountryIsBlank_ThenNotReturnData.json");
    JSONAssert.assertEquals(expectedString, responseString, JSONCompareMode.LENIENT);
  }
}



