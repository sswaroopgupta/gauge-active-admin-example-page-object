import com.thoughtworks.gauge.Step;
import pages.HomePage;
import pages.SignupPage;
import utils.driver.Driver;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class CustomerSignup {
    private HomePage homePage;

    public CustomerSignup() {
        homePage = new HomePage(Driver.webDriver);
    }

    @Step("Sign up as <customer> with email <customer@example.com> and <password>")
    public void registerCustomerWith(String customer, String email, String password) {
        homePage.SignUp();

        SignupPage signupPage = new SignupPage(Driver.webDriver);
        signupPage.enterCustomer(customer);
        signupPage.enterEmail(email);
        signupPage.enterPassword(password);
        signupPage.enterConfirmPassword(password);
        signupPage.clickCommit();
    }

    @Step("Show the log in status for user <customer>")
    public void showTheLogInStatusForUser(String customer) {
        assertTrue(homePage.getGreeting().contains("Welcome " + customer + "! Not you?"));
    }

    @Step("Give an option to Log out")
    public void giveAnOptionToLogOut() {
        assertTrue(homePage.IsLogoutDisplayed());
    }

    @Step("Give an option to Log in")
    public void giveAnOptionToLogIn() {
        assertTrue(homePage.IsLoginDisplayed());
    }

    @Step("See items available for purchase.")
    public void seeItemsAvaiableForPurchase() {
        assertThat(homePage.numberOfAvaialableProducts(), is(not(0)));
    }

    @Step("Show a thank you message for signing up")
    public void showAMessage() {
        assertTrue(homePage.hasThankYouMessageForSigningup());
    }
}