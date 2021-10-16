package com.techproed.tests;


import org.testng.annotations.*;

public class Day10_TestNGAnnotation {
/**
 * @Test is used to create Test Cases on TestNG
 * @BeforeMethod is used to run Before each @Test annotation. Same as @Before is JUnit
 * @AfterMethod is used after each @Test annotation
 * @Ignore is used to skip a @Test annotation
 *.@Test(enabled = false) also skips the @Test annotation. This is similar to @Ignore
 *. @Test(priority =1)
 * Ordering the Test cases
 * TestNg executues the test cases based on alphabetical order- Not From Top to Buttom
 * We use priority to run specific order .
 *
 * Why would you need @BeforeMethod annotation?
 *  -Pre conditions - Creating driver, maximizing screen, time outs, .. To avoid repetition
 *
 *  Why would you need @AfterMethod annotation?
 *  -Post conditions -for closing the driver, to avoid repetition, report generation
 *
 *  Why would you need @Test annotation?
 *  -To create test case.
 *
 */

    @BeforeMethod
    public void setUp(){
        System.out.println("@BeforeMethod is used");
    }
    @AfterMethod
    public void tearDown(){
        System.out.println("@AfterMethod is used");
    }
    @Test(enabled = false)
    public void test1(){
        System.out.println("Test 1");
    }

    @Test(priority = 1)
    public void test6(){
        System.out.println("Test 2");
    }

    @Ignore
    @Test
    public void test3(){
        System.out.println("Test 3");
    }

    @Test(priority = 1)
    public void test4(){
        System.out.println("Test 4");
    }

    @Test(priority = -3)
    public void test5(){
        System.out.println("Test 5");
    }
    @Test
    public void test2(){
        System.out.println("Test 8");
    }
}
