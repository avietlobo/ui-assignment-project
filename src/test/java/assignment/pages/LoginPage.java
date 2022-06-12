package assignment.pages;

import assignment.utils.EncryptionAndDecryption;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    @FindBy(css = "#signin-btn")
    private WebElement signInBtn;
    @FindBy(css = "input[id='identifierId']")
    private WebElement emailTxt;
    @FindBy(css = "div[id='identifierNext'] div button")
    private WebElement nextBtn;
    @FindBy(css = "input[type='password']")
    private WebElement passwordTxt;
    @FindBy(css = "div[id='passwordNext'] div button")
    private WebElement next;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(signInBtn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(emailTxt)).sendKeys("interview-qa-3@apps.fi");
        wait.until(ExpectedConditions.elementToBeClickable(nextBtn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(passwordTxt)).sendKeys(EncryptionAndDecryption.decrypt("PTh1U3kmVm0wMQ=="));
        wait.until(ExpectedConditions.elementToBeClickable(next)).click();
    }


}
