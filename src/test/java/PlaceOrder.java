import com.thoughtworks.gauge.Step;
import pages.CartPage;
import pages.HomePage;
import utils.driver.Driver;

public class PlaceOrder {

    @Step("Add item <item> to the shopping basket.")
    public void addItemToTheBasket(String item) {
        HomePage homePage = new HomePage(Driver.webDriver);
        homePage.selectProduct(item).addToCart();
    }

    @Step("Checkout now")
    public void checkoutNow() {
        CartPage cartPage = new CartPage(Driver.webDriver);
        cartPage.checkoutNow();
    }

    @Step("Show a thank you message for shopping")
    public void showThankYouMessageForShopping() {
        HomePage homePage = new HomePage(Driver.webDriver);
        homePage.hasThankYouForYourPurchase();
    }
}