package automation.GoogleMapsExercise;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class AddInformation {

  public static void main(String[] args) {

    RestAssured.baseURI = "https://rahulshettyacademy.com";

    // add place -> update place with new adress -> get place to validate if new address in present in response

    //given: all input details
    String result = given().log().all().queryParam("key", "qaclick123")
      .header("Content-Type", "application/json")

      .body(PayLoad.personInformation())

      //when: submit the API - resource/Http method
      .when().post("maps/api/place/add/json")

      //then: validate the response
      .then().assertThat().statusCode(200)
      .header("Server", "Apache/2.4.52 (Ubuntu)").extract().response().asString();

    System.out.println(result);

    JsonPath response = new JsonPath(result);
    String placeID = response.getString("place_id");
    System.out.println(placeID);

//Put Address
    String address1 = "70 Thong Nhat street, USA";

    given().log().all().queryParam("key", "qaclick123")
      .header("Content-Type", "application/json")
      .queryParam("place_id", placeID)
      .body("{\n" +
        "  \"place_id\":\"" + placeID + "\",\n" +
        "  \"address\":\"70 Thong Nhat street, USA\",\n" +
        "  \"key\":\"qaclick123\"\n" +
        "}")

      .when().put("maps/api/place/update/json")

      .then().assertThat().statusCode(200).body("msg", equalTo("Address successfully updated"));

//get Address

    String response1 = given().log().all().queryParam("key", "qaclick123")
      .queryParam("place_id", placeID)

      .when().get("maps/api/place/get/json")

      .then().assertThat().statusCode(200).extract().response().asString();

    System.out.println(response1);

    JsonPath getAddress = new JsonPath(response1);
    String address = getAddress.getString("address");
    Assert.assertEquals(address,address1);



  }
}
