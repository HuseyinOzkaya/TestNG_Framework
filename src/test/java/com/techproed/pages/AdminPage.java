package com.techproed.pages;

import com.techproed.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminPage {
    public AdminPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy (id = "UserName")
    public WebElement userName;

    @FindBy(id="Password")
    public WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement login;






}
