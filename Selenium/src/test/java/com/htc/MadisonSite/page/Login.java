package com.htc.MadisonSite.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Login extends Base {

	private By selectList=By.xpath("//*[@id=\"nav\"]/ol/li[4]/a");	
	private By selectOption=By.xpath("//*[@id=\"nav\"]/ol/li[4]/ul/li[2]/a");//By.xpath("//*[@id=\"nav\"]/ol/li[4]/child::ul/child::li/child::a[text()=\"Books & Music\"]");
	private By dashboard=By.xpath("//h1[.=\"My Dashboard\"]");	
	public Login(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public String pageTitle() {
		return driver.getTitle();
	}
	public void clickandSelectList() {
		WebElement list1=driver.findElement(selectList);
		Actions ac=new Actions(driver);
		ac.moveToElement(list1).perform();
	}
	public void clickBooksOption() {
		driver.findElement(selectOption).click();
	}
	public void loginActions() {
		this.clickandSelectList();
		this.clickBooksOption();
	}
	public boolean isDashbordDisplayed() {
		boolean flag=false;
		WebElement dash=driver.findElement(dashboard);
		flag=dash.isDisplayed();
		return flag;
	}

}
