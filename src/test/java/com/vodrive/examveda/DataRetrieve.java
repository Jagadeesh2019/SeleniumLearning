package com.vodrive.examveda;

import org.apache.commons.exec.OS;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class DataRetrieve {


    public RemoteWebDriver driver;
    public static String appURL = "http://www.google.com";

//    @BeforeClass
//    public void setUp() throws MalformedURLException {
//
//    }

    @BeforeSuite
    public void testGooglePageTitleInIEBrowser() throws Exception{
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        capabilities.setPlatform(Platform.MAC);
        //capabilities.setCapability(ChromeOptions.CAPABILITY,chromeOptions);
        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
        driver.manage().window().maximize();
        System.out.println("*** Navigation to Application ***");
//        driver.navigate().to("https://www.shopup.com.bd");
//        String strPageTitle = driver.getTitle();
//        System.out.println("*** Verifying page title ***");
//        //Assert.assertTrue(strPageTitle.equalsIgnoreCase("Google"), "Page title doesn't match");
//        driver.quit();
    }

    @Test(dependsOnMethods = "testing4")
    public void testing1() throws Exception{
        //System.setProperty("webdriver.chrome.driver","/Users/vogo-1161/Drivers/chromeDriver81/chromedriver");

        //WebDriver driver1 = new ChromeDriver();
        driver.get("https://www.facebook.com");

       Thread.sleep(15000);
        driver.quit();

    }

    @Test
    public void testing2() throws Exception{
        //System.setProperty("webdriver.chrome.driver","/Users/vogo-1161/Drivers/chromeDriver81/chromedriver");

        //WebDriver driver1 = new ChromeDriver();
        driver.get("https://www.facebook.com");

        Thread.sleep(15000);
        driver.quit();


    }

    @Test
    public void testing3() throws Exception{
        //System.setProperty("webdriver.chrome.driver","/Users/vogo-1161/Drivers/chromeDriver81/chromedriver");

        //WebDriver driver1 = new ChromeDriver();
        driver.get("https://www.facebook.com");

        Thread.sleep(15000);
        driver.quit();


    }

    @Test
    public void testing4() throws Exception{
        //System.setProperty("webdriver.chrome.driver","/Users/vogo-1161/Drivers/chromeDriver81/chromedriver");

        //WebDriver driver1 = new ChromeDriver();
        driver.get("https://www.facebook.com");

        Thread.sleep(15000);
        driver.quit();


    }

//    @AfterClass
//    public void closeBrowser() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }
}
