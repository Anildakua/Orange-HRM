package TestScripts;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import POMpackage.AdminPOM;
import POMpackage.HomepagePOM;
import POMpackage.LeavePOM;
import POMpackage.loginPOM;
import UtilityPackage.BassClass;
import UtilityPackage.excelUtil;
import UtilityPackage.propartieClass;

public class SanctionLeave extends BassClass{

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
		leave.EmpName().sendKeys("Anil Test");
		leave.EmpSearch().click();
		
		
}
}