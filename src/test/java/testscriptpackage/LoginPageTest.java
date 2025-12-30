package testscriptpackage;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import constants.Constant;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginPageTest extends Base {
	@Test
	public void VerifyUserCanLoginWithValidCredentials() throws IOException {
		LoginPage login = new LoginPage(driver);
		String userName = ExcelUtility.readStringData(1, 0, "Loginpagetest");
		String password = ExcelUtility.readStringData(1, 1, "Loginpagetest");
		login.usernameAndPassword(userName, password);
		login.clickButton();
		boolean isdashboardDisplayed = login.isDashboardIsDisplayed();
		Assert.assertTrue(isdashboardDisplayed, Constant.ERROR_MESSAGE_FOR_LOGIN);
	}

	@Test(dataProvider = "credentials")
	public void verifyUserCanLoginWithValidUsernameAndInvalidPassword(String user, String pass) {
		LoginPage login = new LoginPage(driver);
		login.usernameAndPassword(user, pass);
		login.clickButton();
		boolean isalertdisplayed = login.isAlertMessageIsDisplayed();
		Assert.assertTrue(isalertdisplayed, Constant.ERROR_MESSAGE_FOR_INVALID_LOGIN);
	}

	@DataProvider(name = "credentials")
	public Object[][] testdata() {
		Object data[][] = { { "test", "test" }, { "admin", "test" }, { "test", "admin" } };
		return data;
	}

	@Test
	@Parameters({ "username", "password" })
	public void loginwithInvalidCredentials(String User, String pass) {
		LoginPage login = new LoginPage(driver);
		login.usernameAndPassword(User, pass);
		login.clickButton();
		boolean isalertdisplayed = login.isAlertMessageIsDisplayed();
		Assert.assertTrue(isalertdisplayed, Constant.ERROR_MESSAGE_FOR_INVALID_LOGIN);
	}

}
