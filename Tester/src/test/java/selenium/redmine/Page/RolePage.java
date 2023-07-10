package selenium.redmine.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import selenium.redmine.Common;

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
    var delete = driver.findElement(By.cssSelector("a.icon.icon-del[data-confirm='Are you sure?'][data-method='delete'][href='/roles/6']"));
    delete.click();
  }

  public String getRoleName(WebElement element){
    var roleName = element.findElement(By.cssSelector("td.name span a"));
    return roleName.getText();
  }
}
