package selenium.redmine.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
  private WebDriver driver = null;

  // khoi tao driver trong login page
  public LoginPage(WebDriver driver) {
    this.driver = driver;
  }

  public void enterLoginTextBox(String value) {
    var login = driver.findElement(By.cssSelector("input#username[type='text']"));
    login.sendKeys(value);
  }

  public void enterPassWordTextBox(String value) {
    var password = driver.findElement(By.cssSelector("input#password[type='password']"));
    password.sendKeys(value);
  }

  public void clickLoginButton() {
    var loginButton = driver.findElement(By.cssSelector("input#login-submit[type='submit']"));
    loginButton.click();
  }

  public String InvalidUserOrPasswordInformation() {
    var errorInformation = driver.findElement(By.cssSelector("div#flash_error"));
    return errorInformation.getText();

  }
}

