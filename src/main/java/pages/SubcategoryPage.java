package pages;

import configurations.PropertiesManager;
import org.helpers.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.*;

public class SubcategoryPage {

    @FindBy(className = "actual-price")
    private List<WebElement> itemsPrice;

    @FindBy(id = "products-orderby")
    private WebElement sortByDropDown;

    @FindBy(xpath = "//option[text()='Price: Low to High']")
    private WebElement sortFromLowToHigh;

    @FindBy(xpath = "//option[text()='Price: High to Low']")
    private WebElement sortFromHighToLow;

    @FindBy(id = "products-pagesize")
    private WebElement pageSizeDropDown;

    @FindBy(xpath = "//select[@id='products-pagesize']/option")
    private List<WebElement> pageSizes;

    @FindBy(className = "item-box")
    private List<WebElement> itemsNumber;


    public SubcategoryPage() {
        PageFactory.initElements(new AjaxElementLocatorFactory(DriverManager.getDriver(), PropertiesManager.getWaitTime()), this);
    }

    public void selectSortByOption(String option) {
        sortByDropDown.click();
        switch (option) {
            case "sortFromLowToHigh":
                sortFromLowToHigh.click();
                DriverManager.getWait().until(ExpectedConditions.urlContains("orderby=10"));
                break;
            case "sortFromHighToLow":
                sortFromHighToLow.click();
                DriverManager.getWait().until(ExpectedConditions.urlContains("orderby=11"));
                break;
        }
    }

    public boolean isSortedByPrice(String option) {
        List<Double> sortedPrices = new ArrayList<>();
        for (WebElement itemPrice : itemsPrice) {
            sortedPrices.add(Double.valueOf(itemPrice.getText()));
        }
        List<Double> originalPrices = new ArrayList<>(sortedPrices);
        if (Objects.equals(option, "sortFromLowToHigh")) {
            sortedPrices.sort(Comparator.naturalOrder());
        } else {
            sortedPrices.sort(Comparator.reverseOrder());
        }
        return originalPrices.equals(sortedPrices);
    }

    public boolean isNumberOfItemsApplied(Integer option) {
        pageSizeDropDown.click();
        pageSizes.get(option).click();
        int pageSize = Integer.parseInt(pageSizes.get(option).getText());
        DriverManager.getWait().until(ExpectedConditions.urlContains("pagesize=" + pageSize));
        return itemsNumber.size() <= pageSize;
    }
}
