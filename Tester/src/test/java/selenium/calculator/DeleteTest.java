package selenium.calculator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import selenium.calculator.page.CalculatorPage;

public class DeleteTest {
  private WebDriver driver = null;
  private CalculatorPage calculatorPage = null;

  @BeforeTest
  void prepareStub() {
    System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Downloads\\chromedriver_win32\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    this.calculatorPage = new CalculatorPage(driver);
  }

  @AfterTest
  void clearStub() {
    driver.close();
  }

  @Test
  void Delete_WhenWith1Integer_ThenCalculatorIsOk() throws Exception {
    this.calculatorPage.navigate();
    this.calculatorPage.press1Button();
    this.calculatorPage.pressDeleteButton();
    String result = this.calculatorPage.getResult();
    System.out.println("Result of test case 1 is: " + result);
    Assert.assertEquals(result, "");
  }

  @Test
  void Delete_WhenWith1Character_ThenCalculatorIsOk() throws Exception {
    this.calculatorPage.navigate();
    this.calculatorPage.enterKey("n");
    this.calculatorPage.pressDeleteButton();
    String result = this.calculatorPage.getResult();
    System.out.println("Result of test case 2 is: " + result);
    Assert.assertEquals(result, "");
  }


}
