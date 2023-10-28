package asserts;

import constants.Constants;
import org.testng.Assert;
import pages.ShoppingCartPage;

public class ShoppingCartPageAsserter {

    private final ShoppingCartPage shoppingCartPage;

    public ShoppingCartPageAsserter() {
        shoppingCartPage = new ShoppingCartPage();
    }

    public void assertRemoveFromCartSuccessMessage() {
        Assert.assertTrue(shoppingCartPage.containsMessage(Constants.REMOVE_FROM_CART_SUCCESS_MESSAGE));
    }
}
