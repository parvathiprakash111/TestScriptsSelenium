package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtilitiy;

public class ManageNews_Search {
	WebDriver driver;
	WaitUtilitiy utility = new WaitUtilitiy();

	public ManageNews_Search(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@class='form-control']")
	WebElement addTitle;
	@FindBy(xpath = "//i[@class='fa fa-search']")
	WebElement searchButton;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody/tr/td")
	WebElement table;

	public ManageNews_Search addDetails(String title) {
		addTitle.sendKeys(title);
		return this;
	}

	public ManageNews_Search clickOnSearchButton() {
		searchButton.click();
		utility.waitForTableToBeDisplayed(driver, table);
		return this;
	}

	public boolean isSearchResultDisplayed(String input) {

		List<WebElement> datatable = driver
				.findElements(By.xpath("//table[@class='table table-bordered table-hover table-sm']/tbody/tr/td"));
		for (WebElement data : datatable) {
			if (data.getText().contains(input)) {
				return true;
			}
		}
		return false;
	}
}
