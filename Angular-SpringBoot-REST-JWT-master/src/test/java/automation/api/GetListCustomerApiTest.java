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

public class GetListCustomerApiTest {
  private DatabaseUtil databaseUtil;
  private Header header;


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
    header = new Header("Authorization", "Bearer " + CommonUtil.getAccessToken());
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
    String responseString =
      given()
        .header(header)
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
    String expectedString = CommonUtil.readContentFile("expected/GetListCustomerApi/GetListCustomerApi_WhenPageIs0AndSizeIs1.json");
    JSONAssert.assertEquals(expectedString, responseString, JSONCompareMode.STRICT);
  }

  @Test
  public void GetListCustomerApi_WhenPageIs1AndSizeIs1_ThenReturnData() throws Exception {
    // clean up tables.
    databaseUtil.executeSQL("script/cleanUp.sql");
    // prepare data to test.
    databaseUtil.executeSQL("script/insert_customers_001.sql");
    // call string response body
    String responseString =
      given()
        .header(header)
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
    String expectedString = CommonUtil.readContentFile("expected/GetListCustomerApi/GetListCustomerApi_WhenPageIs1AndSizeIs1.json");
    JSONAssert.assertEquals(expectedString, responseString, JSONCompareMode.STRICT);
  }

  @Test
  public void GetListCustomerApi_WhenCustomerID2_ThenReturnData() throws Exception {
    String responseString =
      given()
        .header(header)
        .queryParam("customerid", "2")
        .when().get("http://localhost:9119/api/customers")
        .then().log()
        .body()
        .assertThat()
        .statusCode(HttpStatus.SC_OK)
        .extract().asString();

    String expectedString = CommonUtil.readContentFile("expected/GetListCustomerApi/GetListCustomerApi_WhenCustomerID2.json");
    JSONAssert.assertEquals(expectedString, responseString, JSONCompareMode.STRICT);
  }

  @Test
  public void GetListCustomerApi_WhenCustomerID3_ThenReturnData() throws IOException {
    String responseString =
      given()
        .header(header)
        .queryParam("customerid", "3")
        .when().get("http://localhost:9119/api/customers")
        .then().log()
        .body()
        .assertThat()
        .statusCode(HttpStatus.SC_OK)
        .extract().asString();

    String expectedString = CommonUtil.readContentFile("expected/GetListCustomerApi/GetListCustomerApi_WhenCustomerID3.json");
    JSONAssert.assertEquals(expectedString, responseString, JSONCompareMode.STRICT);
  }

  @Test
  public void GetListCustomerApi_WhenCustomerID4_ThenReturnEmpty() throws IOException {
    String responseString =
      given()
        .header(header)
        .queryParam("customerid", "4")
        .when().get("http://localhost:9119/api/customers")
        .then().log()
        .body()
        .assertThat()
        .statusCode(HttpStatus.SC_OK)
        .extract().asString();

    String expectedString = CommonUtil.readContentFile("expected/GetListCustomerApi/GetListCustomerApi_WhenCustomerID4.json");
    JSONAssert.assertEquals(expectedString, responseString, JSONCompareMode.STRICT);
  }

  @Test
  public void GetListCustomerApi_WhenCompanyIsJetpulse_ThenReturnData() throws IOException {
    String responseString =
      given()
        .header(header)
        .queryParam("company", "Jetpulse")
        .when().get("http://localhost:9119/api/customers")
        .then().log()
        .body()
        .assertThat()
        .statusCode(HttpStatus.SC_OK)
        .extract().asString();

    String expectedString = CommonUtil.readContentFile("expected/GetListCustomerApi/GetListCustomerApi_WhenCompanyIsJetpulse.json");
    JSONAssert.assertEquals(expectedString, responseString, JSONCompareMode.STRICT);
  }

  @Test
  public void GetListCustomerApi_WhenCompanyIsAlfredsFutterkiste_ThenReturnEmpty() throws IOException {
    String responseString =
      given()
        .header(header)
        .queryParam("company", "Alfreds Futterkiste")
        .when().get("http://localhost:9119/api/customers")
        .then().log()
        .body()
        .assertThat()
        .statusCode(HttpStatus.SC_OK)
        .extract().asString();

    String expectedString = CommonUtil.readContentFile("expected/GetListCustomerApi/GetListCustomerApi_WhenCompanyIsAlfredsFutterkiste.json");
    JSONAssert.assertEquals(expectedString, responseString, JSONCompareMode.STRICT);
  }

  @Test
  public void GetListCustomerApi_WhenCountryIsUnitedStates_ThenReturnData() throws IOException {
    String responseString =
      given()
        .header(header)
        .queryParam("country", "United States")
        .when().get("http://localhost:9119/api/customers")
        .then().log()
        .body()
        .assertThat()
        .statusCode(HttpStatus.SC_OK)
        .extract().asString();

    String expectedString = CommonUtil.readContentFile("expected/GetListCustomerApi/GetListCustomerApi_WhenCountryIsUnitesStates.json");
    JSONAssert.assertEquals(expectedString, responseString, JSONCompareMode.STRICT);
  }

  @Test
  public void GetListCustomerApi_WhenCountryIsABC_ThenReturnEmpty() throws IOException {
    String responseString =
      given()
        .header(header)
        .queryParam("country", "ParsingComplexJson")
        .when().get("http://localhost:9119/api/customers")
        .then().log()
        .body()
        .assertThat()
        .statusCode(HttpStatus.SC_OK)
        .extract().asString();

    String expectedString = CommonUtil.readContentFile("expected/GetListCustomerApi/GetListCustomerApi_WhenCountryIsABC.json");
    JSONAssert.assertEquals(expectedString, responseString, JSONCompareMode.STRICT);
  }

  @Test
  public void GetListCustomerApi_WhenCustomerIDIsEmpty_ThenReturnData() throws IOException {
    String responseString =
      given()
        .header(header)
        .queryParam("customerid", "")
        .when().get("http://localhost:9119/api/customers")
        .then().log()
        .body()
        .assertThat()
        .statusCode(HttpStatus.SC_OK)
        .extract().asString();
    String expectedString = CommonUtil.readContentFile("expected/GetListCustomerApi/GetListCustomerApi_WhenCustomerIDIsEmpty_ThenReturnEmpty.json");
    JSONAssert.assertEquals(expectedString, responseString, JSONCompareMode.STRICT);

  }
}
