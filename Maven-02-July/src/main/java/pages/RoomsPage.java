package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RoomsPage {
	
	private WebDriver driver ; 
	private WebDriverWait wait ;
	
	@FindBy (xpath = "//a[text()=' Return to messenger.com ']")
	private WebElement returnButton; 
	
	// to find multiple webelement having same xpath
	// findElements method 
	@FindBy (xpath = "//a[text()=' Visit our help center ']")
	private WebElement contactToHelpCenter; 

	// what is @FindAll
	
	public RoomsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver ;
	}
	
	public void retrunToMessenger() {
		returnButton.click();
	}
	
	public void  goBackToHelpCenter() {	
		contactToHelpCenter.click();
	}
	
}

// POM 
// WebElement related 

//select class
//Action class mouse action 
//scroll dowen ScrollIntoView()
//iframe handling using WebElement
//Explicit Wait 









