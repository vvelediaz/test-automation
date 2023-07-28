package com.solvd.carina.web;

import com.solvd.carina.demo.gui.pages.common.ModelInfoPageBase;
import com.solvd.carina.web.pages.gsmarena.common.BrandModelsPageBase;
import com.solvd.carina.web.pages.gsmarena.common.HomePageBase;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.lang.invoke.MethodHandles;
import java.util.List;

public class GSMArenaTest implements IAbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test
    public void getSamsungDailyHits() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        List<ExtendedWebElement> samsungDailyHits = homePage.getSamsungDailyHits();
        for(ExtendedWebElement dailyHit : samsungDailyHits) {
            LOGGER.info(dailyHit.getText());
            Assert.assertTrue(dailyHit.getText().contains("Samsung"), "Samsung is not in the title");
        }
    }
}
