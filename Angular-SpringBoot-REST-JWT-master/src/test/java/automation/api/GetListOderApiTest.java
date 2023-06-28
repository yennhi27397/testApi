package automation.api;

import common.CommonUtil;
import common.DatabaseUtil;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetListOderApiTest {
    private DatabaseUtil databaseUtil;

    @BeforeTest
    public void prepareData() throws Exception {
        this.databaseUtil = new DatabaseUtil();
        databaseUtil.executeSQL("cleanUp.sql");
        databaseUtil.executeSQL("insert_orders.sql");
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
        Assert.assertTrue(CommonUtil.compare(response, "/GetListOrdersApi/GetListOrdersApi_WhenOrderIDIsValid_ThenReturnData.json"));
    }
}
