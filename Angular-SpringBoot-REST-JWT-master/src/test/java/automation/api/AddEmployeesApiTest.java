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

public class AddEmployeesApiTest {
    private DatabaseUtil databaseUtil;

    @BeforeTest
    public void prepareData() throws Exception {
        this.databaseUtil = new DatabaseUtil();
        databaseUtil.executeSQL("cleanUp.sql");
        databaseUtil.executeSQL("insert_employees.sql");
    }

    @Test
    public void AddEmployeesApi_WhenDataIsValid_ThenEmployeeAdded() throws Exception {
        RequestSpecification request = RestAssured.given();
        request.contentType(ContentType.JSON);
        request.baseUri("http://localhost:9119/api/employees");
        request.body(CommonUtil.readBody("AddEmployeesApi_WhenDataIsValid_ThenEmployeeAdded.json"));
        Response response = request.post();

        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK);

        String responseString = response.body().asString();
        Assert.assertTrue(CommonUtil.compare(responseString, "/AddEmployeesApi/AddEmployeesApi_WhenDataIsValid_ThenEmployeeAdded.json"));

        List<Map<String, Object>> data = databaseUtil.getRecords("SELECT * FROM employees WHERE id = 3");
        Map<String, Object> expectedRecord = data.get(0);
        Assert.assertEquals(expectedRecord.get("id"), 3);
    }

    @Test
    public void AddEmployeesApi_WhenDataIsInvalid_ThenEmployeeDidNotAdd() throws Exception {
        RequestSpecification request = RestAssured.given();
        request.contentType(ContentType.JSON);
        request.baseUri("http://localhost:9119/api/employees");
        request.body(CommonUtil.readBody("AddEmployeesApi_WhenDataIsInvalid_ThenEmployeeAdded.json"));
        Response response = request.post();

        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK);

        String responseString = response.body().asString();
        Assert.assertTrue(CommonUtil.compare(responseString, "/AddEmployeesApi/AddEmployeesApi_WhenDataIsInValid_ThenEmployeeAdded.json"));

        List<Map<String, Object>> data = databaseUtil.getRecords("SELECT * FROM employees WHERE id = 203");
        Map<String, Object> expectedRecord = data.get(0);

        Assert.assertEquals(expectedRecord.get("id"), 203);
    }

    @Test
    public void AddEmployeesApi_WhenDataMissedIdField_ThenEmployeeDidNotAdd() throws Exception {
        RequestSpecification request = RestAssured.given();
        request.contentType(ContentType.JSON);
        request.baseUri("http://localhost:9119/api/employees");
        request.body(CommonUtil.readBody("AddEmployeesApi_WhenDataMissedIdField_ThenEmployeeDidNotAdd.json"));
        Response response = request.post();

        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_BAD_REQUEST);

        String responseString = response.body().asString();
        Assert.assertTrue(CommonUtil.compare(responseString, "/AddCustomerApi/AddEmployeesApi_WhenDataMissedIdField_ThenEmployeeDidNotAdd.json"));
    }

    @Test
    public void AddEmployeesApi_WhenDataMissedLastNameFirstNameField_ThenEmployeeAdded() throws Exception {
        RequestSpecification request = RestAssured.given();
        request.contentType(ContentType.JSON);
        request.baseUri("http://localhost:9119/api/employees");
        request.body(CommonUtil.readBody("AddEmployeesApi_WhenDataMissedLastNameFirstNameField_ThenEmployeeAdded.json"));
        Response response = request.post();

        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK);

        String responseString = response.body().asString();
        Assert.assertTrue(CommonUtil.compare(responseString, "/AddEmployeesApi/AddEmployeesApi_WhenDataMissedLastNameFirstNameField_ThenEmployeeAdded.json"));

        List<Map<String, Object>> data = databaseUtil.getRecords("SELECT * FROM Employees WHERE id=2");
        Map<String, Object> expectedRecord = data.get(0);

        Assert.assertEquals(expectedRecord.get("id"), 2);


    }


}


