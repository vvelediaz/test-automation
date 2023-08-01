package com.solvd.carina.web.pages.parabank.ios;

import com.solvd.carina.web.components.parabank.ServicesMenu;
import com.solvd.carina.web.components.parabank.ServicesMenuMobile;
import com.solvd.carina.web.pages.parabank.common.BillPayPageBase;
import com.solvd.carina.web.pages.parabank.common.OverviewPageBase;
import com.solvd.carina.web.pages.parabank.common.TransferFundsPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = TransferFundsPageBase.class)
public class TransferFundsPage extends TransferFundsPageBase {
    @FindBy(xpath = "//div[@id='leftPanel']")
    private ServicesMenuMobile servicesMenu;

    @FindBy(xpath = "//input[@id='amount']")
    private ExtendedWebElement amountField;

    @FindBy(xpath = "//select[@id='fromAccountId']")
    private ExtendedWebElement fromAccountIdSelect;

    @FindBy(xpath = "//select[@id='toAccountId']")
    private ExtendedWebElement toAccountIdSelect;

    @FindBy(xpath = "//input[@value='Transfer']")
    private ExtendedWebElement transferButton;

    public TransferFundsPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(transferButton);
    }

    @Override
    public void transfer(String amount, String fromAccountId, String toAccountId) {
        amountField.type(amount);
        fromAccountIdSelect.select(fromAccountId);
        toAccountIdSelect.select(toAccountId);
        transferButton.click();
    }

    @Override
    public boolean isTransferCompletedMessagePresent() {
        WebElement accountOpenedMessage = driver.findElement(By.xpath("//h1[contains(text(),'Transfer Complete!')]"));
        return accountOpenedMessage.isDisplayed();
    }

    @Override
    public OverviewPageBase openOverviewPage() {
        return servicesMenu.openOverviewPage();
    }

    @Override
    public BillPayPageBase openBillPayPage() {
        return servicesMenu.openBillPayPage();
    }

    @Override
    public TransferFundsPageBase refreshPage() {
        return servicesMenu.openTransferFundsPage();
    }
}
