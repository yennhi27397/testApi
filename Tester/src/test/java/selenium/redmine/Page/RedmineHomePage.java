package selenium.redmine.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RedmineHomePage {

  private WebDriver driver = null;
  private String URL = "http://localhost:3000/";

  public RedmineHomePage(WebDriver driver) {
    this.driver = driver;
  }

  public void navigate() {
    driver.navigate().to(URL);
  }

  public void clickSignInButton() {
    var signIn = driver.findElement(By.cssSelector("a.login"));
    signIn.click();
  }

  public String showLoggedInAsAccount() {
    var showLoggedIn = driver.findElement(By.cssSelector("div#loggedas"));
    return showLoggedIn.getText();
  }

  public void clickAdministrationTab() {
    var administration = driver.findElement(By.cssSelector("a.administration"));
    administration.click();
  }

}
