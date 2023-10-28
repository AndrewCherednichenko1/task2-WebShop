package pages;

import configurations.PropertiesManager;
import org.helpers.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

public class LoginPage {

    @FindBy(id = "Email")
    private WebElement emailField;

    @FindBy(id = "Password")
    private WebElement passwordField;

    @FindBy(className = "login-button")
    private WebElement loginButton;


    public LoginPage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    public LoginPage openWebSite() {
        DriverManager.getDriver().get(PropertiesManager.getBaseUrl() + "login");
        return this;
    }

    public LoginPage enterEmail(String email) {
        emailField.sendKeys(email);
        return this;
    }

    public LoginPage enterPassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    public void clickLoginButton() {
        loginButton.click();
    }
}
