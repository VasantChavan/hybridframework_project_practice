package com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}

	@FindBy(name = "username")
	WebElement username_txt;

	@FindBy(name = "password")
	WebElement pass_txt;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement loginBtn;

	@FindBy(xpath = "//img[@alt='company-branding']")
	WebElement orangeHRMLogo;

	@FindBy(xpath = "//p[text()='Forgot your password? ']")
	WebElement forgotPasswordText;

	public void setUserName(String username) {
		username_txt.sendKeys(username);
	}

	public void setPassword(String password) {
		pass_txt.sendKeys(password);
	}

	public HomePage clickonloginbtn() {
		loginBtn.click();
		
		return new HomePage(driver);
	}

	public String getForgotPasswordText() {
		return forgotPasswordText.getText();
	}

	public boolean logoStatus() {
		return orangeHRMLogo.isDisplayed();
	}

}
