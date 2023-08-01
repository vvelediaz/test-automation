package com.solvd.carina.web.pages.ebay.ios;

import com.solvd.carina.web.pages.ebay.common.ProductPageBase;
import com.solvd.carina.web.pages.ebay.common.ProductSearchPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = ProductSearchPageBase.class)
public class MobilePhonePage extends ProductSearchPageBase {
    @FindBy(xpath = "//li[contains(@class, 's-item') and .//span[@class='s-item__price' and number(substring-before(substring-after(., '$'), '.')) < 300]]")
    private List<ExtendedWebElement> phones;

    @FindBy(xpath = "//input[@placeholder='Search for anything']")
    private ExtendedWebElement searchBar;

    @FindBy(xpath = "/html/body/div[5]/div[4]/div[2]/div[1]/div[2]/ul/li[2]/div/div[2]/a")
    private ExtendedWebElement firstProductButton;

    public MobilePhonePage(WebDriver driver) {
        super(driver);
        setPageURL("/sch/i.html?_from=R40&_trksid=p2499334.m570.l1311&_nkw=mobile+phones&_sacat=0");
        setUiLoadedMarker(searchBar);
    }

    @Override
    public ProductPageBase openFirstProductPage() {
        firstProductButton.click();
        return initPage(getDriver(), ProductPageBase.class);
    }

    @Override
    public List<ExtendedWebElement> getItemsPrice() {
        return phones;
    }
}
