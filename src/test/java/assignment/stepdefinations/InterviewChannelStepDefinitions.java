package assignment.stepdefinations;

import assignment.context.TestContext;
import assignment.pages.InterviewChannelPage;
import assignment.pages.PageFactoryManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class InterviewChannelStepDefinitions {

    private final TestContext context;
    private final InterviewChannelPage interviewChannelPage;

    public InterviewChannelStepDefinitions(TestContext context) {
        this.context = context;
        interviewChannelPage = PageFactoryManager.getInterviewChannelPage(context.driver);
    }

    @Then("I am on the interview channel page")
    public void iAmOnTheInterviewChannelPage() throws InterruptedException {
        interviewChannelPage.navigateToInterviewChannel();
    }

    @And("I open a random post")
    public void iOpenARandomPost() throws InterruptedException {
        interviewChannelPage.viewRandomPost();
    }

    @When("I add a random reaction from the default reactions list")
    public void iAddARandomReactionFromTheDefaultReactionsList() throws InterruptedException {
        interviewChannelPage.addComment();
        interviewChannelPage.addRandomReaction();
    }

    @When("I see the random reaction displayed")
    public void iSeeTheRandomReactionDisplayed() throws InterruptedException {
        interviewChannelPage.verifyRandomReaction();
    }

    @When("I edit a new post")
    public void iEditANewPost() throws InterruptedException {
        interviewChannelPage.editNewPost();
    }

    @Then("I should be able to publish it as announcement")
    public void iShouldBeAbleToPublishItAsAnnouncement() throws InterruptedException {
        interviewChannelPage.publishAsAnnouncementExpiringWeekLater();
        Assert.assertTrue(interviewChannelPage.verifyPostCreated());
    }

}
