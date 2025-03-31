package TestScripts;

import org.testng.annotations.Test;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import POMpackage.AdminPOM;
import POMpackage.Apply;
import POMpackage.HomepagePOM;
import POMpackage.LeavePOM;
import POMpackage.loginPOM;
import UtilityPackage.BaseClass;
import UtilityPackage.excelUtil;
import UtilityPackage.propartieClass;

public class ApplyLeave extends BaseClass {

	HomepagePOM home;
	AdminPOM admin;
	LeavePOM leave;
	WebDriverWait wait;
	Apply apply;
	
	@Test(priority = 0)
    public void login() throws Exception {
		

		String name=excelUtil.data("Sheet1", 9, 2);
		String pass=excelUtil.data("Sheet1", 2, 2);	
		loginPOM pom=new loginPOM(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(pom.username()));
		pom.username().sendKeys(name);
		pom.password().sendKeys(pass);
		pom.button().click();
 }
	
	@Test(priority = 1)
	public void apply() throws Exception {
		home=new HomepagePOM(driver);
		apply=new Apply(driver);
		
		home.Leave();
	
		apply.Apply2().click();
		Thread.sleep(2000);
		
		apply.leaveType().click();
	
		apply.CAN_personal().click();
		System.out.println("01");
		apply.From_date().sendKeys("2025-20-03");
		System.out.println("02");
		Thread.sleep(2000);
		System.out.println("03");
		apply.To_date().click();
//		apply.To_date().clear();
		Thread.sleep(2000);
		apply.T_date().click();
		System.out.println("04");
		apply.Full_day().click();
		System.out.println("05");
		apply.Duration().click();
		
		
		apply.Comments().sendKeys("i need leave for 2 days");
		apply.apply_button().click();
			
	}
	
}