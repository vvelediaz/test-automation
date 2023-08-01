package com.solvd.carina.web.pages.ebay.ios;

import com.solvd.carina.web.pages.ebay.common.*;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase {

    @FindBy(xpath = "//li[@class='vl-flyout-nav__js-tab' and @data-currenttabindex='0']")
    private ExtendedWebElement motorsButton;

    @FindBy(xpath = "//input[@placeholder='Search for anything']")
    private ExtendedWebElement searchBar;

    @FindBy(xpath = "//a[@class='gh-header-item__icon-link gh-header-item__profile' and @href='https://www.ebay.com/mye/myebay']")
    private ExtendedWebElement signInButton;

    @FindBy(xpath = "//a[@class='gh-ham-menu__link' and @href='https://www.ebay.com/deals']")
    private ExtendedWebElement dailyDealsButton;

    @FindBy(xpath = "//button[@class='gh-header-item__button gh__needs-js gh-header-item__menu' and contains(@data-marko-key, '@menu-button')]")
    private ExtendedWebElement menuButton;

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
        return initPage(getDriver(), CarAndTruckPartsPageBase.class);
    }

    @Override
    public SignInPageBase openSignInPage() {
        signInButton.click();
        return initPage(getDriver(), SignInPageBase.class);
    }

    @Override
    public DailyDealsPageBase openDailyDealsPage() {
        menuButton.click();
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
