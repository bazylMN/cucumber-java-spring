package cucumber.glue.pageObjects;

import cucumber.glue.customAnnotations.PageObject;
import cucumber.glue.hooks.SessionManager;
import org.springframework.beans.factory.annotation.Autowired;

@PageObject
public class NavigationPageObjects {

    @Autowired
    private SessionManager sessionManager;

    public void getPage(String url) {
        sessionManager.driver().navigate().to(url);
    }

    public String getCurrentUrl() {
        return sessionManager.driver().getCurrentUrl();
    }
}
