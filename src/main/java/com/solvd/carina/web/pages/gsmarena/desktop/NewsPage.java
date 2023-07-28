package com.solvd.carina.web.pages.gsmarena.desktop;

import com.solvd.carina.web.components.NewsItem;
import com.solvd.carina.web.pages.gsmarena.common.NewsPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.Context;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = NewsPageBase.class)
public class NewsPage extends NewsPageBase {

    @FindBy(xpath = "//div[@class='search-band']")
    private ExtendedWebElement searchDiv;

    @Context(dependsOn = "searchDiv")
    @FindBy(xpath = ".//input[@type='text']")
    private ExtendedWebElement searchTextField;

    @Context(dependsOn = "searchDiv")
    @FindBy(xpath = ".//input[@type='submit']")
    private ExtendedWebElement searchButton;

    @FindBy(xpath = "//div[@class='news-item']")
    private List<NewsItem> news;

    public NewsPage(WebDriver driver) {
        super(driver);
        setPageURL("/news.php3");
    }

    @Override
    public List<NewsItem> searchNews(String q) {
        searchTextField.type(q);
        searchButton.click();
        return news;
    }

}
