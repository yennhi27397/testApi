package selenium.redmine.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DeleteUserPage {
  private WebDriver driver;

  public DeleteUserPage(WebDriver driver) {
    this.driver = driver;
  }

  public void enterConfirmLoginTextBox(String name){
    var enterConfirm = driver.findElement(By.cssSelector("input#confirm"));
    enterConfirm.sendKeys(name);
  }

  public void clickDeleteButton(){
    var deleteButton = driver.findElement(By.cssSelector("input[type='submit'][value='Delete']"));
    deleteButton.click();
  }
}
