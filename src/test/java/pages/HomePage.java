package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import utils.driver.Driver;

import java.util.List;

public class HomePage {
    @FindBy(how = How.LINK_TEXT, linkText = "Sign up")
    private WebElement signup;

    @FindBy(how = How.LINK_TEXT, linkText = "Log in")
    private WebElement login;

    @FindBy(how = How.LINK_TEXT, linkText = "Log out")
    private WebElement logout;

    @FindBy(how = How.LINK_TEXT, linkText = "Administration interface")
    private WebElement administratorInterface;

    @FindBy(how = How.XPATH, xpath = "//a[text()='Administration interface']/ancestor::div")
    private WebElement authenticationBanner;

    @FindBy(how = How.CLASS_NAME,className = "product")
    private List<WebElement> products;

    @FindBy(how = How.XPATH,xpath = "//div[@id = 'flash_notice' and text() = 'Thank you for signing up! You are now logged in.']")
    private WebElement thankYouForSigningUp;

    @FindBy(how = How.XPATH,xpath = "//div[@id = 'flash_notice' and text() = 'You have been logged out.']")
    private WebElement youHaveBeenLoggedOut;

    public HomePage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    public void SignUp() {
        signup.click();
    }

    public void LogIn() {
        login.click();
    }

    public void LogOut() {
        logout.click();
    }

    public void AdministratorInterface() {
        administratorInterface.click();
    }

    public String getGreeting() {
        return authenticationBanner.getText();
    }

    public boolean IsLogoutDisplayed() {
        return logout.isDisplayed();
    }

    public boolean IsLoginDisplayed() {
        return login.isDisplayed();
    }

    public int numberOfAvaialableProducts() {
        return products.size();
    }

    public boolean hasThankYouMessageForSigningup() {
        return thankYouForSigningUp.isDisplayed();
    }

    public boolean hasYouHaveBeenLoggedOut() {
        return youHaveBeenLoggedOut.isDisplayed();
    }
}
