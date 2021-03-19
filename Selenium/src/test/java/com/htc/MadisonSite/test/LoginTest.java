package com.htc.MadisonSite.test;
import java.util.Map;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.htc.MadisonSite.BaseTest;
import com.htc.MadisonSite.seleniumUtility.MadisonDataProvider;
public class LoginTest extends BaseTest{
	@Test(dataProviderClass=MadisonDataProvider.class,dataProvider ="data" )
	public void test(Map<String,String> mapData)
	{
		System.out.println("Test Started");
		logger=report.createTest("Login to Madison with invalid");
		db.loginWithCredantials(mapData.get("email"), mapData.get("password"));
		if(mapData.get("Expected").equals("My Account")) {
			Assert.assertTrue(login.isDashbordDisplayed());
			db.performLogOut();
		}
		if(mapData.get("Expected").equals("Invalid login or password.")) {
			Assert.assertTrue(db.isErrorDisplayed());
		}
		System.out.println("Test Ends");
	}
}
