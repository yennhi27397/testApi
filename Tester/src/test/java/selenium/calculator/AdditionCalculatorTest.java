package selenium.calculator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import selenium.calculator.page.CalculatorPage;

public class AdditionCalculatorTest { // feature name
  // BDD
  // GIVEN -> user dang lam gi / muon gi.
  // WHEN -> condition input.
  // THEN -> expectation (requirement of BA.)
  // test case phai doc lap.

  private WebDriver driver = null;
  private CalculatorPage calculatorPage = null;

  @BeforeTest
  void prepareStub() {
    System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Downloads\\chromedriver_win32\\chromedriver.exe");
    driver = new ChromeDriver(); //Open Chrome
    driver.manage().window().maximize(); // zoom to man hinh
    this.calculatorPage = new CalculatorPage(driver);
  }

  @AfterTest
  void cleanStub() {
    driver.close();
  }

  @Test
  void Addition_WhenWith2SoDuong_ThenCalculatorIsOk() throws Exception {
    this.calculatorPage.navigate();
    this.calculatorPage.press1Button();
    this.calculatorPage.pressPlusButton();
    this.calculatorPage.press2Button();
    this.calculatorPage.pressEqualButton();

    String item = this.calculatorPage.getResult();
    System.out.println("Result of test case 1: " + item);

    Assert.assertEquals(item, "3");
  }

  @Test
  void Addition_WhenWith2SoAm_ThenCalculatorIsOk() throws Exception {
    this.calculatorPage.navigate();
    this.calculatorPage.pressMinusButton();
    this.calculatorPage.press1Button();
    this.calculatorPage.pressPlusButton();
    this.calculatorPage.pressMinusButton();
    this.calculatorPage.press2Button();
    this.calculatorPage.pressEqualButton();

    String item = this.calculatorPage.getResult();
    System.out.println("Result of test case 2: " + item);

    Assert.assertEquals(item, "-3");
  }

  @Test
  void Addition_WhenWith1SoAm1SoDuong_ThenCalculatorIsOk() throws Exception {
    this.calculatorPage.navigate();
    this.calculatorPage.pressMinusButton();
    this.calculatorPage.press1Button();
    this.calculatorPage.pressPlusButton();
    this.calculatorPage.press2Button();
    this.calculatorPage.pressEqualButton();

    String item = this.calculatorPage.getResult();
    System.out.println("Result of test case 3: " + item);

    Assert.assertEquals(item, "1");
  }

  @Test
  void Addition_WhenDouble2SoDuong_ThenCalculatorIsOk() throws Exception {
    this.calculatorPage.navigate();
    this.calculatorPage.press1Button();
    this.calculatorPage.press1Button();
    this.calculatorPage.pressPlusButton();
    this.calculatorPage.press2Button();
    this.calculatorPage.press2Button();
    this.calculatorPage.pressEqualButton();

    String item = this.calculatorPage.getResult();
    System.out.println("Result of test case 4: " + item);

    Assert.assertEquals(item, "33");
  }

  @Test
  void Addition_WhenWith2Characters_ThenCalculatorIsNotOk() throws Exception {
    this.calculatorPage.navigate();
    this.calculatorPage.enterKey("n");
    this.calculatorPage.pressPlusButton();
    this.calculatorPage.enterKey("h");
    this.calculatorPage.pressPlusButton();
    this.calculatorPage.enterKey("i");
    this.calculatorPage.pressEqualButton();

    String item = this.calculatorPage.getResult();
    System.out.println("Result of test case 5: " + item);
    Assert.assertEquals(item, "ERROR");
  }

  @Test
    // 3+2+1
  void Addition_WhenWith3numbers_ThenCalculatorIsNotOk() throws Exception {
    this.calculatorPage.navigate();
    this.calculatorPage.press3Button();
    this.calculatorPage.pressPlusButton();
    this.calculatorPage.press2Button();
    this.calculatorPage.pressPlusButton();
    this.calculatorPage.press1Button();
    this.calculatorPage.pressEqualButton();

    String item = this.calculatorPage.getResult();
    System.out.println("Result of test case 6: " + item);
    Assert.assertEquals(item, "6");
  }

  @Test
    // 3.2 + 2.3
  void Addition_WhenWithDecimal_ThenCalculatorIsOk() throws Exception {
    this.calculatorPage.navigate();
    this.calculatorPage.press3Button();
    this.calculatorPage.pressDecimalPoint();
    this.calculatorPage.press2Button();
    this.calculatorPage.pressPlusButton();
    this.calculatorPage.press2Button();
    this.calculatorPage.pressDecimalPoint();
    this.calculatorPage.press3Button();
    this.calculatorPage.pressEqualButton();

    String item = this.calculatorPage.getResult();
    System.out.println("Result of test case 7: " + item);
    Assert.assertEquals(item, "5.5");
  }

  @Test
    // -3.2+ -2.3
  void Addition_WhenWithNegativeDecimal_ThenCalculatorIsOk() throws Exception {
    this.calculatorPage.navigate();
    this.calculatorPage.pressMinusButton();
    this.calculatorPage.press3Button();
    this.calculatorPage.pressDecimalPoint();
    this.calculatorPage.press2Button();
    this.calculatorPage.pressPlusButton();
    this.calculatorPage.pressMinusButton();
    this.calculatorPage.press2Button();
    this.calculatorPage.pressDecimalPoint();
    this.calculatorPage.press3Button();
    this.calculatorPage.pressEqualButton();

    String item = this.calculatorPage.getResult();
    System.out.println("Result of test case 8: " + item);
    Assert.assertEquals(item, "-5.5");
  }

}


