package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//img[@alt='User Image'])[1]")
	WebElement admin;
	@FindBy(xpath = "(//a[@href='https://groceryapp.uniqassosiates.com/admin/logout'])[1]")
	WebElement logout;
	@FindBy(xpath = "(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin'])[2]")
	WebElement adminuser;
	@FindBy(xpath = "(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news'])[2]")
	WebElement moreInfo;
	@FindBy(xpath = "(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category'])[2]")
	WebElement moreInfoCategory;

	public HomePage clickAdmin() {
		admin.click();
		return this;
	}

	public HomePage clickLogOut() {
		logout.click();
		return this;
	}

	public AdminUserPage clickOnAdmin() {
		adminuser.click();
		return new AdminUserPage(driver);

	}

	public ManageNewsPage clickMoreInfo() {

		moreInfo.click();
		return new ManageNewsPage(driver);

	}

	public ManageCategory clickMoreInfoCategory() {
		moreInfoCategory.click();
		return new ManageCategory(driver);
	}

}
