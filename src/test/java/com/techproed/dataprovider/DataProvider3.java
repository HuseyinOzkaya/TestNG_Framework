package com.techproed.dataprovider;

import com.techproed.pages.DefaultPage;
import com.techproed.pages.LoginPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import com.techproed.utilities.ExcelUtil;
import com.techproed.utilities.ReusableMethods;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider3 {
    /*Test the login functionality with manager profile using EXCEL AND DATA PROVIDER
    * We will use EXCEL for storing the test data
    * We will use DATAPROVIDER dor PASSING THE DATA
    * DATAPROVIDER WILL BE LIKE A BRIDGE BETWEEN EXCEL AND TEST CLASS
    * We are using DataProvider because it ise easier to get the data from excel with data provider*/




    @DataProvider
    public Object[][] getData(){
        String path = "./src/test/java/resources/smoketestdata.xlsx";
        String sheetName = "manager_login_info";
        ExcelUtil excelUtil = new ExcelUtil(path,sheetName);
        Object[][] managerProfile = excelUtil.getDataArrayWithoutFirstRow();





//        String[][] managerProfile={
//                {"manager", "Manager1!"},
//                {"manager2", "Manager2!"},
//                {"manager3", "Manager3!"}
//        };
        return managerProfile;
    }

    LoginPage loginPage;
    DefaultPage defaultPage;


    public void setUp() {
        loginPage = new LoginPage();
        Driver.getDriver().get(ConfigReader.getProperty("app_qa_environment"));
        try {
            ReusableMethods.waitFor(1);
            loginPage.advancedLink.click();
            ReusableMethods.waitFor(1);
            loginPage.advanceProceed.click();
        } catch (Exception e) {
            System.out.println("Unable to find the link");


        }
    }
    @Test(dataProvider = "getData")
    public void managerLoginTest(String managerID, String managerPass){
        setUp();
        loginPage.userName.sendKeys(managerID);
        loginPage.password.sendKeys(managerPass);
        loginPage.submitButton.click();
        ReusableMethods.waitFor(1);
        defaultPage = new DefaultPage();
        Assert.assertTrue(defaultPage.addUser.getText().equals("ADD USER"));



    }
}
