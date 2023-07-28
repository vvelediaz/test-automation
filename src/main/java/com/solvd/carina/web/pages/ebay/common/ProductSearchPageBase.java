package com.solvd.carina.web.pages.ebay.common;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

import java.util.List;

public abstract class ProductSearchPageBase extends AbstractPage {
    public ProductSearchPageBase(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
    }

    public void open() {
        super.open();
    }

    public abstract ProductPageBase openFirstProductPage();

    public abstract List<ExtendedWebElement> getItemsPrice();
}
