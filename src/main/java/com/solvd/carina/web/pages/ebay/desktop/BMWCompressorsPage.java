package com.solvd.carina.web.pages.ebay.desktop;

import com.solvd.carina.web.pages.ebay.common.BMWCompressorsPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = BMWCompressorsPageBase.class)
public class BMWCompressorsPage extends BMWCompressorsPageBase {
    @FindBy(xpath = "//input[@placeholder='Search for anything']")
    private ExtendedWebElement searchBar;

    @FindBy(xpath = "//span[@class='s-item__price']")
    private List<ExtendedWebElement> prices;

    public BMWCompressorsPage(WebDriver driver) {
        super(driver);
        setPageURL("/b/BMW-Car-and-Truck-AC-Compressors/33543/bn_580245");
        setUiLoadedMarker(searchBar);
    }

    public List<ExtendedWebElement> getPrices() {
        return prices;
    }
}
