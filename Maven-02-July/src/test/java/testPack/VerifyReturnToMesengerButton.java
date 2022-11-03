package testPack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.LoginPage;
import pages.MessengerPage;
import pages.RoomsPage;

public class VerifyReturnToMesengerButton {
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\akash\\OneDrive\\Documents\\Automation\\Selenium\\chromedriver_win32 (4)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		// To verify Return to mesenger.com
		driver.get("https://www.facebook.com/");	
	
		LoginPage loginPage  = new LoginPage(driver) ;
		loginPage.openMessengerPage();
		
		MessengerPage messengerPage = new MessengerPage(driver);
		messengerPage.clickOnRoomsTab();
		
		RoomsPage roomsPage = new RoomsPage(driver);
		roomsPage.retrunToMessenger();
		
		// Actul results 
		String url = driver.getCurrentUrl();
		String title = driver.getTitle();
		
		if(url.equals("https://www.messenger.com/")  && title.equals("Messenger"))
		{
			System.out.println("PASSED");
		}
		else
		{
			System.out.println("FAILED");
		}
		
		
		
		
		
		
	}

}
