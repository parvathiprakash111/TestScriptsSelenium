package testscriptpackage;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.ManageCategory;
import utilities.ExcelUtility;

public class ManageCategoryTest extends Base {
	HomePage homepage;
	ManageCategory managecategory;

	@Test
	public void verifyThatTheUserIsAbleToAddNewCategory() throws IOException {
		LoginPage login = new LoginPage(driver);
		String username = ExcelUtility.readStringData(1, 0, "Loginpagetest");
		String password = ExcelUtility.readStringData(1, 1, "Loginpagetest");
		login.usernameAndPassword(username, password);
		homepage = login.clickButton();
		managecategory = homepage.clickMoreInfoCategory();
		String categoryname = ExcelUtility.readStringData(1, 0, "Manage_Category");
		managecategory.clickNewCategoryButton().enterNewCategory(categoryname).selectGroups().chooseFile()
				.clickOnSaveButton();
	}
}
