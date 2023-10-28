package pages;

import configurations.PropertiesManager;
import constants.Constants;
import org.helpers.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

import java.util.Random;

public class RegisterPage {

    @FindBy(id = "FirstName")
    private WebElement firstNameField;

    @FindBy(id = "LastName")
    private WebElement lastNameField;

    @FindBy(id = "Email")
    private WebElement emailField;

    @FindBy(id = "Password")
    private WebElement passwordField;

    @FindBy(id = "ConfirmPassword")
    private WebElement confirmPasswordField;

    @FindBy(id = "register-button")
    private WebElement registerButton;

    @FindBy(className = "result")
    private WebElement resultText;


    public RegisterPage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    public RegisterPage openWebSite() {
        DriverManager.getDriver().get(PropertiesManager.getBaseUrl() + "register");
        return this;
    }

    public String getRandomString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 10) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        return salt.toString();

    }

    public RegisterPage enterFirstName() {
        firstNameField.sendKeys(getRandomString());
        return this;
    }

    public RegisterPage enterLastName() {
        lastNameField.sendKeys(getRandomString());
        return this;
    }

    public RegisterPage enterEmail() {
        emailField.sendKeys(getRandomString() + Constants.EMAIL_DOMAIN);
        return this;
    }

    public RegisterPage enterPasswords() {
        var pass = getRandomString();
        passwordField.sendKeys(pass);
        confirmPasswordField.sendKeys(pass);
        return this;
    }

    public void clickRegisterButton() {
        registerButton.click();
    }

    public boolean isRegisteredTextDisplayed() {
        return resultText.getText().equals(Constants.REGISTRATION_SUCCESS_MESSAGE);
    }
}
