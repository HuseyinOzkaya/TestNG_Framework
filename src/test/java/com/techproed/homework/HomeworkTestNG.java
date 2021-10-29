package com.techproed.homework;

import com.techproed.pages.homework.AdminPage;
import com.techproed.pages.homework.MainPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import com.techproed.utilities.ReusableMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class HomeworkTestNG {

    MainPage mainPage ;
    AdminPage adminPage;
  @BeforeMethod
    public void setUp(){
        Driver.getDriver().get(ConfigReader.getProperty("app_qa_environment"));
        mainPage = new MainPage();
        adminPage = new AdminPage();
        mainPage.advancedButton.click();
        mainPage.advancedProceed.click();
        mainPage.userName.sendKeys(ConfigReader.getProperty("manager_username"));
        mainPage.password.sendKeys(ConfigReader.getProperty("manager_password"));
        mainPage.loginButton.click();
        adminPage.hotelMangButton.click();
        adminPage.hotelList.click();


    }

    @Test
    public void iDGroupDropDownTest(){
      adminPage = new AdminPage();
      Select select = new Select(adminPage.idDropDown);
      select.selectByValue("2"); //Hotel 1
        adminPage.searchButton.click();
        ReusableMethods.waitFor(2);

        for (WebElement eachCell : adminPage.idDropdownList){
            Assert.assertFalse(eachCell.getText().contains("Hotel Type2"));
        }

        select.selectByValue("1");
        adminPage.searchButton.click();

        ReusableMethods.waitFor(2);

        for (WebElement eachCell : adminPage.idDropdownList){
            Assert.assertFalse(eachCell.getText().contains("Hotel Type1"));
        }

        adminPage.clearButton.click();
        ReusableMethods.waitFor(1);

        List<String> allElement = new ArrayList<>();
        for (WebElement eachCell : adminPage.idDropdownList){
            allElement.add(eachCell.getText());
        }
        Assert.assertTrue(allElement.contains("Hotel Type1") &&
                            allElement.contains("Hotel Type2"));

    }

    @Test
    public void DateTest(){
      adminPage = new AdminPage();
      String actualDate = adminPage.dateOnThePage.getText();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");
        LocalDate currentDate = LocalDate.now(); // Zone isleme dahil etme
        String expectedDate = dateTimeFormatter.format(currentDate);
        System.out.println(actualDate);
        System.out.println(expectedDate);
        Assert.assertEquals(expectedDate,actualDate);
  }



}
