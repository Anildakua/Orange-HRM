package POMpackage;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminPOM {
	
	WebDriver driver;
	
	public AdminPOM(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements( driver,this);
	}

	@FindBy (xpath = "//div[@class=\"oxd-autocomplete-dropdown --positon-bottom\"]")
	WebElement emp_name_dropdown;
	
	public WebElement emp_dropdown() {
		return emp_name_dropdown;
	}
	
	@FindBy (xpath = "//input[@placeholder='Type for hints...']")
	WebElement Emp_name;
	
	public WebElement emp_name() {
		return Emp_name;
	}
	
	@FindBy (xpath = "//button[@type='submit']")
	WebElement search_button;
	
	public WebElement search_b() {
		return search_button;
	}
	
	@FindBy (xpath = "//button[@class='oxd-icon-button oxd-table-cell-action-space']")
	List<WebElement> Action_images;
	
	public List<WebElement> delete() {
		if(Action_images.size() >=1) {
			Action_images.get(0).click();
		}
		return Action_images;
	}
	
	public List<WebElement> edit() {
		if(Action_images.size() >=1) {
			Action_images.get(1).click();
		}
		return Action_images;
	}
	
	@FindBy (xpath = "//div[@class='oxd-table-cell oxd-padding-cell']")
	List<WebElement> record;
	
	public String role(String role) {
		if(Action_images.size() >=1) {
			 role = Action_images.get(1).getText();
		}
		return role;
	}
	 
	@FindBy (xpath = "//div[@class='oxd-select-text-input']")
	WebElement role_dropdown;
	
	public WebElement role_dropdown() {
		return role_dropdown;
	}
	
	@FindBy (xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")
	WebElement save_button;
	
	public WebElement save_button() {
		return save_button;
	}
	
	@FindBy (xpath = "//div[@class='oxd-select-option'][2]")
	WebElement user_role;
	
	public WebElement userRole() {
		return user_role;
		
	}
	
	
	
	
	
}
