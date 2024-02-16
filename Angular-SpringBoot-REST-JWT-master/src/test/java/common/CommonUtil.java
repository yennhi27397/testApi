package common;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpStatus;
import org.testng.Assert;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Map;

public class CommonUtil {
  private final static String SOURCE_PATH = "src/test/resources/";

  // pass file into param to read body
  public static String readContentFile(String filePath) {
    try {
      FileInputStream fisTargetFile = new FileInputStream(SOURCE_PATH + filePath);
      return IOUtils.toString(fisTargetFile, StandardCharsets.UTF_8);
    } catch (Exception e) {
      e.printStackTrace();
      return "";
    }
  }

  public static String getAccessToken() throws IOException {
    RequestSpecification request = RestAssured.given();
    // Call Header (Content type)
    request.contentType(ContentType.JSON);
    // Call URL
    request.baseUri("http://localhost:9119/session");
    // read request body
    request.body(CommonUtil.readContentFile("requestBody/GetAccessToken_WhenUserAndPasswordValid_ThenReturnAccessToken.json"));
    // Call POST method
    Response response = request.post();
    // get response body
    String responseString = response.body().asString();
    // get data from jsonString
    Map<String, Object> data = new ObjectMapper().readValue(responseString, Map.class);
    Map<String, Object> item = (Map) data.get("item");
    String token = (String) item.get("token");
    return token;
  }


}



