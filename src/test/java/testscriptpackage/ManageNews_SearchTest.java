package testscriptpackage;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import pages.ManageNews_Search;
import utilities.ExcelUtility;

public class ManageNews_SearchTest extends Base {
	HomePage homepage;
	ManageNewsPage managenews;
	ManageNews_Search managesearch;

	@Test
	public void verifyThatTheSearchFunctionalityIsWorking() throws IOException {
		LoginPage login = new LoginPage(driver);
		String username = ExcelUtility.readStringData(1, 0, "Loginpagetest");
		String password = ExcelUtility.readStringData(1, 1, "Loginpagetest");
		login.usernameAndPassword(username, password);
		homepage = login.clickButton();
		managenews = homepage.clickMoreInfo();
		managesearch = managenews.clickOnSearchIcon();
		String addDetail = ExcelUtility.readStringData(0, 0, "Search");

		managesearch.addDetails(addDetail).clickOnSearchButton();
		boolean actualResult = managesearch.isSearchResultDisplayed(addDetail);
		System.out.println(actualResult);
		boolean expectedResult = true;

		Assert.assertEquals(actualResult, expectedResult, Constant.ERROR_MESSAGE_SEARCH_FAIL);

	}
}
