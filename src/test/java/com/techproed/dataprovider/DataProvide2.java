package com.techproed.dataprovider;

import com.techproed.pages.LoginPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import com.techproed.utilities.ReusableMethods;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvide2 {
    /*
    * Test the login functionality with manager crendentials
    * */


    @DataProvider
    public Object[][] getData(){

        String[][] managerProfile={
                {"manager", "Manager1!"},
                {"manager2", "Manager2!"},
                {"manager3", "Manager3!"}
        };
        return managerProfile;
    }

    LoginPage loginPage;
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



    }
}
