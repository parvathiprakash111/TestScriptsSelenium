package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageProductPage {
	WebDriver driver;

	public ManageProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-product'])[3]")
	WebElement moreInfoProduct;
	@FindBy(className = "btn btn-rounded btn-danger")
	WebElement newButtonProduct;
	@FindBy(xpath = "//input[@placeholder='Enter the Title']")
	WebElement enterTitle;
	@FindBy(xpath = "//input[@value='Nonveg']")
	WebElement productType;
	@FindBy(xpath = "//input[@placeholder='Enter the Title']")
	WebElement tagName;

}
