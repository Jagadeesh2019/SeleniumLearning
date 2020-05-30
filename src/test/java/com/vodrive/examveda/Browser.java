package com.vodrive.examveda;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class Browser {


    public static RemoteWebDriver getDriver(String browser) throws Exception{
            return new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),getBrowserCapabilities(browser));
    }

    private static DesiredCapabilities getBrowserCapabilities(String browser){
        switch (browser){
            case "chrome" : System.out.println("Opening Chrome Browser");
            return DesiredCapabilities.chrome();

            case "firefox" : System.out.println("Opening Chrome Browser");
                return DesiredCapabilities.firefox();

            case "IE" : System.out.println("Opening Chrome Browser");
                return DesiredCapabilities.internetExplorer();

            default: System.out.println("Browser Type" + browser + "doesn't support. Launching chrome as the default browser" );
                return DesiredCapabilities.chrome();
        }
    }
}
