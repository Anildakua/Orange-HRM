package POMpackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LeavePOM {
	
	@FindBy(xpath = "//i[@class='oxd-icon bi-calendar oxd-date-input-icon']")
	WebElement from;
	
	public WebElement from() {
		return from;
}
	
	@FindBy(xpath = "(//i[@class='oxd-icon bi-calendar oxd-date-input-icon'])[2]")
	WebElement to;
	
	public WebElement to() {
		return to;
}
	
	@FindBy(xpath = "//div[@class='oxd-select-text-input']")
	WebElement status;
	
	public WebElement status() {
		return status;
}
	
	@FindBy(xpath = "(//div[@class='oxd-select-text-input'])[2]")
	WebElement type;
	
	public WebElement type() {
		return type;
}
	
	@FindBy(xpath = "(//div[@class='oxd-select-text-input'])[3]")
	WebElement subUnit;
	
	public WebElement subUnit() {
		return subUnit;
}
	
	@FindBy(xpath = "//input[@placeholder='Type for hints...']")
	WebElement EmpName;
	
	public WebElement EmpName() {
		return EmpName;
}
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement SearchButton;
	
	public WebElement SearchButton() {
		return SearchButton;
}
	
	
	@FindBy(xpath = "//span[@class='oxd-topbar-body-nav-tab-item']")
	WebElement Entitlement;
	
	public WebElement Entitlement() {
		return Entitlement;
}
	
	@FindBy(xpath = "//a[@class='oxd-topbar-body-nav-tab-link']")
	WebElement AddEntitle;
	
	public WebElement AddEntitle() {
		return AddEntitle;
}
	
	@FindBy(xpath = "//input[@placeholder='Type for hints...']")
	WebElement Name;
	
	public WebElement Name() {
		return Name;
}
	
	
	@FindBy(xpath = "//div[@class='oxd-select-text-input']")
	WebElement LeaveType;
	
	public WebElement LeaveType() {
		return LeaveType;
}
	
	@FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[2]")
	WebElement LeaveBank;
	
	public WebElement LeaveBank() {
		return LeaveBank;
}
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement EntSave;
	
	public WebElement EntSave() {
		return EntSave;
}
}