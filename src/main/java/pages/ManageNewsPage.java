package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {
	WebDriver driver;

	public ManageNewsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	WebElement newButton;
	@FindBy(xpath = "//textarea[@id='news']")
	WebElement enterNews;
	@FindBy(xpath = "//button[@name='create']")
	WebElement saveButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alertMessage;
	@FindBy(xpath = "//a[@onclick='click_button(2)']")
	WebElement searchIcon;

	public ManageNewsPage clickNewButton() {
		newButton.click();
		return this;
	}

	public ManageNewsPage enterNewsToTheField(String news) {
		enterNews.sendKeys(news);
		return this;
	}

	public ManageNewsPage clickSaveButton() {
		saveButton.click();
		return this;
	}

	public boolean isAlertIsDiplayedAfterSaving() {

		return alertMessage.isDisplayed();
	}

	public ManageNews_Search clickOnSearchIcon() {
		searchIcon.click();
		return new ManageNews_Search(driver);
	}
}
