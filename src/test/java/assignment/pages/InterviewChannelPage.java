package assignment.pages;

import assignment.constants.Constants;
import assignment.utils.NumberUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class InterviewChannelPage extends BasePage {
    public InterviewChannelPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#nav-channels-button")
    private WebElement channelsBtn;
    @FindBy(css = "#nav-channels-search")
    private WebElement search;
    @FindBy(css = "div[data-testid='channel-list-drag-drop-item']")
    private WebElement channelItem;

    @FindBy(css = "input[type='password']")
    private WebElement passwordTxt;

    @FindBy(css = "div[id='passwordNext'] div button")
    private WebElement next;
    @FindAll({
            @FindBy(css = "div[data-tracker='Post actions menu']")
    })
    public List<WebElement> postActionsMenu;

    @FindBy(css = "[data-tracker='View post']")
    private WebElement viewPostBtn;

    @FindBy(css = "div[data-testid='comment-input-focus-container']")
    private WebElement commentTxa;
    @FindBy(css = "div[class='fr-element fr-view']")
    private WebElement commentsTxt;
    @FindBy(xpath = "//div[@data-tracker='attach-file-menu']/following-sibling::button")
    private WebElement sendCommentBtn;

    @FindBy(css = "div[data-tracker='reactions']")
    private WebElement likeBtn;
    @FindAll({
            @FindBy(xpath = "//div[@data-tracker='reactions-tooltip']/a")
    })
    public List<WebElement> reactions;

    @FindAll({
            @FindBy(css = "[data-tracker='reactions-summary'] span")
    })
    public List<WebElement> reactionsAdded;

    @FindBy(xpath = "//div[@class='fr-element fr-view']")
    private WebElement editPostTxa;


    @FindBy(xpath = "//div[@data-tracker='Share options']/button")
    private WebElement shareOptionsBtn;
    @FindBy(xpath = "//*[@data-tracker='Publish']")
    private WebElement shareAsAnnouncementBtn;
    @FindBy(xpath = "//*[@class='dropdown__indicator dropdown__dropdown-indicator css-tlfecz-indicatorContainer']")
    private WebElement shareAnnouncementList;
    @FindBy(xpath = "//*[text()='Choose custom date']")
    private WebElement item;

    @FindBy(css = "input[data-testid='datepicker-input']")
    private WebElement datePicker;
    @FindBy(xpath = "//button[@data-tracker='modal-ok']")
    private WebElement shareBtn;
    @FindBy(xpath = "//button[@data-tracker='modal-ok']")
    private WebElement confirmBtn;

    public double postId;
    public String commentText;
    public String reactionEmoji;

    public void navigateToInterviewChannel() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(channelsBtn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(search)).click();
        wait.until(ExpectedConditions.elementToBeClickable(search)).sendKeys(Constants.INTERVIEW_CHANNEL);
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(channelItem)).click();
        Thread.sleep(5000);
    }

    public void viewRandomPost()  {
        wait.until(ExpectedConditions.visibilityOf(postActionsMenu.get(0)));
        int index = NumberUtils.getRandomNumber();
        wait.until(ExpectedConditions.elementToBeClickable(postActionsMenu.get(index))).click();
        wait.until(ExpectedConditions.elementToBeClickable(viewPostBtn)).click();
    }

    public void addComment() {
        commentText = "comments id " + Math.random();
        wait.until(ExpectedConditions.elementToBeClickable(commentsTxt)).sendKeys(commentText);
        wait.until(ExpectedConditions.elementToBeClickable(sendCommentBtn)).click();
    }

    public void addRandomReaction() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[contains(text(),'" + commentText + "')]"))));
        wait.until(ExpectedConditions.visibilityOf(likeBtn)).click();
        Thread.sleep(1000);
        int index = NumberUtils.getRandomNumber(Constants.EMOJI_LIST_COUNT);
        Actions builder = new Actions(driver);
        builder.moveToElement(likeBtn).perform();
        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOfAllElements(reactions));
        reactionEmoji = wait.until(ExpectedConditions.visibilityOf(reactions.get(index))).getText();
        reactions.get(index).click();
        Thread.sleep(3000);

    }

    public void editNewPost() {
        postId = Math.random();
        String postName = "New Post  " + postId;
        wait.until(ExpectedConditions.elementToBeClickable(editPostTxa)).click();
        wait.until(ExpectedConditions.elementToBeClickable(editPostTxa)).sendKeys(postName);
        wait.until(ExpectedConditions.elementToBeClickable(shareOptionsBtn)).click();
    }

    public void publishAsAnnouncementExpiringWeekLater()  {
        wait.until(ExpectedConditions.elementToBeClickable(shareAsAnnouncementBtn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(shareAnnouncementList)).click();
        wait.until(ExpectedConditions.elementToBeClickable(item)).click();
        wait.until(ExpectedConditions.elementToBeClickable(datePicker)).sendKeys(Constants.ANNOUNCEMENT_EXPIRY_DATE);
        wait.until(ExpectedConditions.elementToBeClickable(shareBtn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(confirmBtn)).click();
    }

    public boolean verifyPostCreated() {
        List<WebElement> list = driver.findElements(By.xpath("//*[contains(text(),'" + postId + "')]"));
        return list.size() > 0;
    }

    public void verifyRandomReaction() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[contains(text(),'" + commentText + "')]"))));
        List<WebElement> list = driver.findElements(By.xpath("//*[contains(text(),'" + commentText + "')]"));
        wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath("//*[contains(text(),'" + commentText + "')]/preceding::button[@data-tracker='reactions-summary'][1]/span"))));
        List<WebElement> reactions = driver.findElements(By.xpath("//*[contains(text(),'" + commentText + "')]/preceding::button[@data-tracker='reactions-summary'][1]/span"));
        List<String> reactionsText = new ArrayList<>();
         for(int i =0;i<reactions.size();i++){
            reactionsText.add(reactions.get(i).getText());
        }
        Assert.assertTrue(list.size()>0);
        Assert.assertTrue(reactionsText.contains(reactionEmoji));
    }




}
