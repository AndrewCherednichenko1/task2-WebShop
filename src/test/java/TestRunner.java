import constants.Constants;
import org.testng.annotations.*;

public class TestRunner extends BaseTest {

    @Test(priority = 1, description = "Verify that allows register User")
    public void verifyRegisterAcc() {
        registerPage.openWebSite()
                .enterFirstName()
                .enterLastName()
                .enterEmail()
                .enterPasswords()
                .clickRegisterButton();
        registerPageAsserter.assertRegisteredTextDisplayed();
    }

    @Test(priority = 2, description = "Verify that allows register User")
    public void verifyLogin() {
        loginPage.openWebSite()
                .enterEmail(Constants.LOGIN_EMAIL)
                .enterPassword(Constants.LOGIN_PASSWORD)
                .clickLoginButton();
        homePageAsserter.assertLogoutButtonDisplayed();
    }

    @Test(priority = 3, description = "Verify that ‘Computers’ group has 3 sub-groups with correct names")
    public void verifyComputersGroup() {
        homePage.openWebSite().
                hoverOverComputersGroupButton();
        homePageAsserter.assertNumberOfSubgroups(3);
        String[] expectedSubgroupsList = {"Desktops", "Notebooks", "Accessories"};
        homePageAsserter.asserEachSubgroupNameCorrect(expectedSubgroupsList);
    }

    @Test(priority = 4, description = "Verify that allows sorting items (different options)")
    public void verifySorting() {
        homePage.openWebSite()
                .hoverOverComputersGroupButton()
                .clickDesktopsButton()
                .selectSortByOption("sortFromLowToHigh");
        subcategoryPageAsserter.assertItemsSortedByPrice("sortFromLowToHigh");
        subcategoryPage.selectSortByOption("sortFromHighToLow");
        subcategoryPageAsserter.assertItemsSortedByPrice("sortFromHighToLow");
    }

    @Test(priority = 5, description = "Verify that allows changing number of items on page")
    public void verifyChangingNumberOfItems() {
        homePage.openWebSite()
                .hoverOverComputersGroupButton()
                .clickDesktopsButton();
        subcategoryPageAsserter.assertNumberOfItemsOnPage(3);
    }

    @Test(priority = 6, description = "Verify that allows adding an item to the Wishlist")
    public void verifyAddingToWishlist() {
        verifyLogin();
        productPage.openProductByName(Constants.WISHLIST_PRODUCT)
                .enterRecipientName(Constants.RECIPIENT_NAME);
        int qtyBefore = productPage.wishListQty();
        productPage.clickAddToWishListButton();
        productPageAsserter.assertAddToWishlistSuccessMessage();
        int qtyAfter = productPage.wishListQty();
        productPageAsserter.assertQtyUpdatedByOne(qtyBefore, qtyAfter);
    }

    @Test(priority = 7, description = "Verify that allows adding an item to the cart")
    public void verifyAddingToCart() {
        verifyLogin();
        productPage.openProductByName(Constants.ADD_TO_CART_PRODUCT);
        int qtyBefore = productPage.cartQty();
        productPage.clickAddToCartButton();
        productPageAsserter.assertAddToCartSuccessMessage();
        int qtyAfter = productPage.cartQty();
        productPageAsserter.assertQtyUpdatedByOne(qtyBefore, qtyAfter);
    }

    @Test(priority = 8, description = "Verify that allows removing an item from the card")
    public void verifyRemovingFromCart() {
        verifyAddingToCart();
        shoppingCartPage.openWebSite();
        shoppingCartPage.removeFromCart();
        shoppingCartPageAsserter.assertRemoveFromCartSuccessMessage();
    }

    @Test(priority = 9, description = "Verify that allows checkout an item")
    public void verifyCheckingOutItem() {
        verifyAddingToCart();
        shoppingCartPage.openWebSite()
                .clickCheckoutButton()
                .fillInBillingAddressSection()
                .fillInSections23456();
        checkoutPageAsserter.assertConfirmOrderMessage();
    }
}
