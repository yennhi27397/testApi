package selenium.tiki.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class TikiHomePage {
  private WebDriver driver = null;
  private String tikiHomePage = "https://tiki.vn/";

  public TikiHomePage(WebDriver driver) {
    this.driver = driver;
  }

  public void navigate() {
    driver.navigate().to(tikiHomePage);
  }

  public void clickTaiKhoanTab() {
    var taiKhoanTab = driver.findElement(By.cssSelector("#main-header > div > div.Middle__Wrap-sc-vop1h1-0.edlkEo.revamp > div.Userstyle__RootRevamp-sc-6e6am-15.hkQlMw > div:nth-child(3) > span"));
    taiKhoanTab.click();
  }

  public void enterPhoneTextBox(String number) {
    var phoneTextBox = driver.findElement(By.cssSelector("body > div.ReactModalPortal > div > div > div > div.styles__Left-sc-2hr4xa-1.iwneWf > div > form > div > input[type=tel]"));
    phoneTextBox.sendKeys(number);
  }

  public void clickTiepTucButton() {
    var tiepTucButton = driver.findElement(By.cssSelector("body > div.ReactModalPortal > div > div > div > div.styles__Left-sc-2hr4xa-1.iwneWf > div > form > button"));
    tiepTucButton.click();
  }

  public void enterPassWordTextBox(String key) {
    var phoneTextBox = driver.findElement(By.cssSelector("body > div.ReactModalPortal > div > div > div > div.styles__Left-sc-2hr4xa-1.iwneWf > div > form > div > input[type=password]"));
    phoneTextBox.sendKeys(key);
  }

  public void clickDangNhapButton() {
    var dangNhapButton = driver.findElement(By.cssSelector("body > div.ReactModalPortal > div > div > div > div.styles__Left-sc-2hr4xa-1.iwneWf > div > form > button"));
    dangNhapButton.click();
  }

  public void enterTimKiemTextBox(String key) {
    var timKiemTextBox = driver.findElement(By.cssSelector("#main-header > div > div.Middle__Wrap-sc-vop1h1-0.edlkEo.revamp > div.Middle__LeftContainer-sc-vop1h1-1.hBRVdJ > div.FormSearchStyle__Root-sc-1idbenb-0.crtTgy > div > input"));
    timKiemTextBox.sendKeys(key);
  }

  public void pressEnter() {
    var timKiemTextBox = driver.findElement(By.cssSelector("#main-header > div > div.Middle__Wrap-sc-vop1h1-0.edlkEo.revamp > div.Middle__LeftContainer-sc-vop1h1-1.hBRVdJ > div.FormSearchStyle__Root-sc-1idbenb-0.crtTgy > div > input"));
    timKiemTextBox.sendKeys(Keys.ENTER);
  }
}


