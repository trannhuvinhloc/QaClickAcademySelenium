package CucumberOptions;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

//@RunWith(Cucumber.class)
@CucumberOptions(plugin = "pretty", features = "src/test/java/Feature", glue = "StepDefinition")
public class RunCucumberTest extends AbstractTestNGCucumberTests {

}
