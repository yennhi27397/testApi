package common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Common {
  public static WebElement getWebElement(WebDriver webDriver, String htmlTag, String text) {
    return webDriver.findElement(By.xpath("//" + htmlTag + "[text()='" + text + "']"));
  }

  /*
  @additional -> @name="abc", @class="abc"
   */
  public static WebElement getWebElement(WebDriver webDriver, String htmlTag, String text, String... additional) {
    String findMatch = "";
    for (String att : additional) {
      findMatch = " AND " + att;
    }
    return webDriver.findElement(By.xpath("//" + htmlTag + "[text()='" + text + "'" + findMatch + "]"));
  }

  public static WebElement getWebElementContainText(WebDriver webDriver, String htmlTag, String text) {
    return webDriver.findElement(By.xpath("//" + htmlTag + "[contains(text()='" + text + "')]"));
  }
}
