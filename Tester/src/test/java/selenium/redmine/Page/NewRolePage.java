package selenium.redmine.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import selenium.redmine.Common;

public class NewRolePage {
  private WebDriver driver = null;

  public NewRolePage(WebDriver driver) {
    this.driver = driver;
  }

  // call attribute enter NameTextBox and pass to String value param
  public void enterNameTextBox(String value) {
    // get tag='input', id='role_name'
    var nameTextBox = driver.findElement(By.cssSelector("input#role_name"));
    // enter String value in Name textbox
    nameTextBox.sendKeys(value);
  }

  // call attribute choose Issues Visibility CheckBox and pass to String value param
  public void chooseIssuesVisibilityCheckBox(String value) {
    // get tag='select', id='role_issues_visibility'
    var issuesVisibility = driver.findElement(By.cssSelector("select#role_issues_visibility"));
    // call object 'select' and pass to 'issuesVisibility' element
    Select select = new Select(issuesVisibility);
    // pass to 'value' to choose Issues Visibility CheckBox
    select.selectByValue(value);
  }

  public void chooseUsersVisibilityCheckBox(String value) {
    var usersVisibility = driver.findElement(By.cssSelector("select#role_users_visibility"));
    Select select = new Select(usersVisibility);
    select.selectByValue(value);
  }
  public void clickCheckAllButton(){
    // get tag='a', text= 'Check all'
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
