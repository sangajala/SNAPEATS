package pageobjects;

import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import helpers.WebDriverHelpers;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class ShopPage extends BaseClass {

    @FindBy(how = How.XPATH, using = "//a[@href='#']")
     public static WebElement AddShopButton;

    @FindBy(how = How.XPATH, using = "//a[@href='#']")
    public static WebElement ShopButton;

    @FindBy(how = How.XPATH, using = "//a[@href='/Shop/Resturants']")
    public static WebElement shop ;




    @FindBy(how = How.ID, using = "//a[@href='Resturants']")
    public static WebElement shopType;

    @FindBy(how = How.ID, using = "shop_name")
    public static WebElement ShopName ;

    @FindBy(how = How.ID, using = "address1")
    public static WebElement Address ;

    @FindBy(how = How.ID, using = "city")
    public static WebElement City ;

    @FindBy(how = How.ID, using = "pin")
    public static WebElement Postcode  ;

    @FindBy(how = How.ID, using = "phone")
    public static WebElement PhoneNo   ;

    @FindBy(how = How.ID, using = "lat")
    public static WebElement ShopLatitude   ;

    @FindBy(how = How.ID, using = "slong")
    public static WebElement ShopLongitude   ;

    @FindBy(how = How.ID, using = "website")
    public static WebElement  ShopWebsite   ;

    @FindBy(how = How.ID, using = "shop_image")
    public static WebElement  shopimage   ;

    @FindBy(how=How.XPATH, using="//input[@value='Add']")
    public static WebElement addButton;



    @FindBy(how=How.TAG_NAME, using="body")
    public static WebElement resultTable;



    public ShopPage(WebDriver driver) {
        super(driver);
    }

    public void clicksOnAddShop() {
        // WebDriverHelpers.openButton("Add shop");
        //WebDriverHelpers.textExists("Add shop");
        AddShopButton.click();
    }


    public void dropdownSelect() {
       // WebDriverHelpers.textExists("Restaurants");
        Select dropdown=new Select(driver.findElement(By.id("shopTypeList")));
        dropdown.selectByVisibleText("Restaurants");
      //  shopType.click();

    }

    public static void AddShopButton(String shopName, String address, String city, String postcode, String phoneNo, String shopLongitude, String shopWebsite) {
        ShopName.sendKeys("TeaTime");
        Address.sendKeys("21fairyland");
        City.sendKeys("abc");
        Postcode.sendKeys("xyz123");
        PhoneNo.sendKeys("123456712456");
        ShopLatitude.sendKeys("56.7890");
        ShopLongitude.sendKeys("65.9870");
        ShopWebsite.sendKeys("www.teatime.com");
    }

    public static void testshopimage() {
        shopimage.sendKeys("C:\\Users\\gurp\\teaimage");    }

    public void clicksOnAdd() {
        addButton.click();
    }

    public void isShopCreated() {
        WebDriverHelpers.textExists("Shop Created Successfully");
    }


   // public void searchResultContainsText(String shopName, WebElement searchbox) {
     //   searchbox.sendKeys("TeaTime");
       // WebDriverHelpers.waitForSecs(3);
    //}



    public boolean searchResultContainsText(String ShopName  ) {
        return resultTable.getText().contains(ShopName);
    }

    public  void HoversOverShop() {
    ShopButton.click();

    }

    public void clickOnShop() {
        shop.click();
    }
}

