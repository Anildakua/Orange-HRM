package POMpackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeavePOM {
	
	public WebDriver driver;
	
	public LeavePOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements( driver,this);
	}
	@FindBy(linkText = "Leave")
	WebElement leaveModule;
	
	public WebElement leaveModule() {
		return leaveModule;
}
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
	
	@FindBy(xpath = "//div[@class='oxd-autocomplete-option']")
	WebElement NameSuggestion;
	
	public WebElement NameSuggestion() {
		return NameSuggestion;
}
	
	
	//div[@class='oxd-autocomplete-option']
	@FindBy(xpath = "//div[@class='oxd-select-text-input']")
	WebElement LeaveType;
	
	public WebElement LeaveType() {
		return LeaveType;
}
	
	@FindBy(xpath = "(//div[@class='oxd-select-option'])[5]" )
	WebElement LeaveTypeSelect;
	
	public WebElement LeaveTypeSelect() {
		return LeaveTypeSelect;
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
	@FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-button-margin']")
	WebElement Confirm;
	
	public WebElement Confirm() {
		return Confirm;
}
	
	@FindBy(xpath = "//input[@placeholder='Type for hints...']")
	WebElement EmpLeave;
	
	public WebElement EmpLeave() {
		return EmpLeave;
}
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement EmpSearch;
	
	public WebElement EmpSearch() {
		return EmpSearch;
}
//	@FindBy(xpath = "//a[text()='Apply']")
//	WebElement Apply;
//	
//	public WebElement Apply() {
//		return Apply;
//}
	@FindBy(xpath = "//div[@class='oxd-select-text oxd-select-text--active']")
	WebElement Leavetype_leve;
	
	public WebElement Leave_Type_leave() {
		return Leavetype_leve;
}
	
	@FindBy(xpath = "//div[@class='oxd-autocomplete-option']")
	WebElement Suggestion;
	
	public WebElement Suggestion() {
		return Suggestion;
}
	
	@FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--label-success oxd-table-cell-action-space']")
	WebElement Approve;
	
	public WebElement Approve() {
		return Approve;
}
	
	
	@FindBy(xpath = "(//div[@class='oxd-table-row oxd-table-row--with-border'])[2]")
	WebElement my_leve_first_record;
	
	public WebElement my_leve_first_record() {
		return my_leve_first_record;
}
	
	@FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--label-warn oxd-table-cell-action-space']")
	WebElement my_leve_cancel_Button;
	
	public WebElement my_leve_cancel_Button() {
		return my_leve_cancel_Button;
}
	
	@FindBy(xpath = "(//div[@class='oxd-table-cell oxd-padding-cell'])[7]")
	WebElement my_leve_status;
	
	public WebElement my_leve_status() {
		return my_leve_status;
}
	
}