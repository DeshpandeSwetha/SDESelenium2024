package BDDtestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/resources/BDDFeatures",
		glue="com.BDD",
		plugin={"pretty","html:target/cucumber-travel-reports.html"},
		//dryRun=true, 
		monochrome=true 
		)

public class AgileTravelRunner 
{

}
