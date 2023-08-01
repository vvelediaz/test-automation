package com.solvd.carina.web.pages.ebay.ios;

import com.solvd.carina.web.pages.ebay.common.DailyDealsPageBase;
import com.solvd.carina.web.pages.ebay.common.ProductPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = DailyDealsPageBase.class)
public class DailyDealsPage extends DailyDealsPageBase{
    @FindBy(xpath = "//span[text() = 'Featured Deals']")
    private ExtendedWebElement featuredDealsHeader;

    public DailyDealsPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(featuredDealsHeader);
    }

    @FindBy(xpath = "//*[@id='refit-spf-container']/div[2]/div[2]/div/div/div[1]/div/div/a/h3/span")
    private ExtendedWebElement spotLightDealItemButton;

    @Override
    public ProductPageBase openProductPage() {
        spotLightDealItemButton.click();
        return initPage(getDriver(), ProductPageBase.class);
    }
}
