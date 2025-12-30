package testscriptpackage;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class HomePageTest extends Base {
	HomePage homepage;

	@Test
	public void clickOnAdminAndLogout() throws IOException {
		LoginPage login = new LoginPage(driver);
		String userName = ExcelUtility.readStringData(1, 0, "Loginpagetest");
		String password = ExcelUtility.readStringData(1, 1, "Loginpagetest");
		login.usernameAndPassword(userName, password);
		homepage = login.clickButton();
		homepage.clickAdmin().clickLogOut();
		/*
		 * HomePage home=new HomePage(driver); home.clickAdmin(); home.clickLogOut();
		 */
		// System.out.println(driver.getTitle());
		String expected = "Login | 7rmart supermarket";
		String actual = driver.getTitle();
		Assert.assertEquals(expected, actual, Constant.ERROR_MESSAGE_FAILED_LOGIOUT);
	}
}
