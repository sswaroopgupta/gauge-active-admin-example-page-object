import com.thoughtworks.gauge.Step;
import pages.HomePage;
import pages.SignUpPage;
import utils.driver.Driver;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class CustomerSignUp {

    @Step("Sign up as <customer> with email <customer@example.com> and <password>")
    public void registerCustomerWith(String customer, String email, String password) {
        SignUpPage signUpPage = new HomePage(Driver.webDriver).signUp();
        signUpPage.registerCustomerWith(customer, email, password);
    }

    @Step("Show the log in status for user <customer>")
    public void showTheLogInStatusForUser(String customer) {
        HomePage homePage = new HomePage(Driver.webDriver);
        assertTrue(homePage.getGreeting().contains("Welcome " + customer + "! Not you?"));
    }

    @Step("Give an option to Log out")
    public void giveAnOptionToLogOut() {
        HomePage homePage = new HomePage(Driver.webDriver);
        assertTrue(homePage.IsLogoutDisplayed());
    }

    @Step("Give an option to Log in")
    public void giveAnOptionToLogIn() {
        HomePage homePage = new HomePage(Driver.webDriver);
        assertTrue(homePage.IsLoginDisplayed());
    }

    @Step("See items available for purchase.")
    public void seeItemsAvaiableForPurchase() {
        HomePage homePage = new HomePage(Driver.webDriver);
        assertThat(homePage.numberOfAvailableProducts(), is(not(0)));
    }

    @Step("Show a thank you message for signing up")
    public void showAMessage() {
        HomePage homePage = new HomePage(Driver.webDriver);
        assertTrue(homePage.hasThankYouMessageForSigningup());
    }
}