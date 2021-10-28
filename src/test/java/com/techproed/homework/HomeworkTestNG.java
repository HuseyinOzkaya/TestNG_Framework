package com.techproed.homework;

import com.techproed.pages.DefaultPage;
import com.techproed.pages.EditHotel;
import com.techproed.pages.LoginPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import com.techproed.utilities.ReusableMethods;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class HomeworkTestNG {

    LoginPage loginPage;
    DefaultPage defaultPage;
    EditHotel editHotel;
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
        defaultPage = new DefaultPage();
        defaultPage.hotelManagementTab.click();
        defaultPage.hotelList.click();



    }

    @Test
    public void iDGroupTestSorting() {
        setUp();
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
    public void dateFormatTest(){
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd MMMM yyyy");
        LocalDate currentDate = LocalDate.now();
        String expectedCurrentDate = dateFormat.format(currentDate);
        String actualCurrentDate = defaultPage.dateOnPage.getText();
        Assert.assertEquals(actualCurrentDate,expectedCurrentDate);
    }

@Test
public void viewRecordTest(){
        Select select = new Select(defaultPage.numberOfRecordsView);
        int sizeDefaultValue = defaultPage.IDGroupCells.size();
        Assert.assertEquals(sizeDefaultValue,10);

        select.selectByValue("20");
        ReusableMethods.waitFor(1);
        int size20RecordSelected = defaultPage.IDGroupCells.size();
        Assert.assertEquals(size20RecordSelected,20);

        defaultPage.nextPageRecords.click();
        ReusableMethods.waitFor(1);
        Assert.assertEquals(defaultPage.viewPageNumber.getAttribute("value"),"2");
}

        @Test
        public void isDownloadedTest(){
            defaultPage.downloadButton.click();
            String path = System.getProperty("user.home")+"/Downloads/Admin - List Of Hotels.xlsx";
            ReusableMethods.waitFor(2);
            boolean isExcelDownloaded = Files.exists(Paths.get(path));
            Assert.assertTrue(isExcelDownloaded);

        }


        @Test //US10000
        public void checkDetailsPageTest(){
            defaultPage.firstHotelDetails.click();
            String currentWindowHandle = Driver.getDriver().getWindowHandle();
            String nextWindowHandle = windowHandle(currentWindowHandle);

            Driver.getDriver().switchTo().window(nextWindowHandle);
            Assert.assertEquals(Driver.getDriver().getTitle(),"Admin - Edit Hotel");
        }

    @Test //US10001
    public void changeHotelCodeTest(){
        defaultPage.firstHotelDetails.click();
        String currentWindowHandle = Driver.getDriver().getWindowHandle();
        String nextWindowHandle = windowHandle(currentWindowHandle);
        Driver.getDriver().switchTo().window(nextWindowHandle);
        editHotel = new EditHotel();
        editHotel.generalCodeBox.clear();
        editHotel.generalCodeBox.sendKeys("5555"+ Keys.RETURN);
        ReusableMethods.waitFor(1);
        Assert.assertTrue(editHotel.successMessage.isDisplayed());

    }


    @Test //US10002
    public void changePropertiesTabTest(){
        defaultPage.firstHotelDetails.click();
        String currentWindowHandle = Driver.getDriver().getWindowHandle();
        String nextWindowHandle = windowHandle(currentWindowHandle);
        Driver.getDriver().switchTo().window(nextWindowHandle);
        editHotel = new EditHotel();
       editHotel.propertiesTab.click();
       editHotel.propertiesCodeBox.clear();
       editHotel.propertiesCodeBox.sendKeys("1980");
       editHotel.propertiesFirstRowUpdate.click();
       ReusableMethods.waitFor(1);
       Assert.assertTrue(editHotel.successMessage.isDisplayed());
       editHotel.okButton.click();
       editHotel.deleteButton.click();
       ReusableMethods.waitFor(1);
        Assert.assertTrue(editHotel.deleteConfirmMessage.isDisplayed());
        editHotel.confirmDeleteButton.click();
        ReusableMethods.waitFor(1);
        Assert.assertTrue(editHotel.errorMessage.isDisplayed());


    }

public String windowHandle(String currentWindowHandle){
    String nextWindowHandle="";
    Set<String> windows = Driver.getDriver().getWindowHandles();
    for(String handle:windows){
        if(!(handle==currentWindowHandle)){
            nextWindowHandle = handle;
        }
    }
    return nextWindowHandle;
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






