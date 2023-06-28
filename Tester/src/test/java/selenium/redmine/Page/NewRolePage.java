package selenium.redmine.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import selenium.redmine.Common;

public class NewRolePage {
  private WebDriver driver = null;

  public NewRolePage(WebDriver driver) {
    this.driver = driver;
  }

  public void enterNameTextBox(String value) {
    var nameTextBox = driver.findElement(By.cssSelector("input#role_name[type='text']"));
    nameTextBox.sendKeys(value);
  }

  public void chooseIssuesVisibilityCheckBox(String value) {
    var issuesVisibility = driver.findElement(By.cssSelector("select#role_issues_visibility"));
    Select select = new Select(issuesVisibility);
    select.selectByValue(value);
  }

  public void chooseUsersVisibilityCheckBox(String value) {
    var usersVisibility = driver.findElement(By.cssSelector("select#role_users_visibility"));
    Select select = new Select(usersVisibility);
    select.selectByValue(value);
  }
  public void clickCheckAllButton(){
    var checkAll = Common.getWebElement(driver,"a","Check all");
    checkAll.click();
  }
  public void clickCreateButton(){
    var create = driver.findElement(By.cssSelector("input[type='submit'][value='Create']"));
    create.click();
  }
  public void clickAddIssuesCheckBox(){
    var addIssues = driver.findElement(By.cssSelector("input#role_permissions_add_issues[type='checkbox']"));
    addIssues.click();
  }
  public void clickEditIssuesCheckBox() {
    var editIssues = driver.findElement(By.cssSelector("input#role_permissions_edit_issues[type='checkbox']"));
    editIssues.click();
  }
}
