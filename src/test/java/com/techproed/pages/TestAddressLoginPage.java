package com.techproed.pages;

import com.techproed.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//http://a.testaddressbook.com/sign_in
//10:51
//http://a.testaddressbook.com/sign_in
//Create the page objects in page classes.
//We can create major page specific method such as logIn method
//Create Test Classes and use page objects or methods in the test classes
public class TestAddressLoginPage {
    /*This is the page class
    * This will have only page objects and main important methods*/

    //1. Create constructor

    public TestAddressLoginPage(){
        //PageFactory.initElements initialize this page object
        PageFactory.initElements(Driver.getDriver(),this);  //PageFactor comes from Selenium

    }

    //2. Create page object
    //NOTE: we can locate using 8 locators
    @FindBy(id="session_email")
    public WebElement email;

    @FindBy(xpath="//input[@type='password']")
    public WebElement password;

    @FindBy(xpath="//input[@type='submit']")
    public WebElement SignInButton;





}
