package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


	
	@CucumberOptions(
			features="src/test/resources/Features/MenuItemMen.feature",
			glue="stepDefinition",tags = "@smoke",
			//dryRun = false,
			//monochrome = true,
			plugin = {"pretty","html:test-output.html"}
			)
	public class Run extends AbstractTestNGCucumberTests
	{
	
}
