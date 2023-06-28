package selenium.redmine.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RolePage {
  private WebDriver driver = null;

  public RolePage(WebDriver driver) {
    this.driver = driver;
  }
  public void clickNewRoleTab(){
    var newRole =driver.findElement(By.cssSelector("a.icon.icon-add"));
    newRole.click();
  }
  public String getSuccessfulCreationInformation(){
    var successfulCreation=driver.findElement(By.cssSelector("div#flash_notice"));
    return successfulCreation.getText();
  }
  public List<WebElement> getRoleListFromRoleTable(){
    List<WebElement> roleList = driver.findElements(By.cssSelector("tr.givable"));
    return roleList;
  }
  public void clickDeleteButton(){
    var delete = driver.findElement(By.cssSelector("a[href='/roles/4']"));
    delete.click();
  }
}
