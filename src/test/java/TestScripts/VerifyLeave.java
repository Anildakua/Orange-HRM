package TestScripts;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import POMpackage.AdminPOM;
import POMpackage.HomepagePOM;
import POMpackage.LeavePOM;
import POMpackage.loginPOM;
import UtilityPackage.BaseClass;
import UtilityPackage.excelUtil;
import UtilityPackage.listnerClass;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class VerifyLeave extends BaseClass {
	
	

    HomepagePOM home;
    AdminPOM admin;
    LeavePOM leave;
    WebDriverWait wait;
 

    @Test(priority = 0)
    public void login() throws Exception {
        logger.info("Login test started");
        
        try {
            String name = excelUtil.data("Sheet1", 9, 2);
            String pass = excelUtil.data("Sheet1", 2, 2);
            
            loginPOM pom = new loginPOM(driver);
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(pom.username()));
            
            pom.username().sendKeys(name);
            logger.info("Entered username: {}", name);
            
            pom.password().sendKeys(pass);
            logger.info("Entered password");
            
            pom.button().click();
            logger.info("Login button clicked");
        } catch (Exception e) {
            logger.error("Error during login: ", e);
        }
        
        logger.info("Login test completed");
    }

    @Test(priority = 1)
    public void verify() throws Exception {
        logger.info("Verify leave test started");
        
        try {
            home = new HomepagePOM(driver);
            leave = new LeavePOM(driver);
            
            home.Leave();
            logger.info("Navigated to Leave page");
            
            WebElement record_no_1 = leave.my_leve_first_record();
            String status = leave.my_leve_status().getText();
            String text = "Taken";

            if (record_no_1.isDisplayed()) {
                logger.info("Leave record displayed");
                Assert.assertTrue(true);
                
                if (status.contains(text)) {
                    logger.info("Leave is approved with status: {}", status);
                    Assert.assertTrue(true, "Leave approved");
                    System.out.println("Leave is approved");
                } else {
                    logger.warn("Leave not approved, status: {}", status);
                    Assert.fail("Leave not approved");
                }
            } else {
                logger.error("Leave record not displayed");
                Assert.fail("Leave not displayed");
                System.out.println("Leave not displayed");
            }
        } catch (Exception e) {
            logger.error("Error during verify leave test: ", e);
        }
        
        logger.info("Verify leave test completed");
    }
}
