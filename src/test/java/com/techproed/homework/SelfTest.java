package com.techproed.homework;

import com.techproed.pages.AdminPage;
import com.techproed.pages.DefaultPage;
import com.techproed.pages.LoginPage;
import com.techproed.utilities.Driver;
import com.techproed.utilities.ReusableMethods;
import org.testng.annotations.Test;

import java.util.Set;

public class SelfTest {
    AdminPage adminPage;
    LoginPage loginPage;
    DefaultPage defaultPage;
    @Test
    public void deneme(){

        Driver.getDriver().get("https://qa-environment.resortsline.com/admin/HotelAdmin");
        loginPage = new LoginPage();
        adminPage = new AdminPage();
        loginPage.advancedLink.click();
        ReusableMethods.waitFor(1);
        loginPage.advanceProceed.click();
        adminPage.userName.sendKeys("manager");
        adminPage.password.sendKeys("Manager1!");
        adminPage.login.click();
        defaultPage=new DefaultPage();
        defaultPage.firstHotelDetails.click();
        String currentWindow=Driver.getDriver().getWindowHandle();
        String nextWindow="";
        Set<String> allWindowsHandle = Driver.getDriver().getWindowHandles();
        for(String eachWindow:allWindowsHandle){
            if(eachWindow!=currentWindow){
                nextWindow=eachWindow;
            }

        }
        System.out.println(currentWindow);
        System.out.println(Driver.getDriver().getTitle());
        System.out.println(nextWindow);
        Driver.getDriver().switchTo().window(nextWindow);
        System.out.println(Driver.getDriver().getTitle());

    }
}
