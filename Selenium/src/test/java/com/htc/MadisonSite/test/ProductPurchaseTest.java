package com.htc.MadisonSite.test;

import java.util.Map;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.htc.MadisonSite.BaseTest;

public class ProductPurchaseTest extends BaseTest {

	@Test(dataProviderClass=DataProvider.class,dataProvider ="ecomLogin_address" )
	public void testLoginPage_enterCredantials_shouldLoginSuccessful(Map<String,String> mapData) {
		System.out.println("Test Started");
		logger=report.createTest("Login and Purchase in Madison");

		db.loginWithCredantials(mapData.get("email"),  mapData.get("password"));
		login.loginActions();
		
		books.selectBookFromList();
		
		addToCart.addCart();
		
		cart.clickProceedButton();
		
		checkOut.checkOutOperations(mapData.get("address"),mapData.get("city"),mapData.get("state"),mapData.get("zcode"),mapData.get("tel"));
      Assert.assertEquals(order.SuccessMsg(),mapData.get("expected"));//THANK YOU FOR YOUR PURCHASE!
	
	db.performLogOut();
	System.out.println("Test Ends");
	}
}
