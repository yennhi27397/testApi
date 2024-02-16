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

public class GetListOrdersApiTest {
  private DatabaseUtil databaseUtil;
  private Header header;


  @BeforeTest
  public void beforeTest() throws Exception {
    this.databaseUtil = new DatabaseUtil();
  }

  @BeforeMethod
  public void prepareStub() throws Exception {
    databaseUtil.executeSQL("stubdata/cleanUp.sql");
    databaseUtil.executeSQL("stubdata/insert_orders.sql");
    header = new Header("Authorization", "Bearer " + CommonUtil.getAccessToken());

  }

  @Test
  public void GetOrdersApi_WhenPageIs1AndSizeIs1_ThenReturnData() throws Exception {
    String responseString =
      given()
        .header(header)
        .queryParam("page", "1")
        .queryParam("size", "1")
        .when().get("http://localhost:9119/api/orders")
        .then().log()
        .body()
        .assertThat()
        .statusCode(HttpStatus.SC_OK)
        .extract().asString();

    String expectedString = CommonUtil.readContentFile("expected/GetListOderApi/GetOrdersApi_WhenPageIs1AndSizeIs1_ThenReturnData.json");
    JSONAssert.assertEquals(expectedString, responseString, JSONCompareMode.STRICT);
  }

  @Test
  public void GetOrdersApi_WhenOrderIDIsValid_ThenReturnData() throws Exception {
    String responseString =
      given()
        .header(header)
        .queryParam("orderid", "4001")
        .when().get("http://localhost:9119/api/orders")
        .then().log()
        .body()
        .assertThat()
        .statusCode(HttpStatus.SC_OK)
        .extract().asString();

    String expectedString = CommonUtil.readContentFile("expected/GetListOderApi/GetOrdersApi_WhenOrderIDIsValid_ThenReturnData.json");
    JSONAssert.assertEquals(expectedString, responseString, JSONCompareMode.STRICT);

  }

  @Test
  public void GetOrdersApi_WhenOrderIDIsInvalid_ThenDataDoesNotReturn() throws Exception {
    String responseString =
      given()
        .header(header)
        .queryParam("orderid", "4006")
        .when().get("http://localhost:9119/api/orders")
        .then().log()
        .body()
        .assertThat()
        .statusCode(HttpStatus.SC_OK)
        .extract().asString();

    String expectedString = CommonUtil.readContentFile("expected/GetListOderApi/GetOrdersApi_WhenOrderIDIsInvalid_ThenDataDoesNotReturn.json");
    JSONAssert.assertEquals(expectedString, responseString, JSONCompareMode.STRICT);


  }

  @Test
  public void GetOrdersApi_WhenOrderIDIsEmpty_ThenReturnAllData() throws Exception {
    String responseString =
      given()
        .header(header)
        .queryParam("orderid", "")
        .when().get("http://localhost:9119/api/orders/")
        .then().log()
        .body()
        .assertThat()
        .statusCode(HttpStatus.SC_OK)
        .extract().asString();

    String expectedString = CommonUtil.readContentFile("expected/GetListOderApi/GetOrdersApi_WhenOrderIDIsEmpty_ThenReturnAllData.json");
    JSONAssert.assertEquals(expectedString, responseString, JSONCompareMode.STRICT);
  }

  @Test
  public void GetOrdersApi_WhenCustomerIDIsValid_ThenReturnData() throws Exception {
    String responseString =
      given()
        .header(header)
        .queryParam("customerid", "10")
        .when().get("http://localhost:9119/api/orders/")
        .then().log()
        .body()
        .assertThat()
        .statusCode(HttpStatus.SC_OK)
        .extract().asString();
    String expectedString = CommonUtil.readContentFile("expected/GetListOderApi/GetOrdersApi_WhenCustomerIDIsValid_ThenReturnData.json");
    JSONAssert.assertEquals(expectedString, responseString, JSONCompareMode.STRICT);

  }

  @Test
  public void GetOrdersApi_WhenCustomerIDIsInvalid_ThenDataDoesNotReturn() throws Exception {
    String responseString =
      given()
        .header(header)
        .queryParam("customerid", "0")
        .when().get("http://localhost:9119/api/orders/")
        .then().log()
        .body()
        .assertThat()
        .statusCode(HttpStatus.SC_OK)
        .extract().asString();
    String expectedString = CommonUtil.readContentFile("expected/GetListOderApi/GetOrdersApi_WhenCustomerIDIsInvalid_ThenDataDoesNotReturn.json");
    JSONAssert.assertEquals(expectedString, responseString, JSONCompareMode.STRICT);


  }

