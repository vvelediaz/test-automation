package com.solvd.carina.web.pages.ebay.desktop;

import com.solvd.carina.web.pages.ebay.common.ProductPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = ProductPageBase.class)
public class ProductPage extends ProductPageBase {
    @FindBy(xpath = "//input[@placeholder='Search for anything']")
    private ExtendedWebElement searchBar;

    @FindBy(xpath = "//button[contains(@class, 'ux-call-to-action')][contains(@class, 'btn')][contains(@class, 'btn--fluid')][contains(@class, 'btn--secondary')]")
    private ExtendedWebElement addToWatchListButton;

    public ProductPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(searchBar);
    }

    @Override
    public void addToWatchlist() {
        addToWatchListButton.click();
    }
}