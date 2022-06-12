package assignment.pages;

import org.openqa.selenium.WebDriver;

public class PageFactoryManager {
    private static HomePage homePage;
    private static LoginPage loginPage;
    private static SideBarPage sideBarPage;
    private static InterviewChannelPage interviewChannelPage;

    public static HomePage getHomePage(WebDriver driver) {
        return homePage == null ? new HomePage(driver) : homePage;
    }

    public static LoginPage getLoginPage(WebDriver driver) {
        return loginPage == null ? new LoginPage(driver) : loginPage;
    }

    public static SideBarPage getSideBarPage(WebDriver driver) {
        return sideBarPage == null ? new SideBarPage(driver) : sideBarPage;
    }

    public static InterviewChannelPage getInterviewChannelPage(WebDriver driver) {
        return interviewChannelPage == null ? new InterviewChannelPage(driver) : interviewChannelPage;
    }
}
