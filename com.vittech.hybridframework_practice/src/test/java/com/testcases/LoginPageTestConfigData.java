package com.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.testbase.TestBase;

public class LoginPageTestConfigData extends TestBase {

	//@Test(priority = 1)
	public void loginTest1() {
		
		login.setUserName(configDataProvider.getUserName());
		login.setPassword(configDataProvider.getPassword());
		Assert.assertTrue(login.clickonloginbtn().hpLogoStatus());
	}
	
	@Test(priority = 2)
	public void loginTest2() {
		
		login.setUserName(excelDataProvider.getStringValue(1, 0));
		login.setPassword(excelDataProvider.getStringValue(1, 1));
		if(login.clickonloginbtn().hpLogoStatus())
		{
			excelDataProvider.setCellData(0, 2, "Status");
			excelDataProvider.setCellData(1, 2, "PASS");
			
		}
		else
		{
			excelDataProvider.setCellData(0, 2, "Status");
			excelDataProvider.setCellData(1, 2, "FAIL");
		}
	}

}
