package com.techproed.tests;

import com.techproed.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day11_TestDriver {

    //Create FirstDriverTest
    //Check if Driver class is working
    // Go to amazon page
    //Verify the title includes Amazon
    //Check if Driver class is working
    //https://www.amazon.ca/

    @Test
    public void FirstDriverTest(){
        Driver.getDriver().get("https://www.amazon.ca/");
      String title =  Driver.getDriver().getTitle();
        Assert.assertTrue(title.contains("Amazon"));
        Driver.closeDriver();
    }

}
