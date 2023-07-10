package selenium.redmine.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdministrationPage {
  private WebDriver driver = null;

  public AdministrationPage(WebDriver driver) {
    this.driver = driver;

  }

  // call attribute click Project tab
  public void clickProjectsTab() {
    // get tag='a', class='icon.icon-projects'
    var projects = driver.findElement(By.cssSelector("a.icon.icon-projects"));
    // click project tab
    projects.click();
  }

  // call attribute click Roles And Permissions Tab
  public void clickRolesAndPermissionsTab() {
    // get tag='a', class='icon.icon-roles'
    var rolesAndPermissions = driver.findElement(By.cssSelector("a.icon.icon-roles"));
    // click Roles And Permissions Tab
    rolesAndPermissions.click();
  }

}
