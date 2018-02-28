package CucumberFramework.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        monochrome = true,
        tags = "@tags",
        features = "src/test/resources/",
        format = {"pretty", "html: cucumber-html-reports",
                "json: cucumber-html-reports/cucumber.json"},
        dryRun = false,
        glue = {"cucumber_steps"}
)

public class MainRunner {
}
