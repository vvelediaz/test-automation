package com.solvd.carina.web.pages.parabank.ios;

import com.solvd.carina.web.components.parabank.ServicesMenu;
import com.solvd.carina.web.components.parabank.ServicesMenuMobile;
import com.solvd.carina.web.pages.parabank.common.AccountActivityPageBase;
import com.solvd.carina.web.pages.parabank.common.OpenNewAccountPageBase;
import com.solvd.carina.web.pages.parabank.common.OverviewPageBase;
import com.solvd.carina.web.pages.parabank.common.TransferFundsPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.List;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = OverviewPageBase.class)
public class OverviewPage extends OverviewPageBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//div[@id='headerPanel']")
    private ExtendedWebElement headerPanel;

    @FindBy(xpath = "//div[@id='leftPanel']")
    private ServicesMenuMobile servicesMenu;

    @FindBy(xpath = "/html/body/div[1]/div[3]/div[2]/div/div/table/tbody/tr[1]/td[1]/a")
    private ExtendedWebElement firstAccountButton;

    @FindBy(xpath = "//*/tbody/tr")
    private List<ExtendedWebElement> accounts;

    public OverviewPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(headerPanel);
    }

    @Override
    public OpenNewAccountPageBase openNewAccountPage() {
        return servicesMenu.openOpenNewAccountPage();
    }

    @Override
    public String getFirstAccountNumber() {
        return firstAccountButton.getText();
    }

    @Override
    public List<ExtendedWebElement> getAccounts() {
        return accounts;
    }

    @Override
    public TransferFundsPageBase openTransferFundsPage() {
        return servicesMenu.openTransferFundsPage();
    }

    @Override
    public AccountActivityPageBase openLatestAccountActivityPage() {
        WebElement latestAccount = accounts.get(accounts.size()-2).getElement().findElement(By.xpath(".//a"));
        latestAccount.click();
        return initPage(getDriver(), AccountActivityPageBase.class);
    }
}
