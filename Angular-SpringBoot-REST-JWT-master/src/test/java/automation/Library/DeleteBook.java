package automation.Library;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeleteBook {


  @Test(dataProvider = "BooksData")
  public void DeleteBookApi1_WhenBookAdded_ThenDeleteBookSuccessfully(String isbn, String aisle) {
    RestAssured.baseURI = "http://216.10.245.166";

    given().log().all().header("Content-Type", "application/json")
      .body(PayLoad.AddBook(isbn, aisle))

      .when().post("Library/DeleteBook.php")

      .then().log().all().assertThat().statusCode(200);

  }

  @DataProvider(name = "BooksData")

  //array = collection of element
  //multidimensional array = collection of arrays
  public Object[][] getData() {
    return new Object[][]{{"hgah", "6382"}, {"hsoc", "8294"}, {"nfns", "9481"}};

  }
}
