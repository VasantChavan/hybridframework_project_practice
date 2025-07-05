package com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testbase.TestBase;

public class HomePage extends TestBase{

	@FindBy(xpath = "//img[@alt='client brand banner ']")
	@CacheLookup
	WebElement homepageLogo;
	
	

	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public boolean hpLogoStatus() {
		try {
			return homepageLogo.isDisplayed();
		} catch (Exception e) {
			return false;
		}
		
		
	}

}
