package cucumber.glue.hooks;

import cucumber.api.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TakesScreenshots {

    @Autowired
    private SessionManager sessionManager;

    public void takesScreenshot(Scenario scenario) {
            try {
                byte[] screenshot = ((TakesScreenshot) sessionManager.driver()).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");
            } catch (WebDriverException webDriverException) {
                System.err.println(webDriverException.getMessage());
            } catch (ClassCastException classCastException) {
                classCastException.printStackTrace();
            }
    }
}
