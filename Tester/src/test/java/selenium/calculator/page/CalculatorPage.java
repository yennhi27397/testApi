package selenium.calculator.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CalculatorPage {
  private WebDriver driver = null;

  private String URL = "file:///loaiC:/Users/Admin/Downloads/Telegram%20Desktop/totalOrderByID.html";


  public CalculatorPage(WebDriver driver) {
    this.driver = driver;
  }

  public void pressPlusButton() {
    var plus = driver.findElement(By.cssSelector("#calcu > tbody > tr:nth-child(5) > td:nth-child(4) > input[type=button]"));
    plus.click();
  }

  public void pressMinusButton() {
    var minus = driver.findElement(By.cssSelector("#calcu > tbody > tr:nth-child(4) > td:nth-child(4) > input[type=button]"));
    minus.click();
  }

  public void pressEqualButton() {
    var equal = driver.findElement(By.cssSelector("#calcu > tbody > tr:nth-child(5) > td:nth-child(3) > input[type=button]"));
    equal.click();
  }

  public void press1Button() {
    var button1 = driver.findElement(By.cssSelector("#calcu > tbody > tr:nth-child(2) > td:nth-child(1) > input[type=button]"));
    button1.click();
  }

  public void press2Button() {
    var button2 = driver.findElement(By.cssSelector("#calcu > tbody > tr:nth-child(2) > td:nth-child(2) > input[type=button]"));
    button2.click();
  }

  public void press3Button() {
    var button3 = driver.findElement(By.cssSelector("#calcu > tbody > tr:nth-child(2) > td:nth-child(3) > input[type=button]"));
    button3.click();
  }

  public void pressDecimalPoint() {
    var decimalPoint = driver.findElement(By.cssSelector("#calcu > tbody > tr:nth-child(5) > td:nth-child(2) > input[type=button]"));
    decimalPoint.click();
  }

  public void navigate() {
    driver.navigate().to(URL); // Điều khiển Selenium vào web
  }

  public String getResult() {
    var textbox = driver.findElement(By.cssSelector("#result"));
    String resultString1 = textbox.getAttribute("value");
    return resultString1;
  }

  public void enterKey(String name) {
    var textbox = driver.findElement(By.cssSelector("#result"));
    textbox.sendKeys(name);// nhập ký tự
  }

  public void pressMultiply() {
    var multiply = driver.findElement(By.cssSelector("#calcu > tbody > tr:nth-child(3) > td:nth-child(4) > input[type=button]"));
    multiply.click();
  }

  public void pressDivisionButton() {
    var pressDivision = driver.findElement(By.cssSelector("#calcu > tbody > tr:nth-child(2) > td:nth-child(4) > input[type=button]"));
    pressDivision.click();
  }

  public void pressDeleteButton() {
    var pressDelete = driver.findElement(By.cssSelector("#calcu > tbody > tr:nth-child(1) > td:nth-child(2) > input[type=button]"));
    pressDelete.click();
  }

}



