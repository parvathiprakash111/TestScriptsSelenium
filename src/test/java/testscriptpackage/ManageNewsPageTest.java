package testscriptpackage;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsPageTest extends Base {
	HomePage homepage;
	ManageNewsPage managenews;

	@Test
	public void verifyThatTheUserCanSaveNews() throws IOException {
		LoginPage login = new LoginPage(driver);
		String userName = ExcelUtility.readStringData(1, 0, "Loginpagetest");
		String password = ExcelUtility.readStringData(1, 1, "Loginpagetest");
		login.usernameAndPassword(userName, password);
		homepage = login.clickButton();
		managenews = homepage.clickMoreInfo();
		String news = ExcelUtility.readStringData(1, 0, "Manage_news");
		managenews.clickNewButton().enterNewsToTheField(news).clickSaveButton();

		/*
		 * managenews.clickMoreInfo(); managenews.clickNewButton();
		 * managenews.enterNewsToTheField(" Welcome to the world NEWS");
		 * managenews.clickSaveButton();
		 */
		boolean isAlertDisplayed = managenews.isAlertIsDiplayedAfterSaving();
		Assert.assertTrue(isAlertDisplayed, Constant.ERROR_MESSAGE_FOR_UNABLE_TO_SAVE_NEWS);
	}

	@Test
	public void verifyUserCanSaveNewsWithOutAddingAnyDetails() throws IOException {
		LoginPage loginpage = new LoginPage(driver);
		String userName = ExcelUtility.readStringData(1, 0, "Loginpagetest");
		String password = ExcelUtility.readStringData(1, 1, "Loginpagetest");
		loginpage.usernameAndPassword(userName, password);
		homepage = loginpage.clickButton();
		managenews = homepage.clickMoreInfo();
		managenews.clickNewButton().enterNewsToTheField("").clickSaveButton();
		boolean isAlertDisplayed = managenews.isAlertIsDiplayedAfterSaving();
		Assert.assertTrue(isAlertDisplayed, Constant.ERROR_MESSAGE_FOR_UNABLE_TO_SAVE_NEWS);
	}
}
