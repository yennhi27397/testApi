package selenium.lazada.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import selenium.lazada.page.LazadaHomePage;
import selenium.lazada.page.LazadaLoginPage;
import selenium.lazada.page.LazadaRealHomePage;

public class LoginTest {
  private WebDriver driver;
  private LazadaLoginPage lazadaLoginPage;
  private LazadaHomePage lazadaHomePage;

  private LazadaRealHomePage lazadaRealHomePage;

  @BeforeTest
  void prepareStub() {
    System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
    var chromeOptions = new ChromeOptions();
    chromeOptions.setProxy(null);
    driver = new ChromeDriver(chromeOptions);
    driver.manage().window().maximize();
    lazadaHomePage = new LazadaHomePage(driver);
    lazadaLoginPage = new LazadaLoginPage(driver);
    lazadaRealHomePage = new LazadaRealHomePage(driver);

  }

  @AfterTest
  void clearStub() {
    driver.close();
  }

  @Test
  void loginSuccessfully_WhenEmailAndPasswordIsValid_ThenShowAccount() throws Exception {
    this.lazadaHomePage.navigate();
    this.lazadaHomePage.clickLoginButton();
    this.lazadaLoginPage.enterPhoneOrNumberTextBox("0961285298");
    this.lazadaLoginPage.enterPassword("Phamyn27397");
    this.lazadaLoginPage.clickLoginButton();
    String item = this.lazadaRealHomePage.getAccountName();
    System.out.println("Message shows is " + item);

  }
}
