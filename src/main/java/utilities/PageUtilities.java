package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PageUtilities {

	WebDriver driver;

	public PageUtilities() {

	}

	public PageUtilities(WebDriver driver) {
		this.driver = driver;
	}

	// DropDown Select class utilities
	// select from drop down by value
	public void selectByValue(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}
	// select from drop down by index

	public void selectFromDropDown_ByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	// select from drop down by visible text

	public void selectFromDropDown_ByVisibleText(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	// JavaScriptExecutor utilities
	// Scroll into view
	public void scrollIntoView(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	// Click using JavaScript
	public void clickElementByJS(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}

	// Set value into input
	public void setInputValue(WebElement element, String value) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].value='" + value + "';", element);
	}

	// Highlight an element
	public void highlightElement(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].style.border='3px solid red'", element);
	}

	/** Scroll down by pixels */
	public void scrollDownByPixels(int pixels) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("window.scrollBy(0," + pixels + ")");
	}

	/** Scroll up by pixels */
	public void scrollUpByPixels(int pixels) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("window.scrollBy(0,-" + pixels + ")");
	}
}
