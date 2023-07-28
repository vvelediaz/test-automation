package com.solvd.carina.web.pages.gsmarena.desktop;

import java.lang.invoke.MethodHandles;
import java.time.Duration;
import java.util.List;

import com.solvd.carina.demo.gui.pages.desktop.CompareModelsPage;
import com.solvd.carina.web.components.footer.FooterMenu;
import com.solvd.carina.web.pages.gsmarena.common.AllBrandsPageBase;
import com.solvd.carina.web.pages.gsmarena.common.BrandModelsPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import com.solvd.carina.web.pages.gsmarena.common.HomePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(className = "news-column-index")
    private ExtendedWebElement newsColumn;

    @FindBy(xpath = "//table[@class='module-fit green']//tbody//th/a[contains(nobr, 'Samsung')]/nobr")
    private List<ExtendedWebElement> samsungDailyHits;

    @FindBy(xpath = "//a[@id='login-active']")
    private ExtendedWebElement loginButton;

    @FindBy(id = "footmenu")
    private FooterMenu footerMenu;

    @FindBy(xpath = "//span[text()='All brands']//parent::a")
    private ExtendedWebElement allBrandsButton;

    @FindBy(xpath = "//div[contains(@class, 'brandmenu-v2')]//a")
    private List<ExtendedWebElement> brandLinks;

    @FindBys({ @FindBy(xpath = "//p[contains(@class, 'pad')]"), @FindBy(xpath = ".//*[contains(@class, 'pad-single')]") })
    private ExtendedWebElement phoneFinderButton;

    public HomePage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(newsColumn);
    }

    @Override
    public FooterMenu getFooterMenu() {
        return footerMenu;
    }

    @Override
    public CompareModelsPage openComparePage() {
        return getFooterMenu().openComparePage();
    }

    @Override
    public BrandModelsPageBase selectBrand(String brand) {
        LOGGER.info("selecting '" + brand + "' brand...");
        for (ExtendedWebElement brandLink : brandLinks) {
            String currentBrand = brandLink.getText();
            LOGGER.info("currentBrand: " + currentBrand);
            if (brand.equalsIgnoreCase(currentBrand)) {
                brandLink.click();
                return initPage(driver, BrandModelsPageBase.class);
            }
        }
        throw new RuntimeException("Unable to open brand: " + brand);
    }

    public ExtendedWebElement getPhoneFinderButton() {
        return phoneFinderButton;
    }

    public AllBrandsPageBase openAllBrandsPage(){
        allBrandsButton.click();
        return initPage(driver, AllBrandsPageBase.class);
    }

    @Override
    public List<ExtendedWebElement> getSamsungDailyHits() {
        return samsungDailyHits;
    }

    public void login() {
        Actions actions = new Actions(getDriver());
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(loginButton.getElement()));
        loginButton.click();
    }
}
