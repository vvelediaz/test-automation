package com.solvd.carina.web.pages.gsmarena.common;

import com.solvd.carina.web.components.NewsItem;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

import java.util.List;

public abstract class NewsPageBase extends AbstractPage {

    public NewsPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract List<NewsItem> searchNews(String searchInput);

}
