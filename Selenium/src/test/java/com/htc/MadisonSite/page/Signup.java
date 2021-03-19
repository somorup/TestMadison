package com.htc.MadisonSite.page;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Signup {
	protected WebDriver driver;
	
	public Signup(WebDriver driver)
	{
		this.driver = driver;
	}
	
	Properties prop = null;
	public void propertyFile() throws IOException {

		prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\SAUMYARUP\\Downloads\\MadisonSite\\MadisonSite\\src\\test\\resources\\config.properties");
		prop.load(fis);
	}	
	
	private By accountButtonBy = By.xpath("(//span[text() = \"Account\"])[1]");
	private By signUpButtonBy = By.xpath("//a[text() = \"Register\"]");
	private By firstNameBy = By.xpath("//input[@id = \"firstname\"]");
	private By middleNameBy = By.xpath("//input[@id = \"middlename\"]");
	private By lastNameBy = By.xpath("//input[@id = \"lastname\"]");
	private By emailBy = By.xpath("//input[@id = \"email_address\"]");
	private By passcodeBy = By.xpath("//input[@id = \"password\"]");
	private By confirmPasscodeBy = By.xpath("//input[@id = \"confirmation\"]");
	private By registerButtonBy = By.xpath("//span[text() = \"Register\"]");
	private String message="Thank you for registering with Madison Island.";
	
	public void setFirstName(String firstname) {
		driver.findElement(firstNameBy).sendKeys(firstname);
	}
	public void setMiddleName(String middlename) {
		driver.findElement(middleNameBy).sendKeys(middlename);
	}
	
	public void setLastName(String lastname) {
		driver.findElement(lastNameBy).sendKeys(lastname);
	}
	
	public void setEmail(String email) {
		driver.findElement(emailBy).sendKeys(email);
	}
	
	public void setPasscode(String passcode) {
		driver.findElement(passcodeBy).sendKeys(passcode);
	}
	
	public void setConfirmPasscode(String confirmPasscode) {
		driver.findElement(confirmPasscodeBy).sendKeys(confirmPasscode);
	}
	
	public void clickRegButton() {
		driver.findElement(registerButtonBy).click();
	}
	
	public void clickAccountButton() {
		driver.findElement(accountButtonBy).click();
	}
	
	public void clickRegisterButton() {
		driver.findElement(signUpButtonBy).click();
	}
	public String assertMessage() {
		return message;
	}
	
	public DashBoard createNewAccount(String firstname,String middlename, String lastname, String email, String passcode, String confirmPasscode) {
		DashBoard home = null;
		
		this.clickAccountButton();
		this.clickRegisterButton();
		this.setFirstName(firstname);
		this.setMiddleName(middlename);
		this.setLastName(lastname);
		this.setEmail(email);
		this.setPasscode(passcode);
		this.setConfirmPasscode(confirmPasscode);
		this.clickRegButton();
		home = new DashBoard(driver);
		return home;
	}

}
