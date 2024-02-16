package automation.cucumber.cucumberOption;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
  features = {
/*    "src/test/resources/features/AddCustomerApi.feature",
    "src/test/resources/features/AddCustomerWithdrawApi.feature",*/
    "src/test/java/automation/cucumber/features/login.feature"
  },
  glue = {"automation.cucumber.stepDefinitions"}
)

public class CucumberRunner {
}
