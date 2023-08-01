package com.solvd.carina.web.pages.parabank.desktop;

import com.solvd.carina.web.pages.parabank.common.AccountActivityPageBase;
import com.solvd.carina.web.pages.parabank.common.TransactionPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = AccountActivityPageBase.class)
public class AccountActivityPage extends AccountActivityPageBase{
    @FindBy(xpath = "//table[@id='transactionTable']/tbody/tr")
    private List<ExtendedWebElement> transactions;

    public AccountActivityPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(transactions.get(0));
    }

    @Override
    public TransactionPageBase openLatestTransaction() {
        WebElement latestTransaction = transactions.get(transactions.size()-1).getElement().findElement(By.xpath(".//a"));
        latestTransaction.click();
        return initPage(getDriver(), TransactionPageBase.class);
    }
}

