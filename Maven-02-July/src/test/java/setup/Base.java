package setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class Base {

	// Browser related code 
	
	public static WebDriver openChromeBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\akash\\OneDrive\\Documents\\Automation\\Selenium\\chromedriver_win32 (4)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		return driver ;
	}
	
	//ssdbfdmnfdfmbvbnnvc
	//	fgdfgfgfdg
	
	public static WebDriver openOperaBrowser() {
		System.setProperty("webdriver.opera.driver", "C:\\Users\\akash\\geckodriver-v0.31.0-win64\\operadriver.exe");
		WebDriver driver = new OperaDriver();
		return driver ;
	}
	
	
}
