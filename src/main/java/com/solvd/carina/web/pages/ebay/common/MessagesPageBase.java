package com.solvd.carina.web.pages.ebay.common;

import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class MessagesPageBase extends AbstractPage {
    public MessagesPageBase(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
    }

    public abstract String getFirstMessageSubject();

    public void open() {
        super.open();
    }
}
