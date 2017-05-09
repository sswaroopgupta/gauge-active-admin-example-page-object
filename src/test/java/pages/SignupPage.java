package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SignupPage {

    public SignupPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    @FindBy(how = How.NAME, name = "user[username]")
    private WebElement userName;

    @FindBy(how = How.NAME, name = "user[email]")
    private WebElement userEmail;

    @FindBy(how = How.NAME, name = "user[password]")
    private WebElement userPassword;

    @FindBy(how = How.NAME, name = "user[password_confirmation]")
    private WebElement confirm_password;

    @FindBy(how = How.NAME, name = "commit")
    private WebElement commit;

    public void enterCustomer(String customer) {
        userName.sendKeys(customer);
    }

    public void enterEmail(String email) {
        userEmail.sendKeys(email);
    }

    public void enterPassword(String password) {
        userPassword.sendKeys(password);
    }

    public void enterConfirmPassword(String confirmPassword) {
        confirm_password.sendKeys(confirmPassword);
    }

    public void clickCommit() {
        commit.click();
    }

}
