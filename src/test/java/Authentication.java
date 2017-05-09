import com.thoughtworks.gauge.Step;
import org.openqa.selenium.support.PageFactory;
import pages.HomePage;
import utils.driver.Driver;

public class Authentication {
    private HomePage homePage;

    public Authentication() {
        homePage = PageFactory.initElements(Driver.webDriver, HomePage.class);
    }

    @Step("Log out the customer")
    public void logOutTheCustomer() {
        homePage.LogOut();
    }

    @Step("Clear previous login")
    public void clearPreviousLogin() {
        try {
            homePage.LogOut();
        } catch (Exception ex) {
            System.out.println("no previously logged in Customers");
        }
    }

    @Step("Show You have been logged out message.")
    public void youHaveBeenLoggedOut() {
        homePage.hasYouHaveBeenLoggedOut();
    }
}