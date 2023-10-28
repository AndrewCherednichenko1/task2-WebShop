package asserts;

import constants.Constants;
import org.testng.Assert;
import pages.ProductPage;

public class ProductPageAsserter {

    private final ProductPage productPage;

    public ProductPageAsserter() {
        productPage = new ProductPage();
    }

    public void assertAddToWishlistSuccessMessage() {
        Assert.assertTrue(productPage.containsMessage(Constants.ADD_TO_WISHLIST_SUCCESS_MESSAGE));
    }

    public void assertAddToCartSuccessMessage() {
        Assert.assertTrue(productPage.containsMessage(Constants.ADD_TO_CART_SUCCESS_MESSAGE));
    }

    public void assertQtyUpdatedByOne(Integer qtyBefore, Integer qtyAfter) {
        int finalQty = qtyAfter - qtyBefore;
        Assert.assertEquals(finalQty, 1);
    }
}
