package selenium.redmine.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import selenium.redmine.Common;

public class RedmineHomePage {
  // call attribute WebDriver
  private WebDriver driver = null;
  // call attribute URL to navigate to web
  private String URL = "http://localhost:3000/";
  public RedmineHomePage(WebDriver driver) {
    this.driver = driver;
  }

  // call attribute Navigate
  public void navigate() {
    // pass to file 'URL' to navigate to web
    driver.navigate().to(URL);
  }

  // call attribute click Sign in button
  public void clickSignInButton() {
    // get tag ='a', class='login'
    var signIn = Common.getWebElement(driver,"a","Sign in");
    // click Sign in button
    signIn.click();
  }

  // call attribute get Logged in account Info
  public String getLoggedInAsAccount() {
    // get tag='div' , id='loggedas'
    var showLoggedIn = driver.findElement(By.cssSelector("div#loggedas"));
    // get 'Logged in as Admin' Information
    return showLoggedIn.getText();
  }

  // call attribute click Administration tab
  public void clickAdministrationTab() {
    // get tag ='a', class ='administration'
    var administration = driver.findElement(By.cssSelector("a.administration"));
    // click Administration tab
    administration.click();
  }

}
