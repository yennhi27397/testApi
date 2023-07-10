package selenium.redmine.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewProject {
  private WebDriver driver = null;

  public NewProject(WebDriver driver) {
    this.driver = driver;
  }

  // call attribute enter NameTextBox and pass to String name param
  public void enterNameTextBox(String name) {
    // get tag='input', id='project_name'
    var nameTextBox = driver.findElement(By.cssSelector("input#project_name"));
    // enter String name in Name textbox
    nameTextBox.sendKeys(name);
  }

  // call attribute click Description TextBox
  public void clickDescriptionTextBox() {
    // get tag='textarea', id='project_description'
    var clickDescription = driver.findElement(By.cssSelector("textarea#project_description"));
    // click Description TextBox
    clickDescription.click();
  }

  // call attribute enter Description TextBox and pass to String value into Description TextField
  public void enterDescriptionTextField(String value) {
    // get tag='textarea', id='project_description'
    var enterDescription = driver.findElement(By.cssSelector("textarea#project_description"));
    // enter String value into Description TextField
    enterDescription.sendKeys(value);
  }

  // call attribute click Create Button
  public void clickCreateButton() {
    // get tag='input', type='submit', value='Create'
    var create = driver.findElement(By.cssSelector("input[type='submit'][value='Create']"));
    // click Create button
    create.click();
  }
  // call attribute get Successful Creation Notification
  public String getSuccessfulCreationNotification() {
    // get tag='div', class ='flash_notice'
    var successfulCreation = driver.findElement(By.cssSelector("div#flash_notice"));
    // get 'Successful Creation' text
    return successfulCreation.getText();
  }

}
