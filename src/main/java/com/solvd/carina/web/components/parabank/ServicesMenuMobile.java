package com.solvd.carina.web.components.parabank;

import com.solvd.carina.web.pages.parabank.common.BillPayPageBase;
import com.solvd.carina.web.pages.parabank.common.HomePageBase;
import com.solvd.carina.web.pages.parabank.common.OpenNewAccountPageBase;
import com.solvd.carina.web.pages.parabank.common.OverviewPageBase;
import com.solvd.carina.web.pages.parabank.ios.HomePage;
import com.solvd.carina.web.pages.parabank.ios.OpenNewAccountPage;
import com.solvd.carina.web.pages.parabank.ios.OverviewPage;
import com.solvd.carina.web.pages.parabank.ios.TransferFundsPage;
import com.solvd.carina.web.pages.parabank.ios.BillPayPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ServicesMenuMobile extends ServicesMenuBase {
    @FindBy(xpath = "//a[text()='Open New Account']")
    private ExtendedWebElement openNewAccountButton;

    @FindBy(xpath = "//a[text()='Accounts Overview']")
    private ExtendedWebElement overviewButton;

    @FindBy(xpath = "//a[text()='Transfer Funds']")
    private ExtendedWebElement transferFundsButton;

    @FindBy(xpath = "//a[text()='Log Out']")
    private ExtendedWebElement logoutButton;

    @FindBy(xpath = "//a[text()='Bill Pay']")
    private ExtendedWebElement billPayButton;

    public ServicesMenuMobile(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public OverviewPageBase openOverviewPage() {
        overviewButton.click();
        return new OverviewPage(driver);
    }

    @Override
    public OpenNewAccountPageBase openOpenNewAccountPage() {
        openNewAccountButton.click();
        return new OpenNewAccountPage(driver);
    }

    @Override
    public TransferFundsPage openTransferFundsPage() {
        transferFundsButton.click();
        return new TransferFundsPage(driver);
    }

    @Override
    public BillPayPageBase openBillPayPage() {
        billPayButton.click();
        return new BillPayPage(driver);
    }

    @Override
    public HomePageBase logout() {
        logoutButton.click();
        return new HomePage(driver);
    }
}
