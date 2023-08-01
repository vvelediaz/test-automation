package com.solvd.carina.web.pages.parabank.common;

import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class TransferFundsPageBase extends AbstractPage {
    public TransferFundsPageBase(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
    }

    @Override
    public void open() {
        super.open();
    }

    public abstract void transfer(String amount, String fromAccountId, String toAccountId);

    public abstract boolean isTransferCompletedMessagePresent();

    public abstract OverviewPageBase openOverviewPage();

    public abstract BillPayPageBase openBillPayPage();

    public abstract TransferFundsPageBase refreshPage();
}
