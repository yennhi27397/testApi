package selenium.redmine.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class UserPage {
  private WebDriver driver = null;

  public UserPage(WebDriver driver) {
    this.driver = driver;
  }

  public void clickNewUser() {
    var clickNewUser = driver.findElement(By.cssSelector("a.icon.icon-add"));
    clickNewUser.click();
  }

  public List<WebElement> getUserAccountFromUsersTable() {
    List<WebElement> userAccount = driver.findElements(By.cssSelector("tr.active.user"));
    return userAccount;
  }

  public String getUserNameFromUserTable(WebElement element) {
    var userName = element.findElement(By.cssSelector("td.username a"));
    return userName.getText();
  }


}
