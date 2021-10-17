package com.techproed.pages;

import com.techproed.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DefaultPage {
    public DefaultPage(){
        //PageFactory.initElements initialize this page object
        PageFactory.initElements(Driver.getDriver(),this);  //PageFactor comes from Selenium

    }

    @FindBy(linkText = "ADD USER")
    public WebElement addUser;
    @FindBy(xpath = "//span[.='Hotel Management']")
    public WebElement hotelManagementTab;
    @FindBy(partialLinkText = "Hotel Rooms")
    public WebElement hotelRoomsTab;
}
