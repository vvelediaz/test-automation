package com.solvd.carina.web;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.solvd.carina.web.pages.ebay.common.*;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.zebrunner.carina.core.IAbstractTest;

public class EbayTest implements IAbstractTest{
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test
    public void getCategoriesTest() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        CarAndTruckPartsPageBase carsAndTrucksPage = homePage.openCarsAndTrucksPage();
        Assert.assertTrue(carsAndTrucksPage.isPageOpened(), "Cars and Trucks page is not opened");

        List<String> categoriesString = new ArrayList<>();
        categoriesString.add("Exterior");
        categoriesString.add("Interior");
        categoriesString.add("Engines & Engine Parts");
        categoriesString.add("Steering & Suspension");
        categoriesString.add("Wheels, Tires & Parts");
        categoriesString.add("Lighting & Lamps");
        categoriesString.add("Air & Fuel Delivery");
        categoriesString.add("Brakes & Brake Parts");
        categoriesString.add("Transmission & Drivetrain");
        categoriesString.add("Engine Cooling Components");
        categoriesString.add("Exhaust & Emission Systems");
        categoriesString.add("Starters, Alternators, ECUs & Wiring");
        categoriesString.add("Ignition Systems & Components");
        categoriesString.add("Air Conditioning & Heating");
        categoriesString.add("Towing Parts & Accessories");

        List<String> textList = carsAndTrucksPage.getCategories().stream()
                .map(ExtendedWebElement::getText)
                .peek(LOGGER::info)
                .collect(Collectors.toList());

        Assert.assertEquals(textList, categoriesString);
    }

    @Test
    public void printAllBMWCompressorPrices(){
        BMWCompressorsPageBase bmwCompressorsPage = initPage(getDriver(), BMWCompressorsPageBase.class);
        bmwCompressorsPage.open();
        Assert.assertTrue(bmwCompressorsPage.isPageOpened(), "BMW Compressors page is not opened");

        List<String> prices = bmwCompressorsPage.getPrices().stream()
                .map(ExtendedWebElement::getText)
                .peek(LOGGER::info)
                .collect(Collectors.toList());
        Assert.assertEquals(prices.size(), 48, "Not all prices were acquired");
    }

    @Test
    public void printDevices(){
        ProductSearchPageBase mobilePhonePage = initPage(getDriver(), ProductSearchPageBase.class);
        mobilePhonePage.open();
        Assert.assertTrue(mobilePhonePage.isPageOpened(), "Mobile Phone page is not opened");

        for(ExtendedWebElement element : mobilePhonePage.getItemsPrice()){
            String text = element.getText();;
            try {
                LOGGER.info(text.substring(0, text.indexOf("\n")));
            }catch (Exception e){
                continue;
            }

        }
    }

    @Test
    public void signInAndViewSpotlightDealTest(){
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        SignInPageBase signInPage = homePage.openSignInPage();
        Assert.assertTrue(signInPage.isPageOpened(), "Sign in page is not opened");

        homePage = signInPage.signIn();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        DailyDealsPageBase dailyDealsPage = homePage.openDailyDealsPage();
        Assert.assertTrue(dailyDealsPage.isPageOpened(), "Daily Deals page is not opened");

        ProductPageBase productPage = dailyDealsPage.openProductPage();
        Assert.assertTrue(productPage.isPageOpened(), "Product page is not opened");
    }

    @Test
    public void signInAndViewMessages(){
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        homePage.openSignInPage();

        SignInPageBase signInPage = initPage(getDriver(), SignInPageBase.class);
        Assert.assertTrue(signInPage.isPageOpened(), "Sign in page is not opened");

        signInPage.signIn();
        homePage = initPage(getDriver(), HomePageBase.class);
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        AccountSettingsPageBase accountSettingsPage = homePage.openAccountSettingsPage();
        Assert.assertTrue(accountSettingsPage.isPageOpened(), "Account Settings page is not opened");

        MessagesPageBase messagesPage = accountSettingsPage.openMessagesPage();
        Assert.assertTrue(messagesPage.isPageOpened(), "Messages page is not opened");
        Assert.assertEquals(messagesPage.getFirstMessageSubject(), "A new device is using your account", "Message subject is not correct");
    }

    @Test
    public void signAndAddIphoneToCart(){
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        SignInPageBase signInPage = homePage.openSignInPage();
        Assert.assertTrue(signInPage.isPageOpened(), "Sign in page is not opened");

        homePage = signInPage.signIn();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        ProductSearchPageBase iPhoneSearchPage = homePage.searchProduct("iphone 14");
        Assert.assertTrue(iPhoneSearchPage.isPageOpened(), "Mobile Phone page is not opened");

        ProductPageBase productPage = iPhoneSearchPage.openFirstProductPage();
        Assert.assertTrue(productPage.isPageOpened(), "Product page is not opened");

        productPage.addToCart();

    }
}

