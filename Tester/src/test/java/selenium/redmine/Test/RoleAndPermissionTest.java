package selenium.redmine.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import selenium.redmine.Page.*;
import org.openqa.selenium.Alert;


import java.util.List;

public class RoleAndPermissionTest {
  private WebDriver driver = null;
  private RedmineHomePage redmineHomePage = null;
  private LoginPage loginPage = null;
  private AdministrationPage administrationPage = null;
  private RolePage rolePage = null;
  private NewRolePage newRolePage = null;

  @BeforeTest
  void prepareStub() {
    System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Downloads\\chromedriver_win32\\chromedriver.exe");
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
    this.administrationPage.clickRolesAndPermissionsTab();
    this.rolePage.clickNewRoleTab();
    this.newRolePage.enterNameTextBox("Tester");
    this.newRolePage.chooseIssuesVisibilityCheckBox("own");
    this.newRolePage.chooseUsersVisibilityCheckBox("members_of_visible_projects");
    this.newRolePage.clickAddIssuesCheckBox();
    this.newRolePage.clickEditIssuesCheckBox();
    Thread.sleep(5*1000);
    this.newRolePage.clickCreateButton();
    String item = this.rolePage.getSuccessfulCreationInformation();
    System.out.println(item);
    Assert.assertEquals(item,"Successful creation.");

    List<WebElement> items = this.rolePage.getRoleListFromRoleTable();
    System.out.println("Total of roles are "+items.size());
    Assert.assertEquals(items.size(),3);
  }
  @Test
  void deleteNewRoleAndPermission_WhenWithAbc_ThenAbc() throws Exception {
    this.redmineHomePage.navigate();
    this.redmineHomePage.clickSignInButton();
    this.loginPage.enterLoginTextBox("admin");
    this.loginPage.enterPassWordTextBox("123456789");
    this.loginPage.clickLoginButton();
    this.redmineHomePage.clickAdministrationTab();
    this.administrationPage.clickRolesAndPermissionsTab();
    this.rolePage.clickDeleteButton();
    Alert alert = driver.switchTo().alert();
    alert.accept();
    List<WebElement> items = this.rolePage.getRoleListFromRoleTable();
    System.out.println("Total of roles are "+items.size());
    Assert.assertEquals(items.size(),1);
  }
}
