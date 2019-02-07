package cucumber.glue;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue={"cucumber.glue.hooks", "cucumber.glue.steps", "com.foreach.cuke"},
        features="src/test/resources/features",
        plugin={"pretty", "html:target/html"},
        monochrome=true)
public class CucumberRunner {
}
