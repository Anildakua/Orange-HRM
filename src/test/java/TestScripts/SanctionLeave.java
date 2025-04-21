package TestScripts;

import org.testng.annotations.Test;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import POMpackage.AdminPOM;
import POMpackage.HomepagePOM;
import POMpackage.LeavePOM;
import POMpackage.loginPOM;
import UtilityPackage.BaseClass;
import UtilityPackage.excelUtil;
import UtilityPackage.propartieClass;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SanctionLeave extends BaseClass {

    HomepagePOM home;
    AdminPOM admin;
    LeavePOM leave;

    @Test(priority = 0)
    public void login() throws Exception {
        logger.info("Login test started");
        
        try {
        	propartieClass pro = new propartieClass();
            String name = excelUtil.data("Sheet1", 1, 2);
            String pass = excelUtil.data("Sheet1", 2, 2);

            loginPOM pom = new loginPOM(driver);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(pom.username()));
            
            pom.username().sendKeys(name);
            logger.info("Entered username");
            
            pom.password().sendKeys(pass);
            logger.info("Entered password");
            
            pom.button().click();
            logger.info("Login button clicked");
        } catch (Exception e) {
            logger.error("Error during login test: ", e);
        }
        
        logger.info("Login test completed");
    }

    @Test(priority = 1)
    public void leave() throws InterruptedException {
        logger.info("Leave test started");
        
        try {
            home = new HomepagePOM(driver);
            leave = new LeavePOM(driver);

            home.Leave();
            logger.info("Navigated to Leave page");

            leave.EmpName().sendKeys("Anil Test");
            logger.info("Entered employee name");
            
            Thread.sleep(2000);
            leave.Suggestion().click();
            logger.info("Selected suggestion");
            
            Thread.sleep(2000);
            leave.EmpSearch().click();
            logger.info("Searched for employee");
            
            Thread.sleep(2000);
            leave.Approve().click();
            logger.info("Approved leave");
        } catch (Exception e) {
            logger.error("Error during leave test: ", e);
        }

        logger.info("Leave test completed");
    }
}
	