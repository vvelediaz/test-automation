package com.solvd.carina.web.pages.ebay.ios;

import com.solvd.carina.web.pages.ebay.common.HomePageBase;
import com.solvd.carina.web.pages.ebay.common.SignInPageBase;
import com.zebrunner.carina.utils.config.Configuration;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = SignInPageBase.class)
public class SignInPage extends SignInPageBase {
    @FindBy(xpath = "//input[@id='userid']")
    private ExtendedWebElement userIdField;

    @FindBy(xpath = "//input[@id='pass']")
    private ExtendedWebElement passwordField;

    @FindBy(xpath = "//button[@id='signin-continue-btn']")
    private ExtendedWebElement continueButton;

    @FindBy(xpath = "//button[@id='sgnBt']")
    private ExtendedWebElement signInButton;

    public SignInPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(userIdField);
    }

    @Override
    public HomePageBase signIn() {
        userIdField.type(Configuration.getRequired("username"));
        continueButton.click();

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(passwordField.getElement()));

        passwordField.type(Configuration.getRequired("password"));
        signInButton.click();
        return initPage(getDriver(), HomePageBase.class);
    }
}
