package POMpackage;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class pim_POM {
	
	public WebDriver driver;
	public pim_POM(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements( driver ,this);
	}

	@FindBy (xpath = "//i[@class='oxd-icon bi-plus oxd-button-icon']")
	WebElement add_button;
	
	public WebElement add() {
		return add_button;
	}
	 @FindBy (xpath = "//li[@class='oxd-topbar-body-nav-tab']")
	 List<WebElement> PIM_top;
	 
	 public List<WebElement> top() {
		return PIM_top;
		 
	 }
	 
	 
	 public List<WebElement> addEmp() {
		 if(PIM_top.size() >=0) {
				PIM_top.get(0).click();
			}
		return PIM_top;	 
	 }
	 
	 public List<WebElement> report() {
		 if(PIM_top.size() >=1) {
				PIM_top.get(1).click();
			}
		return PIM_top;
	 }
	 
	 @FindBy (xpath = "//input[@class='oxd-input oxd-input--active orangehrm-firstname']")
	 WebElement first_name;
	 
	 public WebElement firstname() {
		return first_name;
	 }
	 
	 @FindBy (xpath = "//input[@name='middleName']")
	 WebElement middleName;
	 
	 public WebElement middleName() {
		return middleName;
	 }
	 
	 @FindBy (xpath = "//input[@name='lastName']")
	 WebElement lastName;
	 
	 public WebElement lastName() {
		return lastName;
	 }
	 
	 @FindBy (xpath = "//span[@class='oxd-switch-input oxd-switch-input--active --label-right']")
	 WebElement Cre_log_details;
	 
	 public WebElement cld() {
		return Cre_log_details;
	 }
	 
	
	 
	 
	 @FindBy (xpath = "(//input[@class='oxd-input oxd-input--active'])[3]")
	 WebElement username;
	 
	 public WebElement new_username() {
			return username;
		 }
	 
	 @FindBy (xpath = "(//input[@type='password'])[1]")
	 WebElement new_password;
	 
	 public WebElement new_password() {
			return new_password;
		 }
	 
	 @FindBy (xpath = "(//input[@type='password'])[2]")
	 WebElement con_password;
	 
	 public WebElement con_password() {
			return con_password;
		 }
	 
	 @FindBy (xpath = "//button[@type='submit']")
	 WebElement save_button;
	 
	 public WebElement save_button() {
		return save_button;
		}
	 
	 @FindBy (xpath = "(//input[@class='oxd-input oxd-input--active'])[3]")
	public
	 WebElement emp_username;
	 
	 public WebElement emp_username() {
		return emp_username;
		}
}
