package LoginPage;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import BasePackage.BassClass;
import ExcelDataPackage.excelUtil;
import POMpackage.AdminPOM;
import POMpackage.HomepagePOM;
import POMpackage.loginPOM;
import POMpackage.pim_POM;
import propertiePackage.propartieClass;

public class loginPage extends BassClass {

	HomepagePOM home;
	AdminPOM admin;
	int cell = 0;
	@Test (priority = 0)
	public void login() throws Exception {
		
//		String name=pr.proparties("username");
//		String pass=pr.proparties("password");	
        String name = null;
		String pass = null;
		cell++;
		for (int row = 0; row <= 2; row++) {
				if (row<=1) {
					name=excelUtil.data("Sheet1", row, cell);
				} else {
					pass=excelUtil.data("Sheet1", row, cell);
				}
		}
		loginPOM pom=new loginPOM(driver);
		Thread.sleep(2000);
		pom.username().sendKeys(name);
		pom.password().sendKeys(pass);
		pom.button().click();
	}
	
	@Test (priority = 1)
	public void Home() throws Exception {
		home=new HomepagePOM(driver);
		home.Admin();
		Thread.sleep(2000);
		
	}
	
	@Test (priority = 2)
	public void verifying() throws Exception {
		admin=new AdminPOM(driver);
		admin.emp_name().sendKeys(pr.proparties("Admin_EMP"));
		Thread.sleep(2000);
		String user_name = admin.emp_dropdown().getText();
		admin.emp_dropdown().click();
		Thread.sleep(2000);
		String name=pr.proparties("Admin_EMP");
		
		if (name.equalsIgnoreCase(user_name)) {
			userCredential();
			
		} else {
			add_emp();

		}
	}
	
	
	public void add_emp() throws Exception {
		pim_POM pim=new pim_POM(driver);
		Thread.sleep(2000);
		home.PIM().click();
		pim.addEmp();
		Thread.sleep(2000);
		pim.firstname().sendKeys(pr.proparties("Firstname"));
		pim.lastName().sendKeys(pr.proparties("Lasrname"));
		Thread.sleep(2000);
		pim.cld().click();
		Thread.sleep(2000);
		pim.new_username();
		pim._new_password();
		pim.con_password();
		Thread.sleep(2000);
		pim.save_button().click();
	}
	

	public void userCredential() throws Exception {
	    admin=new AdminPOM(driver);
		Thread.sleep(2000);
		admin.search_b().click();
		admin.edit();
		admin.role_dropdown().click();
		Thread.sleep(2000);
		admin.userRole().click();
		admin.save_button().click();

	}
	@Test (priority = 3)
	public void logout() throws Exception {
		HomepagePOM hm=new HomepagePOM(driver);
		hm.user_dropdown().click();
		Thread.sleep(2000);
		hm.logout().click();
		Thread.sleep(2000);
	
	}
}
