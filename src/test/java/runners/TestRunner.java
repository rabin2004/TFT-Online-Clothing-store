package runners;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
		
		features = "C:\\Users\\User\\Desktop\\eclipse\\TFTonlineStore\\src\\main\\java\\Features",
		plugin = {"pretty", "html:target/cucumber-html-report", "json:json_output/cucumber.json", 
				"junit:junit_output/cucumber.junit"},
		monochrome = true,
		glue="com.qa.test",
		tags = {},
		strict= true, 
		dryRun= false
		)
public class TestRunner{
	
}
