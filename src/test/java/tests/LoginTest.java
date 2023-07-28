package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.cs.annotations.FrameworkAnnotations;

import Pages.LoginPage;

public class LoginTest extends BaseTest {

	@DataProvider
	public Object[][] getData() {
		return new Object[][] { { "Admin", "admin123" } };
		
		
	}

	@FrameworkAnnotations(author = "Bahubali", category = "smoke")
	@Test(dataProvider = "getData", description = "Verify Login Tile")
	public void verifyLoginTitle(String userName, String password) {
		LoginPage loginPage = new LoginPage();
		String actTitle = loginPage.loginAppl(userName, password).getHomePageTitle();

		String expTitle = "OrangeHRM";

		Assert.assertEquals(actTitle, expTitle,
				"Actual Title :" + actTitle + " does not match with exp title: " + expTitle);
	}

}
