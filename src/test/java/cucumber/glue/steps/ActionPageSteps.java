package cucumber.glue.steps;

import cucumber.api.java8.En;
import cucumber.glue.pageObjects.ActionPageObjects;
import org.springframework.beans.factory.annotation.Autowired;

public class ActionPageSteps implements En {

    @Autowired
    private ActionPageObjects actionPageObjects;

    public ActionPageSteps(){
        When("I click jam on menu", () -> {
            actionPageObjects.clickJamMenu();
        });
    }
}
