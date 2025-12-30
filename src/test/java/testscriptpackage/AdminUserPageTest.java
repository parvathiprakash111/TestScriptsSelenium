package testscriptpackage;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import pages.AdminUserPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class AdminUserPageTest extends Base {
	HomePage homepage;
	AdminUserPage adminuser;

	@Test
	public void createNewAdminUserInformation() throws IOException {
		LoginPage login = new LoginPage(driver);
		String userName = ExcelUtility.readStringData(1, 0, "Loginpagetest");
		String password = ExcelUtility.readStringData(1, 1, "Loginpagetest");
		login.usernameAndPassword(userName, password);
		homepage = login.clickButton();
		adminuser = homepage.clickOnAdmin();
		String Admin_userName = ExcelUtility.readStringData(1, 0, "AdminUserPageTest");
		String admin_Password = ExcelUtility.readStringData(1, 1, "AdminUserPageTest");
		String admin_UserType = ExcelUtility.readStringData(1, 2, "AdminUserPageTest");
		adminuser.clickOnNew().enterUserAndPassword(Admin_userName, admin_Password).selectFromDropdown(admin_UserType)
				.clickSaveButton();
		/*
		 * AdminUserPage adminuser=new AdminUserPage(driver); adminuser.clickOnAdmin();
		 * adminuser.clickOnNew(); adminuser.enterUserAndPassword("HARRY", "tEst@123");
		 * adminuser.selectFromDropdown("admin"); adminuser.clickSaveButton();
		 */
		boolean isAlertDisplayed = adminuser.isAlertIsDisplayed();
		Assert.assertTrue(isAlertDisplayed, Constant.ERROR_MESSAGE_UNABLE_TO_SAVE_ADMIN_INFO);

	}
}
