package com.techproed.tests;

import com.github.javafaker.Faker;
import com.techproed.pages.DefaultPage;
import com.techproed.pages.HotelRoomsPage;
import com.techproed.pages.LoginPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.SQLOutput;
import java.util.List;

public class Day13_WebTables {

    //Create a class: WebTables
    //Create a method: login()
    //Log in https://www.carettahotel.com/
    ////Click on Hotel Management
    ////Click on Hotel Rooms

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
        defaultPage.hotelManagementTab.click();
        defaultPage.hotelRoomsTab.click();


    }

    @Test
    public  void entireTable(){
        //Create a test method: entireTable() and Find the size of the entire table body and print all of headers
        System.out.println("*Entire Table*");
        System.out.println("*Table Body*");
       WebElement allTable = Driver.getDriver().findElement(By.xpath("//table//tbody"));
        System.out.println(allTable.getText());

        List<WebElement> allHeaders = Driver.getDriver().findElements(By.xpath("//th"));

        System.out.println("Headers : ");
        for (WebElement eachHeaer:allHeaders){
            System.out.println(eachHeaer.getText());
        }
        System.out.println("Number of headers : " + allHeaders.size());

        //Create a test method: printRows() and Print all of the rows and print the element s on the 4th row


    }


    @Test
    public void printRows(){
        //        Create a test method: printRows() and Print all of the rows and print the element s on the 4th row
        System.out.println("*Print Rows*");
        List<WebElement> allRows = Driver.getDriver().findElements(By.xpath("//tbody//tr"));
        //row numbers
        int rowNum=1;
        for (WebElement eachRow : allRows){
            System.out.println("Row Number "+rowNum + " => "+eachRow.getText());
            rowNum++;
        }

        //Print row4 only
        WebElement row4 = Driver.getDriver().findElement(By.xpath("//tbody//tr[4]"));
        System.out.println("ROW 4 => "+row4.getText());
    }




//Create a test method: printCells() and a the total number of cells in the table body and print all of the cells

    @Test
    public void printCells(){
        System.out.println("-------------------------------------------");
        System.out.println("*Print Cells*");
        List<WebElement> allCells = Driver.getDriver().findElements(By.xpath("//tbody//td"));
        System.out.println("all cells in the table are : "+allCells.size());
        int cellNum =0;
        for(WebElement eachCell:allCells){
            System.out.println(eachCell.getText());
            cellNum++;
        }
        System.out.println("Total count : "+cellNum);
    }

    //Create a test method: printColumns() and print Find the total number of columns and Print the elements of the 5th column

    @Test
    public void printColumns(){
        List<WebElement> allHeaders = Driver.getDriver().findElements(By.xpath("//th"));
        System.out.println("Number of headers : " + allHeaders.size());
        int columnNum =1;
        List<WebElement> fifthColumAll = Driver.getDriver().findElements(By.xpath("//table//tbody//tr//td[5]"));
        for(WebElement eachFifthColumn:fifthColumAll){
            System.out.println("Data " +columnNum + ": "+ eachFifthColumn.getText());
            columnNum++;
        }


    }


    //Create a test method: printData(int row, int column); This method should print the given cell. Example: printData(2,3); should print 2nd row,3rd column


    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }

}
