package LoginPage;


import org.openqa.selenium.WebElement;
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
//		home.Admin();
//		Thread.sleep(2000);
//		driver.navigate().back();
		home.PIM();
		Thread.sleep(2000);
		
	}
	
	@Test (priority = 2)
	public void add_emp() throws Exception {
		pim_POM pim=new pim_POM(driver);
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
	
	@Test (priority = 3)
	public void userCredential() throws Exception {
		AdminPOM admin=new AdminPOM(driver);
		home.Admin();
		Thread.sleep(2000);
		admin.emp_name().sendKeys(pr.proparties("Admin_EMP"));
		Thread.sleep(2000);
		admin.emp_dropdown().click();
		Thread.sleep(2000);
		admin.search_b().click();
		admin.edit();
		
	}
//	@Test (priority = 4)
//	public void logout() throws Exception {
//		HomepagePOM hm=new HomepagePOM(driver);
//		hm.user_dropdown().click();
//		Thread.sleep(2000);
//		hm.logout().click();
//	
//	}
}
