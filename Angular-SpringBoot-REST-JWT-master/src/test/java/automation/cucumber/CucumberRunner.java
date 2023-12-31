package automation.cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
  features = {
    "src/test/resources/features/AddCustomerApi.feature",
    "src/test/resources/features/AddCustomerWithdrawApi.feature"
  },
  glue = {"automation.cucumber.definitions"}
)

public class CucumberRunner extends AbstractTestNGCucumberTests {
}
