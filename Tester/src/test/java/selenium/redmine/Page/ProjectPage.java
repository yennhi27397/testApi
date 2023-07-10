package selenium.redmine.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProjectPage {
  private WebDriver driver = null;

  public ProjectPage(WebDriver driver) {
    this.driver = driver;
  }
  // call attribute New Project Tab
  public void clickNewProjectTab(){
    // get tag='a', class='icon.icon-add'
    var project = driver.findElement(By.cssSelector("a.icon.icon-add"));
    // click New Project Tab
    project.click();
  }
  public void clickDeleteButton
}
