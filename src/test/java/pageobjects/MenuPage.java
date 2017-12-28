package pageobjects;

import helpers.WebDriverHelpers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MenuPage extends BaseClass {

    @FindBy(how = How.ID, using = "menuname")
    public static WebElement MenuName;

    @FindBy(how = How.XPATH, using = "//button[text()='Add Menu']")
    public static WebElement Submit;

    @FindBy(how=How.XPATH, using="//input[@type='search']")
    public static WebElement searchBox;













    public MenuPage(WebDriver driver) {
        super(driver);
    }

    public void goToMenuPage() {
        driver.navigate().to("http://se.testersworld.com/Master/Menu");
    }

    public void addMenuName(String name) {
        MenuName.sendKeys("fiterCof");
        Submit.click();

    }

    public void isAddedSuccessfully() {
        {
            WebDriverHelpers.textExists("Menu Name Added Successfully");
        }
    }

    public void searchForMenu(String text1) {
        searchBox.sendKeys(text1);
        WebDriverHelpers.waitForSecs(3);

    }
}
