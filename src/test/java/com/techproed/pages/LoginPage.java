package com.techproed.pages;

import com.techproed.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage(){

        //PageFactory.initElements initialize this page object
        PageFactory.initElements(Driver.getDriver(),this);  //PageFactor comes from Selenium


    }
    @FindBy(id = "UserName")
    public WebElement userName;

    @FindBy(id = "Password")
    public WebElement password;

    @FindBy(id ="btnSubmit")
    public WebElement submitButton;

    @FindBy(id = "details-button")
    public WebElement advancedLink;

    @FindBy(id="proceed-link")
    public WebElement advanceProceed;

}
