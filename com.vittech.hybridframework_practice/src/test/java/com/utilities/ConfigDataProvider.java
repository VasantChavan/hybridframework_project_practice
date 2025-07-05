package com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {

	private Properties prop;

	public ConfigDataProvider(String filename) {
		try {
			File fs = new File("./src/test/resources/config/" + filename + ".properties");
			FileInputStream fins = new FileInputStream(fs);
			prop = new Properties();
			prop.load(fins);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getUserName()
	{
		return prop.getProperty("username");
	}
	public String getPassword()
	{
		return prop.getProperty("password");
	}
	public String getAppURL()
	{
		return prop.getProperty("appUrl");
	}
	
	public String getValue(String key)
	{
		return prop.getProperty(key);
	}


	public static void main(String[] args) {
//		
//		ConfigDataProvider configDataProvider=	new ConfigDataProvider("config");
//		System.out.println("User name is : "+configDataProvider.getUserName());
//		System.out.println("Paasword is : "+configDataProvider.getPassword());
//		System.out.println("App URL is : "+configDataProvider.getAppURL());
//		
//		System.out.println("sreach key and retrive the value associated with key :"+configDataProvider.getValue("password"));
	}
}
