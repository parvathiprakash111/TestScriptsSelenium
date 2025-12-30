package testscriptpackage;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import pages.AdminUserPage;
import pages.AdminUser_SearchPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class AdminUser_SearchTest extends Base {
	HomePage homepage;
	AdminUserPage adminuser;
	AdminUser_SearchPage adminsearch;

	@Test
	public void verifyThatUserIsAbleToSearchAdminUser() throws IOException {
		LoginPage login = new LoginPage(driver);
		String name = ExcelUtility.readStringData(1, 0, "Loginpagetest");
		String password = ExcelUtility.readStringData(1, 1, "Loginpagetest");
		login.usernameAndPassword(name, password);
		homepage = login.clickButton();
		adminuser = homepage.clickOnAdmin();
		adminsearch = adminuser.clickOnAdminSearcIcon();
		String searchUser = ExcelUtility.readStringData(1, 0, "Admin_Search");
		String searchUsertype = ExcelUtility.readStringData(1, 1, "Admin_Search");
		adminsearch.enterTheNameToSearch(searchUser).selectUserFromDropDown(searchUsertype).clickOnAdminSearchButton();
		boolean actualResult = adminsearch.isSearchDataIsDisplayed(searchUser);
		System.out.println(actualResult);
		boolean expectedResult = true;
		Assert.assertEquals(actualResult, expectedResult, Constant.ERROR_MESSAGE_ADMIN_SEARCH_FAIL);
	}
}