  @Test
  public void GetOrdersApi_WhenCustomerIDIsEmpty_ThenReturnAllData() throws Exception {
    String responseString =
      given()
        .header(header)
        .queryParam("customerid", "")
        .when().get("http://localhost:9119/api/orders/")
        .then().log()
        .body()
        .assertThat()
        .statusCode(HttpStatus.SC_OK)
        .extract().asString();
    String expectedString = CommonUtil.readContentFile("expected/GetListOderApi/GetOrdersApi_WhenCustomerIDIsEmpty_ThenReturnAllData.json");
    JSONAssert.assertEquals(expectedString, responseString, JSONCompareMode.STRICT);


  }

  @Test
  public void GetOrdersApi_WhenEmployeesIDIsValid_ThenReturnData() throws Exception {
    String responseString =
      given()
        .header(header)
        .queryParam("employeeid", "218")
        .when().get("http://localhost:9119/api/orders/")
        .then().log()
        .body()
        .assertThat()
        .statusCode(HttpStatus.SC_OK)
        .extract().asString();

    String expectedString = CommonUtil.readContentFile("expected/GetListOderApi/GetOrdersApi_WhenEmployeesIDIsValid_ThenReturnData.json");
    JSONAssert.assertEquals(expectedString, responseString, JSONCompareMode.STRICT);


  }

  @Test
  public void GetOrdersApi_WhenEmployeesIDIsInvalid_ThenDataDoesNotReturn() throws Exception {
    String responseString =
      given()
        .header(header)
        .queryParam("employeeid", "200")
        .when().get("http://localhost:9119/api/orders/")
        .then().log()
        .body()
        .assertThat()
        .statusCode(HttpStatus.SC_OK)
        .extract().asString();

    String expectedString = CommonUtil.readContentFile("expected/GetListOderApi/GetOrdersApi_WhenEmployeesIDIsInvalid_ThenDataDoesNotReturn.json");
    JSONAssert.assertEquals(expectedString, responseString, JSONCompareMode.STRICT);
  }

  @Test
  public void GetOrdersApi_WhenEmployeesIDIsEmpty_ThenReturnAllData() throws Exception {
    String responseString =
      given()
        .header(header)
        .queryParam("employeeid", "")
        .when().get("http://localhost:9119/api/orders/")
        .then().log()
        .body()
        .assertThat()
        .statusCode(HttpStatus.SC_OK)
        .extract().asString();

    String expectedString = CommonUtil.readContentFile("expected/GetListOderApi/GetOrdersApi_WhenEmployeesIDIsEmpty_ThenReturnAllData.json");
    JSONAssert.assertEquals(expectedString, responseString, JSONCompareMode.STRICT);

  }

  @Test
  public void GetOrdersApi_WhenOrderStatusIsValid_ThenReturnData() throws Exception {
    String responseString =
      given()
        .header(header)
        .queryParam("status", "Shipped")
        .when().get("http://localhost:9119/api/orders/")
        .then().log()
        .body()
        .assertThat()
        .statusCode(HttpStatus.SC_OK)
        .extract().asString();

    String expectedString = CommonUtil.readContentFile("expected/GetListOderApi/GetOrdersApi_WhenOrderStatusIsShipped_ThenReturnData.json");
    JSONAssert.assertEquals(expectedString, responseString, JSONCompareMode.STRICT);
  }

  @Test
  public void GetOrdersApi_WhenOrderStatusIsComplete_ThenReturnData() throws Exception {
    databaseUtil.executeSQL("script/cleanUpOrders.sql");
    databaseUtil.executeSQL("script/insert_ordersStatusComplete.sql");
    String responseString =
      given()
        .header(header)
        .queryParam("status", "Complete")
        .when().get("http://localhost:9119/api/orders/")
        .then().log()
        .body()
        .assertThat()
        .statusCode(HttpStatus.SC_OK)
        .extract().asString();

    String expectedString = CommonUtil.readContentFile("expected/GetListOderApi/GetOrdersApi_WhenOrderStatusIsComplete_ThenReturnData.json");
    JSONAssert.assertEquals(expectedString, responseString, JSONCompareMode.STRICT);
  }

  @Test
  public void GetOrdersApi_WhenOrderStatusIsInvalid_ThenDataDoesNotReturn() throws Exception {
    String responseString =
      given()
        .header(header)
        .queryParam("status", "ParsingComplexJson")
        .when().get("http://localhost:9119/api/orders/")
        .then().log()
        .body()
        .assertThat()
        .statusCode(HttpStatus.SC_OK)
        .extract().asString();

    String expectedString = CommonUtil.readContentFile("expected/GetListOderApi/GetOrdersApi_WhenOrderStatusIsInvalid_ThenDataDoesNotReturn.json");
    JSONAssert.assertEquals(expectedString, responseString, JSONCompareMode.STRICT);
  }

}

