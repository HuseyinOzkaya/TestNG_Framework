package com.techproed.tests;

import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day11_FirstConfigTest {

    //In FirstConfigTest
    //Get url from config.properties file

    @Test
    public void firstConfigTest(){
        String url = ConfigReader.getProperty("app_url");
        Driver.getDriver().get(url);

        Assert.assertTrue(Driver.getDriver().getTitle().contains(ConfigReader.getProperty("app_title")));
    //    Driver.getDriver().get(ConfigReader.getProperty("app_url"));
        Driver.closeDriver();
    }

}
