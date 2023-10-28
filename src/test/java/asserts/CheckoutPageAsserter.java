package asserts;

import org.testng.Assert;
import pages.CheckoutPage;

public class CheckoutPageAsserter {

    private final CheckoutPage checkoutPage;

    public CheckoutPageAsserter() {
        checkoutPage = new CheckoutPage();
    }

    public void assertConfirmOrderMessage() {
        Assert.assertTrue(checkoutPage.confirmMessageIsDisplayed());
    }
}
