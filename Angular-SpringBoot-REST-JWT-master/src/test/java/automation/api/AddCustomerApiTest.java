package automation.api;

import common.CommonUtil;
import common.DatabaseUtil;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class AddCustomerApiTest {
    private DatabaseUtil databaseUtil;

    @BeforeTest
    public void prepareData() throws Exception {
        this.databaseUtil = new DatabaseUtil();
        // clean up tables.
        databaseUtil.executeSQL("cleanUp.sql");
        // prepare data to test.
        databaseUtil.executeSQL("insert_customers.sql");
    }

    @Test
    public void AddCustomerApi_WhenDataIsValid_ThenAddedCustomer() throws Exception {
        // call API by POST method
        RequestSpecification request = RestAssured.given();
        request.contentType(ContentType.JSON);
        request.baseUri("http://localhost:9119/api/customers");
        request.body(CommonUtil.readBody("AddCustomerApi_WhenDataIsValid_ThenAddedCustomer.json"));
        Response response = request.post();
        // test status
        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK);
        // response
        String responseString = response.body().asString();
        Assert.assertTrue(CommonUtil.compare(responseString, "/AddCustomerApi/AddCustomerApi_WhenDataIsValid_ThenAddedCustomer.json"));
        // list record.
        List<Map<String, Object>> data = databaseUtil.getRecords("SELECT * FROM customers WHERE first_name='Doan' and last_name='Pham'");
        // record
        Map<String, Object> expectedRecord = data.get(0);
        // data in column 'id'
        Assert.assertEquals(expectedRecord.get("id"), 4);
    }

    @Test
    public void AddCustomerApi_WhenDataIsInvalid_ThenCantAddCustomer() throws Exception {
        RequestSpecification request = RestAssured.given();
        request.contentType(ContentType.JSON);
        request.baseUri("http://localhost:9119/api/customers");
        request.body(CommonUtil.readBody("AddCustomerApi_WhenDataIsInvalid_ThenCantAddCustomer.json"));
        Response response = request.post();

        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK);
        String responseString = response.body().asString();
        Assert.assertTrue(CommonUtil.compare(responseString, "/AddCustomerApi/AddCustomerApi_WhenDataIsInvalid_ThenCantAddCustomer.json"));
    }

    @Test
    public void AddCustomerApi_WhenDataMissedIDField_ThenCustomerDidNotAdd() throws Exception {
        RequestSpecification request = RestAssured.given();
        request.contentType(ContentType.JSON);
        request.baseUri("http://localhost:9119/api/customers");
        request.body(CommonUtil.readBody("AddCustomerApi_WhenDataMissedIDField_ThenCantAddCustomer.json"));
        Response response = request.post();

        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_BAD_REQUEST);
        String responseString = response.body().asString();
        Assert.assertTrue(CommonUtil.compare(responseString, "/AddCustomerApi/AddCustomerApi_WhenDataMissedIDField_ThenCantAddCustomer.json"));
    }

    @Test
    public void AddCustomerApi_WhenDataMissedFirstNameLastNameField_ThenCustomerAdded() throws Exception {
        RequestSpecification request = RestAssured.given();
        request.contentType(ContentType.JSON);
        request.baseUri("http://localhost:9119/api/customers");
        request.body(CommonUtil.readBody("AddCustomerApi_WhenDataMissedFirstNameLastNameField_ThenCustomerAdded.json"));
        Response response = request.post();
        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK);

        String responseString = response.body().asString();
        Assert.assertTrue(CommonUtil.compare(responseString, "/AddCustomerApi/UpdateCustomerApi_WhenCustomerIDIsValid_ThenResultData.json"));


    }
}
