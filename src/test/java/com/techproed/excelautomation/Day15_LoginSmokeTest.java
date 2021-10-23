package com.techproed.excelautomation;

import com.techproed.pages.DefaultPage;
import com.techproed.pages.LoginPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import com.techproed.utilities.ExcelUtil;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class Day15_LoginSmokeTest {
    //TASK:
    //Test the log in functionality of the application with different user profiles(admin, manager, customer services, end user)
    //Test Data  URL : https://qa-environment.resortsline.com/Account/Logon
    //User Credentials : Excel Sheet


    //STEPS:
    //Prepare the test data:
    //Add url in config properties
    //Add smoke test excel sheet in the resources
    //Create your automation scrips
    //Java class : LoginSmokeTest
    //Methods   : adminLoginTest
    //Methods   : managerLoginTest

    //creating ExcelUtil object
    ExcelUtil excelUtil;

    //Get the data (username, password) as key-value pairs
    //I will use testData to store username-password values
    //Map<String, String> : {manager, Manager1!}
    List<Map<String ,String >> testData;

    //Page Object
    LoginPage loginPage;
    DefaultPage defaultPage;

    public void setUp(){
        Driver.getDriver().get(ConfigReader.getProperty("app_qa_environment"));
        loginPage = new LoginPage();
//        if(loginPage.advancedLink.isDisplayed()) {
//            loginPage.advancedLink.click();
//            loginPage.advanceProceed.click();
//        }
        try{
            loginPage.advancedLink.click();
            loginPage.advanceProceed.click();
        }catch (Exception e){
            System.out.println("Advanced Link and Proceed Link is not displayed");
        }

    }

    @Test
    public void adminLoginTest(){

        String path ="./src/test/java/resources/smoketestdata.xlsx";
        String sheetName ="admin_login_info";
        excelUtil = new ExcelUtil(path,sheetName);

        testData = excelUtil.getDataList();
        System.out.println(testData);

        for(Map<String,String> eachData: testData){
            setUp();
            loginPage.userName.sendKeys(eachData.get("username"));
            loginPage.password.sendKeys(eachData.get("password"));
            loginPage.submitButton.click();
        }




        //setUp is used to log the application page
//        setUp();

//        loginPage.userName.sendKeys("manager");
//        loginPage.password.sendKeys("Manager1!");
//        loginPage.submitButton.click();


    }


    @Test
    public void managerLoginTest(){

        String path ="./src/test/java/resources/smoketestdata.xlsx";
        String sheetName ="manager_login_info";
        excelUtil = new ExcelUtil(path,sheetName);

        testData = excelUtil.getDataList();
        System.out.println(testData);

        for(Map<String,String> eachData: testData){
            setUp();
            loginPage.userName.sendKeys(eachData.get("username"));
            loginPage.password.sendKeys(eachData.get("password"));
            loginPage.submitButton.click();
        }

    }
    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }


}
