package automation.GoogleMapsExercise;


import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ComplexJsomParse {


  //Number of courses
  @Test
  public void numberOfCourses() {
    JsonPath js = new JsonPath(PayLoad.CoursePrice());
    //Number of courses
    int size = js.getInt("courses.size");
    System.out.println("Number of courses" + size);
  }


  // Purchase amount
  @Test
  public void purchaseAmount() {
    JsonPath js = new JsonPath(PayLoad.CoursePrice());

    int amount = js.getInt("dashboard.purchaseAmount");
    System.out.println("Purchase amount" + amount);
  }


  // Title of first course
  @Test
  public void printTitleOfFirstCourse() {
    JsonPath js = new JsonPath(PayLoad.CoursePrice());

    String title = js.getString("courses.title[0]");
    System.out.println("Title of first course " + title);
  }


  // all course title and their respective price
  @Test
  public void respectivePrice() {

    JsonPath js = new JsonPath(PayLoad.CoursePrice());

    int size = js.getInt("courses.size");

    for (int i = 0; i < size; i++) {
      String allTitle = js.getString("courses[" + i + "].title");
      //int allPrice = js.getInt("courses["+i+"].price");
      System.out.println(allTitle);
      System.out.println(js.get("courses[" + i + "].price.").toString());
    }
  }


  // Number of copy sold
  @Test
  public void numberOfCopySold() {
    JsonPath js = new JsonPath(PayLoad.CoursePrice());
    int copy = js.getInt("courses.copies[2]");
    System.out.println("number Of Copy Sold" + copy);
  }


  // sum of all course price matches with purchase amount
  @Test
  public void sumOfAllCoursePrice() {
    JsonPath js = new JsonPath(PayLoad.CoursePrice());
    int purchaseAmount = js.getInt("dashboard.purchaseAmount");

    int sum = 0;

    int size = js.get("courses.size");
    for (int j = 0; j < size; j++) {
      int price = js.getInt("courses[" + j + "].price");
      int copy1 = js.getInt("courses[" + j + "].copies");
      int total = price * copy1;
      sum += total;
    }
    System.out.println("purchase Amount = " + sum);

    Assert.assertEquals(sum, purchaseAmount);


  }
}


