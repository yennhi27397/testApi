package selenium.calculator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import selenium.calculator.page.CalculatorPage;

public class MultiplicationCalculatorTest {
  private WebDriver driver = null;
  private CalculatorPage calculatorPage = null;

  @BeforeTest
  void prepareStub() {
    System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Downloads\\chromedriver_win32\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    calculatorPage = new CalculatorPage(driver);
  }

  @AfterTest
  void clearStub() {
    driver.close();
  }

  @Test
    // 2*2
  void Multiplication_WhenWith2Integer_ThenCalculatorIsOk() throws Exception {
    this.calculatorPage.navigate();
    this.calculatorPage.press2Button();
    this.calculatorPage.pressMultiply();
    this.calculatorPage.press2Button();
    this.calculatorPage.pressEqualButton();

    String result = this.calculatorPage.getResult();
    System.out.println("Result of test case 1 is: " + result);
    Assert.assertEquals(result, "4");
  }

  @Test
    // -1*-2
  void Multiplication_WhenWith2NegativeInteger_ThenCalculatorIsOk() throws Exception {
    this.calculatorPage.navigate();
    this.calculatorPage.pressMinusButton();
    this.calculatorPage.press1Button();
    this.calculatorPage.pressMultiply();
    this.calculatorPage.pressMinusButton();
    this.calculatorPage.press2Button();
    this.calculatorPage.pressEqualButton();

    String result = this.calculatorPage.getResult();
    System.out.println("Result of test case 2 is: " + result);
    Assert.assertEquals(result, "2");
  }

  @Test
    // -2*3
  void Multiplication_WhenWith1NegativeInteger1Integer_ThenCalculatorIsOk() throws Exception {
    this.calculatorPage.navigate();
    this.calculatorPage.pressMinusButton();
    this.calculatorPage.press2Button();
    this.calculatorPage.pressMultiply();
    this.calculatorPage.press3Button();
    this.calculatorPage.pressEqualButton();

    String result = this.calculatorPage.getResult();
    System.out.println("Result of test case 3 is: " + result);
  }

  @Test
    // 2.3* 3.2
  void Multiplication_WhenWith2Decimal_ThenCalculatorIsOk() throws Exception {
    this.calculatorPage.navigate();
    this.calculatorPage.press2Button();
    this.calculatorPage.pressDecimalPoint();
    this.calculatorPage.press3Button();
    this.calculatorPage.pressMultiply();
    this.calculatorPage.press3Button();
    this.calculatorPage.pressDecimalPoint();
    this.calculatorPage.press2Button();
    this.calculatorPage.pressEqualButton();

    String result = this.calculatorPage.getResult();
    System.out.println("Result of test case 4 is: " + result);
    Assert.assertEquals(result, "7.359999999999999");

  }

  @Test
    // -2.3* -3.2
  void Multiplication_WhenWith2NegativeDecimal_ThenCalculatorIsOk() throws Exception {
    this.calculatorPage.navigate();
    this.calculatorPage.pressMinusButton();
    this.calculatorPage.press2Button();
    this.calculatorPage.pressDecimalPoint();
    this.calculatorPage.press3Button();
    this.calculatorPage.pressMultiply();
    this.calculatorPage.pressMinusButton();
    this.calculatorPage.press3Button();
    this.calculatorPage.pressDecimalPoint();
    this.calculatorPage.press2Button();
    this.calculatorPage.pressEqualButton();

    String result = this.calculatorPage.getResult();
    System.out.println("Result of test case 5 is: " + result);
    Assert.assertEquals(result, "7.359999999999999");
  }

  @Test
    // -2.3* 3.2
  void Multiplication_WhenWith1NegativeDecimal1Decimal_ThenCalculatorIsOk() throws Exception {
    this.calculatorPage.navigate();
    this.calculatorPage.pressMinusButton();
    this.calculatorPage.press2Button();
    this.calculatorPage.pressDecimalPoint();
    this.calculatorPage.press3Button();
    this.calculatorPage.pressMultiply();
    this.calculatorPage.press3Button();
    this.calculatorPage.pressDecimalPoint();
    this.calculatorPage.press2Button();
    this.calculatorPage.pressEqualButton();

    String result = this.calculatorPage.getResult();
    System.out.println("Result of test case 6 is: " + result);
    Assert.assertEquals(result, "-7.359999999999999");
  }

  @Test
    // n*h
  void Multiplication_WhenWith2characters_ThenCalculatorIsOk() throws Exception {
    this.calculatorPage.navigate();
    this.calculatorPage.enterKey("n");
    this.calculatorPage.pressMultiply();
    this.calculatorPage.enterKey("h");
    this.calculatorPage.pressEqualButton();

    String result = this.calculatorPage.getResult();
    System.out.println("Result of test case 7 is: " + result);
    Assert.assertEquals(result, "ERROR");
  }
}
