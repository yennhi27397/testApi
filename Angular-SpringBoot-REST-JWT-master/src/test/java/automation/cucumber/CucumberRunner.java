package automation.cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "",
  features = {"src/test/resources/features/AddCustomerApi.feature"},
  glue = {"automation.cucumber.definitions"},
  plugin = {})
public class CucumberRunner extends AbstractTestNGCucumberTests {
}
