package assignment.pages;

import assignment.constants.Constants;
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

    public void login()  {
        wait.until(ExpectedConditions.elementToBeClickable(signInBtn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(emailTxt)).sendKeys(Constants.USER_ID);
        wait.until(ExpectedConditions.elementToBeClickable(nextBtn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(passwordTxt)).sendKeys(EncryptionAndDecryption.decrypt(Constants.ENCRYPTED_PASSWORD));
        wait.until(ExpectedConditions.elementToBeClickable(next)).click();
    }


}
