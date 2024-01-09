package selenium.lazada.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LazadaLoginPage {
  private WebDriver driver;

  public LazadaLoginPage(WebDriver driver) {
    this.driver = driver;
  }

  public void enterPhoneOrNumberTextBox(String value) {
    var enterPhoneOrNumber = driver.findElement(By.cssSelector("input[data-meta='Field'][data-spm-anchor-id='a2o42.login_signup.0.i0.75175d0a6hfGRU']"));
    enterPhoneOrNumber.sendKeys(value);
  }

  public void enterPassword(String value) {
    var enterPassword = driver.findElement(By.cssSelector("input[data-meta='Field'][data-spm-anchor-id='a2o42.login_signup.0.i3.75175d0a6hfGRU']"));
    enterPassword.sendKeys(value);
  }

  public void clickLoginButton(){
    var clickLogin = driver.findElement(By.cssSelector("button.next-btn"));
    clickLogin.click();
  }
}
