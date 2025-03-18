package POMpackage;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomepagePOM {
	
	public WebDriver driver;
	
	public HomepagePOM(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements( driver ,this);
	}


	@FindBy(xpath = "//a[@class='oxd-main-menu-item']/..")
	List<WebElement> modules;
	
	public List<WebElement> modules() {
		return  modules;
		
	}
	
	public List<WebElement> Admin() {
		if(modules.size() >=1) {
			modules.get(0).click();
		}
		return modules;
	}
	
	public List<WebElement> PIM() {
		if(modules.size() >=1) {
			modules.get(1).click();
		}
		return modules;
	}
	
	public List<WebElement> Leave() {
		if(modules.size() >=1) {
			modules.get(2).click();
		}
		return modules;
	}
	
	@FindBy(xpath = "//p[@class='oxd-userdropdown-name']/../..")
	WebElement  user_dropdown;
	
	public WebElement user_dropdown() {
		return user_dropdown;
	}
	
	@FindBy(xpath = "//a[text()='Logout']")
	WebElement logout;
	
	public WebElement logout() {
		return logout;
	}
	
}
