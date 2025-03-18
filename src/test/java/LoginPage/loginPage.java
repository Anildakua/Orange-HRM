package LoginPage;


import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import BasePackage.BassClass;
import POMpackage.HomepagePOM;
import POMpackage.loginPOM;
import POMpackage.pim_POM;
import propertiePackage.propartieClass;

public class loginPage extends BassClass {

	@Test (priority = 0)
	public void login() throws Exception {
		
		
		String name=pr.proparties("username");
		String pass=pr.proparties("password");
		loginPOM pom=new loginPOM(driver);
		Thread.sleep(2000);
		pom.username().sendKeys(name);
		pom.password().sendKeys(pass);
		pom.button().click();
		
		
	}
	
	@Test (priority = 1)
	public void Home() throws Exception {
		
		HomepagePOM home=new HomepagePOM(driver);
		home.Admin();
		Thread.sleep(2000);
		driver.navigate().back();
		home.PIM();
		Thread.sleep(2000);
		
	}
	
	@Test (priority = 2)
	public void add_emp() throws Exception {
		pim_POM pim=new pim_POM(driver);
		pim.addEmp();
		Thread.sleep(2000);
		pim.firstname().sendKeys("rocky");
		pim.lastName().sendKeys("bhai");
		Thread.sleep(2000);
		pim.cld().click();
		Thread.sleep(2000);
		pim.new_username();
		pim._new_password();
		pim.con_password();
		Thread.sleep(2000);
		pim.save_button().click();
	}
	
	
	@Test (priority = 3)
	public void logout() throws Exception {
		HomepagePOM hm=new HomepagePOM(driver);
		hm.user_dropdown().click();
		Thread.sleep(2000);
		hm.logout().click();
		loginPOM pom=new loginPOM(driver);
		Thread.sleep(2000);
		pom.username().sendKeys("Rocky");
		pom.password().sendKeys("Rocky@123");
		pom.button().click();
	}
}
