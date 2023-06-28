package selenium.redmine.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProjectPage {
  private WebDriver driver = null;

  public ProjectPage(WebDriver driver) {
    this.driver = driver;
  }
  public void clickNewProjectTab(){
    var project = driver.findElement(By.cssSelector("a.icon.icon-add"));
    project.click();
  }
}
