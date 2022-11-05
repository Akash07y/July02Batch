package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Utility;

public class LoginPage {
	
	// Variables - WebElement
	
	@FindBy (xpath = "//input[@id='email']") 
	private WebElement userName ;
	
	@FindBy (xpath = "//input[@id='pass']") 
	private WebElement password ;
	
	@FindBy (xpath = "//button[text()='Log in']") 
	private WebElement loginButton ;
	
	@FindBy (xpath = "//a[text()='Messenger']") 
	private WebElement messengerLink ;
	
	// Constructor - Initilization
	
	// driver123 = driver = new ChromeDriver();
	public LoginPage(WebDriver driver123) {  
		PageFactory.initElements(driver123, this);
	}
	
	// Methods - Actions on weblement
	public void sendUserName(String name) {
		
			userName.sendKeys(name);
	}
	
	public void sendPassword(String pass) {
		password.sendKeys(pass);
	}
	
	public void clickOnLoginButton() {
		loginButton.click();
	}
	
	public void openMessengerPage() {
		messengerLink.click();
	}
	
	// Group of actions
	public void loginToApplication() {
		userName.sendKeys("Velocity");
		password.sendKeys("123456");
		loginButton.click();
	}	
}
