package stepdef;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
	    features = {"Feature Files"},
		glue={"stepdef"},
		//plugin = {"html:target/Report.html" }
		//dryRun = true,
		//plugin = { "de.monochromata.cucumber.report.PrettyReports:target/cucumber" }
		plugin = { "de.monochromata.cucumber.report.PrettyReports:target/cucumber", "json:target/cucumber.json" }
		
	    //tags= "@Theme"

		)
 
public class TestRunner extends AbstractTestNGCucumberTests
{
	
 
}

