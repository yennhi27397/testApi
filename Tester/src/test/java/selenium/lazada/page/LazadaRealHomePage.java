package selenium.lazada.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LazadaRealHomePage {
  private WebDriver driver;

  public LazadaRealHomePage(WebDriver driver) {
    this.driver = driver;
  }

  public String getAccountName() {
    var getAccount = driver.findElement(By.cssSelector("span#myAccountTrigger"));
    return getAccount.getText();
  }
}
