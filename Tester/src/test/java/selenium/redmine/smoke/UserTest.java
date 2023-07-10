package selenium.redmine.smoke;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import selenium.redmine.page.*;

public class UserTest {
  private WebDriver driver = null;
  private RedmineHomePage redmineHomePage = null;
  private LoginPage loginPage = null;
  private AdministrationPage administrationPage = null;
  private RolePage rolePage = null;
  private NewRolePage newRolePage = null;

  @BeforeTest
  void prepareStub() {
    System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    this.redmineHomePage = new RedmineHomePage(driver);
    this.loginPage = new LoginPage(driver);
    this.administrationPage = new AdministrationPage(driver);
    this.rolePage = new RolePage(driver);
    this.newRolePage = new NewRolePage(driver);
  }

  @AfterTest
  void clearStub() {
    driver.close();
  }

  @Test
  void createNewRoleAndPermission_WhenWithAbc_ThenAbc() throws Exception {
    this.redmineHomePage.navigate();
    this.redmineHomePage.clickSignInButton();
    this.loginPage.enterLoginTextBox("admin");
    this.loginPage.enterPassWordTextBox("123456789");
    this.loginPage.clickLoginButton();
    this.redmineHomePage.clickAdministrationTab();
  }
}

