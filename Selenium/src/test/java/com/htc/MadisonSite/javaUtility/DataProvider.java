package com.htc.MadisonSite.javaUtility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class DataProvider {

	protected Properties properties;
	
	public DataProvider() {
		File source=new File("C:\\Users\\SAUMYARUP\\Downloads\\MadisonSite\\MadisonSite\\src\\test\\resources\\config.properties");
		try {
			FileInputStream fileInputStream=new FileInputStream(source);
			properties=new Properties();
			properties.load(fileInputStream);
		} catch (Exception e) {
			System.out.println("Not able to load config file "+e.getMessage());
		}
	}
	
	
	public String getBrowser() {
		return properties.getProperty("browser");
	}
	
	public String getStagingURL() {
		return properties.getProperty("url");
	}
	
	public String getDriverLocatioin() {
		return properties.getProperty("driverLocation");
	}
	
	
}
