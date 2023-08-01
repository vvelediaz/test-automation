package com.solvd.carina.web.pages.gsmarena.common;

import com.solvd.carina.demo.gui.pages.desktop.CompareModelsPage;
import com.solvd.carina.web.components.gsmarena.footer.FooterMenuBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public abstract class HomePageBase extends AbstractPage {

    @FindBy(xpath = "//button[text()='Agree and proceed']")
    private ExtendedWebElement acceptCookies;

    public HomePageBase(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://www.gsmarena.com/");
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
    }

    @Override
    public void open() {
        super.open();
        acceptCookies.clickIfPresent();
    }

    public abstract BrandModelsPageBase selectBrand(String brandName);

    public abstract FooterMenuBase getFooterMenu();

    public abstract CompareModelsPage openComparePage();

    public abstract AllBrandsPageBase openAllBrandsPage();

    public abstract void login();

    public abstract List<ExtendedWebElement> getSamsungDailyHits();
}
