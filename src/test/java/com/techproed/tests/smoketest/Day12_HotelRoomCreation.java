package com.techproed.tests.smoketest;
import com.github.javafaker.Faker;
import com.techproed.pages.DefaultPage;
import com.techproed.pages.HotelRoomsPage;
import com.techproed.pages.LoginPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class Day12_HotelRoomCreation {
    LoginPage loginPage;
    DefaultPage defaultPage;
    HotelRoomsPage hotelRoomsPage;
    Faker faker = new Faker();

    @BeforeMethod
    public void setUp() {
        Driver.getDriver().get(ConfigReader.getProperty("app_url_login"));
        loginPage = new LoginPage();
        loginPage.userName.sendKeys(ConfigReader.getProperty("manager_username"));
        loginPage.password.sendKeys(ConfigReader.getProperty("manager_password"));
        loginPage.submitButton.click();
        //asserting login success
        defaultPage = new DefaultPage();
        Assert.assertTrue(defaultPage.addUser.isDisplayed());

    }

    @Test
    public void hotelRoomCreate() throws InterruptedException {
//Click on Hotel Management
        defaultPage.hotelManagementTab.click();
//Click on Hotel Rooms
        defaultPage.hotelRoomsTab.click();
//Click on Add Hotel Room
        hotelRoomsPage = new HotelRoomsPage();
        hotelRoomsPage.addHotelRoomLink.click();
//Enter All required fields
        //ID IS DROPDOWN
        Select select = new Select(hotelRoomsPage.idDropdown);
        select.selectByIndex(2);
        //Code
        hotelRoomsPage.code.sendKeys("discount code");
        //Name
        hotelRoomsPage.name.sendKeys(faker.name().fullName());
        //Location
        hotelRoomsPage.location.sendKeys(faker.address().city());
        //Description
        hotelRoomsPage.description.sendKeys(faker.company().name());
        //Price
        hotelRoomsPage.price.sendKeys(faker.number().digits(4));
        //RoomType
        Select selectRoom = new Select(hotelRoomsPage.roomTypeDropdown);
        selectRoom.selectByVisibleText("King");

        //MaxAdultCount
        hotelRoomsPage.maxAdultCount.sendKeys("2");

        //MaxChildrenCount
        hotelRoomsPage.maxChildCount.sendKeys("2");

        //isApproved
        if(!hotelRoomsPage.isApproved.isSelected()) {
            hotelRoomsPage.isApproved.click();
        }

        //Save
        hotelRoomsPage.saveRoom.click();

        //Explicit Wait

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
        WebElement popupMessageElement = wait.until(ExpectedConditions.visibilityOf(hotelRoomsPage.verify));
        //verify
        Assert.assertTrue(popupMessageElement.isDisplayed());



        //Click Ok
        hotelRoomsPage.verifyOk.click();



//To enter a price, we can send keys, OR we can use actions class to drag and drop
//Click Save
//Verify the message: HotelRoom was inserted successfully
//Click OK
    }
}