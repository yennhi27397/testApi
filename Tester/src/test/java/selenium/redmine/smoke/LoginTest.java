package selenium.redmine.smoke;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import selenium.redmine.page.LoginPage;
import selenium.redmine.page.NewProject;
import selenium.redmine.page.ProjectPage;
import selenium.redmine.page.RedmineHomePage;

public class LoginTest {
  // call attribute of WebDriver, RedmineHomePage, LoginPage
  private WebDriver driver = null;
  private RedmineHomePage redmineHomePage = null;
  private LoginPage loginPage = null;
  private ProjectPage projectPage = null;
  private NewProject newProject = null;

  @BeforeTest
  void prepareStub() {
    System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
    // Open Chrome
    driver = new ChromeDriver();
    // Zoom to man hinh
    driver.manage().window().maximize();
    // call Object loginPage, redmineHomePage, projectPage, newProject and pass to driver
    this.loginPage = new LoginPage(driver); // Page Object Model.
    this.redmineHomePage = new RedmineHomePage(driver);  // Page Object Model.
    this.projectPage = new ProjectPage(driver);  // Page Object Model.
    this.newProject = new NewProject(driver);  // Page Object Model.
  }


  @AfterTest
  void clearStub() {
    // close driver after test
    driver.close();
  }

  @Test()
  void LoginSuccessfully_WhenAbc_ThenAbc() throws Exception {
    // navigate to redmineHomePage
    this.redmineHomePage.navigate();
    // click sign in button
    this.redmineHomePage.clickSignInButton();
    // enter "admin" in Login text box
    this.loginPage.enterLoginTextBox("admin");
    // enter "123456789" in Password text box
    this.loginPage.enterPassWordTextBox("123456789");
    // click Login button
    this.loginPage.clickLoginButton();
    // get Logged Account Info
    String item = this.redmineHomePage.getLoggedInAsAccount();
    System.out.println(item);
    // Compare String actual Logged Account and string expected notification
    Assert.assertEquals(item, "Logged in as Admin");
  }
}
