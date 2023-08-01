package com.solvd.carina.web.pages.parabank.desktop;

import com.solvd.carina.web.components.parabank.ServicesMenu;
import com.solvd.carina.web.pages.parabank.common.HomePageBase;
import com.solvd.carina.web.pages.parabank.common.TransactionPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = TransactionPageBase.class)
public class TransactionPage extends TransactionPageBase {
    @FindBy(xpath = "//div[@id='leftPanel']")
    private ServicesMenu servicesMenu;

    @FindBy(xpath = "/html/body/div[1]/div[3]/div[2]/table/tbody/tr[5]/td[2]")
    private ExtendedWebElement amount;

    public TransactionPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(amount);
    }
    @Override
    public String getAmount() {
        return amount.getText();
    }

    @Override
    public HomePageBase logout() {
        return servicesMenu.logout();
    }


}
