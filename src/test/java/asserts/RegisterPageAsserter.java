package asserts;

import org.testng.Assert;
import pages.RegisterPage;

public class RegisterPageAsserter {

    private final RegisterPage registerPage;

    public RegisterPageAsserter() {
        registerPage = new RegisterPage();
    }

    public void assertRegisteredTextDisplayed() {
        Assert.assertTrue(registerPage.isRegisteredTextDisplayed());
    }
}
