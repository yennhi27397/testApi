package automation.api;

import common.CommonUtil;
import common.DatabaseUtil;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetListOrdersApiTest {
  private DatabaseUtil databaseUtil;

  @BeforeMethod
  public void prepareStub() throws Exception {
    this.databaseUtil = new DatabaseUtil();
    databaseUtil.executeSQL("script/cleanUpOrders.sql");
    databaseUtil.executeSQL("script/insert_orders.sql");
  }

  @Test
  public void GetOrdersApi_WhenPageIs1AndSizeIs1_ThenReturnData() throws Exception {
    String response =
      given()
        .queryParam("page", "1")
        .queryParam("size", "1")
        .when().get("http://localhost:9119/api/orders")
        .then().log()
        .body()
        .assertThat()
        .statusCode(HttpStatus.SC_OK)
        .extract().asString();

    Assert.assertTrue(CommonUtil.compare(response, "expected/GetListOderApi/GetOrdersApi_WhenPageIs1AndSizeIs1_ThenReturnData.json"));
  }

  @Test
  public void GetOrdersApi_WhenOrderIDIsValid_ThenReturnData() throws Exception {
    String response =
      given()
        .queryParam("orderid", "4001")
        .when().get("http://localhost:9119/api/orders")
        .then().log()
        .body()
        .assertThat()
        .statusCode(HttpStatus.SC_OK)
        .extract().asString();

    Assert.assertTrue(CommonUtil.compare(response, "expected/GetListOderApi/GetOrdersApi_WhenOrderIDIsValid_ThenReturnData.json"));

  }

  @Test
  public void GetOrdersApi_WhenOrderIDIsInvalid_ThenDataDoesNotReturn() throws Exception {
    String response =
      given()
        .queryParam("orderid", "4006")
        .when().get("http://localhost:9119/api/orders")
        .then().log()
        .body()
        .assertThat()
        .statusCode(HttpStatus.SC_OK)
        .extract().asString();

    Assert.assertTrue(CommonUtil.compare(response, "expected/GetListOderApi/GetOrdersApi_WhenOrderIDIsInvalid_ThenDataDoesNotReturn.json"));


  }

  @Test
  public void GetOrdersApi_WhenOrderIDIsEmpty_ThenReturnAllData() throws Exception {
    String response =
      given()
        .queryParam("orderid", "")
        .when().get("http://localhost:9119/api/orders/")
        .then().log()
        .body()
        .assertThat()
        .statusCode(HttpStatus.SC_OK)
        .extract().asString();

    Assert.assertTrue(CommonUtil.compare(response, "expected/GetListOderApi/GetOrdersApi_WhenOrderIDIsEmpty_ThenReturnAllData.json"));
  }

  @Test
  public void GetOrdersApi_WhenCustomerIDIsValid_ThenReturnData() throws Exception {
    String response =
      given()
        .queryParam("customerid", "10")
        .when().get("http://localhost:9119/api/orders/")
        .then().log()
        .body()
        .assertThat()
        .statusCode(HttpStatus.SC_OK)
        .extract().asString();
    Assert.assertTrue(CommonUtil.compare(response, "expected/GetListOderApi/GetOrdersApi_WhenCustomerIDIsValid_ThenReturnData.json"));

  }

  @Test
  public void GetOrdersApi_WhenCustomerIDIsInvalid_ThenDataDoesNotReturn() throws Exception {
    String response =
      given()
        .queryParam("customerid", "0")
        .when().get("http://localhost:9119/api/orders/")
        .then().log()
        .body()
        .assertThat()
        .statusCode(HttpStatus.SC_OK)
        .extract().asString();
    Assert.assertTrue(CommonUtil.compare(response, "expected/GetListOderApi/GetOrdersApi_WhenCustomerIDIsInvalid_ThenDataDoesNotReturn.json"));


  }

  @Test
  public void GetOrdersApi_WhenCustomerIDIsEmpty_ThenReturnAllData() throws Exception {
    String response =
      given()
        .queryParam("customerid", "")
        .when().get("http://localhost:9119/api/orders/")
        .then().log()
        .body()
        .assertThat()
        .statusCode(HttpStatus.SC_OK)
        .extract().asString();
    Assert.assertTrue(CommonUtil.compare(response, "expected/GetListOderApi/GetOrdersApi_WhenCustomerIDIsEmpty_ThenReturnAllData.json"));


  }

  @Test
  public void GetOrdersApi_WhenEmployeesIDIsValid_ThenReturnData() throws Exception {
    String response =
      given()
        .queryParam("employeeid", "218")
        .when().get("http://localhost:9119/api/orders/")
        .then().log()
        .body()
        .assertThat()
        .statusCode(HttpStatus.SC_OK)
        .extract().asString();

    Assert.assertTrue(CommonUtil.compare(response, "expected/GetListOderApi/GetOrdersApi_WhenEmployeesIDIsValid_ThenReturnData.json"));


  }

  @Test
  public void GetOrdersApi_WhenEmployeesIDIsInvalid_ThenDataDoesNotReturn() throws Exception {
    String response =
      given()
        .queryParam("employeeid", "200")
        .when().get("http://localhost:9119/api/orders/")
        .then().log()
        .body()
        .assertThat()
        .statusCode(HttpStatus.SC_OK)
        .extract().asString();

    Assert.assertTrue(CommonUtil.compare(response, "expected/GetListOderApi/GetOrdersApi_WhenEmployeesIDIsInvalid_ThenDataDoesNotReturn.json"));
  }

  @Test
  public void GetOrdersApi_WhenEmployeesIDIsEmpty_ThenReturnAllData() throws Exception {
    String response =
      given()
        .queryParam("employeeid", "")
        .when().get("http://localhost:9119/api/orders/")
        .then().log()
        .body()
        .assertThat()
        .statusCode(HttpStatus.SC_OK)
        .extract().asString();

    Assert.assertTrue(CommonUtil.compare(response, "expected/GetListOderApi/GetOrdersApi_WhenEmployeesIDIsEmpty_ThenReturnAllData.json"));

  }

  @Test
  public void GetOrdersApi_WhenOrderStatusIsValid_ThenReturnData() throws Exception {
    String response =
      given()
        .queryParam("status", "Shipped")
        .when().get("http://localhost:9119/api/orders/")
        .then().log()
        .body()
        .assertThat()
        .statusCode(HttpStatus.SC_OK)
        .extract().asString();

    Assert.assertTrue(CommonUtil.compare(response, "expected/GetListOderApi/GetOrdersApi_WhenOrderStatusIsShipped_ThenReturnData.json"));
  }

  @Test
  public void GetOrdersApi_WhenOrderStatusIsComplete_ThenReturnData() throws Exception {
    databaseUtil.executeSQL("script/cleanUpOrders.sql");
    databaseUtil.executeSQL("script/insert_ordersStatusComplete.sql");
    String response =
      given()
        .queryParam("status", "Complete")
        .when().get("http://localhost:9119/api/orders/")
        .then().log()
        .body()
        .assertThat()
        .statusCode(HttpStatus.SC_OK)
        .extract().asString();

    Assert.assertTrue(CommonUtil.compare(response, "expected/GetListOderApi/GetOrdersApi_WhenOrderStatusIsComplete_ThenReturnData.json"));
  }

  @Test
  public void GetOrdersApi_WhenOrderStatusIsInvalid_ThenDataDoesNotReturn() throws Exception {
    String response =
      given()
        .queryParam("status", "ABC")
        .when().get("http://localhost:9119/api/orders/")
        .then().log()
        .body()
        .assertThat()
        .statusCode(HttpStatus.SC_OK)
        .extract().asString();

    Assert.assertTrue(CommonUtil.compare(response, "expected/GetListOderApi/GetOrdersApi_WhenOrderStatusIsInvalid_ThenDataDoesNotReturn.json"));
  }

}

