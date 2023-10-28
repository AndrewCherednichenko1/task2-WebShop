package pages;

import configurations.PropertiesManager;
import org.helpers.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class ProductPage {

    @FindBy(id = "add-to-wishlist-button-3")
    private WebElement addToWishListButton;

    @FindBy(id = "giftcard_3_RecipientName")
    private WebElement recipientName;

    @FindBy(xpath = "//p[@class='content']")
    private WebElement successMessage;

    @FindBy(className = "wishlist-qty")
    private WebElement wishListQty;

    @FindBy(className = "cart-qty")
    private WebElement cartQty;

    @FindBy(id = "add-to-cart-button-72")
    private WebElement addToCartButton;


    public ProductPage() {
        PageFactory.initElements(new AjaxElementLocatorFactory(DriverManager.getDriver(), PropertiesManager.getWaitTime()), this);
    }

    public ProductPage openProductByName(String name) {
        DriverManager.getDriver().get(PropertiesManager.getBaseUrl() + name);
        return this;
    }

    public void enterRecipientName(String name) {
        recipientName.sendKeys(name);
    }

    public Integer wishListQty() {
        return Integer.parseInt(wishListQty.getText().replaceAll("[()]", ""));
    }

    public Integer cartQty() {
        return Integer.parseInt(cartQty.getText().replaceAll("[()]", ""));
    }

    public boolean containsMessage(String message) {
        return successMessage.getText().contains(message);
    }

    public void clickAddToWishListButton() {
        addToWishListButton.click();
    }

    public void clickAddToCartButton() {
        addToCartButton.click();
    }
}
