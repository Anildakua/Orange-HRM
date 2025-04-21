package TestScripts;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
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
public class AdminAcc extends BaseClass{
	HomepagePOM home;
	AdminPOM admin;
	
	@Test(priority = 0)
public void login() throws Exception {
	    logger.info("Starting login test case...");

		propartieClass pro = new propartieClass();
		String name=pr.proparties("username");
		String pass=pr.proparties("password");
	    logger.debug("Fetched credentials from properties file");

		
		loginPOM pom=new loginPOM(driver);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    logger.debug("Waiting for username field to be visible");

		wait.until(ExpectedConditions.visibilityOf(pom.username()));
		pom.username().sendKeys(name);
		pom.password().sendKeys(pass);
		pom.button().click();
		logger.info("Login submitted with username: " + name);

	    logger.info("Login test case completed");
}
	
	@Test(priority = 1, dependsOnMethods = "login")
	public void add_emp() throws Exception {
	    logger.info("Starting add_emp test case...");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		String expected_result = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
		String actual_result =driver.getCurrentUrl();
		if(expected_result.equals(actual_result)) {	
			Thread.sleep(3000);
	        logger.info("Navigated to homepage successfully");

		pim_POM pim=new pim_POM(driver);
		home  = new HomepagePOM(driver);
		wait.until(ExpectedConditions.elementToBeClickable(home.PIM()));
		home.PIM().click();
		
		logger.debug("Now Clicking on PIM module");
		pim.addEmp();
		
		logger.info("Adding Employee Details");
		wait.until(ExpectedConditions.visibilityOf(pim.firstname()));
		pim.firstname().sendKeys(excelUtil.data("Sheet1", 7, 1));
		pim.lastName().sendKeys(excelUtil.data("Sheet1", 8, 1));
        logger.debug("Entered employee name");

		String user_name=pim.firstname().getText();
		System.out.println(user_name);
		pim.cld().click();
		pim.new_username().sendKeys(excelUtil.data("Sheet1", 1, 2));
        logger.debug("Entered username");

		pim._new_password();
		pim.con_password();
        logger.debug("Waiting to click save button");
		wait.until(ExpectedConditions.elementToBeClickable(pim.save_button()));
		Thread.sleep(4000);
		pim.save_button().click();
		Thread.sleep(4000);
        logger.info("Employee details saved successfully");
	    logger.info("add_emp test case completed");

		}else {
	        logger.error("Not on homepage. Expected: " + expected_result + ", but got: " + actual_result);
		}

	}
	@Test(priority = 2, dependsOnMethods = "add_emp")
	public void userCredential() throws Exception {
	    logger.info("Starting userCredential test case...");

		String expected_result2 = "OrangeHRM";
		String actual_result2 =driver.getTitle();
		if(expected_result2.equals(actual_result2)) {
	        logger.info("Successfully navigated to Admin Page");

	    admin=new AdminPOM(driver);
	    home.Admin();	

	    admin.emp_name().sendKeys(pr.proparties("Admin_EMP"));
		Thread.sleep(2000);
        logger.debug("Entering employee name for search");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(admin.emp_dropdown()));
	    admin.emp_dropdown().click();
        logger.debug("Clicking search button");

	    admin.search_b().click();
		//wait.until(ExpectedConditions.presenceOfElementLocated((By) admin.edit_button()));
        logger.debug("Editing user role");

		admin.edit();
		admin.role_dropdown().click();
		wait.until(ExpectedConditions.visibilityOf(admin.role_dropdown2()));
		admin.role_dropdown2().click();
		admin.save_button().click();
		wait.until(ExpectedConditions.visibilityOf(admin.adminPopUP()));
        logger.info("User credentials updated successfully");
	    logger.info("userCredential test case completed");

		}else {
	        logger.warn("Not on Admin page. Expected title: " + expected_result2 + ", but got: " + actual_result2);
		}

	}
	
}