package selenium.cucumber.definitions;

import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import selenium.redmine.page.LoginPage;
import selenium.redmine.page.NewProject;
import selenium.redmine.page.ProjectPage;
import selenium.redmine.page.RedmineHomePage;

public class LoginDefinitions {

  // call attribute of WebDriver, RedmineHomePage, LoginPage
  private static WebDriver driver = null;
  private static RedmineHomePage redmineHomePage = null;
  private static LoginPage loginPage = null;
  private static ProjectPage projectPage = null;
  private static NewProject newProject = null;

  @BeforeAll
  public static void prepareStub() {
    System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
    // Open Chrome
    driver = new ChromeDriver();
    // Zoom to man hinh
    driver.manage().window().maximize();
    // call Object loginPage, redmineHomePage, projectPage, newProject and pass to driver
    loginPage = new LoginPage(driver); // Page Object Model.
    redmineHomePage = new RedmineHomePage(driver);  // Page Object Model.
    projectPage = new ProjectPage(driver);  // Page Object Model.
    newProject = new NewProject(driver);  // Page Object Model.
  }

  @AfterAll
  public static void clearStub() {
    // close driver after test
    driver.close();
  }

  @Before
  public static void cleanBrowser() {
    driver.manage().deleteAllCookies();
  }

  @Given("Account has been successfully registered")
  public void AccountHasBeenSuccessfullyRegistered() {
    System.out.println("Account has been successfully registered");
  }

  @When("Enter valid username and password")
  public void enterValidUsernameAndPassword() {
    // navigate to redmineHomePage
    redmineHomePage.navigate();
    // click sign in button
    redmineHomePage.clickSignInButton();
    // enter "admin" in Login text box
    loginPage.enterLoginTextBox("admin");
    // enter "123456789" in Password text box
    loginPage.enterPassWordTextBox("123456789");
    // click Login button
    loginPage.clickLoginButton();
  }

  @Then("User login successfully")
  public void userLoginSuccessfully() {
    // get Logged Account Info
    String item = redmineHomePage.getLoggedInAsAccount();
    System.out.println(item);
    // Compare String actual Logged Account and string expected notification
    Assert.assertEquals(item, "Logged in as Admin");
  }


  @Given("The account has been successfully registered")
  public void theAccountHasBeenSuccessfullyRegistered() {
    System.out.println("The account has been successfully registered");
  }

  @When("Enter blank username and valid password")
  public void enterBlankUsernameAndValidPassword() {
    // navigate to redmineHomePage
    redmineHomePage.navigate();
    // click sign in button
    redmineHomePage.clickSignInButton();
    // enter "admin" in Login text box
    loginPage.enterLoginTextBox("");
    // enter "123456789" in Password text box
    loginPage.enterPassWordTextBox("123456789");
    // click Login button
    loginPage.clickLoginButton();

  }

  @Then("User can not login successfully")
  public void userCanNotLoginSuccessfully() {
    // get Logged Account Info
    String item = loginPage.InvalidUserOrPasswordInformation();
    System.out.println(item);
    // Compare String actual Logged Account and string expected notification
    Assert.assertEquals(item, "Invalid user or password");
  }

  @When("Enter as {string} and as {string}")
  public void enterAsAndAs(String userName, String password) {
    // navigate to redmineHomePage
    redmineHomePage.navigate();
    // click sign in button
    redmineHomePage.clickSignInButton();
    // enter "admin" in Login text box
    loginPage.enterLoginTextBox(userName);
    // enter "123456789" in Password text box
    loginPage.enterPassWordTextBox(password);
    // click Login button
    loginPage.clickLoginButton();
  }
}
