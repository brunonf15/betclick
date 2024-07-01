package BDD;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    plugin = { 
        "pretty", // Formats the console output in a more readable way
        "html:target/cucumber/report.html", // Generates an HTML report in the specified directory
        "junit:target/reports/cucumber.xml", // Generates a JUnit XML report in the specified directory
        "json:target/reports/cucumber.json" // Generates a JSON report in the specified directory
    },
    monochrome = true, // Makes the log output without colors
    //tags = "@seriea", // Filters the scenarios to be executed based on the specified tags
    features = "src/test/resources", // Specifies the path to the feature files
    glue = "BDD.steps" // Specifies the path to the step definition files
)

public class TestRunner {
    // The class remains empty
    // Used only as a holder for the above annotations
}
