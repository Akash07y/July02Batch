package testPack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.LoginPage;
import pages.MessengerPage;
import pages.RoomsPage;
import setup.Base;
import utils.Utility;

public class VerifyRoomsPage extends Base {
	
	private WebDriver driver ;
	private LoginPage loginPage ;
	private MessengerPage messengerPage ;
	private RoomsPage roomsPage ;
	private SoftAssert soft ;
	private int testID;
	@Parameters ("browser")
	@BeforeTest
	public void launchBrowser(String browserName) {
		
		System.out.println(browserName);
		if(browserName.equals("Chrome"))
		{
			driver = openChromeBrowser();
		}
		
		if(browserName.equals("Firefox"))
		{
			driver = openFirefoxBrowser();
		}
		
		if(browserName.equals("Opera"))
		{
			driver = openOperaBrowser();
		}
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();	
	}
	
	@BeforeClass
	public void creatPOMObjects() {
		loginPage  = new LoginPage(driver) ;
		
		String data = Utility.getDataFromExelSheet("test", 2, 1);
		
		loginPage.sendUserName(data);
		
		data = Utility.getDataFromExelSheet("test", 2, 2);
		
		loginPage.sendPassword(data);
		
		
		
		messengerPage = new MessengerPage(driver);
		roomsPage = new RoomsPage(driver);
	}
	
	@BeforeMethod
	public void openRoomsPage() {
		System.out.println("before method");
		driver.get("https://www.facebook.com/");		
		loginPage.openMessengerPage();
		messengerPage.clickOnRoomsTab();
		soft = new SoftAssert();
	}
	
	

	@Test 
	public void verifyReturnToMessangerButton() throws InterruptedException {
		testID = 1234 ;
		System.out.println("test 1");
		roomsPage.retrunToMessenger();
		
		if( j.equals("mobile"))
		Thread.sleep(2000);
		// Actul results 
		String url = driver.getCurrentUrl();
		String title = driver.getTitle();
	
		soft.assertEquals(url, "https://www.messenger.com");
		soft.assertEquals(title, "Messenge");
		soft.assertAll();
	}
	
	@Test
	public void verifyContactToHelpCenter() throws InterruptedException {
		testID = 11122 ;
		//SoftAssert soft = new SoftAssert();
		
		System.out.println("test 2");
		roomsPage.goBackToHelpCenter();
		
		// Actul results 
		String url = driver.getCurrentUrl();
		String title = driver.getTitle();
			
		
		soft.assertEquals(url, "https://www.messenger.com/help");
		soft.assertEquals(title, "Messenger Help Centre");
		soft.assertAll();
	}
	
	@AfterMethod 
	public void logOutFromApplication(ITestResult result) {	
		
		if(ITestResult.FAILURE == result.getStatus())
		{
			Utility.captureScrreen(testID, driver);
		}
		
		System.out.println("after method");
		System.out.println("logout");
	}
	
	// TestNG Listners  -> maintaing the results/status of test methods 
//	   ITestResult
//	   ITestReporter
//	   ITestListner
//	
//	
	
	
	
	
	
	@AfterClass
	public void clearObjet() {
		loginPage  = null;
		messengerPage = null;
		roomsPage = null;
	}
	
	@AfterTest
	public void cloaseBrowser() {
		driver.close();
		driver = null;
		// to remove delete all object without referance
		System.gc();   // Garbeg Collector 	
	}
}
