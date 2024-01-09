package selenium.redmine.smoke;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import selenium.redmine.page.*;

import java.util.ArrayList;
import java.util.List;

public class ProjectTest {
  // call attribute of WebDriver, RedmineHomePage, LoginPage...
  private WebDriver driver = null;
  private RedmineHomePage redmineHomePage = null;
  private LoginPage loginPage = null;
  private AdministrationPage administrationPage = null;
  private ProjectPage projectPage = null;
  private NewProject newProject = null;
  private DeleteProjectPage deleteProjectPage = null;

  @BeforeTest
  void prepareStub() {
    // todo:
    System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
    // Open Chrome
    driver = new ChromeDriver();
    // Zoom to man hinh
    driver.manage().window().maximize();
    // call Student loginPage, redmineHomePage, projectPage, newProject, administrationPage and pass to driver
    this.redmineHomePage = new RedmineHomePage(driver);
    this.loginPage = new LoginPage(driver);
    this.administrationPage = new AdministrationPage(driver);
    this.projectPage = new ProjectPage(driver);
    this.newProject = new NewProject(driver);
    this.deleteProjectPage = new DeleteProjectPage(driver);
  }

  @AfterTest
  void clearStub() {
    // close driver after test
    driver.close();
  }

  @BeforeMethod
  void cleanBrowser(){
    driver.manage().deleteAllCookies();
  }


  @Test (priority = 1)
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


  @Test (priority = 2)
  void DeleteProject_WhenWithAbc_ThenAbc() throws Exception {
    this.redmineHomePage.navigate();
    this.redmineHomePage.clickSignInButton();
    this.loginPage.enterLoginTextBox("admin");
    this.loginPage.enterPassWordTextBox("123456789");
    this.loginPage.clickLoginButton();
    this.redmineHomePage.clickAdministrationTab();
    this.administrationPage.clickProjectsTab();
    this.projectPage.clickDeleteClound360Button();
    this.deleteProjectPage.enterIdentifierTextBox("clound360");
    this.deleteProjectPage.clickDeleteButton();

    List<WebElement> project = this.projectPage.getProjectFromProjectTable();
    System.out.println("Total of project is " + project.size());
    Assert.assertEquals(project.size(), 2);

    List<String> projectName = new ArrayList<>();
    for (WebElement name : project) {
      String item = this.projectPage.getProjectName(name);
      System.out.println(item);
      projectName.add(item);
    }
    Assert.assertListContainsObject(projectName, "ABC", "");
    Assert.assertListContainsObject(projectName, "Clound365", "");

  }


}


