package TestScripts;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import POMpackage.AdminPOM;
import POMpackage.HomepagePOM;
import POMpackage.LeavePOM;
import POMpackage.loginPOM;
import UtilityPackage.BaseClass;
import UtilityPackage.excelUtil;

public class VerifyLeave extends BaseClass {

	HomepagePOM home;
	AdminPOM admin;
	LeavePOM leave;
	WebDriverWait wait;
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
	public void verify() throws Exception {
		home=new HomepagePOM(driver);
		leave=new LeavePOM(driver);
		home.Leave();
		WebElement record_no_1 =leave.my_leve_first_record();
		WebElement cancel=leave.my_leve_cancel_Button();
		boolean button = cancel.isDisplayed();
		if (record_no_1.isDisplayed()==true)
		{
			System.out.println("displayed");
			Assert.assertTrue(true);
			if (button==true)
			{
				Assert.fail("leave not approve");
				System.out.println("button is displayed");
			}
			else
			{
				Assert.assertTrue(true,"leave aprove");
				System.out.println("button is not displayed");
			}
		}
		else 
		{
			//Assert.fail("leave not displayed");
			System.out.println("leave not displayed");
		}
	}
}  
