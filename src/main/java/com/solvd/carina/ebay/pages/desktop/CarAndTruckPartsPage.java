package com.solvd.carina.ebay.pages.desktop;

import com.solvd.carina.ebay.pages.common.CarAndTruckPartsPageBase;
import com.solvd.carina.ebay.pages.common.HomePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = CarAndTruckPartsPageBase.class)
public class CarAndTruckPartsPage extends CarAndTruckPartsPageBase {
    @FindBy(xpath = "//div[contains(@class, 'b-visualnav__title')]\n")
    private List<ExtendedWebElement> categories;

    @FindBy(xpath = "//div[@class='b-visualnav__grid']")
    private ExtendedWebElement categoryGrid;

    public CarAndTruckPartsPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(categoryGrid);
    }

    @Override
    public List<ExtendedWebElement> getCategories() {
        return categories;
    }
}
