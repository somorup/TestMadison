package com.htc.MadisonSite.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductOrderConfirmation {
	protected WebDriver driver;
	private By message=By.xpath("//*[@id=\"top\"]/body/div/div[2]/div[2]/div/div/h2");	

		
	public ProductOrderConfirmation(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	public String SuccessMsg() {
		String text=driver.findElement(message).getText();
		return text;
	}
}
