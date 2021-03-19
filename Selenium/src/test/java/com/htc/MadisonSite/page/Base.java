package com.htc.MadisonSite.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base{
	
	WebDriver driver;
	
	public Base(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public static int explicitWaitTime=10;
	WebDriverWait wait =null;

	public boolean waitForVisibilityOfElements(By locators)
	{
	wait = new WebDriverWait(driver, explicitWaitTime);
	wait.until(ExpectedConditions.visibilityOfElementLocated(locators));
	return true;
}

public void waitForElementToBeClickable(WebDriver driver, By locators) {
	wait = new WebDriverWait(driver, explicitWaitTime);
	wait.until(ExpectedConditions.elementToBeClickable(locators));
}

public void waitForElementToBeSelectable(WebDriver driver, By locators) {
	wait = new WebDriverWait(driver, explicitWaitTime);
	wait.until(ExpectedConditions.elementToBeSelected(locators));
	
}

}
