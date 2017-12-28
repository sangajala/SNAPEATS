package pageobjects;

import helpers.WebDriverHelpers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public abstract class BaseClass {
	public static WebDriver driver;
	public static boolean bResult;

	@FindBy(how= How.XPATH, using="//input[@type='search']")
	public static WebElement searchBar;

	@FindBy(how=How.ID, using="datatable")
	public static WebElement resultTable;

	public  BaseClass(WebDriver driver){
		BaseClass.driver = driver;
		BaseClass.bResult = true;
		PageFactory.initElements(driver,this);
	}



	public void searchForString(String text) {

		searchBar.sendKeys(text);
		WebDriverHelpers.waitForSecs(3);


	}

	public boolean searchResultContainsText(String driverEmail) {
		return resultTable.getText().contains(driverEmail);
	}

}
