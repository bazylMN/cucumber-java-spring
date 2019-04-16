package cucumber.glue;

import cucumber.api.java.Before;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("classpath:cucumber.glue")
public class SpringConfiguration {

    @Before
    public void setup_cucumber_spring_context(){
        // Cucumber will recognize this class as glue
        // and use its context configuration.
        // Class SpringConfiguration can be replaced with annotations: @ContextConfiguration and @ComponentScan("classpath:cucumber.glue"),
        // placed in CucumberRunner class
    }
}
