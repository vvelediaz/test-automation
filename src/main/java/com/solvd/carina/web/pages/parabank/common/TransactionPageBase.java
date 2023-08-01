package com.solvd.carina.web.pages.parabank.common;

import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class TransactionPageBase extends AbstractPage {
    public TransactionPageBase(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
    }

    @Override
    public void open() {
        super.open();
    }

    public abstract String getAmount();

    public abstract HomePageBase logout();
}
