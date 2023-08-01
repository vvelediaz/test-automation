package com.solvd.carina.web;

import com.solvd.carina.web.pages.parabank.common.*;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class IOSParabankTest implements IBankLoginMobile {
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

    @Test(dataProvider = "transferFundsData")
    public void testTransferFundsMultipleTimes(String amount, String numberOfTimes) {
        // Open Overview page
        OverviewPageBase overviewPage = login();
        Assert.assertTrue(overviewPage.isPageOpened(), "Overview page is not opened");

        // Get number of accounts, get main account number and latest account number, and verify latest account initial balance
        int numberOfAccountsBefore = overviewPage.getAccounts().size();
        String mainAccountNumber = overviewPage.getFirstAccountNumber();
        ExtendedWebElement latestAccount = overviewPage.getAccounts().get(numberOfAccountsBefore - 2);
        String latestAccountNumber = latestAccount.getElement().findElement(By.xpath(".//td[1]")).getText();
        String latestAccountInitialBalance = latestAccount.getElement().findElement(By.xpath(".//td[2]")).getText();


        // Transfer funds to new account
        TransferFundsPageBase transferFundsPage = overviewPage.openTransferFundsPage();
        Assert.assertTrue(transferFundsPage.isPageOpened(), "Transfer Funds page is not opened");

        for(int i = 0; i < Integer.parseInt(numberOfTimes); i++) {
            transferFundsPage.transfer(amount, mainAccountNumber, latestAccountNumber);
            Assert.assertTrue(transferFundsPage.isTransferCompletedMessagePresent(), "Transfer is not completed");
            transferFundsPage = transferFundsPage.refreshPage();
        }

        overviewPage = transferFundsPage.openOverviewPage();
        latestAccount = overviewPage.getAccounts().get(numberOfAccountsBefore - 2);
        String latestAccountUpdatedBalance = latestAccount.getElement().findElement(By.xpath(".//td[2]")).getText();
        double initialBalance = Double.parseDouble(latestAccountInitialBalance.replace("$", ""));
        double updatedBalance = Double.parseDouble(latestAccountUpdatedBalance.replace("$", ""));

        Assert.assertEquals(initialBalance + Integer.parseInt(amount) * Integer.parseInt(numberOfTimes), updatedBalance);
    }

    @DataProvider(name = "transferFundsData")
    public Object[][] getTransferFundsData() {
        return new Object[][] {
                {"100", "1"},
                {"50", "2"},
                {"20", "5"}
        };
    }
}
