package com.vodrive.examveda;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.util.Set;

public class TestListener implements ITestListener {

    String filePath = "/Users/vogo-1161/AutomationTests/SeleniumLearning/src/test/java/com/vodrive/screenshots";

    @Override
    public void onTestStart(ITestResult result) {

    }

    @Override
    public void onTestSuccess(ITestResult result) {

    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("***** Error "+result.getName()+" test has failed *****");
        String methodName=result.getName().trim();
        ITestContext context = result.getTestContext();
//        System.out.println(context.getName());
//        System.out.println(context.getAllTestMethods().length);
//        System.out.println(context.getFailedTests().getAllMethods().size());
//        Set<String> attributeNames = context.getAttributeNames();
//        System.out.println(attributeNames.size());
//        for(int i=0;i<attributeNames.toArray().length;i++){
//            System.out.println(attributeNames.toArray()[i]);
//        }

        RemoteWebDriver driver = (RemoteWebDriver) context.getAttribute("WebDriver");
       if(driver!=null){
           takeScreenshotAtEndOfTest(methodName, driver);
       }else {
           System.out.println("Driver is null");
       }

    }

    private void takeScreenshotAtEndOfTest(String testMethodName,RemoteWebDriver driver) {
            System.out.println("Control in takeScreenshotAtEndOfTest");
        try {
            System.out.println("Control in try");
            File scrfile = null;
            try{
                scrfile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
                System.out.println("Control after scrfile");
            }catch (Exception e){
               e.printStackTrace();
            }
            if(scrfile!=null){
                FileUtils.copyFile(scrfile ,new File("/Users/vogo-1161/AutomationTests/SeleniumLearning/src/test/java/com/vodrive/screenshots/" + testMethodName+".jpg"));
                System.out.println("Control after FileCopy");
            }else {
                System.out.println("ScrFile is Null");
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

    }
}
