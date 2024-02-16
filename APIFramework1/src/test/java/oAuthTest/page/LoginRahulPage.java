package oAuthTest.page;

import common.Common;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginRahulPage {
  private WebDriver driver;
  private String URL = "https://accounts.google.com/v3/signin/identifier?continue=https%3A%2F%2Fwww.google.com%3Fhl%3Den-US&ec=GAlA8wE&hl=en&flowName=GlifWebSignIn&flowEntry=AddSession&dsh=S1191855719%3A1708051881872509&theme=glif";

  public LoginRahulPage(WebDriver driver) {
    this.driver = driver;
  }
  public void navigate() {
    driver.navigate().to(URL);
  }
  public void enterEmailOrPhoneTextBox(String value) {
    var login = driver.findElement(By.cssSelector("input#identifierId"));
    login.sendKeys(value);
  }
  public void enterPasswordTextBox(String value) {
    var login = driver.findElement(By.cssSelector("input.whsOnd.zHQkBf[aria-disabled='false'][aria-label='Nhập mật khẩu của bạn']"));
    login.sendKeys(value);

  }
  public void clickContinueButton(){
    var continueButton = Common.getWebElement(driver,"span","Next");
    continueButton.click();
  }
}
