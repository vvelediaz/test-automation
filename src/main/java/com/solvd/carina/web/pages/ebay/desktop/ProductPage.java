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

    @FindBy(xpath = "/html/body/div[4]/div[2]/div[1]/div[3]/div[2]/div/div[2]/div/div[1]/div[2]/ul/li[1]/div/a")
    private ExtendedWebElement addToCartButton;

    public ProductPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(searchBar);
    }

    @Override
    public void addToWatchlist() {
        addToWatchListButton.click();
    }

    public void addToCart(){
        addToCartButton.click();
    }
}