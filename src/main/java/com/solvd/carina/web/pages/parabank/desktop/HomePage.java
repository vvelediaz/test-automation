package com.solvd.carina.web.pages.parabank.desktop;

import com.solvd.carina.web.pages.parabank.common.HomePageBase;
import com.solvd.carina.web.pages.parabank.common.OverviewPageBase;
import com.zebrunner.carina.utils.config.Configuration;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase {
    @FindBy(xpath = "//input[@name='username']")
    private ExtendedWebElement usernameField;

    @FindBy(xpath = "//input[@name='password']")
    private ExtendedWebElement passwordField;

    @FindBy(xpath = "//input[@value='Log In']")
    private ExtendedWebElement loginButton;

    public HomePage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(usernameField);
    }

    public OverviewPageBase login(){
        usernameField.type(Configuration.getRequired("username"));
        passwordField.type(Configuration.getRequired("password"));
        loginButton.click();
        return initPage(getDriver(), OverviewPageBase.class);
    }
}
