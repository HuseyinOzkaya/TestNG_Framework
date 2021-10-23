package com.techproed.javascriptexecuter;

import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import com.techproed.utilities.JSUtils;
import com.techproed.utilities.ReusableMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JSUtilTest {

    @Test
    public void scroolIntoView(){
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));

        WebElement resentBlog=Driver.getDriver().findElement(By.xpath("//*[.='Recent Blog']"));
        JSUtils.scrollIntoViewJS(resentBlog);
        ReusableMethods.waitFor(1);
        Assert.assertTrue(resentBlog.isDisplayed());
    }


    @Test
    public void clickWithJs(){
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
        WebElement checkAvailabilityButton = Driver.getDriver().findElement(By.xpath("//input[@type='submit']"));
        JSUtils.clickElementByJS(checkAvailabilityButton);
    }

    @Test
    public void flashJS(){   //check colour
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
        WebElement checkAvailabilityButton = Driver.getDriver().findElement(By.xpath("//input[@type='submit']"));
        JSUtils.flash(checkAvailabilityButton);
    }


    @Test
    public void changeColorJS(){   //check colour
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
        WebElement checkAvailabilityButton = Driver.getDriver().findElement(By.xpath("//input[@type='submit']"));
        JSUtils.changeColor("red",checkAvailabilityButton);
    }
}
