package automation.api;

import common.CommonUtil;
import common.DatabaseUtil;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class GetListCustomerApiTest {
  private DatabaseUtil databaseUtil;

  @BeforeTest
  public void beforeTest() throws Exception {
    this.databaseUtil = new DatabaseUtil();
  }

  @BeforeMethod
  public void prepareData() throws Exception {
    // clean up tables.
    databaseUtil.executeSQL("script/cleanUp.sql");
    // prepare data to test.
    databaseUtil.executeSQL("script/insert_customers.sql");
  }

  @AfterTest
  public void cleanUpData() {

  }

  @Test
  public void GetListCustomerApi_WhenPageIs0AndSizeIs1_ThenReturnData() throws Exception {
    // clean up tables.
    databaseUtil.executeSQL("script/cleanUp.sql");
    // prepare data to test.
    databaseUtil.executeSQL("script/insert_customers_001.sql");
    // call string response body
    String response =
      given()
        // pass query param to search infor
        .queryParam("page", "0")
        .queryParam("size", "1")
        // call URL
        .when().get("http://localhost:9119/api/customers")
        // get data
        .then().log()
        .body()
        .assertThat()
        // get status code
        .statusCode(HttpStatus.SC_OK)
        // string body
        .extract().asString();
    // compare String actual response with expected response
    Assert.assertTrue(CommonUtil.compare(response, "expected/GetListCustomerApi/GetListCustomerApi_WhenPageIs0AndSizeIs1.json"));
  }

  @Test
  public void GetListCustomerApi_WhenPageIs1AndSizeIs1_ThenReturnData() throws Exception {
    // clean up tables.
    databaseUtil.executeSQL("script/cleanUp.sql");
    // prepare data to test.
    databaseUtil.executeSQL("script/insert_customers_001.sql");
    // call string response body
    String response =
      given()
        // pass query param to search infor
        .queryParam("page", "1")
        .queryParam("size", "1")
        // call URL
        .when().get("http://localhost:9119/api/customers")
        // get data
        .then().log()
        .body()
        .assertThat()
        // get status code
        .statusCode(HttpStatus.SC_OK)
        // string body
        .extract().asString();
    // compare String actual response with expected response
    Assert.assertTrue(CommonUtil.compare(response, "expected/GetListCustomerApi/GetListCustomerApi_WhenPageIs1AndSizeIs1.json"));
  }

  @Test
  public void GetListCustomerApi_WhenCustomerID2_ThenReturnData() throws Exception {
    String response =
      given()
        .queryParam("customerid", "2")
        .when().get("http://localhost:9119/api/customers")
        .then().log()
        .body()
        .assertThat()
        .statusCode(HttpStatus.SC_OK)
        .extract().asString();

    Assert.assertTrue(CommonUtil.compare(response, "expected/GetListCustomerApi/GetListCustomerApi_WhenCustomerID2.json"));
  }

  @Test
  public void GetListCustomerApi_WhenCustomerID3_ThenReturnData() throws IOException {
    String response =
      given()
        .queryParam("customerid", "3")
        .when().get("http://localhost:9119/api/customers")
        .then().log()
        .body()
        .assertThat()
        .statusCode(HttpStatus.SC_OK)
        .extract().asString();

    Assert.assertTrue(CommonUtil.compare(response, "expected/GetListCustomerApi/GetListCustomerApi_WhenCustomerID3.json"));
  }

  @Test
  public void GetListCustomerApi_WhenCustomerID4_ThenReturnEmpty() throws IOException {
    String response =
      given()
        .queryParam("customerid", "4")
        .when().get("http://localhost:9119/api/customers")
        .then().log()
        .body()
        .assertThat()
        .statusCode(HttpStatus.SC_OK)
        .extract().asString();

    Assert.assertTrue(CommonUtil.compare(response, "expected/GetListCustomerApi/GetListCustomerApi_WhenCustomerID4.json"));
  }

  @Test
  public void GetListCustomerApi_WhenCompanyIsJetpulse_ThenReturnData() throws IOException {
    String response =
      given()
        .queryParam("company", "Jetpulse")
        .when().get("http://localhost:9119/api/customers")
        .then().log()
        .body()
        .assertThat()
        .statusCode(HttpStatus.SC_OK)
        .extract().asString();

    Assert.assertTrue(CommonUtil.compare(response, "expected/GetListCustomerApi/GetListCustomerApi_WhenCompanyIsJetpulse.json"));
  }

  @Test
  public void GetListCustomerApi_WhenCompanyIsAlfredsFutterkiste_ThenReturnEmpty() throws IOException {
    String response =
      given()
        .queryParam("company", "Alfreds Futterkiste")
        .when().get("http://localhost:9119/api/customers")
        .then().log()
        .body()
        .assertThat()
        .statusCode(HttpStatus.SC_OK)
        .extract().asString();

    Assert.assertTrue(CommonUtil.compare(response, "expected/GetListCustomerApi/GetListCustomerApi_WhenCompanyIsAlfredsFutterkiste.json"));
  }

  @Test
  public void GetListCustomerApi_WhenCountryIsUnitedStates_ThenReturnData() throws IOException {
    String response =
      given()
        .queryParam("country", "United States")
        .when().get("http://localhost:9119/api/customers")
        .then().log()
        .body()
        .assertThat()
        .statusCode(HttpStatus.SC_OK)
        .extract().asString();

    Assert.assertTrue(CommonUtil.compare(response, "expected/GetListCustomerApi/GetListCustomerApi_WhenCountryIsUnitesStates.json"));
  }

  @Test
  public void GetListCustomerApi_WhenCountryIsABC_ThenReturnEmpty() throws IOException {
    String response =
      given()
        .queryParam("country", "ABC")
        .when().get("http://localhost:9119/api/customers")
        .then().log()
        .body()
        .assertThat()
        .statusCode(HttpStatus.SC_OK)
        .extract().asString();

    Assert.assertTrue(CommonUtil.compare(response, "expected/GetListCustomerApi/GetListCustomerApi_WhenCountryIsABC.json"));
  }

  @Test
  public void GetListCustomerApi_WhenCustomerIDIsEmpty_ThenReturnData() throws IOException {
    String response =
      given()
        .queryParam("customerid", "")
        .when().get("http://localhost:9119/api/customers")
        .then().log()
        .body()
        .assertThat()
        .statusCode(HttpStatus.SC_OK)
        .extract().asString();
    Assert.assertTrue(CommonUtil.compare(response, "expected/GetListCustomerApi/GetListCustomerApi_WhenCustomerIDIsEmpty_ThenReturnEmpty.json"));

  }
}
