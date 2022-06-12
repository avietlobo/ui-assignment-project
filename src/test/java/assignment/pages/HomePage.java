package assignment.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#nav-channels-button")
    private WebElement channelsBtn;

    public String getPageUrl() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(channelsBtn));
        return driver.getCurrentUrl();
    }

}
