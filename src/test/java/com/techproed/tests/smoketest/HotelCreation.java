package com.techproed.tests.smoketest;

import com.techproed.pages.DefaultPage;
import com.techproed.pages.HotelRoomsPage;
import com.techproed.pages.LoginPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HotelCreation {

    LoginPage kayit;
    DefaultPage defaul;
    HotelRoomsPage room;

    @BeforeMethod
    public void setUp(){
        Driver.getDriver().get(ConfigReader.getProperty("app_url_login"));
        kayit.userName.sendKeys(ConfigReader.getProperty("manager_username"));
        kayit.password.sendKeys(ConfigReader.getProperty("manager_password"));
        kayit.submitButton.click();

        defaul = new DefaultPage();
        Assert.assertTrue(defaul.addUser.isDisplayed());
    }

    @Test
    public void roomTest(){

    }



}
