package com.techproed.pages.homework;

import com.techproed.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AdminPage {
    public AdminPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[.='Hotel Management']")
    public WebElement hotelMangButton;

    @FindBy(linkText = "Hotel List")
    public WebElement hotelList;

    @FindBy(id="lkpGroups")
    public WebElement idDropDown;

    @FindBy(xpath = "//*[.='Search']")
    public WebElement searchButton;

    @FindBy(xpath = "//tbody//tr//td[7]")
    public List<WebElement> idDropdownList;

    @FindBy(xpath = "//*[.='Clear']")
    public WebElement clearButton;

    @FindBy(xpath = "//h3[@class='page-title']")
    public WebElement dateOnThePage;



}
