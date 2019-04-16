package cucumber.glue.pageObjects;

import com.codeborne.selenide.WebDriverRunner;
import cucumber.glue.customAnnotations.PageObject;
import cucumber.glue.hooks.SessionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;

import static com.codeborne.selenide.Selenide.$;

@PageObject
public class ActionPageObjects {

    @Autowired
    private SessionManager sessionManager;

    private static final String JAM_MENU = ".Header-nav-item[href*=jam]";

    public void clickJamMenu() {
        WebDriverRunner.setWebDriver(sessionManager.driver());
        $(JAM_MENU).click();
    }
}
