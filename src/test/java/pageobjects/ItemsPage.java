package pageobjects;


import helpers.WebDriverHelpers;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class ItemsPage extends BaseClass {

    @FindBy(how = How.XPATH, using = "//button[text()='Add Item']")
    public static WebElement AddItem;


    @FindBy(how = How.NAME, using = "cid")
    public static WebElement SelCategory;

    @FindBy(how = How.NAME, using = "sid")
    public static WebElement SelShop;

    @FindBy(how = How.NAME, using = "scat_name")
    public static WebElement ItmName;

    @FindBy(how = How.NAME, using = "scat_price")
    public static WebElement ItmPrice;

    @FindBy(how = How.NAME, using = "scat_desc")
    public static WebElement ItmDesc;

    @FindBy(how = How.ID, using = "scat_image")
    public static WebElement UploadImage;

    @FindBy(how = How.XPATH, using = "//input[@value='Add Item']")
    public static WebElement AddingItem;


    public ItemsPage(WebDriver driver) {
        super(driver);
    }

    public void goToAddItem() {
        driver.navigate().to("http://se.testersworld.com/Shop/Items");
    }



    public void setAddItem() {
        AddItem.click();
    }
    // Select dropdown=new Select(SelCategory);
    // dropdown.selectByVisibleText("Sides");

    // Select dropdown1=new Select(SelShop);
    // dropdown1.selectByVisibleText("Wagamama");

    //  public void setItemname (itemName) {
    // ItmName.sendKeys(ItemName);}

    // public void setItemprice (String itemPrice) {
    // ItmPrice.sendKeys(itemPrice);}

    //public void setItemdescription (String itemDescription) {
    // ItmDesc.sendKeys(itemDescription);


    //public void setAddingItem() {
    //AddingItem.click();








    public void addItem(String itemName, String category, String shop, String itemPrice, String itemDescription) {
        WebDriverHelpers.selectDropDown(SelCategory, category);
        WebDriverHelpers.selectDropDown(SelShop, shop);
        ItmName.sendKeys(itemName);
        ItmPrice.sendKeys(itemPrice);
        ItmDesc.sendKeys(itemDescription);
        WebDriverHelpers.gotoBottomOfThePage();
        AddingItem.click();
    }


    public boolean isItemAdded (String text){
        searchForString(text);
        return searchResultContainsText(text);
    }

}
