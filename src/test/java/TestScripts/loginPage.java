package TestScripts;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import POMpackage.AdminPOM;
import POMpackage.HomepagePOM;
import POMpackage.loginPOM;
import POMpackage.pim_POM;
import UtilityPackage.BaseClass;
import UtilityPackage.excelUtil;
import UtilityPackage.listnerClass;
import UtilityPackage.propartieClass;

@Listeners(listnerClass.class)
public class loginPage extends BaseClass {

	HomepagePOM home;
	AdminPOM admin;
	int cell = 0;
	int cell2= 0;
	int num=0;
	int user=0;
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
		String name_user = pr.proparties("Admin_EMP");
		System.out.println(name_user);
		System.out.println(user_name);
		if (user_name.equalsIgnoreCase(name_user)) {
			System.out.println("if111");
			String name="No Records Found";
			admin.search_b().click();
			Thread.sleep(2000);
			String popup = home.popup().getText();
			System.out.println(popup);
			if (name.equalsIgnoreCase(popup)) {
				System.out.println("if");
				add_emp();
			} else {
				System.out.println("else");
				userCredential();
			}
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
		  String First_name = null;
			String Last_name = null;
			cell2++;
			for (int row = 7; row <= 8; row++) {
					if (row<=7) {
						System.out.println("7th row");
						First_name=excelUtil.data("Sheet1", row, cell);
					} else {
						System.out.println("10th row");
						Last_name=excelUtil.data("Sheet1", row, cell);
					}
			}
		pim.firstname().sendKeys(First_name);
		Thread.sleep(2000);
		pim.lastName().sendKeys(Last_name);
		Thread.sleep(2000);
		String user_name=pim.firstname().getText();
		System.out.println(user_name);
		pim.cld().click();
		Thread.sleep(2000);
		
		 String user_name1 = null;
			user++;
			for (int row = 9; row <= 9; row++) {
					if (row<=9) {
						System.out.println("9th row");
						user_name1=excelUtil.data("Sheet1", row, user);
					} 
			}
		
		pim.new_username().sendKeys(user_name1);
		pim.new_password().sendKeys(excelUtil.data("Sheet1", 2, 2));
		pim.con_password().sendKeys(excelUtil.data("Sheet1", 2, 2));
		Thread.sleep(2000);
		pim.save_button().click();
		String name=pr.proparties("Firstname");
		System.out.println(name);
		num++;
		if (num<=1) {
			System.out.println(name);
			home.Admin();
			verifying();
		}
	}
	

	public void userCredential() throws Exception {
	    admin=new AdminPOM(driver);
		Thread.sleep(2000);
		admin.edit();
		admin.role_dropdown().click();
		Thread.sleep(2000);
		admin.userRole().click();
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
	@Test(priority = 4)
	public void Employee() throws Exception {
		login();
		home.PIM();
		add_emp();
		add_emp();
		
	}
}

