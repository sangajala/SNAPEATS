package pageobjects;

import helpers.WebDriverHelpers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CategoryPage extends BaseClass {


    @FindBy(id = "category_name")
    WebElement categoryName;

    @FindBy(id = "category_desc")
     WebElement desc;



    @FindBy(how = How.XPATH, using = "//button[text()='Add Category']")
     WebElement AddCategory;





    @FindBy(id = "category_desc")
    WebElement categorydesc;








    public CategoryPage(WebDriver driver) {
        super(driver);
    }

    public void goToCategory() {
        driver.navigate().to("http://se.testersworld.com/Master/Category");
    }

    public void addsCategoryName(String name) {
        categoryName.sendKeys(name);
    }

    public void addsDescription(String description) {
        desc.sendKeys(description);
    }

    public void isCategoryCreated() {
    }

    public void createCategory(String name, String description) {

        this.categoryName.sendKeys(name);
        categorydesc.sendKeys(description);
//        WebDriverHelpers.gotoBottomOfThePage();
        AddCategory.click();

    }
}
