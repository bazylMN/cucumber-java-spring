package cucumber.glue.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java8.En;
import cucumber.glue.pageObjects.NavigationPageObjects;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

public class NavigationPageSteps implements En {

    @Autowired
    private NavigationPageObjects navigationPageObjects;

    @Given("I go to {string} page")
    public void iGoToPage(String urlName){
        navigationPageObjects.getPage(urlName);
   }

    @Then("I should be on {string} page")
    public void iShouldBeOnPage(CharSequence name){
        Assert.assertTrue(navigationPageObjects.getCurrentUrl().contains(name));
    }
}
