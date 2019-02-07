package cucumber.glue.hooks;

import cucumber.api.java.Before;
import org.junit.After;
import org.springframework.beans.factory.annotation.Autowired;

public class Hooks {

    @Autowired
    private SessionManager sessionManager;

    @Before
    public void BeforeScenario() {
        sessionManager.getDriver();
    }

    @After
    public void AfterScenario() {
        sessionManager.closeSession();
    }
}
