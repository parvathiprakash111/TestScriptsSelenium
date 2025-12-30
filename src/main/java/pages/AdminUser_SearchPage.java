package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtilities;

public class AdminUser_SearchPage {
	WebDriver driver;
	PageUtilities utility = new PageUtilities();

	public AdminUser_SearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='un']")
	WebElement enterName;
	@FindBy(xpath = "//select[@id='ut']")
	WebElement selectUser_Type;
	@FindBy(xpath = "//button[@name='Search']")
	WebElement adminSearchButton;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody/tr/td")
	WebElement tabledata;

	public AdminUser_SearchPage enterTheNameToSearch(String name) {
		enterName.sendKeys(name);
		return this;
	}

	public AdminUser_SearchPage selectUserFromDropDown(String usertype) {
		utility.selectByValue(selectUser_Type, usertype);
		return this;

	}

	public AdminUser_SearchPage clickOnAdminSearchButton() {
		adminSearchButton.click();
		return this;
	}

	public boolean isSearchDataIsDisplayed(String input) {
		List<WebElement> data = driver
				.findElements(By.xpath("//table[@class='table table-bordered table-hover table-sm']/tbody/tr/td"));
		for (WebElement tablesdata : data) {
			if (tablesdata.getText().equalsIgnoreCase(input)) {
				return true;
			}
		}
		return false;
	}
}
