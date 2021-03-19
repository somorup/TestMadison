package com.htc.MadisonSite.seleniumUtility;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.Properties;
import org.testng.annotations.DataProvider;

import com.htc.MadisonSite.javaUtility.ExcelFileReader;
public class MadisonDataProvider {
public Properties data;
public MadisonDataProvider()
{
		data=new Properties();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("C:\\Users\\SAUMYARUP\\Downloads\\MadisonSite\\MadisonSite\\src\\test\\resources\\config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			data.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
//	@DataProvider(name = "seleniumLogin_data")
//	public Object[][] madisonSigninValidData(Method m)
//	{
//		ExcelFileReader ref= new ExcelFileReader(data.getProperty("seleniumstore.datas"));
//		Object[][] loginDataSet=null;
//		if(m.getName().equals("testLoginPage_shouldLoginSuccessfully")) {
//
//			loginDataSet=ref.getDataUsingMap(data.getProperty("seleniumstore.valid.sheetname"));
//		}
//		else {
//			loginDataSet=ref.getDataUsingMap(data.getProperty("seleniumstore.invalid.sheetname"));
//		}
//		System.out.println("test"+loginDataSet.length);
//		return loginDataSet;
//	}
//	
	@DataProvider(name = "customeraddress")
	public Object[][] ecomStoreAddressData()
	{
        ExcelFileReader ref= new ExcelFileReader(data.getProperty("seleniumstore.datas"));
        Object[][] loginDataSet=ref.getDataAsMap(data.getProperty("seleniumstore.sheetname.address"));
        System.out.println("test"+loginDataSet.length);
		return loginDataSet;
		}
	
	@DataProvider(name = "userregister")
	public Object[][] ecomStoreRegisterValidData()
	{

		ExcelFileReader ref= new ExcelFileReader(data.getProperty("seleniumstore.datas"));

		Object[][] loginDataSet=ref.getDataAsMap(data.getProperty("seleniumstore.sheetname.register"));

		System.out.println(loginDataSet.length);
		return loginDataSet;

	}
	
			@DataProvider(name = "logindata")
			public Object[][] ecomStoreSigninInValidData()
			{
	            ExcelFileReader ref= new ExcelFileReader(data.getProperty("seleniumstore.datas"));
	            Object[][] loginDataSet=ref.getDataAsMap(data.getProperty("seleniumstore.sheetname.all"));
	            System.out.println(loginDataSet.length);
				return loginDataSet;
	
			}

}