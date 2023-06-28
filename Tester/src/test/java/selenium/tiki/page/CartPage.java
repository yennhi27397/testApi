package selenium.tiki.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import selenium.redmine.Common;

import java.util.List;

public class CartPage {
  private WebDriver driver = null;

  public CartPage(WebDriver driver) {
    this.driver = driver;
  }
  public List<WebElement> getProductFromProductTable(){
    List<WebElement> items = driver.findElements(By.cssSelector("div.eZNlgw.styles__StyledNormalProduct-sc-1ulujnv-0"));
    return items;
  }
  public String getProductName(WebElement element){
    var productName = element.findElement(By.cssSelector("a.product__name[data-view-id='cart_main_product'][data-view-index='9ab26dc2-0bf2-11ee-83e8-82b3c16e0565'][href='/product-p73124602.html?spid=73124606'][target='_blank']"));
    return productName.getText();
  }
  public String getProductPrice (WebElement element){
    var productPrice = Common.getWebElement(driver,"span","331.000 ₫");
    return productPrice.getText();
  }
  public String getQuantityOfProduct(WebElement element){
    var quantityOfProduct = element.findElement(By.cssSelector("input.qty-input[type='tel'][value='1']"));
    String result = quantityOfProduct.getAttribute("value");
    return result;
  }

}
