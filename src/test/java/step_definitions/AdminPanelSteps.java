package step_definitions;


import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import helpers.WebDriverHelpers;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;
import static pageobjects.ShopPage.*;
import static pageobjects.ShopPage.searchBar;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.openqa.selenium.interactions.Actions;
import pageobjects.*;

public class AdminPanelSteps {

    public WebDriver driver;
    public AdminLoginPage adminLoginPage;
    public DashboardPage dashboardPage;
    public DriverPage driverPage;
    public String driverEmail;
    public ShopPage shopPage;
    public String ShopName;
    public CategoryPage categoryPage;
    public OrderPage orderPage;
    public String Address1;
    private String itemName;
    private ItemsPage itemsPage;
    private MenuPage menuPage;
    private String MenuName1;
    private String categoryName;

    public AdminPanelSteps() {
        driver = Hooks.driver;
    }



    @Given("^admin logged into the admin panel$")
    public void adminLoggedIntoTheAdminPanel() throws Throwable {
        WebDriverHelpers.openAdminPanel(driver);
        adminLoginPage = new AdminLoginPage(driver);
        adminLoginPage.login();
        Assert.assertTrue(adminLoginPage.isUserLogged());
    }

    @When("^he create a driver with username \"([^\"]*)\"$")
    public void heCreateADriverWithUsername(String email) throws Throwable {

        driverEmail = email;
        dashboardPage = new DashboardPage(driver);
        driverPage = dashboardPage.gotoDriverPage();
        driverPage.gotoCreateDriver();
        driverPage.createDriver(email);
    }

    @Then("^driver should be successfully created$")
    public void driverShouldBeSuccessfullyCreated() throws Throwable {

        driverPage.isDriverCreated();

    }

    @When("^admin view his details$")
    public void adminViewHisDetails() throws Throwable {
        driverPage.searchForString(driverEmail);
        Assert.assertTrue(driverPage.searchResultContainsText(driverEmail));

    }

    @Then("^the details should be as entered$")
    public void theDetailsShouldBeAsEntered() throws Throwable {
        Assert.assertTrue(driverPage.searchResultContainsText("1212121212"));
    }

    @When("^he clicks on add shop$")
    public void heClicksOnAddShop() throws Throwable {
         shopPage = new ShopPage(driver);
         shopPage.clicksOnAddShop();

    }

    @Then("^he should enter the details as with Shop Type options$")
    public void heShouldEnterTheDetailsAsWithShopTypeOptions() throws Throwable {

        //Select dropdown=new Select(driver.findElement(By.id("shopTypeList")));
        //dropdown.selectByVisibleText("Restaurants");
        shopPage.dropdownSelect();
    }


    @And("^he should enter details as\"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void heShouldEnterDetailsAs(String ShopName, String Address, String City, String Postcode, String PhoneNo, String ShopLatitude, String ShopLongitude, String ShopWebsite) throws Throwable {
      shopPage.AddShopButton(ShopName,Address,City,Postcode,PhoneNo,ShopLongitude,ShopWebsite);
    }

    @And("^he upload the shop image$")
    public void heUploadTheShopImage() throws Throwable {
       testshopimage();
    }

    @Then("^added shop should be created successfully$")
    public void addedShopShouldBeCreatedSuccessfully() throws Throwable {
        shopPage.clicksOnAdd();
        shopPage.isShopCreated();
        shopPage.searchForString(ShopName);
      //  Assert.assertTrue(shopPage.searchResultContainsText(String ShopName));


    }

    @When("^admin view shop details$")
    public void adminViewShopDetails() throws Throwable {
        searchBar.sendKeys(ShopName);
        WebDriverHelpers.waitForSecs(3);
    }

    @When("^he hovers over shop button$")
    public void heHoversOverShopButton() throws Throwable {
        Actions builder = new Actions(driver);
       // driver.findElement(By.xpath("//a[@href='Resturants']")).click();
        builder.build().perform();
//     shopPage.HoversOverShop();
        driver.navigate().to("http://se.testersworld.com/Shop/AddResturant");
    }
    @When("^selects shop option$")
    public void selects_shop_option() throws Throwable {
       shopPage.clickOnShop();
    }

    @When("^he clicks on categories$")
    public void heClicksOnCategories() throws Throwable {
        categoryPage= new CategoryPage(driver);
        categoryPage.goToCategory();

    }

    @And("^he adds category with catagory name\"([^\"]*)\" and description with\"([^\"]*)\"$")
    public void heAddsCategoryWithCatagoryNameAndDescriptionWith(String name, String description) throws Throwable {
        categoryPage.addsCategoryName(name);
        categoryPage.addsDescription(description);
    }

