package asserts;

import org.testng.Assert;
import pages.SubcategoryPage;

public class SubcategoryPageAsserter {

    private final SubcategoryPage subcategoryPage;

    public SubcategoryPageAsserter() {
        subcategoryPage = new SubcategoryPage();
    }

    public void assertItemsSortedByPrice(String sortingType) {
        Assert.assertTrue(subcategoryPage.isSortedByPrice(sortingType));
    }

    public void assertNumberOfItemsOnPage(Integer numberOfOptions) {
        for (int i = 0; i < numberOfOptions; i++) {
            Assert.assertTrue(subcategoryPage.isNumberOfItemsApplied(i));
        }
    }
}
