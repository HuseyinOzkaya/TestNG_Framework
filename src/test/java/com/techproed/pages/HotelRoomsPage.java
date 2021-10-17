package com.techproed.pages;

import com.techproed.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HotelRoomsPage {
    public HotelRoomsPage(){
        //PageFactory.initElements initialize this page object
        PageFactory.initElements(Driver.getDriver(),this);  //PageFactor comes from Selenium

    }

    @FindBy(partialLinkText = "ADD HOTELROOM")
    public WebElement addHotelRoomLink;

    @FindBy(id = "IDHotel")
    public WebElement idDropdown;

    @FindBy(id="Code")
    public WebElement code;

    @FindBy(id="Name")
    public WebElement name;

    @FindBy(id="Location")
    public WebElement location;

    @FindBy(xpath = "//*[@role='textbox']")
    public WebElement description;

    @FindBy(id="Price")
    public WebElement price;

    @FindBy(id="IDGroupRoomType")
    public WebElement roomTypeDropdown;

    @FindBy(id="MaxAdultCount")
    public WebElement maxAdultCount;

    @FindBy(id="MaxChildCount")
    public WebElement maxChildCount;

    @FindBy(id="IsAvailable")
    public WebElement isApproved;

    @FindBy(id="btnSubmit")
    public WebElement saveRoom;

    @FindBy(xpath = "//div[@class='bootbox-body']")
    public WebElement verify;


    @FindBy(xpath = "//button[@class='btn btn-primary']")
    public WebElement verifyOk;

}
