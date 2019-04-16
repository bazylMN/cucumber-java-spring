package cucumber.glue.hooks;

import cucumber.api.Scenario;
import cucumber.api.java.AfterStep;
import org.junit.After;
import org.springframework.beans.factory.annotation.Autowired;

public class Hooks {

    @Autowired
    private SessionManager sessionManager;
    @Autowired
    private TakesScreenshots takesScreenshots;

    @After
    public void afterScenario() {
        sessionManager.closeSession();
    }

    @AfterStep()
    public void takeScreenshot(Scenario scenario) {
        if (scenario.isFailed()) {
            takesScreenshots.takesScreenshot(scenario);
        }
    }
}
