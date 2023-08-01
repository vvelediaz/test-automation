package com.solvd.carina.web.components.parabank;

import com.solvd.carina.web.pages.parabank.common.BillPayPageBase;
import com.solvd.carina.web.pages.parabank.common.HomePageBase;
import com.solvd.carina.web.pages.parabank.common.OpenNewAccountPageBase;
import com.solvd.carina.web.pages.parabank.common.OverviewPageBase;
import com.solvd.carina.web.pages.parabank.desktop.HomePage;
import com.solvd.carina.web.pages.parabank.desktop.OpenNewAccountPage;
import com.solvd.carina.web.pages.parabank.desktop.OverviewPage;
import com.solvd.carina.web.pages.parabank.desktop.TransferFundsPage;
import com.solvd.carina.web.pages.parabank.desktop.BillPayPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ServicesMenu extends ServicesMenuBase {
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

    public ServicesMenu(WebDriver driver, SearchContext searchContext) {
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
