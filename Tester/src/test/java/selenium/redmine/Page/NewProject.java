package selenium.redmine.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewProject {
  private WebDriver driver = null;

  public NewProject(WebDriver driver) {
    this.driver = driver;
  }

  public void enterNameTextBox(String name) {
    var nameTextBox = driver.findElement(By.cssSelector("input#project_name[type='text']"));
    nameTextBox.sendKeys(name);
  }

  public void clickDescriptionTextBox() {
    var clickDescription = driver.findElement(By.cssSelector("textarea#project_description"));
    clickDescription.click();
  }

  public void enterDescriptionTextBox(String value) {
    var enterDescription = driver.findElement(By.cssSelector("textarea#project_description"));
    enterDescription.sendKeys(value);
  }

  public void clickCreateButton() {
    var create = driver.findElement(By.cssSelector("input[type='submit'][value='Create']"));
    create.click();
  }

  public String getSuccessfulCreationNotification() {
    var successfulCreation = driver.findElement(By.cssSelector("div#flash_notice"));
    return successfulCreation.getText();
  }

}
