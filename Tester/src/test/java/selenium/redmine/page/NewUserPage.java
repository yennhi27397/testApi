package selenium.redmine.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewUserPage {
  private WebDriver driver = null;

  public NewUserPage(WebDriver driver) {
    this.driver = driver;
  }

  public void enterLoginTextBox(String name) {
    var loginTextBox = driver.findElement(By.cssSelector("input#user_login"));
    loginTextBox.sendKeys(name);
  }

  public void enterFirstNameTextBox(String name) {
    var FirstNameTextBox = driver.findElement(By.cssSelector("input#user_firstname"));
    FirstNameTextBox.sendKeys(name);
  }

  public void enterLastNameTextBox(String name) {
    var LastNameTextBox = driver.findElement(By.cssSelector("input#user_lastname"));
    LastNameTextBox.sendKeys(name);
  }

  public void enterPasswordTextBox(String name) {
    var PasswordTextBox = driver.findElement(By.cssSelector("input#user_password"));
    PasswordTextBox.sendKeys(name);
  }
  public void enterEmailTextBox(String name) {
    var EmailTextBox = driver.findElement(By.cssSelector("input#user_mail"));
    EmailTextBox.sendKeys(name);
  }

  public void enterConfirmationTextBox(String name) {
    var ConfirmationTextBox = driver.findElement(By.cssSelector("input#user_password_confirmation"));
    ConfirmationTextBox.sendKeys(name);
  }

  public void clickCreateButton() {
    var clickCreate = driver.findElement(By.cssSelector("input[data-disable-with='Create']"));
    clickCreate.click();
  }

  public String getUserCreatedInformation(){
    var userCreated = driver.findElement(By.cssSelector("div#flash_notice"));
    return userCreated.getText();
  }

  public void clickAdministrationTab(){
    var administration = driver.findElement(By.cssSelector("a.administration"));
    administration.click();
  }
}
