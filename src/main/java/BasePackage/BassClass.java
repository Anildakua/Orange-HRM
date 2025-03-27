package BasePackage;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import POMpackage.HomepagePOM;
import propertiePackage.propartieClass;

public class BassClass {

	public WebDriver driver;
	public propartieClass pr=new propartieClass();
	
	@BeforeClass
	public void beforeClass() throws Exception {
	        driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.get(pr.proparties("URL"));
	}
	
	@BeforeMethod
	public void beforeMethod() {
	 
		
//		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
//		WebElement until = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='username']")));
		screenshort();
	}
	
	
	@AfterMethod
	public void afterMethod() throws InterruptedException {
		
//		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
//		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='oxd-userdropdown-tab']")));
	}
	@AfterClass
	public void afterClass() {
		
		driver.quit();
	}
	
	public void screenshort() {
		Random ra=new Random();
		TakesScreenshot ts=(TakesScreenshot)driver;
		System.out.println(ts);
		File old_file = ts.getScreenshotAs(OutputType.FILE);
		File fis=new File("./Screnshoots/imaige.png");
		old_file.renameTo(fis);
	}


}
