package cucumber.StepDefinitions;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(features="E:/SeleniumGithubProject/Learn/src/test/java/cucumber/feature",
        glue={"StepDefinitions"},
       tags = "@smoke"
)
public class TestRunner {


}
