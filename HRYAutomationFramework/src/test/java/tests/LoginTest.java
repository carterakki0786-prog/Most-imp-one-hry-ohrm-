package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.DashboardPage;
import pages.LoginPage;
import utilities.ConfigReader;
//import utilities.ScreenshotUtils;
import org.testng.annotations.Listeners;
import listeners.TestListener;

@Listeners(TestListener.class)
public class LoginTest extends BaseTest {
	@Test
	public void launchApplication() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));
		DashboardPage dashboardPage = new DashboardPage(driver);
		Assert.assertTrue(dashboardPage.isDashboardDisplayed());

		dashboardPage.logout();

		Assert.assertTrue(loginPage.isLoginButtonDisplayed());
		
		Assert.assertTrue(false, "Intentional Failure");
		

	}

	//@Test
//	public void captureScreenshot() throws InterruptedException {
//
//		Thread.sleep(3000);
//
//		ScreenshotUtils.captureScreenshot(driver, "LoginTest");
//	}

}