package com.vodrive.examveda;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParallelTestB {




    public static RemoteWebDriver driver;
    public static String appURL = "http://www.facebook.com";


    @BeforeClass
    @Parameters({"browser"})
    public void setUp(String browser, ITestContext context) throws Exception{
        //System.out.println("*******************PTB");
        driver = Browser.getDriver(browser);
        context.setAttribute("WebDriver", driver);
        driver.manage().window().maximize();
    }


    @Test(priority = 1,enabled = true)
    //@Parameters({"browser"})
    public void testPageTitleB1() throws Exception{
        //System.out.println("*******************");
//        driver = Browser.getDriver(browser);
//        driver.manage().window().maximize();
        driver.navigate().to("http://www.facebook.com");
        //Thread.sleep(5000);
        String strPageTitle = driver.getTitle();
        System.out.println("Facebook : "+strPageTitle);
        try{
            Assert.assertTrue(strPageTitle.contains("YouTube"), "Facebook : Page title doesn't match : "+strPageTitle);
        }catch (Exception e){
            System.out.println(e);
        }
        //Thread.sleep(4000);
        //driver.quit();
    }

    @Test(priority = 2,enabled = true)
    //@Parameters({"browser"})
    public void testPageTitleB2() throws Exception{
        //System.out.println("*******************");
//        driver = Browser.getDriver(browser);
        //driver.manage().window().maximize();
        driver.navigate().to("http://www.amazon.com");
        //Thread.sleep(5000);
        String strPageTitle = driver.getTitle();
        System.out.println("Amazon : "+strPageTitle);
        try{
            Assert.assertTrue(strPageTitle.contains("Facebook"), "Amazon : Page title doesn't match : "+strPageTitle);
        }catch (Exception e){
            System.out.println(e);
        }
       // Thread.sleep(5000);
        //driver.quit();
    }


    @AfterClass
    public void tearDown(){
        if(driver!=null) {
            System.out.println("Closing browser");
            driver.quit();
        }
    }


}
