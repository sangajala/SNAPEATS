package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import step_definitions.RunCukesTest;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserFactory {


    public static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            return createBrowserInstance();
        } else
            return driver;
    }

    private static WebDriver createBrowserInstance() {
        WebDriver driver = null;
        if(RunCukesTest.remote){
            if (RunCukesTest.browser.equalsIgnoreCase(BrowserNames.CHROME.toString())) {
                DesiredCapabilities capabilities = DesiredCapabilities.chrome();
                capabilities.setCapability("platform", "windowsOS 10");
                capabilities.setCapability("version", "");
                String url = "http://sangajala55:04d71cd1-2ed2-41bd-9b41-c8376c26f0b5@ondemand.saucelabs.com:80/wd/hub";
                try {
                    driver =  new RemoteWebDriver(new URL(url),capabilities);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            } else if (RunCukesTest.browser.equalsIgnoreCase(BrowserNames.FIREFOX.toString())) {
                DesiredCapabilities caps = DesiredCapabilities.firefox();
                caps.setCapability("platform", "windowsOS 10");
                caps.setCapability("version", "");
                driver = new RemoteWebDriver(caps);
            } else {
                DesiredCapabilities capabilities = DesiredCapabilities.chrome();
                capabilities.setCapability("platform", "windowsOS 10");
                capabilities.setCapability("version", "");
                driver =  new RemoteWebDriver(capabilities);
            }
            driver.manage().window().maximize();
            return driver;
        }
        else {
            if (RunCukesTest.browser.equalsIgnoreCase(BrowserNames.CHROME.toString())) {
                 driver =  new ChromeDriver();
            } else if (RunCukesTest.browser.equalsIgnoreCase(BrowserNames.FIREFOX.toString())) {
                driver =  new FirefoxDriver();
            } else {
                driver =  new ChromeDriver();
            }
            driver.manage().window().maximize();
            return driver;

        }

    }
}
