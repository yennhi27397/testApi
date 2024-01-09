package selenium.lazada.page;

import org.openqa.selenium.WebDriver;
import selenium.redmine.Common;

public class LazadaHomePage {
  private WebDriver driver;
  private String URL = "https://www.lazada.vn/";

  public LazadaHomePage(WebDriver webDriver) {
    this.driver = webDriver;
  }

  public void navigate() {
    driver.navigate().to(URL);
  }

  public void clickLoginButton(){
    var clickLogin = Common.getWebElement(driver,"a","login");
    clickLogin.click();
  }


}
