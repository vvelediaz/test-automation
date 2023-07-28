package com.solvd.carina.web.pages.ebay.desktop;

import com.solvd.carina.web.pages.ebay.common.ProductPageBase;
import com.solvd.carina.web.pages.ebay.common.ProductSearchPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = ProductSearchPageBase.class)
public class ProductSearchPage extends ProductSearchPageBase {
    @FindBy(xpath = "//li[contains(@class, 's-item') and .//span[@class='s-item__price']]")
    private List<ExtendedWebElement> items;

    @FindBy(xpath = "//input[@placeholder='Search for anything']")
    private ExtendedWebElement searchBar;

    @FindBy(xpath = "//a[@class='s-item__link'][1]")
    private ExtendedWebElement firstProductButton;

    public ProductSearchPage() {
        super(null);
        setUiLoadedMarker(searchBar);
    }

    @Override
    public List<ExtendedWebElement> getItemsPrice() {
        return items;
    }

    public ProductPageBase openFirstProductPage() {
        firstProductButton.click();
        return initPage(getDriver(), ProductPageBase.class);
    }
}
