package com.testbase;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.pageobjects.LoginPage;
import com.utilities.ConfigDataProvider;
import com.utility.ExcelDataProvider;

public class TestBase {

	protected WebDriver driver = null;
	protected LoginPage login=null;
	protected ConfigDataProvider configDataProvider;
	protected ExcelDataProvider excelDataProvider;
	
	
	@BeforeSuite
	public void init()
	{
		 configDataProvider=	new ConfigDataProvider("config");
		 excelDataProvider =new ExcelDataProvider("testdata","Login");
	}
	
	@BeforeClass
	public void pageint()
	{
		login=new LoginPage(driver);
		
	}

	@BeforeTest(description = "Browser setup before we start with testing ")
	@Parameters({ "browser" })
	public void setup(@Optional("CHROME")String browsername) {

		switch (browsername) {
		case "CHROME":
			driver = new ChromeDriver();
			break;
		case "FIREFOX":
			driver = new FirefoxDriver();
			break;
		case "EDGE":
			driver = new EdgeDriver();
			break;

		default:
			System.out.println(" please check browser setup with expected browser ");
			break;
		}
		
		driver.get(configDataProvider.getAppURL());
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}
	
	@AfterTest
	public void teardown()
	{
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.quit();
	}

}
