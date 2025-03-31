package POMpackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Apply {

	public WebDriver driver;
	
	public Apply(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements( driver,this);
	}
	
	@FindBy (xpath = "//li[@class='oxd-topbar-body-nav-tab']")
	WebElement Apply;
	
	public WebElement Apply2() {
		return Apply;
}	
	@FindBy(xpath = "//div[@class='oxd-select-text oxd-select-text--active']")
	WebElement leaveType;
	
	public WebElement leaveType() {
		return leaveType;
}
	
	@FindBy(xpath = "//span[text()='CAN - Personal']")
	WebElement CAN_personal;
	
	public WebElement CAN_personal() {
		return CAN_personal;
}	
	
	@FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[2]")
	WebElement From_date;
	
	public WebElement From_date() {
		return From_date;
}	
	
	@FindBy(xpath = "//div[text()='22']")
	WebElement T_date;
	
	public WebElement T_date() {
		return T_date;
}
	
	@FindBy(xpath = "(//input[@placeholder='yyyy-dd-mm'])[2]")
	WebElement To_date;
	
	public WebElement To_date() {
		return To_date;
}	
	
	@FindBy(xpath = "//div[@class='oxd-select-text oxd-select-text--focus']")
	WebElement Duration;
	
	public WebElement Duration() {
		return Duration;
}	
	@FindBy(xpath = "//span[text()='Full Day']")
	WebElement Full_day;
	
	public WebElement Full_day() {
		return Full_day;
}	
	@FindBy(xpath = "//textarea[@class='oxd-textarea oxd-textarea--active oxd-textarea--resize-vertical']")
	WebElement Comments;
	
	public WebElement Comments() {
		return Comments;
}	
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement apply_button;
	
	public WebElement apply_button() {
		return  apply_button;
}
}
