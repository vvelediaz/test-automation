package com.solvd.carina.web;

import com.solvd.carina.web.pages.ebay.common.HomePageBase;
import com.solvd.carina.web.pages.ebay.common.SignInPageBase;
import com.zebrunner.carina.core.IAbstractTest;
import org.testng.Assert;

public interface ILogin extends IAbstractTest{
    default HomePageBase login() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        SignInPageBase signInPage = homePage.openSignInPage();
        Assert.assertTrue(signInPage.isPageOpened(), "Sign in page is not opened");

        return signInPage.signIn();
    }
}
