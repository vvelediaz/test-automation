package com.solvd.carina.web;

import com.solvd.carina.web.pages.parabank.common.*;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ParabankTest implements IBankLogin {
    @Test
    public void openAccountTestAndMoveFundsToMain() {
        // Login, record initial number of accounts and main account id
        OverviewPageBase overviewPage = login();
        String accountNumber = overviewPage.getFirstAccountNumber();
        int numberOfAccountsBefore = overviewPage.getAccounts().size();

        // Create new account
        OpenNewAccountPageBase openNewAccountPage = overviewPage.openNewAccountPage();
        Assert.assertTrue(openNewAccountPage.isPageOpened(), "Open New Account page is not opened");
        openNewAccountPage.createAccount("CHECKING", accountNumber);
        Assert.assertTrue(openNewAccountPage.isAccountOpenedMessagePresent());

        // Verify new account is created
        overviewPage = openNewAccountPage.openOverviewPage();
        int numberOfAccountsAfter = overviewPage.getAccounts().size();
        Assert.assertEquals(numberOfAccountsAfter, numberOfAccountsBefore + 1);

        // Transfer funds back to main account
        ExtendedWebElement latestAccount = overviewPage.getAccounts().get(numberOfAccountsAfter - 2);
        String latestAccountNumber = latestAccount.getElement().findElement(By.xpath(".//td[1]")).getText();
        TransferFundsPageBase transferFundsPage = overviewPage.openTransferFundsPage();
        Assert.assertTrue(transferFundsPage.isPageOpened(), "Transfer Funds page is not opened");
        transferFundsPage.transfer("100", latestAccountNumber, accountNumber);

        // Verify all funds are transferred
        overviewPage = transferFundsPage.openOverviewPage();
        latestAccount = overviewPage.getAccounts().get(numberOfAccountsAfter - 2);
        String latestAccountBalance = latestAccount.getElement().findElement(By.xpath(".//td[2]")).getText();
        Assert.assertEquals(latestAccountBalance, "$0.00");

        // Open latest account activity page and then open latest transaction
        AccountActivityPageBase accountActivityPage = overviewPage.openLatestAccountActivityPage();
        Assert.assertTrue(accountActivityPage.isPageOpened(), "Account Activity page is not opened");
        TransactionPageBase transactionPage = accountActivityPage.openLatestTransaction();
        Assert.assertTrue(transactionPage.isPageOpened(), "Transaction page is not opened");

        Assert.assertEquals(transactionPage.getAmount(), "$100.00");

        // Logout
        HomePageBase homePage = transactionPage.logout();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
    }
}
