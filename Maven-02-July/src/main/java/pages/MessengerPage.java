package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MessengerPage {
	// Variables
	@FindBy (xpath = "//a[text()='Rooms']") 
	private WebElement rooms ;
	
	@FindBy (xpath = "//a[text()='Features']") 
	private WebElement features ;
	
	@FindBy (xpath = "//a[text()='Desktop app']") 
	private WebElement desktopApp ;
	
	// Constructor - Initilization
	public MessengerPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	// Methods - Actions on weblement
	public void clickOnRoomsTab() {
		rooms.click();
	}
	
	public void clickOnFearuresTab() {
		features.click();
	}
	
	public void clickOnDesktopAppTab() {
		desktopApp.click();
	}
}
