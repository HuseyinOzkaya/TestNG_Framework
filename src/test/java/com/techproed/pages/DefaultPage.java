package com.techproed.pages;

import com.techproed.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

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
    @FindBy(partialLinkText = "Hotel List")
    public WebElement hotelList;
    @FindBy(xpath = "//select[@name='lkpGroups']")
    public WebElement selectHotelType; //Value=1 => Hotel Type2
                                        //Value=2 => Hotel Type1
    @FindBy(xpath = "//button[@class='btn btn-sm yellow filter-submit margin-bottom']")
    public WebElement searchButton;

    @FindBy(xpath="//tbody//tr//td[7]")
    public List<WebElement> IDGroupCells;

    @FindBy(xpath = "//*[.='Clear']")
    public WebElement clearButton;

    @FindBy(xpath = "//h3[@class='page-title']")
    public WebElement dateOnPage;

    @FindBy(xpath = "//select[@name='datatable_ajax_length']")
    public WebElement numberOfRecordsView;

    @FindBy(xpath = "//a[@title='Next']")
    public WebElement nextPageRecords;

    @FindBy(xpath = "//div[@class='pagination-panel']/input")
    public WebElement viewPageNumber;

    @FindBy(id= "btnExportTable")
    public WebElement downloadButton;

    @FindBy(xpath = "//tbody//tr[1]//td[8]")
    public WebElement firstHotel;



}
