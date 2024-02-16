package selenium.redmine.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import selenium.redmine.Common;
import selenium.redmine.page.LoginPage;
import selenium.redmine.page.RedmineHomePage;

import java.io.IOException;
import java.util.ArrayList;

public class OpenNewPage {

  private WebDriver driver = null;
  private RedmineHomePage redmineHomePage = null;

  private LoginPage loginPage = null;


  @BeforeTest
  void prepareStub() {
    System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    this.redmineHomePage = new RedmineHomePage(driver);
    this.loginPage = new LoginPage(driver);
  }

  @BeforeMethod
  void cleanBrowser() {
    driver.manage().deleteAllCookies();
  }

  @Test
  void OpenNewPage_WhenAbc_ThenAbc() throws Exception {
    driver.navigate().to("http://google.com");

    Thread.sleep(20, 1000);

    //Open new tab
    Common.openNewTab(driver, "http://localhost:3000/");

    // lấy all tab
    ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
    driver.switchTo().window(tabs.get(0));

    driver.get("http://facebook.com");

    this.redmineHomePage.navigate();
    this.redmineHomePage.clickSignInButton();
    this.loginPage.enterLoginTextBox("admin");
    this.loginPage.enterPassWordTextBox("123456789");
    this.loginPage.clickLoginButton();
    String item = this.redmineHomePage.getLoggedInAsAccount();
    System.out.println(item);
    // Compare String actual Logged Account and string expected notification
    Assert.assertEquals(item, "Logged in as Admin");


  }

  @AfterMethod
  void captureResult(ITestResult result) throws IOException {
    Common.screenshot(this.driver, result, ITestResult.SUCCESS, ITestResult.FAILURE);
  }

  @AfterTest
  void clearStub() {
    // close driver after test
    driver.close();
    driver.quit();
  }
}


