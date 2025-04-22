package UtilityPackage;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import POMpackage.HomepagePOM;

public class BaseClass {

	public static WebDriver driver;
	public static Logger logger ;
	public propartieClass pr=new propartieClass();
	
	@BeforeTest
	//@Parameters("browser")
	public void beforeTest() throws Exception 
	{
		String browser = pr.proparties("browser");     //get the spesific browser
		switch (browser) 
		{
		case "Chrome":
			driver=new ChromeDriver();break;
		case "Edge":
			driver=new EdgeDriver();break;
		default:
			System.out.println("its not a valid browser");break;
		}
		//open the browser      
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		try 
		{
			driver.get(pr.proparties("URL"));
		} catch (Exception e) 
		{
			System.out.println("Not get the URL proparties file we get the :"+e);
		}
	}
	
	@BeforeClass
	public void beforeClass() 
	{
		 logger = LogManager.getLogger(this.getClass());
	        
	}
	
	@BeforeMethod
	public void beforeMethod() 
	{
	 
	}
	
	
	@AfterMethod
	public void afterMethod() throws InterruptedException 
	{
		

	}
	@AfterClass
	public void afterClass() 
	{
		HomepagePOM hm=new HomepagePOM(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(hm.user_dropdown()));
		hm.user_dropdown().click();
		wait.until(ExpectedConditions.elementToBeClickable(hm.logout2()));
		hm.logout2().click();	
		
	}
	
	@AfterTest
	public void afterTest() 
	{
		driver.quit();
	}


}
