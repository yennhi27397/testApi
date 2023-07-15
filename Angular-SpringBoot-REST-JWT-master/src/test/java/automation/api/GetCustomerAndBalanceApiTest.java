package automation.api;

import automation.service.stub.BankApiStub;
import common.CommonUtil;
import common.DatabaseUtil;
import org.apache.http.HttpStatus;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;

import static io.restassured.RestAssured.given;

public class GetCustomerAndBalanceApiTest {
  private DatabaseUtil databaseUtil;
  private BankApiStub bankApiStub;

  @BeforeTest
  public void beforeTest() throws Exception {
    this.databaseUtil = new DatabaseUtil();
    this.bankApiStub = new BankApiStub(9090);

  }

  @BeforeMethod
  public void prepareStub() throws Exception {
    databaseUtil.executeSQL("script/cleanUp.sql");
    databaseUtil.executeSQL("script/insert_customers.sql");
  }

  @AfterTest
  public void cleanUpData() throws SQLException {
    this.databaseUtil.stop();
    this.bankApiStub.stop();

  }

  @Test
  public void GetCustomerAndBalanceApi_WhenCustomerIs1_ThenReturnDataAndBalance() throws IOException {
    String responseString =
      given()
        .when().get("http://localhost:9119/api/customers/1")
        .then().log()
        .body()
        .assertThat()
        .statusCode(HttpStatus.SC_OK)
        .extract().asString();

    String expectedString = CommonUtil.readContentFile("expected/GetCustomerAndBalanceApi/GetCustomerAndBalanceApi_WhenCustomerIs1_ThenReturnDataAndBalance.json");
    JSONAssert.assertEquals(expectedString, responseString, JSONCompareMode.STRICT);

  }

  @Test
  public void GetCustomerAndBalanceApi_WhenCustomerIdBankingIsNotFound_ThenReturnInfoAndBalanceIsUnknown() throws IOException {

    String responseString =
      given()
        .when().get("http://localhost:9119/api/customers/2")
        .then().log()
        .body()
        .assertThat()
        .statusCode(HttpStatus.SC_OK)
        .extract().asString();

    String expectedString = CommonUtil.readContentFile("expected/GetCustomerAndBalanceApi/GetCustomerAndBalanceApi_WhenCustomerIdBankingIsNotFound_ThenReturnInfoAndBalanceIsUnknown.json");
    JSONAssert.assertEquals(expectedString, responseString, JSONCompareMode.STRICT);


  }

  @Test
  public void GetCustomerAndBalanceApi_WhenBankingReturn500_ThenReturnInfoAndBalanceUnknown() throws IOException {
    String responseString =
      given()
        .when().get("http://localhost:9119/api/customers/3")
        .then().log()
        .body()
        .statusCode(HttpStatus.SC_OK)
        .extract().asString();

    String expectedString = CommonUtil.readContentFile("expected/GetCustomerAndBalanceApi/GetCustomerAndBalanceApi_WhenBankingReturn500_ThenReturnInfoAndBalanceUnknown.json");
    JSONAssert.assertEquals(expectedString, responseString, JSONCompareMode.STRICT);

  }
}
