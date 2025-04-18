package TestScripts;

import org.testng.annotations.Test;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import POMpackage.AdminPOM;
import POMpackage.HomepagePOM;
import POMpackage.LeavePOM;
import POMpackage.loginPOM;
import UtilityPackage.BaseClass;
import UtilityPackage.excelUtil;
import UtilityPackage.listnerClass;
import UtilityPackage.propartieClass;

@Listeners(listnerClass.class)
public class LeaveBalance extends BaseClass {
	
	HomepagePOM home;
	AdminPOM admin;
	LeavePOM leave;
	@Test(priority = 0)
public void login() throws Exception {
		
		
		propartieClass pro = new propartieClass();
		String name=excelUtil.data("Sheet1", 1, 2);
		String pass=excelUtil.data("Sheet1", 2, 2);	
		
		loginPOM pom=new loginPOM(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(pom.username()));
		pom.username().sendKeys(name);
		pom.password().sendKeys(pass);
		pom.button().click();
}
	@Test(priority = 1)
	public void leave() throws InterruptedException {
		home = new HomepagePOM(driver);
		leave = new LeavePOM(driver);
		home.Leave();
		//leave.leaveModule().click();
		leave.Entitlement().click();
		leave.AddEntitle().click();
		leave.Name().sendKeys("Anil test");
		Thread.sleep(3000);
		leave.NameSuggestion().click();
		leave.LeaveType().click();
		Thread.sleep(3000);
		leave.LeaveTypeSelect().click();
		leave.LeaveBank().sendKeys("10");
		leave.EntSave().click();
		leave.Confirm().click();
		
		}

}
