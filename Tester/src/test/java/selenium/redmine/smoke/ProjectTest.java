package selenium.redmine.smoke;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import selenium.redmine.page.*;

public class ProjectTest {
  // call attribute of WebDriver, RedmineHomePage, LoginPage...
  private WebDriver driver = null;
  private RedmineHomePage redmineHomePage = null;
  private LoginPage loginPage = null;
  private AdministrationPage administrationPage = null;
  private ProjectPage projectPage = null;
  private NewProject newProject = null;

  @BeforeTest
  void prepareStub() {
    // todo:
    System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
    // Open Chrome
    driver = new ChromeDriver();
    // Zoom to man hinh
    driver.manage().window().maximize();
    // call Object loginPage, redmineHomePage, projectPage, newProject, administrationPage and pass to driver
    this.redmineHomePage = new RedmineHomePage(driver);
    this.loginPage = new LoginPage(driver);
    this.administrationPage = new AdministrationPage(driver);
    this.projectPage = new ProjectPage(driver);
    this.newProject = new NewProject(driver);
  }

  @AfterTest
  void clearStub() {
    // close driver after test
    driver.close();
  }

  @Test
  void CreateNewProject_WhenWithAbc_ThenAbc() throws Exception {
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
    // click Project tab
    this.administrationPage.clickProjectsTab();
    // click New Project tab
    this.projectPage.clickNewProjectTab();
    // enter "Clound360" in Name text box
    this.newProject.enterNameTextBox("Clound360");
    // click Description field name
    this.newProject.clickDescriptionTextBox();
    // enter "Managing tasks for the Clound365 project" in Description field name
    this.newProject.enterDescriptionTextField("Managing tasks for the Clound365 project");
    // click Create button
    this.newProject.clickCreateButton();
    // get 'Successful Creation' notification
    String item = this.newProject.getSuccessfulCreationNotification();
    // print notification
    System.out.println("Notification show " + item);
    // Compare String actual notification and string expected notification
    Assert.assertEquals(item, "Successful creation.");
  }



}


