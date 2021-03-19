package com.htc.MadisonSite.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Cart {
	protected WebDriver driver;

	private By proceedButton=By.xpath("//*[@id=\"top\"]/body/div/div[2]/div[2]/div/div/div[2]/div[3]/div/ul/li/button");
	
	public Cart(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public void clickProceedButton() {
		driver.findElement(proceedButton).click();;
		
	}
}
