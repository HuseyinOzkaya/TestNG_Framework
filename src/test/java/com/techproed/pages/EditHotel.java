package com.techproed.pages;

import com.techproed.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditHotel {
   public EditHotel(){
       PageFactory.initElements(Driver.getDriver(), this);
   }
   @FindBy(id = "Code")
    public WebElement generalCodeBox;

   @FindBy(xpath = "(//*[.='Save'])[2]")
    public WebElement saveButton;

   @FindBy(xpath = "//div[@class='bootbox-body']")
    public WebElement successMessage;

   @FindBy(linkText = "Properties")
    public WebElement propertiesTab;

    @FindBy(id = "product_barcodeCode_84")
    public WebElement propertiesCodeBox;

    @FindBy(xpath = "(//tbody//tr[1]//td[6]//a[2])")
    public WebElement propertiesFirstRowUpdate;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    public WebElement okButton;

    @FindBy(id = "btnDelete")
    public WebElement deleteButton;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    public WebElement confirmDeleteButton;

    @FindBy(xpath = "//*[.='Would you like to continue?']")
    public WebElement deleteConfirmMessage;

    @FindBy(xpath = "//div[contains(text(),'Error:')]")
    public WebElement errorMessage;





}
