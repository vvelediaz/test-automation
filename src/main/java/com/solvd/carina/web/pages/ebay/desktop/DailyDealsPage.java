package com.solvd.carina.web.pages.ebay.desktop;

import com.solvd.carina.web.pages.ebay.common.DailyDealsPageBase;
import com.solvd.carina.web.pages.ebay.common.ProductPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = DailyDealsPageBase.class)
public class DailyDealsPage extends DailyDealsPageBase{
    @FindBy(xpath = "//span[text() = 'Featured Deals']")
    private ExtendedWebElement featuredDealsHeader;

    @FindBy(xpath = "/html/body/main/div/div[2]/div[2]/div[1]/div/div/div/a/h3")
    private ExtendedWebElement spotLightDealItemButton;

    public DailyDealsPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(featuredDealsHeader);
    }

    @Override
    public ProductPageBase openProductPage() {
        spotLightDealItemButton.click();
        return initPage(getDriver(), ProductPageBase.class);
    }
}
