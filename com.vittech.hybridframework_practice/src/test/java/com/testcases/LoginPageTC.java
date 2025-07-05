package com.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.testbase.TestBase;

public class LoginPageTC extends TestBase {

	@Test(priority = 1)
	public void verifyLoginPageTitle() {
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
	}

	@Test(priority = 2)
	public void verifyOrangeHRMLogo() throws InterruptedException {
		Thread.sleep(3000);
		Assert.assertTrue(login.logoStatus());
	}

	@Test(priority = 3)
	public void verifyOrangeHRMLinks() {
		List<WebElement> links = driver.findElements(By.tagName("a"));
		for (WebElement link : links) {
			System.out.println(link.getText());
		}
	}

	@Test(priority = 4)
	public void verifyForgotPasswordLinkText() {

		Assert.assertEquals(login.getForgotPasswordText(), "Forgot your password?");
	}

}
