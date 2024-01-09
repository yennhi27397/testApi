package selenium.redmine;

import org.openqa.selenium.*;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;

public class Common {
  private static final String ROOT_PATH = System.getProperty("user.dir");
  private static final String STORE_FOLDER_SCREEN_SHOT = "/target/screenshot/";

  public static WebElement getWebElement(WebDriver webDriver, String htmlTag, String text) {
    return webDriver.findElement(By.xpath("//" + htmlTag + "[text()='" + text + "']"));
  }

  /*
    @additional -> @name='abc, @class='abc
    getWebElementWithAtt(driver, "a", "Check All", "@abc='12'")
   */
  public static WebElement getWebElementWithAtt(WebDriver webDriver, String htmlTag, String text, String... additional) {
    String findMatch = "";
    for (String att : additional) {
      findMatch = " AND " + att;
    }
    return webDriver.findElement(By.xpath("//" + htmlTag + "[text()='" + text + "'" + findMatch + "]"));
  }

  // get element co TAG ma chua text do
  // getWebElementContainText(driver, "a", "love") -> get tag 'a' that contain 'text'
  public static WebElement getWebElementContainText(WebDriver webDriver, String htmlTag, String text) {
    return webDriver.findElement(By.xpath("//" + htmlTag + "[contains(text()='" + text + "')]"));
  }

  public static void screenshot(WebDriver webDriver, ITestResult result, int... status) throws IOException {
    if (Arrays.stream(status)
        .noneMatch(item -> item == ITestResult.FAILURE || item == ITestResult.SUCCESS || item == ITestResult.SUCCESS_PERCENTAGE_FAILURE)) {
      return;
    }
    // Chuyển đối tượng WebDriver sang TakeScreenshot
    TakesScreenshot scrShot = ((TakesScreenshot) webDriver);
    //Sử dụng phương thức getScreenshotAs để có thể capture screenshot và tạo file image
    File screenshotFile = scrShot.getScreenshotAs(OutputType.FILE);
    //result.getMethod().getMethodName() - lấy tên của test case xong gán cho tên file chụp màn hình luôn
    File destFile = new File(
        ROOT_PATH + STORE_FOLDER_SCREEN_SHOT
            + result.getMethod().getMethodName() + ".png");
    destFile.getParentFile().mkdirs();
    Files.copy(screenshotFile.toPath(), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
  }

  public static void openNewTab(WebDriver driver, String url) {
    ((JavascriptExecutor) driver).executeScript
        ("window.open('" + url + "');");
    // window.open('url');
  }
}
