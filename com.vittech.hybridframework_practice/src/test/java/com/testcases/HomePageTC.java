package com.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pageobjects.HomePage;
import com.testbase.TestBase;

public class HomePageTC extends TestBase {

	HomePage homepage;

	@Test(priority = 1)
	public void verifyHomePageTitle() {
		login.setUserName("Admin");
		login.setPassword("admin123");
		homepage = login.clickonloginbtn();

		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
	}

	@Test(priority = 2)
	public void verifyHomePageLogo() {
		Assert.assertTrue(homepage.hpLogoStatus());
	}
}
