package selenium.tiki.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import selenium.redmine.Common;

public class ProductInformationPage {
  private WebDriver driver = null;

  public ProductInformationPage(WebDriver driver) {
    this.driver = driver;
  }

  public void chooseColor() {
    var color = Common.getWebElement(driver, "span", "Đen");
    color.click();
  }
  public void chooseProduct() {
    var color = Common.getWebElement(driver,"div","331.000");
    color.click();
  }
  public void clickDoiDiaChiButton() {
    var doiDiaChi = driver.findElement(By.cssSelector("#__next > div:nth-child(1) > main > div.Container-sc-itwfbd-0.hfMLFx > div.styles__Wrapper-sc-8ftkqd-0.eypWKn > div.styles__StyledProductContent-sc-1f8f774-0.ewqXRk > div.body > div.left > div.style__StyledDeliveryZone-sc-jqxr7o-0.iYPujD.delivery-zone > div.delivery-zone__heading > div > span.address-change"));
    doiDiaChi.click();
  }

  public void tickDiaChiRadioButton() {
    var diaChi = Common.getWebElement(driver, "span", "Xã Xuân Thới Đông, Huyện Hóc Môn, Hồ Chí Minh");
    diaChi.click();
  }

  public void clickGiaoDenDiaChiNayButton() {
    var giaoDenDiaChiNayButton = driver.findElement(By.cssSelector("button.gzCknT"));
    giaoDenDiaChiNayButton.click();
  }

  public void clickChonMuaButton() {
    var chonMuaButton = Common.getWebElement(driver,"button","Chọn mua");
    chonMuaButton.click();
  }
  public String showInformationOrderSuccessfully(){
    var information = driver.findElement(By.cssSelector("#main-header > div > div.Middle__Wrap-sc-vop1h1-0.edlkEo.revamp > div.Userstyle__RootRevamp-sc-6e6am-15.hkQlMw > div.Userstyle__CartItem-sc-6e6am-14.hfiWvr > div > p"));
    return information.getText();
  }
  public void clickCartImage(){
    var cart = driver.findElement(By.cssSelector("img.cart-icon[alt='header_header_img_Cart'][src='https://salt.tikicdn.com/ts/upload/51/e2/92/8ca7e2cc5ede8c09e34d1beb50267f4f.png']"));
    cart.click();
  }
  public void clickDichVuMuaKemCheckBox(){
    var dichVuMuaKem = driver.findElement(By.cssSelector("img[src='https://frontend.tikicdn.com/_desktop-next/static/img/icons/enabled_on.svg']"));
    dichVuMuaKem.click();
  }

}
