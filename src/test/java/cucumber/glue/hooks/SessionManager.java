package cucumber.glue.hooks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;

@Component
public class SessionManager {

    private WebDriver webDriver;

    public WebDriver driver() {
        return webDriver;
    }

    @Bean(destroyMethod = "quit")
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
