package TestScripts;

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
		
		
		propartieClass pro = new propartieClass();
		String name=excelUtil.data("Sheet1", 7, 2);
		String pass=excelUtil.data("Sheet1", 3, 2);	
		
		loginPOM pom=new loginPOM(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(pom.username()));
		pom.username().sendKeys(name);
		pom.password().sendKeys(pass);
		pom.button().click();
 }
	
	@Test(priority = 1)
	public void apply() {
		home=new HomepagePOM(driver);
		home.Leave();
		leave.Apply().click();
		apply.leaveType().click();
		apply.CAN_personal().click();
		apply.From_date().sendKeys("2025-20-03");
		apply.To_date().sendKeys("2025-22-03");
		apply.Duration().click();
		apply.Full_day().click();
		apply.Comments().sendKeys("i need leave for 2 days");
		apply.apply_button().click();
			
	}
	
	@Test(priority = 2)
	public void logout() throws Exception {
		HomepagePOM hm=new HomepagePOM(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(hm.user_dropdown()));
		hm.user_dropdown().click();
		wait.until(ExpectedConditions.elementToBeClickable(hm.logout2()));
		hm.logout2().click();	
	}
}