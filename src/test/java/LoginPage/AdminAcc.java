package LoginPage;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import BasePackage.BassClass;
import ExcelDataPackage.excelUtil;
import POMpackage.AdminPOM;
import POMpackage.HomepagePOM;
import POMpackage.loginPOM;
import POMpackage.pim_POM;
import propertiePackage.propartieClass;

public class AdminAcc extends BassClass{

	HomepagePOM home;
	AdminPOM admin;
	
	@Test(priority = 0)
public void login() throws Exception {
		
		
		propartieClass pro = new propartieClass();
		String name=pr.proparties("username");
		String pass=pr.proparties("password");	
		
		loginPOM pom=new loginPOM(driver);
		Thread.sleep(2000);
		pom.username().sendKeys(name);
		pom.password().sendKeys(pass);
		pom.button().click();
}
	@Test(priority = 1)
	public void add_emp() throws Exception {
		pim_POM pim=new pim_POM(driver);
		home  = new HomepagePOM(driver);
		home.PIM().click();
		pim.addEmp();
		
		pim.firstname().sendKeys(excelUtil.data("Sheet1", 7, 1));
		pim.lastName().sendKeys(excelUtil.data("Sheet1", 8, 1));
		String user_name=pim.firstname().getText();
		System.out.println(user_name);
		pim.cld().click();
		
		pim.new_username().sendKeys(excelUtil.data("Sheet1", 1, 2));
		pim._new_password();
		pim.con_password();
		Thread.sleep(2000);
		pim.save_button().click();
	
	}
	@Test(priority = 2)
	public void userCredential() throws Exception {
	    admin=new AdminPOM(driver);
	    home.Admin();	
	    admin.emp_name().sendKeys(pr.proparties("Admin_EMP"));
		Thread.sleep(2000);

	    admin.emp_dropdown().click();
	    admin.search_b().click();
		Thread.sleep(2000);
		admin.edit();
		admin.role_dropdown().click();
		Thread.sleep(2000);
		admin.role_dropdown2().click();
		admin.save_button().click();

	}
	@Test (priority = 3)
	public void logout() throws Exception {
		Thread.sleep(5000);
		HomepagePOM hm=new HomepagePOM(driver);
		hm.user_dropdown().click();
		Thread.sleep(2000);
		hm.logout2().click();
		Thread.sleep(2000);
	
	}
	
}