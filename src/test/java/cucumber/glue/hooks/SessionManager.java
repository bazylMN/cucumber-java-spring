package cucumber.glue.hooks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class SessionManager {

    private WebDriver webDriver;

    public WebDriver getDriver() {
        return webDriver;
    }

    @PostConstruct
    public WebDriver getWebDriver(){
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        webDriver = new ChromeDriver();
        return webDriver;
    }

    @PreDestroy
    public void closeSession(){
        webDriver.manage().deleteAllCookies();
        webDriver.close();
        webDriver.quit();
    }
}
