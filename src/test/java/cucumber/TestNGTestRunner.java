package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@SuppressWarnings("removal")
@CucumberOptions(features = "src/test/java/cucumber", glue = "rahulshettyacademy.stepDefinition", tags = "@Regression", monochrome = true, plugin = {
		"html:target/cucumber.html" })
public class TestNGTestRunner extends AbstractTestNGCucumberTests {

}
