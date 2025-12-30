package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.PageUtilities;

public class AdminUserPage {
	WebDriver driver;
	PageUtilities utility = new PageUtilities();

	public AdminUserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	WebElement newbutton;
	@FindBy(xpath = "//input[@name='username']")
	WebElement user_Name;
	@FindBy(xpath = "//input[@name='password']")
	WebElement password;
	@FindBy(xpath = "//select[@name='user_type']")
	WebElement userType;
	@FindBy(xpath = "//button[@name='Create']")
	WebElement save;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alert;
	@FindBy(xpath = "//a[@onclick='click_button(2)']")
	WebElement adminSearch;

	public AdminUserPage clickOnNew() {
		newbutton.click();
		return this;
	}

	public AdminUserPage enterUserAndPassword(String username, String passwd) {
		user_Name.sendKeys(username);
		password.sendKeys(passwd);
		return this;
	}

	public AdminUserPage selectFromDropdown(String typevalue) {
		utility.selectByValue(userType, typevalue);
		return this;
	}

	public AdminUserPage clickSaveButton() {
		save.click();
		return this;
	}

	public boolean isAlertIsDisplayed() {
		return alert.isDisplayed();
	}

	public AdminUser_SearchPage clickOnAdminSearcIcon() {
		adminSearch.click();
		return new AdminUser_SearchPage(driver);
	}
}
