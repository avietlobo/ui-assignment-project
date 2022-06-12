package assignment.stepdefinations;

import assignment.context.TestContext;
import assignment.pages.HomePage;
import assignment.pages.PageFactoryManager;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class HomeStepDefinitions {

    private final TestContext context;
    private final HomePage homePage;

    public HomeStepDefinitions(TestContext context) {
        this.context = context;
        homePage = PageFactoryManager.getHomePage(context.driver);
    }

    @Then("I should be logged in")
    public void iShouldBeLoggedIn() throws InterruptedException {
        Assert.assertTrue(homePage.getPageUrl().contains("home"));
    }

}
