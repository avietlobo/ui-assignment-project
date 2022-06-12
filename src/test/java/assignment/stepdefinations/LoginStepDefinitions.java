package assignment.stepdefinations;

import assignment.context.TestContext;
import assignment.pages.LoginPage;
import assignment.pages.PageFactoryManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class LoginStepDefinitions {

    private final TestContext context;
    private final LoginPage loginPage;

    public LoginStepDefinitions(TestContext context) {
        this.context = context;
        loginPage = PageFactoryManager.getLoginPage(context.driver);
    }

    @Given("I navigate to the login page")
    public void iNavigateToTheLoginPage() {
        loginPage.load();
    }

    @When("I submit username and password")
    public void iSubmitUsernameAndPassword() throws InterruptedException {
        loginPage.login();
    }


}
