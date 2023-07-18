package selenium.cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
  features = {
      "src/test/resources/features/Login.feature",

  },
  glue = {"selenium.cucumber.definitions"}
)

public class CucumberRunner extends AbstractTestNGCucumberTests {
}
