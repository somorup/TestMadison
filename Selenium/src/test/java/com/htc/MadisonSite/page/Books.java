package com.htc.MadisonSite.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Books extends Base {

	private By selectBook=By.xpath("//*[@id=\"top\"]/body/div/div[2]/div[2]/div/div[2]/div[3]/ul/li[2]/div/h2/a");	
	
		
	public Books(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public void selectBookFromList() {
		driver.findElement(selectBook).click();
	}
}
