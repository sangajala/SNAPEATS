package helpers;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class WebDriverHelpers {

    static WebDriver driver;

    private static String bodyElementText()
    {
        return driver.findElement(By.tagName("body")).getText();
    }


    public static void openAdminPanel(WebDriver driver) {
        WebDriverHelpers.driver = driver;
        driver.get("http://se.testersworld.com/");
        Log.info("I am at admin panel page");
        Assert.assertTrue(driver.findElement(By.className("account-content")).isDisplayed());
    }

    public static boolean textExists(String text) {
        return bodyElementText().contains(text);
    }

    public static void openButton(String buttonText) {
        driver.findElement(By.xpath("//button[text()='"+buttonText+"']")).click();
    }

    public static void waitForSecs(int secs) {
        try {
            Thread.sleep(secs*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void dropdown(String locator) {
         new Select(driver.findElement(By.id("locator")));

    }

    public static void selectDropDown(WebElement element, String text) {
        Select select = new Select(element);
        select.selectByVisibleText(text);
        waitForSecs(2);
    }

    public static void gotoBottomOfThePage() {
        ((JavascriptExecutor)driver).executeScript("scrollTo(0,3000)");
    }
}
