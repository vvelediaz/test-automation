package com.solvd.carina.web.pages.ebay.common;

import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class HomePageBase extends AbstractPage {
    public HomePageBase(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
    }

    public abstract CarAndTruckPartsPageBase openCarsAndTrucksPage();

    public abstract SignInPageBase openSignInPage();

    public abstract DailyDealsPageBase openDailyDealsPage();

    public abstract AccountSettingsPageBase openAccountSettingsPage();

    @Override
    public void open() {
        super.open();
    }
}
