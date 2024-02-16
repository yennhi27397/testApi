package selenium.redmine.test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import selenium.redmine.Common;
import selenium.redmine.page.*;

import java.io.IOException;
import java.util.ArrayList;
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
    //todo:
    System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
    // Open Chrome
    driver = new ChromeDriver();
    // Zoom to man hinh
    driver.manage().window().maximize();
    // call Student loginPage, redmineHomePage, projectPage, administrationPage, newRolePage and pass to driver
    this.redmineHomePage = new RedmineHomePage(driver);
    this.loginPage = new LoginPage(driver);
    this.administrationPage = new AdministrationPage(driver);
    this.rolePage = new RolePage(driver);
    this.newRolePage = new NewRolePage(driver);
  }

  @AfterTest
  void clearStub() {
    // close driver after test
    driver.close();
  }

  @BeforeMethod
  void cleanBrowser() {
    // clean data on browser.
    driver.manage().deleteAllCookies();
  }

  @AfterMethod
  void captureResult(ITestResult result) throws IOException {
    Common.screenshot(this.driver, result, ITestResult.SUCCESS, ITestResult.FAILURE);
  }

  // thu tu uu chay truoc.
  @Test(priority = 1)
  void createNewRoleAndPermission_WhenWithAbc_ThenAbc() throws Exception {
    // navigate to redmine HomePage
    this.redmineHomePage.navigate();
    // click sign in button
    this.redmineHomePage.clickSignInButton();
    // enter "admin" in Login text box
    this.loginPage.enterLoginTextBox("admin");
    // enter "123456789" in Password text box
    this.loginPage.enterPassWordTextBox("123456789");
    // click Login button
    this.loginPage.clickLoginButton();
    // click Administration tab
    this.redmineHomePage.clickAdministrationTab();
    // click Roles And Permissions Tab
    this.administrationPage.clickRolesAndPermissionsTab();
    // click New Role Tab
    this.rolePage.clickNewRoleTab();
    // enter "ABC" in Name TextBox
    this.newRolePage.enterNameTextBox("ABC");
    // choose Issues Visibility CheckBox and pass to 'own' value to get 'Issues created by.." option
    this.newRolePage.chooseIssuesVisibilityCheckBox("own");
    // choose Users Visibility CheckBox and pass to 'members_of_visible_projects' value to get 'Member of.." option
    this.newRolePage.chooseUsersVisibilityCheckBox("members_of_visible_projects");
    // click Add Issues CheckBox
    this.newRolePage.clickAddIssuesCheckBox();
    // click Edit Issues CheckBox
    this.newRolePage.clickEditIssuesCheckBox();
    // Wait 5s
    Thread.sleep(5 * 1000);
    // click Create Button
    this.newRolePage.clickCreateButton();
    // get 'Successful Creation' Information
    String item = this.rolePage.getSuccessfulCreationInformation();
    // print notification
    System.out.println(item);
    // Compare String actual notification and string expected notification
    Assert.assertEquals(item, "Successful creation.");

    // get all list Role form Role Table
    List<WebElement> items = this.rolePage.getRoleListFromRoleTable();
    // print size of role
    System.out.println("Total of roles are " + items.size());
    // Compare int role actual size and int expected size
    Assert.assertEquals(items.size(), 4);

    // check 4 roles is what.
    List<String> roleName = new ArrayList<>();
    for (WebElement user : items) {
      String name = this.rolePage.getRoleName(user);
      System.out.println(name);
      roleName.add(name);
    }
    Assert.assertListContainsObject(roleName, "Director", "");
    Assert.assertListContainsObject(roleName, "Developer", "");
    Assert.assertListContainsObject(roleName, "Tester", "");
    Assert.assertListContainsObject(roleName, "ABC", "");
  }

  @Test(priority = 2)
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
    System.out.println("Total of roles are " + items.size());
    Assert.assertEquals(items.size(), 3);

    // check 1 role is what.
    List<String> roleName = new ArrayList<>();
    for (WebElement user : items) {
      String name = this.rolePage.getRoleName(user);
      System.out.println(name);
      roleName.add(name);
    }
    Assert.assertListContainsObject(roleName, "Director", "");
    Assert.assertListContainsObject(roleName, "Developer", "");
    Assert.assertListContainsObject(roleName, "Tester", "");
  }
}
