package POMpackage;

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
}
