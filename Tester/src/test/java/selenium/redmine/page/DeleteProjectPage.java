package selenium.redmine.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DeleteProjectPage {
  private WebDriver driver;

  public DeleteProjectPage(WebDriver driver) {
    this.driver = driver;
  }

  public void enterIdentifierTextBox(String name) {
    var enterIdentifier = driver.findElement(By.cssSelector("input#confirm"));
    enterIdentifier.sendKeys(name);
  }

  public void  clickDeleteButton(){
    var clickDelete = driver.findElement(By.cssSelector("input[data-disable-with='Delete']"));
    clickDelete.click();
  }
}
