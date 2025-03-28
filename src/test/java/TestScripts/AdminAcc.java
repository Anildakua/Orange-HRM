package TestScripts;

import org.testng.annotations.Test;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import POMpackage.AdminPOM;
import POMpackage.HomepagePOM;
import POMpackage.loginPOM;
import POMpackage.pim_POM;
import UtilityPackage.BassClass;
import UtilityPackage.excelUtil;
import UtilityPackage.listnerClass;
import UtilityPackage.propartieClass;
@Listeners(listnerClass.class)
public class AdminAcc extends BassClass{

	HomepagePOM home;
	AdminPOM admin;
	
	@Test(priority = 0)
public void login() throws Exception {
		
		
		propartieClass pro = new propartieClass();
		String name=pr.proparties("username");
		String pass=pr.proparties("password");	
		
		loginPOM pom=new loginPOM(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(pom.username()));
		pom.username().sendKeys(name);
		pom.password().sendKeys(pass);
		pom.button().click();
}
	@Test(priority = 1)
	public void add_emp() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		String expected_result = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
		String actual_result =driver.getCurrentUrl();
		if(expected_result.equals(actual_result)) {
			System.out.println("I am homepage");
		
		pim_POM pim=new pim_POM(driver);
		home  = new HomepagePOM(driver);
		wait.until(ExpectedConditions.elementToBeClickable(home.PIM()));
		home.PIM().click();
		pim.addEmp();
		wait.until(ExpectedConditions.visibilityOf(pim.firstname()));
		pim.firstname().sendKeys(excelUtil.data("Sheet1", 7, 1));
		pim.lastName().sendKeys(excelUtil.data("Sheet1", 8, 1));
		String user_name=pim.firstname().getText();
		System.out.println(user_name);
		pim.cld().click();
		
		pim.new_username().sendKeys(excelUtil.data("Sheet1", 1, 2));
		pim._new_password();
		pim.con_password();
		wait.until(ExpectedConditions.elementToBeClickable(pim.save_button()));
		Thread.sleep(5000);
		pim.save_button().click();
		Thread.sleep(5000);
		}else {
			System.out.println("I am not Homepage");
		}
	}
	@Test(priority = 2)
	public void userCredential() throws Exception {
		String expected_result2 = "OrangeHRM";
		String actual_result2 =driver.getTitle();
		if(expected_result2.equals(actual_result2)) {
			System.out.println("I am Admin Page");
		
	    admin=new AdminPOM(driver);
	    home.Admin();	
	    admin.emp_name().sendKeys(pr.proparties("Admin_EMP"));
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(admin.emp_dropdown()));
	    admin.emp_dropdown().click();
	    admin.search_b().click();
		//wait.until(ExpectedConditions.presenceOfElementLocated((By) admin.edit_button()));
		admin.edit();
		admin.role_dropdown().click();
		wait.until(ExpectedConditions.visibilityOf(admin.role_dropdown2()));
		admin.role_dropdown2().click();
		admin.save_button().click();
		wait.until(ExpectedConditions.visibilityOf(admin.adminPopUP()));
		}else {
			System.out.println("I am not Admin Page");
		}

	}
	@Test (priority = 3)
	public void logout() throws Exception {
		HomepagePOM hm=new HomepagePOM(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(hm.user_dropdown()));
		hm.user_dropdown().click();
		wait.until(ExpectedConditions.elementToBeClickable(hm.logout2()));
		hm.logout2().click();	
	}
	
}