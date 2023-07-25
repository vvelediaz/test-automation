package com.solvd.carina.ebay.pages.desktop;

import com.solvd.carina.ebay.pages.common.CarAndTruckPartsPageBase;
import com.solvd.carina.ebay.pages.common.MobilePhonePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = MobilePhonePageBase.class)
public class MobilePhonePage extends MobilePhonePageBase {
    @FindBy(xpath = "//li[contains(@class, 's-item') and .//span[@class='s-item__price' and number(substring-before(substring-after(., '$'), '.')) < 300]]")
    private List<ExtendedWebElement> phones;

    @FindBy(xpath = "//input[@placeholder='Search for anything']")
    private ExtendedWebElement searchBar;

    public MobilePhonePage(WebDriver driver) {
        super(driver);
        setPageURL("/sch/i.html?_from=R40&_trksid=p2499334.m570.l1311&_nkw=mobile+phones&_sacat=0");
        setUiLoadedMarker(searchBar);
    }

    @Override
    public List<ExtendedWebElement> getPhones() {
        return phones;
    }
}
