package com.techproed.tests.smoketest;

import com.techproed.pages.DefaultPage;
import com.techproed.pages.LoginPage;
import com.techproed.pages.MainPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class Day12_NegativeLoginTest {

    @Test
    public void negativeLoginTest(){

        Driver.getDriver().get(ConfigReader.getProperty("app_url"));

        //1. create page objects -MainPage,LoginPage-DONE
        /*2. create test class
        - Create Page Objects
               --create MainPage Object
         */
        MainPage mainPage = new MainPage();
        mainPage.mainPageLoginButton.click();

        //At this point we are on the LoginPage
        //Create LoginPage object
        LoginPage loginPage = new LoginPage();
        loginPage.userName.sendKeys(ConfigReader.getProperty("manager_username"));
        loginPage.password.sendKeys("Admin1");
        loginPage.submitButton.click();



        boolean isLoggedIn = loginPage.errorMessage.isDisplayed();
        Assert.assertTrue(isLoggedIn);
        //Assert.assertTrue(defaultPage.addUser.getText().contains("USER ADD"));

    }

    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }
}
