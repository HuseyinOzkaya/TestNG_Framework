package com.techproed.pages.homework;

import com.techproed.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    public MainPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "details-button")
    public WebElement advancedButton;

    @FindBy(partialLinkText = "unsafe")
    public WebElement advancedProceed;

    @FindBy(id = "UserName")
    public WebElement userName;

    @FindBy(id = "Password")
    public WebElement password;

    @FindBy(xpath = "//input[@id='btnSubmit']")
    public WebElement loginButton;



}
