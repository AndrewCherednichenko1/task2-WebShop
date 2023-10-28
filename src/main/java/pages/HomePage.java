package pages;

import configurations.PropertiesManager;
import org.helpers.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.List;

public class HomePage {

    @FindBy(className = "ico-logout")
    private WebElement logoutButton;

    @FindBy(xpath = "//ul[@class='top-menu']//a[contains(text(), 'Computers')]")
    private WebElement computersGroupButton;

    @FindBy(xpath = "//ul[@class='top-menu']//a[contains(text(), 'Computers')]/following-sibling::ul/li")
    private List<WebElement> computersSubGroup;


    Actions actions = new Actions(DriverManager.getDriver());

    public HomePage() {
        PageFactory.initElements(new AjaxElementLocatorFactory(DriverManager.getDriver(), PropertiesManager.getWaitTime()), this);
    }

    public HomePage openWebSite() {
        DriverManager.getDriver().get(PropertiesManager.getBaseUrl());
        return this;
    }

    public boolean isLogoutButtonDisplayed() {
        return logoutButton.isDisplayed();
    }

    public HomePage hoverOverComputersGroupButton() {
        actions.moveToElement(computersGroupButton).perform();
        return this;
    }

    public Integer getNumberOfSubgroups() {
        return computersSubGroup.size();
    }

    public List<WebElement> getSubgroupsList() {
        return computersSubGroup;
    }

    public SubcategoryPage clickDesktopsButton() {
        computersSubGroup.get(0).click();
        return new SubcategoryPage();
    }
}
