package automation.Library;

public class PayLoad {

  public static String AddBook(String isbn, String aisle) {
    return ("{\n" +
      "\n" +
      "\"name\":\"Learn Appium Automation with Java\",\n" +
      "\"isbn\":\"" + isbn + "\",\n" +
      "\"aisle\":\"" + aisle + "\",\n" +
      "\"author\":\"John foe\"\n" +
      "}\n");
  }


}
