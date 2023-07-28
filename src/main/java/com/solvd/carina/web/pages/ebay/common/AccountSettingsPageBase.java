package com.solvd.carina.web.pages.ebay.common;

import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class AccountSettingsPageBase extends AbstractPage {
    public AccountSettingsPageBase(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
    }

    public abstract MessagesPageBase openMessagesPage();

    public void open() {
        super.open();
    }
}
