package com.htc.MadisonSite.test;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.htc.MadisonSite.BaseTest;
import com.htc.MadisonSite.seleniumUtility.MadisonDataProvider;

public class SignupTest extends BaseTest {


	@Test(dataProviderClass=MadisonDataProvider.class,dataProvider ="selenium_register")
	public void testCreateAccount_fillDetails_ShouldCreateNewAccountsuccessfully(Map<String,String> mapData) {
		System.out.println("Test Started");
		logger=report.createTest("Madison Registration");
		db = su.createNewAccount(mapData.get("firstName"),mapData.get("middleName"),mapData.get("lastName"), mapData.get("emailId"), mapData.get("password"), mapData.get("confirm"));
		Assert.assertEquals(db.isWelcomeTextDisplayed(), mapData.get("expected"));
       db.clickAccountButton();
		db.clickLogoutButton();
	}
}
