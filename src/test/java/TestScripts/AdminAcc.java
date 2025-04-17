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
    private static final Logger logger = LogManager.getLogger(AdminAcc.class);
	HomepagePOM home;
	AdminPOM admin;
	
	@Test(priority = 0)
public void login() throws Exception {
		logger.info("Window Maximized");
		logger.trace("This is a TRACE log");
        logger.debug("This is a DEBUG log");
        logger.info("This is an INFO log");
        logger.warn("This is a WARN log");
        logger.error("This is an ERROR log");
		propartieClass pro = new propartieClass();
		String name=pr.proparties("username");
		String pass=pr.proparties("password");		
		loginPOM pom=new loginPOM(driver);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(pom.username()));
		pom.username().sendKeys(name);
		pom.password().sendKeys(pass);
		pom.button().click();
		logger.info("Now Logging IN Orange HRM");

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
		
		logger.debug("Now Clicking on PIM module");

		pim.addEmp();
		
		logger.info("Adding Employee Details");
		wait.until(ExpectedConditions.visibilityOf(pim.firstname()));
		pim.firstname().sendKeys(excelUtil.data("Sheet1", 7, 1));
		pim.lastName().sendKeys(excelUtil.data("Sheet1", 8, 1));
		String user_name=pim.firstname().getText();
		System.out.println(user_name);
		pim.cld().click();
		pim.new_username().sendKeys(excelUtil.data("Sheet1", 1, 2));
		pim._new_password();
		pim.con_password();
		wait.until(ExpectedConditions.elementToBeClickable(pim.save_button()));
		Thread.sleep(4000);
		pim.save_button().click();
		Thread.sleep(4000);
		}else {
			System.out.println("I am not Homepage");
		}
	}
	@Test(priority = 2)
	public void userCredential() throws Exception {
		String expected_result2 = "OrangeHRM";
		String actual_result2 =driver.getTitle();
		if(expected_result2.equals(actual_result2)) {
	    admin=new AdminPOM(driver);
	    home.Admin();	
	    admin.emp_name().sendKeys(pr.proparties("Admin_EMP"));
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(admin.emp_dropdown()));
	    admin.emp_dropdown().click();
	    admin.search_b().click();
		//wait.until(ExpectedConditions.presenceOfElementLocated((By) admin.edit_button()));
		admin.edit();
		admin.role_dropdown().click();
		wait.until(ExpectedConditions.visibilityOf(admin.role_dropdown2()));
		admin.role_dropdown2().click();
		admin.save_button().click();
		wait.until(ExpectedConditions.visibilityOf(admin.adminPopUP()));
		}else {
			System.out.println("I am not Admin Page");
		}

	}
	
}