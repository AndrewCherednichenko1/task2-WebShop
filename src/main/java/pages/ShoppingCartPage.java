package pages;

import configurations.PropertiesManager;
import org.helpers.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class ShoppingCartPage {

    @FindBy(name = "removefromcart")
    private WebElement removeCheckbox;

    @FindBy(name = "updatecart")
    private WebElement updateCartButton;

    @FindBy(className = "order-summary-content")
    private WebElement orderSummary;

    @FindBy(id = "checkout")
    private WebElement checkoutButton;

    @FindBy(id = "termsofservice")
    private WebElement termsOfServiceCheckbox;


    public ShoppingCartPage() {
        PageFactory.initElements(new AjaxElementLocatorFactory(DriverManager.getDriver(), PropertiesManager.getWaitTime()), this);
    }

    public ShoppingCartPage openWebSite() {
        DriverManager.getDriver().get(PropertiesManager.getBaseUrl() + "cart");
        return this;
    }

    public void removeFromCart() {
        removeCheckbox.click();
        updateCartButton.click();
    }

    public boolean containsMessage(String message) {
        return orderSummary.getText().equals(message);
    }

    public CheckoutPage clickCheckoutButton() {
        termsOfServiceCheckbox.click();
        checkoutButton.click();
        return new CheckoutPage();
    }
}
