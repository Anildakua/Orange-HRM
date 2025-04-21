package TestScripts;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.time.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import POMpackage.AdminPOM;
import POMpackage.HomepagePOM;
import POMpackage.loginPOM;
import POMpackage.pim_POM;
import UtilityPackage.BaseClass;
import UtilityPackage.excelUtil;
import UtilityPackage.propartieClass;

public class EmployeeAcc extends BaseClass {
    private static final Logger logger = LogManager.getLogger(EmployeeAcc.class);
	HomepagePOM home;
	AdminPOM admin;
	@Test(priority = 0)
public void login() throws Exception {
        logger.info("Starting login process for EmployeeAcc class");
		String name=excelUtil.data("Sheet1", 1, 2);
		String pass=excelUtil.data("Sheet1", 2, 2);	
        logger.error("Fetched username and password from Excel");
		loginPOM pom=new loginPOM(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        logger.debug("Waiting for username input to become visible");
		wait.until(ExpectedConditions.visibilityOf(pom.username()));
		pom.username().sendKeys(name);
		pom.password().sendKeys(pass);
        logger.info("Entered credentials, attempting login");
		pom.button().click();
        logger.info("Login submitted");
}
	@Test(priority = 1, dependsOnMethods = "login")
	public void add_emp() throws Exception {
        logger.info("Starting add employee test");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		String expected_result = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
		String actual_result =driver.getCurrentUrl();
		if(expected_result.equals(actual_result)) {
            logger.info("Successfully navigated to homepage");
		pim_POM pim=new pim_POM(driver);
		home  = new HomepagePOM(driver);
        logger.debug("Navigating to PIM module");
		wait.until(ExpectedConditions.elementToBeClickable(home.PIM()));
		home.PIM().click();
		pim.addEmp();
        logger.debug("Accessed Add Employee form");
		wait.until(ExpectedConditions.visibilityOf(pim.firstname()));
		pim.firstname().sendKeys(excelUtil.data("Sheet1", 7, 2));
		pim.lastName().sendKeys(excelUtil.data("Sheet1", 8, 2));
		String user_name=pim.firstname().getText();
        logger.info("Entered employee name");
		System.out.println(user_name);
		pim.cld().click();
		
		pim.new_username().sendKeys(excelUtil.data("Sheet1", 9, 2));
        logger.debug("Entered new username");
		pim._new_password();
		pim.con_password();
        logger.debug("Entered and confirmed password");
		wait.until(ExpectedConditions.elementToBeClickable(pim.save_button()));
		pim.save_button().click();
        logger.info("Clicked save button to add employee");
		Thread.sleep(5000);
        logger.info("Add employee test completed successfully");

		}else {
            logger.error("Add employee test Unsuccessfully");
		}
}
}
