package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtilitiy;

public class LoginPage {
	WebDriver driver;
	WaitUtilitiy waitutility = new WaitUtilitiy();

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name='username']")
	WebElement username;
	@FindBy(xpath = "//input[@name='password']")
	WebElement password;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement SignIn;
	@FindBy(xpath = "//p[text()='Dashboard']")
	WebElement dashboard;
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	WebElement alertmessage;

// return types of the methods are changed to the class names so as to make a connections between the classes written for each pages
// here return type is the class name because the function does not move to another page . so return the same class

	public LoginPage usernameAndPassword(String usernamefield, String passwordField) {
		username.sendKeys(usernamefield);
		password.sendKeys(passwordField);
		return this;
	}

// here the return type is HomePage class because the click function will open the home page

	public HomePage clickButton() {
		waitutility.waitForElementToClick(driver, SignIn);
		SignIn.click();
		return new HomePage(driver); // new homepage is object creation
	}

	public boolean isDashboardIsDisplayed() {

		return dashboard.isDisplayed();

	}

	public boolean isAlertMessageIsDisplayed() {

		return alertmessage.isDisplayed();
	}
}