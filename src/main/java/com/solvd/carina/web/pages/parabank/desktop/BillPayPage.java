package com.solvd.carina.web.pages.parabank.desktop;

import com.solvd.carina.web.components.parabank.ServicesMenuMobile;
import com.solvd.carina.web.pages.parabank.common.BillPayPageBase;
import com.solvd.carina.web.pages.parabank.common.OpenNewAccountPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = BillPayPageBase.class)
public class BillPayPage extends BillPayPageBase {
    @FindBy(xpath = "//input[@value='Send Payment']")
    private ExtendedWebElement sendPaymentButton;

    @FindBy(xpath = "//div[@id='leftPanel']")
    private ServicesMenuMobile servicesMenu;

    public BillPayPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(sendPaymentButton);
    }

    @Override
    public OpenNewAccountPageBase openNewAccountPage() {
        return servicesMenu.openOpenNewAccountPage();
    }
}
