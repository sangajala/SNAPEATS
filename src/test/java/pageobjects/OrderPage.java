package pageobjects;

import helpers.WebDriverHelpers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class OrderPage extends BaseClass {

    @FindBy(how = How.XPATH, using ="//button[text()='Create Order']")
    public static WebElement CreateOrder;


    @FindBy(how = How.ID, using = "D_Address1")
    public static WebElement Add1;


    @FindBy(how = How.ID, using = "City")
    public static WebElement Cty;

    @FindBy(how = How.ID, using = "PinCode")
    public static WebElement Post;

    @FindBy(how = How.ID, using = "driversList")
    public static WebElement SelectDriver;

    @FindBy(how = How.ID, using = "order_notes")
    public static WebElement OrderNotes;

    @FindBy(how = How.ID, using = "shopsList")
    public static WebElement SelectShop;

    @FindBy(how = How.ID, using = "ShopAddressList1")
    public static WebElement SelectShopAddress;

    @FindBy(how = How.ID, using = "CategoryList1")
    public static WebElement ItemCategory;

    @FindBy(how = How.ID, using = "itemsList1")
    public static WebElement SelectItem;

    @FindBy(how = How.ID, using = "qty1")
    public static WebElement NoOfItems;

    @FindBy(how = How.XPATH, using = "//input[@value='Create Order']")
    public static WebElement SubmitOrder;


    public OrderPage(WebDriver driver) {
        super(driver);
    }

    public void goToCreateOrder() {
        driver.navigate().to("http://se.testersworld.com/Order");
    }



    public void setCreateOrder() {
        CreateOrder.click();
    }

    public void setAddress1(String address1) {
        Add1.sendKeys(address1 );

            }
    public void setcity(String city) {
        Cty.sendKeys(city);
    }
    public void setPostcode(String postCode) {
        Post.sendKeys(postCode);


    }




    public void SetSelectDriver(String onotes){

//        SelectDriver.isSelected();
        Select dropdown=new Select(SelectDriver);
        dropdown.selectByVisibleText("abc");
        OrderNotes.getText();
    }



    public void SetSelectShop(){
        SelectShop.getText();}
    public void setSelectShopAddress(){
        SelectShopAddress.getText();}
    public void setItemCategory(){
        ItemCategory.getText();}
    public void setSelectItem(){
        SelectItem.getText();};
    public void setNoOfItems(){
        NoOfItems.getText();}

    public void setSubmitOrder()
    {SubmitOrder.click();}


    public void createOrder(String address1, String city, String postCode, String driverName, String orderNotes, String shopForOrder, String shopAddress, String itemCategory, String item, String numberOfItems) {

        Add1.sendKeys(address1 );
        Cty.sendKeys(city);
        Post.sendKeys(postCode);
        WebDriverHelpers.selectDropDown(SelectDriver,driverName);
        OrderNotes.sendKeys(orderNotes);
        WebDriverHelpers.selectDropDown(SelectShop,shopForOrder);

        WebDriverHelpers.selectDropDown(SelectShopAddress,shopAddress);
        WebDriverHelpers.selectDropDown(ItemCategory,itemCategory);
        WebDriverHelpers.selectDropDown(SelectItem,item);
        NoOfItems.sendKeys(numberOfItems);
        SubmitOrder.click();

    }

    public boolean isOrderCreated(String text) {
        searchForString(text);
        return searchResultContainsText(text);
    }
}

