package selenium.calculator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import selenium.calculator.page.CalculatorPage;

public class DivisionCalculatorTest {
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
  void Division_WhenWith2Integer_ThenCalculatorIsOk() throws Exception {
    this.calculatorPage.navigate();
    this.calculatorPage.press2Button();
    this.calculatorPage.pressDivisionButton();
    this.calculatorPage.press2Button();
    this.calculatorPage.pressEqualButton();

    String result = this.calculatorPage.getResult();
    System.out.println("Result of test case 1 is: " + result);
    Assert.assertEquals(result, "1");
  }

  @Test
    // -2/-2
  void Division_WhenWith2NegativeInteger_ThenCalculatorIsOk() throws Exception {
    this.calculatorPage.navigate();
    this.calculatorPage.pressMinusButton();
    this.calculatorPage.press2Button();
    this.calculatorPage.pressDivisionButton();
    this.calculatorPage.pressMinusButton();
    this.calculatorPage.press2Button();
    this.calculatorPage.pressEqualButton();

    String result = this.calculatorPage.getResult();
    System.out.println("Result of test case 2 is: " + result);
    Assert.assertEquals(result, "1");

  }

  @Test
    // 2/ -2
  void Division_WhenWith1NegativeInteger1Integer_ThenCalculatorIsOk() throws Exception {
    this.calculatorPage.navigate();
    this.calculatorPage.press2Button();
    this.calculatorPage.pressDivisionButton();
    this.calculatorPage.pressMinusButton();
    this.calculatorPage.press2Button();
    this.calculatorPage.pressEqualButton();

    String result = this.calculatorPage.getResult();
    System.out.println("Result of test case 3 is: " + result);
    Assert.assertEquals(result, "-1");
  }

  @Test
    // 2.3/2.3
  void Division_WhenWith2Decimals_ThenCalculatorIsOk() throws Exception {
    this.calculatorPage.navigate();
    this.calculatorPage.press2Button();
    this.calculatorPage.pressDecimalPoint();
    this.calculatorPage.press3Button();
    this.calculatorPage.pressDivisionButton();
    this.calculatorPage.press2Button();
    this.calculatorPage.pressDecimalPoint();
    this.calculatorPage.press3Button();
    this.calculatorPage.pressEqualButton();

    String result = this.calculatorPage.getResult();
    System.out.println("Result of test case 4 is: " + result);
    Assert.assertEquals(result, "1");
  }

  @Test
    // -2.3/-2.3
  void Division_WhenWith2NegativeDecimals_ThenCalculatorIsOk() throws Exception {
    this.calculatorPage.navigate();
    this.calculatorPage.pressMinusButton();
    this.calculatorPage.press2Button();
    this.calculatorPage.pressDecimalPoint();
    this.calculatorPage.press3Button();
    this.calculatorPage.pressDivisionButton();
    this.calculatorPage.pressMinusButton();
    this.calculatorPage.press2Button();
    this.calculatorPage.pressDecimalPoint();
    this.calculatorPage.press3Button();
    this.calculatorPage.pressEqualButton();

    String result = this.calculatorPage.getResult();
    System.out.println("Result of test case 5 is: " + result);
    Assert.assertEquals(result, "1");
  }

  @Test
    // 2.3/-2.3
  void Division_WhenWith1NegativeDecimal1Decimal_ThenCalculatorIsOk() throws Exception {
    this.calculatorPage.navigate();
    this.calculatorPage.press2Button();
    this.calculatorPage.pressDecimalPoint();
    this.calculatorPage.press3Button();
    this.calculatorPage.pressDivisionButton();
    this.calculatorPage.pressMinusButton();
    this.calculatorPage.press2Button();
    this.calculatorPage.pressDecimalPoint();
    this.calculatorPage.press3Button();
    this.calculatorPage.pressEqualButton();

    String result = this.calculatorPage.getResult();
    System.out.println("Result of test case 6 is: " + result);
    Assert.assertEquals(result, "-1");
  }

  @Test
    // n/h
  void Division_WhenWith2Characters_ThenCalculatorIsOk() throws Exception {
    this.calculatorPage.navigate();
    this.calculatorPage.enterKey("n");
    this.calculatorPage.pressDivisionButton();
    this.calculatorPage.enterKey("h");
    this.calculatorPage.pressEqualButton();

    String result = this.calculatorPage.getResult();
    System.out.println("Result of test case 7 is: " + result);
    Assert.assertEquals(result, "ERROR");
  }

  @Test
    // n/1
  void Division_WhenWith1Character1Integer_ThenCalculatorIsOk() throws Exception {
    this.calculatorPage.navigate();
    this.calculatorPage.enterKey("n");
    this.calculatorPage.pressDivisionButton();
    this.calculatorPage.press1Button();
    this.calculatorPage.pressEqualButton();

    String result = this.calculatorPage.getResult();
    System.out.println("Result of test case 8 is: " + result);
    Assert.assertEquals(result, "ERROR");
  }
}
