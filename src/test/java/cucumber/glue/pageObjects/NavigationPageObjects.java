package cucumber.glue.pageObjects;

import cucumber.glue.hooks.SessionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NavigationPageObjects {

    @Autowired
    private SessionManager sessionManager;

    public void getPage(String url) {
        sessionManager.getDriver().navigate().to(url);
    }

    public String getCurrentUrl() {
        return sessionManager.getDriver().getCurrentUrl();
    }
}
