package testPack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
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

public class VerifyHomePage extends Base{


	private WebDriver driver ;
	private LoginPage loginPage ;
	private MessengerPage messengerPage ;
	private RoomsPage roomsPage ;
	private SoftAssert soft ;
	
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
		System.out.println("test 1");
		roomsPage.retrunToMessenger();
		
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
		//SoftAssert soft = new SoftAssert();
		
		System.out.println("test 2");
		roomsPage.goBackToHelpCenter();
		
		// Actul results 
		String url = driver.getCurrentUrl();
		String title = driver.getTitle();
			
		
		soft.assertEquals(url, "https://www.messenger.com/hel");
		soft.assertEquals(title, "Messenger Help Centr");
		soft.assertAll();
	}
	
	@Test (dependsOnMethods = "verifyContactToHelpCenter")
	public void verifyContactToHelpCenter12345() throws InterruptedException {
		//SoftAssert soft = new SoftAssert();
		
		System.out.println("test 2");
		roomsPage.goBackToHelpCenter();
		
		// Actul results 
		String url = driver.getCurrentUrl();
		String title = driver.getTitle();
			
		
		soft.assertEquals(url, "https://www.messenger.com/hel");
		soft.assertEquals(title, "Messenger Help Centr");
		soft.assertAll();
	}
	
	@AfterMethod
	public void logOutFromApplication() {		
		System.out.println("after method");
		System.out.println("logout");
	}
	
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
