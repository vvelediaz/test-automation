package com.solvd.carina.ebay.pages.desktop;

import com.solvd.carina.ebay.pages.common.BMWCompressorsPageBase;
import com.solvd.carina.ebay.pages.common.CarAndTruckPartsPageBase;
import com.solvd.carina.ebay.pages.common.HomePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;


import java.time.Duration;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase {

    @FindBy(xpath = "//li[@class='vl-flyout-nav__js-tab' and @data-currenttabindex='0']")
    private ExtendedWebElement motorsButton;

    @FindBy(xpath = "//input[@placeholder='Search for anything']")
    private ExtendedWebElement searchBar;

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
}
