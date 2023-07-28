package com.solvd.carina.web.pages.ebay.desktop;

import com.solvd.carina.web.pages.ebay.common.AccountSettingsPageBase;
import com.solvd.carina.web.pages.ebay.common.MessagesPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = AccountSettingsPageBase.class)
public class AccountSettingsPage extends AccountSettingsPageBase {
    @FindBy(xpath = "//h1[text()='My eBay']")
    private ExtendedWebElement accountSettingsPageTitle;

    @FindBy(xpath = "//a[text()='Messages']")
    private ExtendedWebElement messagesButton;

    public AccountSettingsPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(accountSettingsPageTitle);
    }

    public MessagesPageBase openMessagesPage() {
        messagesButton.click();
        return initPage(getDriver(), MessagesPageBase.class);
    }
}
