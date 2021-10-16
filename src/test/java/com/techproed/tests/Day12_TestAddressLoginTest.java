package com.techproed.tests;
/**
 * http://a.testaddressbook.com/sign_in
 * 10:51
 * http://a.testaddressbook.com/sign_in
 * Create the page objects in page classes.
 * We can create major page specific method such as logIn method
 * Create Test Classes and use page objects or methods in the test classes
 */

//We created TestAddressLoginPage class in pages for this process.

import com.techproed.pages.TestAddressLoginPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.testng.annotations.Test;

public class Day12_TestAddressLoginTest {

    @Test
    public void testAddressLogin(){
        //Going to the application page
       // Driver.getDriver().get("http://a.testaddressbook.com/sign_in");
        //  testAddressLoginPage.email.sendKeys("testtechproed@gmail.com");
        //  testAddressLoginPage.password.sendKeys("Test1234!");

        Driver.getDriver().get(ConfigReader.getProperty("test_address_url"));

        //Creating paobject
        TestAddressLoginPage testAddressLoginPage = new TestAddressLoginPage();

        //Signing in

        testAddressLoginPage.email.sendKeys(ConfigReader.getProperty("test_address_email"));
        testAddressLoginPage.password.sendKeys(ConfigReader.getProperty("test_address_password"));
        testAddressLoginPage.SignInButton.click();

        Driver.closeDriver();
    }
}
