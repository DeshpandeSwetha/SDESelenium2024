package BDDtestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/resources/BDDFeatures",//path to the feature file
		glue="com.BDD", //path to the step definition file
		tags="@FlipkartRegression",
		plugin={"pretty","html:target/cucumber-reports.html"},//to create the reports under particular folder
		//dryRun=true,//makes sure the testcases in the feature file has step definitions
		monochrome=true) //to get the output in the readable format in the console

public class BDDTestRunner 
{
    
}