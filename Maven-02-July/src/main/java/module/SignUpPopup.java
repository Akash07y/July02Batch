package module;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPopup {
	
	// Variables
	@FindBy (xpath = "//a[text()='Rooms']") 
	private WebElement firstName ;
	
	@FindBy (xpath = "//a[text()='Features']") 
	private WebElement lastName ;
	
	@FindBy (xpath = "//a[text()='Desktop app']") 
	private WebElement mobileNo ;
	
	// Constructor - Initilization
	public SignUpPopup(WebDriver driver) {
		PageFactory.initElements(driver, this);		
	}
	
	// Methods - Actions on weblement
	
	public void sendFirstName() {
		firstName.sendKeys("Akash");
	}
	
	public void sendLastName() {
		lastName.sendKeys("Akash");
	}
	
	public void sendMibileNo() {
		mobileNo.sendKeys("Akash");
	}
}
