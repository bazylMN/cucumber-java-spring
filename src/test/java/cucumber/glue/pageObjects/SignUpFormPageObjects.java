package cucumber.glue.pageObjects;

import cucumber.glue.customAnnotations.PageObject;
import cucumber.glue.hooks.SessionManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.springframework.beans.factory.annotation.Autowired;

@PageObject
public class SignUpFormPageObjects {

    @Autowired
    private SessionManager sessionManager;

    private static final String USER_LOGIN = "user[login]";
    private static final String USER_EMAIL = "user[email]";
    private static final String USER_PASSWORD = "user[password]";

    private static final String USER_INPUT = "[name^='user[']";
    private static final String USER_INPUT_ATTRIBUTE_NAME = "name";



    public void signUp(String login, String email, String password) {
        /**
         * Standard way to send keys:
         *         sessionManager.driver().findElement(By.id(USER_LOGIN)).sendKeys(login);
         *         sessionManager.driver().findElement(By.id(USER_EMAIL)).sendKeys(email);
         *         sessionManager.driver().findElement(By.id(USER_PASSWORD)).sendKeys(password);
         */

        /**
         * lamdbda-way to send keys (imagine there is no id for inputs):
         */
        sendKeysForInputWithAttrubuteName("login", login);
        sendKeysForInputWithAttrubuteName("email", email);
        sendKeysForInputWithAttrubuteName("password", password);
    }

    public String shouldSeeLoginData() {
        String script = "return document.getElementById('"+ USER_LOGIN + "').value";
        JavascriptExecutor js=(JavascriptExecutor)sessionManager.driver();
        return (String)js.executeScript(script);
    }

    public String shouldSeeEmailData() {
        JavascriptExecutor js=(JavascriptExecutor)sessionManager.driver();
        return (String)js.executeScript("return document.getElementById('"+ USER_EMAIL +"').value");
    }

    public String shouldSeePasswordData() {
        JavascriptExecutor js=(JavascriptExecutor)sessionManager.driver();
        return (String)js.executeScript("return document.getElementById('"+ USER_PASSWORD +"').value");
    }

    private void sendKeysForInputWithAttrubuteName(String partValueName, String keyToSend){
        sessionManager.driver().findElements(By.cssSelector(USER_INPUT))
                .stream()
                .filter(elem->elem.getAttribute(USER_INPUT_ATTRIBUTE_NAME).contains(partValueName))
                .findFirst()
                .get()
                .sendKeys(keyToSend);
    }
}
