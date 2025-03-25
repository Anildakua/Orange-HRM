package LoginPage;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import BasePackage.BassClass;
import ExcelDataPackage.excelUtil;
import POMpackage.AdminPOM;
import POMpackage.HomepagePOM;
import POMpackage.loginPOM;
import POMpackage.pim_POM;
import propertiePackage.propartieClass;

public class EmployeeAcc extends BassClass {
	HomepagePOM home;
	AdminPOM admin;
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
		pim.firstname().sendKeys(excelUtil.data("Sheet1", 7, 2));
		pim.lastName().sendKeys(excelUtil.data("Sheet1", 8, 2));
		String user_name=pim.firstname().getText();
		System.out.println(user_name);
		pim.cld().click();
		
		pim.new_username().sendKeys(excelUtil.data("Sheet1", 9, 2));
		pim._new_password();
		pim.con_password();
		wait.until(ExpectedConditions.elementToBeClickable(pim.save_button()));
		pim.save_button().click();
		}else {
			System.out.println("I am not Homepage");
		}
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
