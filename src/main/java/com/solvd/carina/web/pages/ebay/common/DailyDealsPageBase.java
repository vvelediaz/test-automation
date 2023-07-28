package com.solvd.carina.web.pages.ebay.common;

import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class DailyDealsPageBase extends AbstractPage {
    public DailyDealsPageBase(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
    }

    public abstract ProductPageBase openProductPage();
    public void open() {
        super.open();
    }
}
