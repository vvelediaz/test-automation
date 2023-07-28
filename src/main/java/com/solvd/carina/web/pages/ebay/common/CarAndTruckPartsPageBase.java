package com.solvd.carina.web.pages.ebay.common;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

import java.util.List;

public abstract class CarAndTruckPartsPageBase extends AbstractPage {

    protected CarAndTruckPartsPageBase(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
    }

    public abstract List<ExtendedWebElement> getCategories();

    @Override
    public void open() {
        super.open();
    }
}
