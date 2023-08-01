package com.solvd.carina.web.pages.parabank.ios;

import com.solvd.carina.web.components.parabank.ServicesMenu;
import com.solvd.carina.web.components.parabank.ServicesMenuMobile;
import com.solvd.carina.web.pages.parabank.common.OpenNewAccountPageBase;
import com.solvd.carina.web.pages.parabank.common.OverviewPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = OpenNewAccountPageBase.class)
public class OpenNewAccountPage extends OpenNewAccountPageBase {
    @FindBy(xpath = "//select[@id='type']")
    private ExtendedWebElement selectAccountTypeOption;

    @FindBy(xpath = "//select[@id='fromAccountId']")
    private ExtendedWebElement selectAccountTransferOption;

    @FindBy(xpath = "//input[@value='Open New Account']")
    private ExtendedWebElement openNewAccountButton;

    @FindBy(xpath = "//div[@id='leftPanel']")
    private ServicesMenuMobile servicesMenu;

    public OpenNewAccountPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(openNewAccountButton);
    }

    public void createAccount(String type, String fromAccountId) {
        selectAccountTypeOption.select(type);
        selectAccountTransferOption.select(fromAccountId);
        openNewAccountButton.click();
    }

    public boolean isAccountOpenedMessagePresent() {
        WebElement accountOpenedMessage = driver.findElement(By.xpath("//p[contains(text(),'Congratulations, your account is now open.')]"));
        return accountOpenedMessage.isDisplayed();
    }

    @Override
    public OverviewPageBase openOverviewPage() {
        return servicesMenu.openOverviewPage();
    }
}
