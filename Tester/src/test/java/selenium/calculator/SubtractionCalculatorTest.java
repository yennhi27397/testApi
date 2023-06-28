package selenium.calculator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import selenium.calculator.page.CalculatorPage;

public class SubtractionCalculatorTest {
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
  void cleanStub() {
    driver.close();
  }

  @Test
    // 3-2
  void Subtraction_WhenWith2Integers_ThenCalculatorIsOk() throws Exception {
    this.calculatorPage.navigate();
    this.calculatorPage.press3Button();
    this.calculatorPage.pressMinusButton();
    this.calculatorPage.press2Button();
    this.calculatorPage.pressEqualButton();

    String result = this.calculatorPage.getResult();
    System.out.println("Result of test case 1 is: " + result);
    Assert.assertEquals(result, "1");
  }

  @Test
    // -3 --2
  void Subtraction_WhenWith2NegativeIntegers_ThenCalculatorIsOk() throws Exception {
    this.calculatorPage.navigate();
    this.calculatorPage.pressMinusButton();
    this.calculatorPage.press3Button();
    this.calculatorPage.pressMinusButton();
    this.calculatorPage.pressMinusButton();
    this.calculatorPage.press2Button();
    this.calculatorPage.pressEqualButton();

    String result = this.calculatorPage.getResult();
    System.out.println("Result of test case 2 is: " + result);
    Assert.assertEquals(result, "-1");
  }

  @Test
    // 3 --2
  void Subtraction_WhenWith1PositiveNumberAnd1NegativeNumber_ThenCalculatorIsOK() throws Exception {
    this.calculatorPage.navigate();
    this.calculatorPage.press3Button();
    this.calculatorPage.pressMinusButton();
    this.calculatorPage.pressMinusButton();
    this.calculatorPage.press2Button();
    this.calculatorPage.pressEqualButton();

    String result = this.calculatorPage.getResult();
    System.out.println("Result of test case 3 is: " + result);
    Assert.assertEquals(result, "5");
  }

  @Test
    // n-h
  void Subtraction_WhenWith2Characters_ThenCalculatorIsNotOk() throws Exception {
    this.calculatorPage.navigate();
    this.calculatorPage.enterKey("n");
    this.calculatorPage.pressPlusButton();
    this.calculatorPage.enterKey("h");
    this.calculatorPage.pressEqualButton();

    String result = this.calculatorPage.getResult();
    System.out.println("Result of test case 4 is: " + result);
    Assert.assertEquals(result, "ERROR");
  }

  @Test
    //3.2-1.2
  void Subtraction_WhenWith2Decimal_ThenCalculatorIsOK() throws Exception {
    this.calculatorPage.navigate();
    this.calculatorPage.press3Button();
    this.calculatorPage.pressDecimalPoint();
    this.calculatorPage.press2Button();
    this.calculatorPage.pressMinusButton();
    this.calculatorPage.press1Button();
    this.calculatorPage.pressDecimalPoint();
    this.calculatorPage.press2Button();
    this.calculatorPage.pressEqualButton();

    String result = this.calculatorPage.getResult();
    System.out.println("Result of test case 5 is: " + result);
    Assert.assertEquals(result, "2");
  }

  @Test
    // -2.3 - -3.2
  void Subtraction_WhenWith2NegativeDecimal_ThenCalculatorIsOk() throws Exception {
    this.calculatorPage.navigate();
    this.calculatorPage.pressMinusButton();
    this.calculatorPage.press2Button();
    this.calculatorPage.pressDecimalPoint();
    this.calculatorPage.press3Button();
    this.calculatorPage.pressMinusButton();
    this.calculatorPage.pressMinusButton();
    this.calculatorPage.press3Button();
    this.calculatorPage.pressDecimalPoint();
    this.calculatorPage.press2Button();
    this.calculatorPage.pressEqualButton();

    String result = this.calculatorPage.getResult();
    System.out.println("Result of test case 6 is: " + result);
    Assert.assertEquals(result, "0.9000000000000004");
  }

  @Test
    // 3.2 - 1
  void Subtraction_WhenWith1Integer1NegativeDecimal_ThenCalculatorIsOK() throws Exception {
    this.calculatorPage.navigate();
    this.calculatorPage.press3Button();
    this.calculatorPage.pressDecimalPoint();
    this.calculatorPage.press2Button();
    this.calculatorPage.pressMinusButton();
    this.calculatorPage.press1Button();
    this.calculatorPage.pressEqualButton();

    String result = this.calculatorPage.getResult();
    System.out.println("Result of test case 7 is: " + result);
    Assert.assertEquals(result, "2.2");
  }

  @Test
    // 2-2-2
  void Subtraction_WhenWith3Number_ThenCalculatorIsOk() throws Exception {
    this.calculatorPage.navigate();
    this.calculatorPage.press2Button();
    this.calculatorPage.pressMinusButton();
    this.calculatorPage.press2Button();
    this.calculatorPage.pressMinusButton();
    this.calculatorPage.press2Button();
    this.calculatorPage.pressEqualButton();

    String result = this.calculatorPage.getResult();
    System.out.println("Result of test case 8 is: " + result);
    Assert.assertEquals(result, "-2");
  }
}
