package selenium.redmine.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import selenium.redmine.Page.*;

public class ProjectTest {
  private WebDriver driver = null;
  private RedmineHomePage redmineHomePage = null;
  private LoginPage loginPage = null;
  private AdministrationPage administrationPage = null;
  private ProjectPage projectPage = null;
  private NewProject newProject = null;

  @BeforeTest
  void prepareStub() {
    System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Downloads\\chromedriver_win32\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    this.redmineHomePage = new RedmineHomePage(driver);
    this.loginPage = new LoginPage(driver);
    this.administrationPage = new AdministrationPage(driver);
    this.projectPage = new ProjectPage(driver);
    this.newProject = new NewProject(driver);
  }

  @AfterTest
  void clearStub() {
    driver.close();
  }

  @Test
  void CreateNewProject_WhenWithAbc_ThenAbc() throws Exception {
    this.redmineHomePage.navigate();
    this.redmineHomePage.clickSignInButton();
    this.loginPage.enterLoginTextBox("admin");
    this.loginPage.enterPassWordTextBox("123456789");
    this.loginPage.clickLoginButton();
    this.redmineHomePage.clickAdministrationTab();
    this.administrationPage.clickProjectsTab();
    this.projectPage.clickNewProjectTab();
    this.newProject.enterNameTextBox("Clound360");
    this.newProject.clickDescriptionTextBox();
    this.newProject.enterDescriptionTextBox("Managing tasks for the Clound365 project");
    this.newProject.clickCreateButton();
    String item = this.newProject.getSuccessfulCreationNotification();
    System.out.println("Notification show " + item);
    Assert.assertEquals(item, "Successful creation.");
  }
  @Test
  void DeleteNewProject_WhenWithAbc_ThenAbc() throws Exception {
    this.redmineHomePage.navigate();
    this.redmineHomePage.clickSignInButton();
    this.loginPage.enterLoginTextBox("admin");
    this.loginPage.enterPassWordTextBox("123456789");
    this.loginPage.clickLoginButton();
    this.redmineHomePage.clickAdministrationTab();
    this.administrationPage.clickProjectsTab();



  }

}
