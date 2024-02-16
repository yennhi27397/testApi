package automation.cucumber.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepDefination {

  @Given("User is existed on Net banking landing page")
  public void userIsExistedOnNetBankingLandingPage() {
    System.out.println("Navigate the application");

  }

  @When("User login into application with valid username and password")
  public void UserLoginIntoApplicationWithValidUsernameAndPassword() {
    System.out.println("Login successful");

  }

  @Then("Home page is populated")
  public void homePageIsPopulated()  {
    System.out.println("Homepage display");

  }
  @And("cards are displayed")
  public void cardsAreDisplayed(){
    System.out.println("cards are displayed");
  }

}

