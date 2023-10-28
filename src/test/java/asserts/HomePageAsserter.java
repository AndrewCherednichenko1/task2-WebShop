package asserts;

import org.testng.Assert;
import pages.HomePage;

public class HomePageAsserter {

    private final HomePage homePage;

    public HomePageAsserter() {
        homePage = new HomePage();
    }

    public void assertLogoutButtonDisplayed() {
        Assert.assertTrue(homePage.isLogoutButtonDisplayed());
    }

    public void assertNumberOfSubgroups(Integer expectedNumber) {
        Assert.assertEquals(homePage.getNumberOfSubgroups(), expectedNumber);
    }

    public void asserEachSubgroupNameCorrect(String[] expectedList) {
        for (int i = 0; i < homePage.getNumberOfSubgroups(); i++) {
            Assert.assertTrue(homePage.getSubgroupsList().get(i).isDisplayed());
            String actualSubGroupName = homePage.getSubgroupsList().get(i).getText().trim();
            String expectedSubGroupName = expectedList[i];
            Assert.assertEquals(expectedSubGroupName, actualSubGroupName);
        }
    }
}
