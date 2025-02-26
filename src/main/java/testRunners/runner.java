package testRunners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;



@CucumberOptions(
        features = {"src/test/java/features"},
        glue = {"stepDefinitions","util"},
        tags = "",
        plugin = {"summary","pretty","html:Reports/CucumberReport/Reports.html",
                  "json:Reports/CucumberReport/Report"
                  })
public class runner extends AbstractTestNGCucumberTests {
}
