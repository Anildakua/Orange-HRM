package TestScripts;
import org.testng.Assert;
import com.aventstack.extentreports.ExtentTest;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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


public class ApplyLeave extends BaseClass {

	HomepagePOM home;
	AdminPOM admin;
	LeavePOM leave;
	WebDriverWait wait;
	Apply apply;
	
	@Test(priority = 0)
    public void login() throws Exception {
		try {
        logger.info("Starting login test for ApplyLeave class");

		String name=excelUtil.data("Sheet1", 9, 2);
		String pass=excelUtil.data("Sheet1", 2, 2);	
        logger.debug("Retrieved login credentials from Excel");

		loginPOM pom=new loginPOM(driver);
	    wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        logger.debug("Waiting for username field to become visible");
		wait.until(ExpectedConditions.visibilityOf(pom.username()));
        logger.info("Entering username and password");
		pom.username().sendKeys(name);
		pom.password().sendKeys(pass);
        logger.info("Clicking login button");
		pom.button().click();
        logger.info("Login test completed");
		 } catch (Exception e) {
		        logger.error("Login failed", e);
		        Assert.fail("Login failed - stopping test");
		    }
 }
	
	@Test(priority = 1, dependsOnMethods = "login")
	public void apply() throws Exception {
        logger.info("Starting leave application test");
		home=new HomepagePOM(driver);
		apply=new Apply(driver);
        logger.debug("Navigating to Leave section");
		home.Leave();
        logger.debug("Clicking on Apply for Leave");
		apply.Apply2().click();
        logger.debug("Waiting for leave type dropdown");
		wait.until(ExpectedConditions.visibilityOf(apply.leaveType()));
		apply.leaveType().click();
        logger.debug("Selected leave type");
		apply.CAN_personal().click();
		logger.debug("Selected personal leave");

        logger.info("Entering leave dates");
		apply.From_date().sendKeys("2025-20-03");
		wait.until(ExpectedConditions.visibilityOf(apply.To_date()));
		apply.To_date().click();
		wait.until(ExpectedConditions.visibilityOf(apply.T_date()));
		apply.T_date().click();
        logger.debug("Leave dates selected");
//		apply.Full_day().click();
//		apply.Duration().click();
        logger.info("Entering leave reason comment");
		apply.Comments().sendKeys("i need leave for 2 days");
        logger.info("Clicking on Apply button");
		apply.apply_button().click();
        logger.debug("Waiting for leave application popup");
		wait.until(ExpectedConditions.visibilityOf(apply.popup_apply()));
        logger.info("Leave application test completed successfully");
	}
	
}