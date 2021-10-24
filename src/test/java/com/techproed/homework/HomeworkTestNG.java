package com.techproed.homework;

import com.techproed.pages.DefaultPage;
import com.techproed.pages.LoginPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import com.techproed.utilities.ReusableMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class HomeworkTestNG {

    LoginPage loginPage;
    DefaultPage defaultPage;
    Select select;


    public void setUp() {
        Driver.getDriver().get(ConfigReader.getProperty("app_qa_environment"));
        loginPage = new LoginPage();
        loginPage.advancedLink.click();
        ReusableMethods.waitFor(1);
        loginPage.advanceProceed.click();
        loginPage.userName.sendKeys(ConfigReader.getProperty("manager_username"));
        loginPage.password.sendKeys(ConfigReader.getProperty("manager_password"));
        loginPage.submitButton.click();

    }

    @Test
    public void iDGroup() {
        setUp();
        defaultPage = new DefaultPage();
        defaultPage.hotelManagementTab.click();
        defaultPage.hotelList.click();
        ReusableMethods.waitFor(2);
        IDGroupCheck("2");
        IDGroupCheck("1");
        ReusableMethods.waitFor(1);
        defaultPage.clearButton.click();
        select = new Select(defaultPage.selectHotelType);
        ReusableMethods.waitFor(1);
        String clearButtonClicked = select.getFirstSelectedOption().getText();
        IDGroupCheck(clearButtonClicked);

    }

    @Test
    public void dateFormat(){
        setUp();
        defaultPage = new DefaultPage();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd MMMM yyyy");
        LocalDate currentDate = LocalDate.now();
        String expectedCurrentDate = dateFormat.format(currentDate);
        String actualCurrentDate = defaultPage.dateOnPage.getText();
        Assert.assertEquals(actualCurrentDate,expectedCurrentDate);
    }



    public void IDGroupCheck(String option) {
        List<WebElement> IDGroupColumn = defaultPage.IDGroupCells;
        List<String> allCells = new ArrayList<>();
        ReusableMethods.waitFor(1);

        if (option == "1" || option == "2") {
            select = new Select(defaultPage.selectHotelType);
            select.selectByValue(option);
            defaultPage.searchButton.click();
            ReusableMethods.waitFor(1);

            for (WebElement eachIDGroupCell : IDGroupColumn) {
                if (option == "2") {
                    Assert.assertTrue(!eachIDGroupCell.getText().contains("Hotel Type2"));
                } else if (option == "1") {
                    Assert.assertTrue(!eachIDGroupCell.getText().contains("Hotel Type1"));
                }
            }

        } else if (option.contains("Select Group...")) {
            for (WebElement selectEachIDGroupCell : IDGroupColumn) {
                allCells.add(selectEachIDGroupCell.getText());
            }
            Assert.assertTrue(allCells.contains("Hotel Type1") && allCells.contains("Hotel Type2"));
        }
    }



    @AfterMethod
    public void closeAfter(){
        Driver.closeDriver();
    }
}






