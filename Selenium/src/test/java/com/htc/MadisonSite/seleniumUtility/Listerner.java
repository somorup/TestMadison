package com.htc.MadisonSite.seleniumUtility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

public class Listerner implements ITestListener {
	protected WebDriver driver;
	ExtentTest logger;
	
	public void onTestStart(ITestResult result) {
	System.out.println("TestCases start and details are"+result.getName());
		
	}
	
	public void onStart(ITestContext context) {
		System.out.println("Testcase Starts"+context.getName());
		
	}

	public void onFinish(ITestContext context) {
		System.out.println("Testcase Finish"+context.getName());
		
	}
	public void onTestSuccess(ITestResult result) {
		System.out.println("TestCases Success and details are"+result.getName());
		TestUtil.captureScreenShot(driver,result);
		try {
			logger.pass("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(TestUtil.captureScreenShot(driver, result)).build());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
   }

	public void onTestFailure(ITestResult result) {
		
		System.out.println("TestCases failed and details are"+result.getName());
		System.out.println(result.getThrowable().getStackTrace());
		TestUtil.captureScreenShot(driver,result);
		try {
			logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(TestUtil.captureScreenShot(driver, result)).build());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("TestCases Skipped and details are"+result.getName());
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		System.out.println("TestCases failed and details are"+result.getName());
	}


	
	

}