    @Then("^categories should be added successfully$")
    public void categoriesShouldBeAddedSuccessfully() throws Throwable {
        categoryPage.isCategoryCreated();
    }

    @When("^he clicks on create order$")
    public void heClicksOnCreateOrder() throws Throwable {
        orderPage= new OrderPage(driver);
         orderPage.goToCreateOrder();
         orderPage.setCreateOrder();
    }
//    @And("^he should enter the deliver details as\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"([^\"]*)\"([^\"]*)\"([^\"]*)\"([^\"]*)\"([^\"]*)\"([^\"]*)\"([^\"]*)\"$")
    @And("^he should enter the deliver details as\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"$")
    public void heShouldEnterTheDeliverDetailsAs(String Address1, String city, String PostCode,String driverName, String orderNotes,String shopForOrder, String ShopAddress, String itemCategory, String item, String numberOfItems) throws Throwable {

        this.Address1 = Address1;
        orderPage.createOrder(Address1,city,PostCode,driverName,orderNotes,shopForOrder,ShopAddress,itemCategory,item,numberOfItems);


    }



   // @And("^he should enter the details as driver and order notes$")
    //public void heShouldEnterTheDetailsAsDriverAndOrderNotes() throws Throwable {
      //    orderPage.SetSelectDriver();
        //  orderPage.SetSelectDriver();
    //}

    @Then("^he clicks on create order button$")
    public void heClicksOnCreateOrderButton() throws Throwable {

    }

    @Then("^he should view order details$")
    public void heShouldViewOrderDetails() throws Throwable {
        Assert.assertTrue(orderPage.isOrderCreated(this.Address1));
    }

    @And("^admin view category details$")
    public void adminViewCategoryDetails() throws Throwable {

        categoryPage.searchForString(categoryName);
        Assert.assertTrue(categoryPage.searchResultContainsText(categoryName));

    }

   // @And("^he should enter the details with driver as\"([^\"]*)\" and order notes as\"([^\"]*)\"$")
    //public void heShouldEnterTheDetailsWithDriverAsAndOrderNotesAs(String Dname, String Onotes) throws Throwable {
      //  orderPage.SetSelectDriver();
        //orderPage.SetSelectDriver();

    //}

    @And("^he should enter the details with driver and order notes as\"([^\"]*)\"$")
    public void heShouldEnterTheDetailsWithDriverAndOrderNotesAs(String Onotes) throws Throwable {
        orderPage.SetSelectDriver(Onotes);
    }

    @And("^user enters item details as \"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"$")
    public void userEntersItemDetailsAs(String Category, String Shop, String ItemName, String ItemPrice, String ItemDescription) throws Throwable {
        this.itemName = ItemName;
        itemsPage.addItem(ItemName,Category,Shop,ItemPrice,ItemDescription);
    }

    @Then("^he should view item details$")
    public void heShouldViewItemDetails() throws Throwable {
        Assert.assertTrue(itemsPage.isItemAdded(this.itemName));


    }

    @When("^user navigates to items page to add item$")
    public void userNavigatesToItemsPageToAddItem() throws Throwable {
        itemsPage = new ItemsPage(driver);
        itemsPage.goToAddItem();
        itemsPage.setAddItem();
    }

    @When("^he clicks on menu items$")
    public void heClicksOnMenuItems() throws Throwable {
        menuPage= new MenuPage(driver);
        menuPage.goToMenuPage();

    }

    @And("^he adds menu name with\"([^\"]*)\"$")
    public void heAddsMenuNameWith(String name) throws Throwable {
        menuPage.addMenuName(name);
        this.MenuName1=name;

    }

    @Then("^menu name should be successfully added$")
    public void menuNameShouldBeSuccessfullyAdded() throws Throwable {
        menuPage.isAddedSuccessfully();
    }

//    @When("^he clicks on categories$")
//    public void heClicksOnCategories() throws Throwable {
//        categoryPage= new CategoryPage(driver);
//        categoryPage.goToCategory();
//
//    }

    @And("^he adds category with category name \"([^\"]*)\" and description \"([^\"]*)\"$")
    public void heAddsCategoryWithCategoryNameAndDescription(String name, String description) throws Throwable {
        categoryPage.createCategory(name, description);
        this.categoryName = name;

    }


//    @And("^admin view category details$")
//    public void adminViewCategoryDetails() throws Throwable {
//        categoryPage.searchForString(categoryName);
//        Assert.assertTrue(categoryPage.searchResultContainsText(categoryName));
//
//    }

    @Then("^the category details should be as entered$")
    public void theCategoryDetailsShouldBeAsEntered() throws Throwable {
        Assert.assertTrue(categoryPage.searchResultContainsText(this.categoryName));
    }
}




