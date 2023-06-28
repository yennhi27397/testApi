package selenium.tiki.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import selenium.tiki.page.CartPage;
import selenium.tiki.page.ProductInformationPage;
import selenium.tiki.page.ProductPage;
import selenium.tiki.page.TikiHomePage;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class OrderTest {
  private WebDriver driver = null;
  private TikiHomePage tikiHomePage = null;
  private ProductPage productPage = null;
  private ProductInformationPage productInformationPage = null;
  private CartPage cartPage = null;

  @BeforeTest
  void prepareStub() {
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    this.tikiHomePage = new TikiHomePage(driver);
    this.productInformationPage = new ProductInformationPage(driver);
    this.productPage = new ProductPage(driver);
    this.cartPage = new CartPage(driver);
  }

  @AfterTest
  void clearStub() {
    //driver.close();
  }

  @Test
  void OrderSupply_WhenWith1Supply_ThenOrderIsOk() throws Exception {
    this.tikiHomePage.navigate();
    this.tikiHomePage.clickTaiKhoanTab();
    this.tikiHomePage.enterPhoneTextBox("0961285298");
    this.tikiHomePage.clickTiepTucButton();
    this.tikiHomePage.enterPassWordTextBox("Phamyn27397");
    this.tikiHomePage.clickDangNhapButton();
    Thread.sleep(20 * 1000);
    this.tikiHomePage.enterTimKiemTextBox("Binh Giu Nhiet");
    this.tikiHomePage.pressEnter();
    this.productInformationPage.chooseProduct();
    this.productInformationPage.chooseColor();
    this.productInformationPage.clickDoiDiaChiButton();
    this.productInformationPage.tickDiaChiRadioButton();
    this.productInformationPage.clickGiaoDenDiaChiNayButton();
    Thread.sleep(3 * 1000);
    this.productInformationPage.clickChonMuaButton();

    String information = this.productInformationPage.showInformationOrderSuccessfully();
    System.out.println("Information show is " + information);
    Assert.assertEquals(information, "Thêm vào giỏ hàng thành công!");

    this.productInformationPage.clickCartImage();
    List<WebElement> item = this.cartPage.getProductFromProductTable();
    System.out.println(item.size());
    Assert.assertEquals(item.size(), 2);

    List<String> Result = new ArrayList<>();
    for (WebElement products : item) {
      String productName = this.cartPage.getProductName(products);
      String price = this.cartPage.getProductPrice(products);
      String quantity = this.cartPage.getQuantityOfProduct(products);
      System.out.println(productName + "-" + price + "-"+ quantity);
      Result.add(productName + "-" + price + "-"+ quantity);
    }
    Assert.assertListContainsObject(Result
        , "Bình Giữ Nhiệt Bằng Thép Không Gỉ Lock&Lock Vacuum Bottle LHC6180SLV (800ML) - Màu Đen-369.000 ₫-1", "");


  }
}
