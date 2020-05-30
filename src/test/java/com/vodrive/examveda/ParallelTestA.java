package com.vodrive.examveda;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParallelTestA {

    public static RemoteWebDriver driver;
    public static String appURL = "http://www.google.com";


    @BeforeClass
    @Parameters({"browser"})
    public void setUp(String browser, ITestContext context) throws Exception{
        //System.out.println("*******************PTA");
        driver = Browser.getDriver(browser);
        context.setAttribute("WebDriver", driver);
        driver.manage().window().maximize();
    }


    @Test(priority = 1,enabled = true)
    //@Parameters({"browser"})
    public void testPageTitleA1() throws Exception{
        //System.out.println("*******************");
//         driver = Browser.getDriver(browser);
//        driver.manage().window().maximize();
        driver.navigate().to("http://www.youtube.com");
        //Thread.sleep(5000);
        String strPageTitle = driver.getTitle();
        System.out.println("Youtube : "+strPageTitle);
            Assert.assertTrue(strPageTitle.contains("Flipkart"), "Youtube : Page title doesn't match : "+strPageTitle);
        //Thread.sleep(5000);
     //   driver.quit();
    }

    @Test(priority = 2)
    //@Parameters({"browser"})
    public void testPageTitleA2() throws Exception{
        //System.out.println("*******************");
        //RemoteWebDriver driver = Browser.getDriver(browser);
        //driver.manage().window().maximize();
        driver.get("http://www.snapdeal.com");
        //Thread.sleep(5000);
        String strPageTitle = driver.getTitle();
        System.out.println("SnapDeal : "+strPageTitle);
        try{
            Assert.assertTrue(strPageTitle.contains("Amazon"), "SnapDeal : Page title doesn't match : "+strPageTitle);
        }catch (Exception e){
            System.out.println(e);
        }
        //Thread.sleep(5000);
       // driver.quit();
    }

    @AfterClass
    public void tearDown(){
        if(driver!=null) {
            System.out.println("Closing browser");
            driver.quit();
        }
    }


}
