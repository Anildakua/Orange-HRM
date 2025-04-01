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
	    wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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
		wait.until(ExpectedConditions.visibilityOf(apply.leaveType()));
		apply.leaveType().click();
		apply.CAN_personal().click();
		apply.From_date().sendKeys("2025-20-03");
		wait.until(ExpectedConditions.visibilityOf(apply.To_date()));
		apply.To_date().click();
		wait.until(ExpectedConditions.visibilityOf(apply.T_date()));
		apply.T_date().click();
//		apply.Full_day().click();
//		apply.Duration().click();

		apply.Comments().sendKeys("i need leave for 2 days");
		apply.apply_button().click();
		wait.until(ExpectedConditions.visibilityOf(apply.popup_apply()));
			
	}
	
}