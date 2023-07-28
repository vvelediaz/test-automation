package com.solvd.carina.web.pages.ebay.desktop;

import com.solvd.carina.web.pages.ebay.common.*;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase {

    @FindBy(xpath = "//li[@class='vl-flyout-nav__js-tab' and @data-currenttabindex='0']")
    private ExtendedWebElement motorsButton;

    @FindBy(xpath = "//input[@placeholder='Search for anything']")
    private ExtendedWebElement searchBar;

    @FindBy(xpath = "//a[text()='Sign in']")
    private ExtendedWebElement signInButton;

    @FindBy(xpath = "//li[@class='gh-t gh-divider-l' and @id='gh-p-1']")
    private ExtendedWebElement dailyDealsButton;

    @FindBy(xpath = "//button[@id='gh-ug']")
    private ExtendedWebElement accountDropDownMenu;

    @FindBy(xpath = "//a[text()='Account settings']")
    private ExtendedWebElement accountSettingsButton;

    @FindBy(xpath = "//input[@type='submit' and @value='Search']")
    private ExtendedWebElement searchButton;

    public HomePage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(searchBar);
    }

    @Override
    public CarAndTruckPartsPageBase openCarsAndTrucksPage() {
        Actions actions = new Actions(getDriver());
        actions.moveToElement(motorsButton.getElement()).perform(); // Hover over the "Motors" button

        // Wait for the element to be clickable
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        WebElement carsAndTruckPartsButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@class, 'vl-flyout-nav__js-link') and contains(text(), 'Car & Truck Parts')]")));

        // Click the element
        carsAndTruckPartsButton.click();

        return initPage(getDriver(), CarAndTruckPartsPageBase.class);
    }

    @Override
    public SignInPageBase openSignInPage() {
        signInButton.click();
        return initPage(getDriver(), SignInPageBase.class);
    }

    @Override
    public DailyDealsPageBase openDailyDealsPage() {
        dailyDealsButton.click();
        return initPage(getDriver(), DailyDealsPageBase.class);
    }

    @Override
    public AccountSettingsPageBase openAccountSettingsPage() {
        accountDropDownMenu.hover();
        accountSettingsButton.click();
        return initPage(getDriver(), AccountSettingsPageBase.class);
    }

    @Override
    public ProductSearchPageBase searchProduct(String product) {
        searchBar.type(product);
        searchButton.click();
        return initPage(getDriver(), ProductSearchPageBase.class);
    }
}
