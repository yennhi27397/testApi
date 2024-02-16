package selenium.redmine.test;

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

public class UserTest {
  private WebDriver driver = null;
  private RedmineHomePage redmineHomePage = null;
  private LoginPage loginPage = null;
  private AdministrationPage administrationPage = null;
  private RolePage rolePage = null;
  private NewRolePage newRolePage = null;

  private UserPage userPage = null;
  private NewUserPage newUserPage = null;
  private DeleteUserPage deleteUserPage = null;

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
    this.userPage = new UserPage(driver);
    this.newUserPage = new NewUserPage(driver);
    this.deleteUserPage = new DeleteUserPage(driver);
  }
  @BeforeMethod
  void cleanBrowser() {
    driver.manage().deleteAllCookies();
  }

  @AfterTest
  void clearStub() {
    driver.close();
  }

  @AfterMethod
  void captureResult(ITestResult result) throws IOException {
    Common.screenshot(this.driver, result, ITestResult.SUCCESS, ITestResult.FAILURE);
  }

  @Test(priority = 1)
  void createNewUser_WhenWithAbc_ThenAbc() throws Exception {
    this.redmineHomePage.navigate();
    this.redmineHomePage.clickSignInButton();
    this.loginPage.enterLoginTextBox("admin");
    this.loginPage.enterPassWordTextBox("123456789");
    this.loginPage.clickLoginButton();
    this.redmineHomePage.clickAdministrationTab();
    this.administrationPage.clickUserTab();
    this.userPage.clickNewUser();
    this.newUserPage.enterLoginTextBox("ABC");
    this.newUserPage.enterFirstNameTextBox("Nguyen");
    this.newUserPage.enterLastNameTextBox("Doan");
    this.newUserPage.enterEmailTextBox("pnhi23333@gmail.com");
    this.newUserPage.enterPasswordTextBox("123456789");
    this.newUserPage.enterConfirmationTextBox("123456789");
    this.newUserPage.clickCreateButton();
    String item = this.newUserPage.getUserCreatedInformation();
    System.out.println(item);
    Assert.assertEquals(item, "User ABC created.");

    this.newUserPage.clickAdministrationTab();
    this.administrationPage.clickUserTab();

    List<WebElement> listUser = this.userPage.getUserAccountFromUsersTable();
    System.out.println("Total of user account are " + listUser.size());
    Assert.assertEquals(listUser.size(), 5);

    List<String> user = new ArrayList<>();
    for (WebElement name : listUser) {
      String item1 = this.userPage.getUserNameFromUserTable(name);
      System.out.println(item1);
      user.add(item1);
    }
    Assert.assertListContainsObject(user, "Admin", "");
    Assert.assertListContainsObject(user, "Developer", "");
    Assert.assertListContainsObject(user, "NguyenQuang", "");
    Assert.assertListContainsObject(user, "Tester", "");
    Assert.assertListContainsObject(user, "ABC", "");

  }

  @Test(priority = 2)
  void deleteUser_WhenWithAbc_ThenAbc() throws Exception {
    this.redmineHomePage.navigate();
    this.redmineHomePage.clickSignInButton();
    this.loginPage.enterLoginTextBox("admin");
    this.loginPage.enterPassWordTextBox("123456789");
    this.loginPage.clickLoginButton();
    this.redmineHomePage.clickAdministrationTab();
    this.administrationPage.clickUserTab();
    this.userPage.clickDeleteUser();
    this.deleteUserPage.enterConfirmLoginTextBox("ABC");
    this.deleteUserPage.clickDeleteButton();

    List<WebElement> item = this.userPage.getUserAccountFromUsersTable();
    System.out.println("Total of user account are " + item.size());
    Assert.assertEquals(item.size(), 4);

    List<String> name = new ArrayList<>();
    for (WebElement user : item) {
      String userName = this.userPage.getUserNameFromUserTable(user);
      System.out.println(userName);
      name.add(userName);

    }


  }
}


