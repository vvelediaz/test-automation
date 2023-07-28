package com.solvd.carina.web.pages.ebay.desktop;

import com.solvd.carina.web.pages.ebay.common.MessagesPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = MessagesPageBase.class)
public class MessagesPage extends MessagesPageBase {
    @FindBy(xpath = "//h1[text()='My eBay: Messages']")
    private ExtendedWebElement messagesPageTitle;

    @FindBy(xpath = "//div[text()='A new device is using your account']")
    private ExtendedWebElement firstMessageSubject;

    public MessagesPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(messagesPageTitle);
    }

    public String getFirstMessageSubject() {
        return firstMessageSubject.getText();
    }
}
