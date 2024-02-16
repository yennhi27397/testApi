package automation.Library;

import io.restassured.path.json.JsonPath;

public class ReUsableMethods {
  public static JsonPath rawToString(String response){
    JsonPath jsonPath = new JsonPath(response);
    return jsonPath;
  }
}
