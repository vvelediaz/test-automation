package com.solvd.carina.web.pages.parabank.common;

import com.solvd.carina.web.pages.parabank.desktop.TransferFundsPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

import java.util.List;

public abstract class OverviewPageBase extends AbstractPage {
    public OverviewPageBase(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
    }

    public abstract OpenNewAccountPageBase openNewAccountPage();

    public abstract String getFirstAccountNumber();

    @Override
    public void open() {
        super.open();
    }

    public abstract List<ExtendedWebElement> getAccounts();

    public abstract TransferFundsPageBase openTransferFundsPage();

    public abstract AccountActivityPageBase openLatestAccountActivityPage();
}
