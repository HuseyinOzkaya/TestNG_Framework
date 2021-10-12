package com.techproed.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class Day10_Soft_Assertion {


        WebDriver driver;
        @BeforeMethod
        public void setUp(){

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }

        @Test
        public void softAssert(){

            /**
             * When user goes to the application home page
             * then verifies the title equals Caretta Hotel - Home
             * and clicks on login button
             * then verify the page title equals Caretta Hotel - Login
             */
            driver.get("http://www.carettahotel.com/");
            SoftAssert softAssert = new SoftAssert();
            softAssert.assertTrue(driver.getTitle().equals("Caretta Hotel"));
            //if above test case fails it con not execute rest of it. Hard Assertion

            driver.findElement(By.linkText("Log in")).click();
            softAssert.assertTrue(driver.getTitle().equals("Caretta Hotel - Log in"));

            softAssert.assertAll();
        }



        @AfterMethod
        public void tearDown(){

        }
}
