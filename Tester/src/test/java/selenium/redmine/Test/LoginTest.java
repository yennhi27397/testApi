package selenium.redmine.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import selenium.redmine.Page.LoginPage;
import selenium.redmine.Page.NewProject;
import selenium.redmine.Page.ProjectPage;
import selenium.redmine.Page.RedmineHomePage;

public class LoginTest {
  private WebDriver driver = null;
  private RedmineHomePage redmineHomePage = null;
  private LoginPage loginPage = null;
  private ProjectPage projectPage = null;
  private NewProject newProject = null;

  @BeforeTest
  void prepareStub() {
    System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Downloads\\chromedriver_win32\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    this.loginPage = new LoginPage(driver);
    this.redmineHomePage = new RedmineHomePage(driver);
    this.projectPage = new ProjectPage(driver);
    this.newProject = new NewProject(driver);
  }

  @AfterTest
  void clearStub() {
    driver.close();
  }

  @Test
  void LoginSuccessfully_WhenAbc_ThenAbc() throws Exception {
    this.redmineHomePage.navigate();
    this.redmineHomePage.clickSignInButton();
    this.loginPage.enterLoginTextBox("admin");
    this.loginPage.enterPassWordTextBox("123456789");
    this.loginPage.clickLoginButton();
    String item = this.redmineHomePage.showLoggedInAsAccount();
    System.out.println(item);
    Assert.assertEquals(item, "Logged in as Admin");
  }
}
