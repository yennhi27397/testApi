package selenium.redmine.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdministrationPage {
  private WebDriver driver = null;

  public AdministrationPage(WebDriver driver) {
    this.driver = driver;

}
  public void clickProjectsTab(){
    var projects = driver.findElement(By.cssSelector("a.icon.icon-projects"));
    projects.click();
  }
  public void clickRolesAndPermissionsTab(){
    var rolesAndPermissions = driver.findElement(By.cssSelector("a.icon.icon-roles"));
    rolesAndPermissions.click();
  }

}
