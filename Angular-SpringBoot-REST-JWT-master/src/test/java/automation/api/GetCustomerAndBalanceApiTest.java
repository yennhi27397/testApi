package automation.api;

import automation.service.stub.BankApiStub;
import common.CommonUtil;
import common.DatabaseUtil;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetCustomerAndBalanceApiTest {
  private DatabaseUtil databaseUtil;
  private BankApiStub bankApiStub;

  @BeforeTest
  public void beforeTest() throws Exception {
    this.databaseUtil = new DatabaseUtil();
    // start server
    this.bankApiStub = new BankApiStub(9090);
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
  public void GetCustomerAndBalanceApi_WhenCustomerIs1_ThenReturnDataAndBalance() throws Exception {
    String response =
      given()
        .when().get("http://localhost:9119/api/customers/1")
        .then().log()
        .body()
        .assertThat()
        .statusCode(HttpStatus.SC_OK)
        .extract().asString();

    Assert.assertTrue(CommonUtil.compare(response,
      "expected/GetCustomerAndBalanceApi/GetCustomerAndBalanceApi_WhenCustomerIs1_ThenReturnDataAndBalance.json")
    );

  }

  @Test
  public void GetCustomerAndBalanceApi_WhenCustomerIdBankingIsNotFound_ThenReturnInfoAndBalanceIsUnknown() throws Exception {
    String response =
      given()
        .when().get("http://localhost:9119/api/customers/2")
        .then().log()
        .body()
        .assertThat()
        .statusCode(HttpStatus.SC_OK)
        .extract().asString();

    Assert.assertTrue(CommonUtil.compare(response,
      "expected/GetCustomerAndBalanceApi/GetCustomerAndBalanceApi_WhenCustomerIdBankingIsNotFound_ThenReturnInfoAndBalanceIsUnknown.json")
    );

  }

  @Test
  public void GetCustomerAndBalanceApi_WhenBankingReturn500_ThenReturnInfoAndBalanceUnknown() throws Exception {
    String response =
      given()
        .when().get("http://localhost:9119/api/customers/3")
        .then().log()
        .body()
        .assertThat()
        .statusCode(HttpStatus.SC_OK)
        .extract().asString();

    Assert.assertTrue(CommonUtil.compare(response,
      "expected/GetCustomerAndBalanceApi/GetCustomerAndBalanceApi_WhenBankingReturn500_ThenReturnInfoAndBalanceUnknown.json")
    );

  }
}
