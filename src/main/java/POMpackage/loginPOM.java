package POMpackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPOM {
	
	public WebDriver driver;
	
	public loginPOM(WebDriver driver) {
	 this.driver=driver;
	 PageFactory.initElements( driver, this);
	}

	@FindBy (xpath = "//input[@name='username']")
	WebElement username;
	
	public WebElement username() {
		return username;
	}
	
	@FindBy (xpath = "//input[@name='password']")
	WebElement password;
	
	public WebElement password() {
		return password;
		
	}
	
	@FindBy (xpath = "//button[@type='submit']")
	WebElement button;
	 
	public WebElement button() {
		return button;
		
	}
}
