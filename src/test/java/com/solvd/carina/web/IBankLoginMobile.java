package com.solvd.carina.web;

import com.solvd.carina.web.pages.parabank.common.HomePageBase;
import com.solvd.carina.web.pages.parabank.common.OverviewPageBase;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.lang.invoke.MethodHandles;

public interface IBankLoginMobile extends IAbstractTest, IMobileUtils {
    static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    default OverviewPageBase login(){
        LOGGER.info(getDriver().toString());
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        LOGGER.info(homePage.toString());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        OverviewPageBase overviewPage = homePage.login();
        Assert.assertTrue(overviewPage.isPageOpened(), "Overview page is not opened");
        return overviewPage;
    }
}