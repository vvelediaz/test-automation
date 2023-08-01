package com.solvd.carina.web.components.parabank;

import com.solvd.carina.web.pages.parabank.common.*;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public abstract class ServicesMenuBase extends AbstractUIObject {
    public ServicesMenuBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract OverviewPageBase openOverviewPage();

    public abstract OpenNewAccountPageBase openOpenNewAccountPage();

    public abstract TransferFundsPageBase openTransferFundsPage();

    public abstract BillPayPageBase openBillPayPage();

    public abstract HomePageBase logout();
}
