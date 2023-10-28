package pages;

import configurations.PropertiesManager;
import constants.Constants;
import org.helpers.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class CheckoutPage {

    @FindBy(id = "BillingNewAddress_CountryId")
    private WebElement countryDropDown;

    @FindBy(xpath = "//select[@id='BillingNewAddress_CountryId']/option[text()='Ukraine']")
    private WebElement countryToSelectUkraine;

    @FindBy(id = "BillingNewAddress_City")
    private WebElement cityField;

    @FindBy(id = "BillingNewAddress_Address1")
    private WebElement address1Field;

    @FindBy(id = "BillingNewAddress_ZipPostalCode")
    private WebElement zipField;

    @FindBy(id = "BillingNewAddress_PhoneNumber")
    private WebElement phoneNumberField;

    @FindBy(id = "billing-address-select")
    private WebElement billingAuto;

    @FindBy(xpath = "//div[@id='billing-buttons-container']/input[contains(@class,'new-address-next-step-button')]")
    private WebElement continueButtonSection1;

    @FindBy(xpath = "//div[@id='shipping-buttons-container']/input[contains(@class,'new-address-next-step-button')]")
    private WebElement continueButtonSection2;

    @FindBy(xpath = "//div[@id='shipping-method-buttons-container']/input[contains(@class,'shipping-method-next-step-button')]")
    private WebElement continueButtonSection3;

    @FindBy(xpath = "//div[@id='payment-method-buttons-container']/input[contains(@class,'payment-method-next-step-button')]")
    private WebElement continueButtonSection4;

    @FindBy(xpath = "//div[@id='payment-info-buttons-container']/input[contains(@class,'payment-info-next-step-button')]")
    private WebElement continueButtonSection5;

    @FindBy(className = "confirm-order-next-step-button")
    private WebElement confirmButton;

    @FindBy(xpath = "//strong[text()='Your order has been successfully processed!']")
    private WebElement confirmMessage;


    public CheckoutPage() {
        PageFactory.initElements(new AjaxElementLocatorFactory(DriverManager.getDriver(), PropertiesManager.getWaitTime()), this);
    }

    public CheckoutPage fillInBillingAddressSection() {
        if (billingAuto.isDisplayed()) {
            continueButtonSection1.click();
        } else {
            countryDropDown.click();
            countryToSelectUkraine.click();
            cityField.sendKeys(Constants.BILLING_ADDRESS_CITY);
            address1Field.sendKeys(Constants.BILLING_ADDRESS1);
            zipField.sendKeys(Constants.BILLING_ADDRESS_ZIP);
            phoneNumberField.sendKeys(Constants.PHONE_NUMBER);
            continueButtonSection1.click();
        }
        return this;
    }

    public void waitAndClick(WebElement element) {
        DriverManager.getWait().until(elementToBeClickable(element)).click();
    }

    public void fillInSections23456() {
        waitAndClick(continueButtonSection2);
        waitAndClick(continueButtonSection3);
        waitAndClick(continueButtonSection4);
        waitAndClick(continueButtonSection5);
        waitAndClick(confirmButton);
    }

    public boolean confirmMessageIsDisplayed() {
        DriverManager.getWait().until(visibilityOf(confirmMessage));
        return confirmMessage.isDisplayed();
    }
}
