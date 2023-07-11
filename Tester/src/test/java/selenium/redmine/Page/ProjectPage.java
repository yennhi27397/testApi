package selenium.redmine.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProjectPage {
  private WebDriver driver = null;

  public ProjectPage(WebDriver driver) {
    this.driver = driver;
  }

  // call attribute New Project Tab
  public void clickNewProjectTab() {
    // get tag='a', class='icon.icon-add'
    var project = driver.findElement(By.cssSelector("a.icon.icon-add"));
    // click New Project Tab
    project.click();
  }

  public void clickDeleteButton() {
    var clickDelete = driver.findElement(By.cssSelector("a.icon.icon-del[data-method='delete'][href='/projects/clound360']"));
    clickDelete.click();
  }

  public List<WebElement> getProjectFromProjectTable() {
    List<WebElement> getProject = driver.findElements(By.cssSelector("tr.leaf.project.public.root"));
    return getProject;
  }

  public String getProjectName(WebElement webElement){
    var projectName = webElement.findElement(By.cssSelector("td.name span a"));
    return projectName.getText();
  }
}
