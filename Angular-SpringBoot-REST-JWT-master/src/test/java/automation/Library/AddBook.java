package automation.Library;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class AddBook {
  @Test
  public void AddBookApi_WhenValidIsbnAndAisle_ThenAddBookSuccessfully() {
    RestAssured.baseURI = "http://216.10.245.166";

    String response = given().log().all().header("Content-Type", "application/json")
      .body(PayLoad.AddBook("sdgashja", "23132"))

      .when().post("Library/Addbook.php")

      .then().log().all().assertThat().statusCode(200).extract().response().asString();

    JsonPath js = ReUsableMethods.rawToString(response);
    String id = js.get("ID");
    System.out.println(id);


  }

  @Test(dataProvider = "BooksData")
  public void AddBookApi1_WhenValidIsbnAndAisle_ThenAddBookSuccessfully(String isbn, String aisle) {
    RestAssured.baseURI = "http://216.10.245.166";

    String response = given().log().all().header("Content-Type", "application/json")
      .body(PayLoad.AddBook(isbn, aisle))

      .when().post("Library/Addbook.php")

      .then().log().all().assertThat().statusCode(200).extract().response().asString();

    JsonPath js = ReUsableMethods.rawToString(response);
    String id = js.get("ID");
    System.out.println(id);


  }

  @DataProvider(name = "BooksData")

  //array = collection of element
  //multidimensional array = collection of arrays
  public Object[][] getData() {
    return new Object[][]{{"hgah", "6382"}, {"hsoc", "8294"}, {"nfns", "9481"}};

  }

}
