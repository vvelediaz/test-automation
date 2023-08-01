package com.solvd.carina.web.components.gsmarena.footer;

import com.solvd.carina.demo.gui.pages.desktop.CompareModelsPage;
import com.solvd.carina.demo.gui.pages.desktop.HomePage;
import com.solvd.carina.demo.gui.pages.desktop.NewsPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class FooterMenu extends FooterMenuBase {

    @FindBy(linkText = "Home")
    private ExtendedWebElement homeLink;

    @FindBy(xpath = ".//a[contains(text(),'Compare')]")
    private ExtendedWebElement compareLink;

    @FindBy(linkText = "News")
    private ExtendedWebElement newsLink;

    public FooterMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public HomePage openHomePage() {
        homeLink.click();
        return new HomePage(driver);
    }

    public CompareModelsPage openComparePage() {
        compareLink.scrollTo();
        compareLink.hover();
        compareLink.click();
        return new CompareModelsPage(driver);
    }

    public NewsPage openNewsPage() {
        newsLink.scrollTo();
        newsLink.hover();
        newsLink.click();
        return new NewsPage(driver);
    }
}
