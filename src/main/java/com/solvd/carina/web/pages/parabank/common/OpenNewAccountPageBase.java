package com.solvd.carina.web.pages.parabank.common;

import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class OpenNewAccountPageBase extends AbstractPage {

    public OpenNewAccountPageBase(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
    }

    public abstract void createAccount(String type, String fromAccountId);

    public abstract boolean isAccountOpenedMessagePresent();

    @Override
    public void open() {
        super.open();
    }

    public abstract OverviewPageBase openOverviewPage();
}
