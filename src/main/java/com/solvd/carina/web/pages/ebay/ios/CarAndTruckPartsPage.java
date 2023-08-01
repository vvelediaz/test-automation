package com.solvd.carina.web.pages.ebay.ios;

import com.solvd.carina.web.pages.ebay.common.CarAndTruckPartsPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = CarAndTruckPartsPageBase.class)
public class CarAndTruckPartsPage extends CarAndTruckPartsPageBase {
    @FindBy(xpath = "//div[contains(@class, 'b-visualnav__title')]")
    private List<ExtendedWebElement> categories;

    @FindBy(xpath = "//div[@class='b-visualnav__grid']")
    private ExtendedWebElement categoryGrid;

    public CarAndTruckPartsPage(WebDriver driver) {
        super(driver);
        setPageURL("/b/Car-Truck-Parts-Accessories/6030/bn_562630");
        setUiLoadedMarker(categoryGrid);
    }

    @Override
    public List<ExtendedWebElement> getCategories() {
        return categories;
    }
}
