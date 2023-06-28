package selenium.tiki.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductPage {
  private WebDriver driver = null;

  public ProductPage(WebDriver driver) {
    this.driver = driver;
  }

  public List<WebElement> getProductList() {
    List<WebElement> binhGiuNhietProducts = driver.findElements(By.cssSelector(
        ".style__StyledNameProduction-sc-qg694h-8"
    ));
    return binhGiuNhietProducts;
  }

  public String getNameProduct(WebElement product) {
    var name = product.findElement(By.cssSelector("div.name > h3"));
    return name.getText();
  }
}
