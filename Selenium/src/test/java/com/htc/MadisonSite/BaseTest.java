package com.htc.MadisonSite;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.htc.MadisonSite.javaUtility.BrowserFactory;
import com.htc.MadisonSite.javaUtility.DataProvider;
import com.htc.MadisonSite.page.Books;
import com.htc.MadisonSite.page.Cart;
import com.htc.MadisonSite.page.CheckOut;
import com.htc.MadisonSite.page.DashBoard;
import com.htc.MadisonSite.page.Login;
import com.htc.MadisonSite.page.ProductOrder;
import com.htc.MadisonSite.page.Signup;
import com.htc.MadisonSite.page.ProductOrderConfirmation;
import com.htc.MadisonSite.seleniumUtility.TestUtil;
public class BaseTest {
	public static WebDriver driver = null;
    protected Signup su = null;
	protected DashBoard db = null;
	protected DataProvider config=null;
	protected Login login = null;
	protected Books books=null;
	protected Cart cart=null;
	protected ProductOrder addToCart=null;
	protected CheckOut checkOut=null;
	protected ProductOrderConfirmation order=null;
	protected ExtentReports report;
	protected ExtentTest logger;
	public Properties data=null;
	private WebElement logout;

	@BeforeSuite
	public void loadProptiesFile()
	{
		Reporter.log("Setting up reports and Test is getting ready", true);
		data=new Properties();
		try {
			FileInputStream fis=new FileInputStream("C:\\Users\\SAUMYARUP\\Downloads\\MadisonSite\\MadisonSite\\src\\test\\resources\\config.properties");
			data.load(fis);
		}  catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ExtentHtmlReporter htmlReport=new ExtentHtmlReporter(new File("./Reports/MadisonIsland_"+TestUtil.getCurrentDateTime()+".html"));
		report=new ExtentReports();
		report.attachReporter(htmlReport);
		config=new DataProvider();
		Reporter.log("Setting up reports", true);
	}

	@BeforeClass
	public void setup() {
		driver=BrowserFactory.startBrowser(driver,config.getBrowser(),config.getStagingURL(),config.getDriverLocatioin());
		Reporter.log("Trying to start Browser and Getting Application ready", true);
		Reporter.log("Browser and Application up and running", true);
		books=new Books(driver);
		addToCart=new ProductOrder(driver);
		cart=new Cart(driver);
		checkOut=new CheckOut(driver);
		su = new Signup(driver);
		order=new ProductOrderConfirmation(driver);
		db=new DashBoard(driver);
		login=new Login(driver);
	}
	
	@AfterMethod
	public void createScreenshot(ITestResult result) throws IOException {
		Reporter.log("Test is about to end", true);

		if(result.getStatus()==ITestResult.FAILURE) 
		{
			//TestUtil.captureScreenShot(driver);
			logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(TestUtil.captureScreenShot(driver,result)).build());
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			logger.pass("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(TestUtil.captureScreenShot(driver,result)).build());
		}
		report.flush();

		Reporter.log("Test is Completed and Reports Generated", true);
	}
	
	@AfterTest
	public void Signoff()
	{
		logout = db.getLogoutButton();
		if(logout.isDisplayed())
		{
			db.performLogOut();
		}
	}
	
	
	

}