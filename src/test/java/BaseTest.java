import asserts.*;
import org.helpers.DriverManager;
import org.testng.annotations.*;
import pages.*;

public class BaseTest {

    public HomePage homePage;

    public RegisterPage registerPage;

    public LoginPage loginPage;

    public SubcategoryPage subcategoryPage;

    public ProductPage productPage;

    public ShoppingCartPage shoppingCartPage;

    public CheckoutPage checkoutPage;

    public RegisterPageAsserter registerPageAsserter;

    public HomePageAsserter homePageAsserter;

    public SubcategoryPageAsserter subcategoryPageAsserter;

    public ProductPageAsserter productPageAsserter;

    public ShoppingCartPageAsserter shoppingCartPageAsserter;

    public CheckoutPageAsserter checkoutPageAsserter;

    @BeforeClass
    public void setUp() {
        DriverManager.initDriver();
        homePage = new HomePage();
        registerPage = new RegisterPage();
        loginPage = new LoginPage();
        subcategoryPage = new SubcategoryPage();
        productPage = new ProductPage();
        shoppingCartPage = new ShoppingCartPage();
        checkoutPage = new CheckoutPage();
        registerPageAsserter = new RegisterPageAsserter();
        homePageAsserter = new HomePageAsserter();
        subcategoryPageAsserter = new SubcategoryPageAsserter();
        productPageAsserter = new ProductPageAsserter();
        shoppingCartPageAsserter = new ShoppingCartPageAsserter();
        checkoutPageAsserter = new CheckoutPageAsserter();
    }

    @AfterClass
    public void closeBrowser() {
        DriverManager.quitDriver();
    }
}
