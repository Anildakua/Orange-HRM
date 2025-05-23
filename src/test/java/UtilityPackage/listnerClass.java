package UtilityPackage;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class listnerClass extends BaseClass implements ITestListener {

	public ExtentSparkReporter sparkRepoter;
	public ExtentReports extend;
	public ExtentTest test;
	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		sparkRepoter=new ExtentSparkReporter("./Reports/firstreport.html");
		sparkRepoter.config().setDocumentTitle("OrangHRM");
		sparkRepoter.config().setReportName("Create admin");
		sparkRepoter.config().setTheme(Theme.DARK);
		
		extend=new ExtentReports();
		extend.attachReporter(sparkRepoter);
		extend.setSystemInfo("Application", "Orange-HRM");
		extend.setSystemInfo("module", "Admin");
		extend.setSystemInfo("Username", System.getProperty("user.name"));
		extend.setSystemInfo("Enviroment", "QA"); 
		//System.out.println("****onStart*****"+context.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test=extend.createTest(result.getName());
		test.log(Status.PASS, "Test case pass :"+result.getName());
		//System.out.println("****onTestSuccesst*****"+result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test=extend.createTest(result.getName());
		test.log(Status.FAIL, "Test case fail :"+result.getName());
		
		
		TakesScreenshot ts=(TakesScreenshot) driver;
		File old_file = ts.getScreenshotAs(OutputType.FILE);
		File file=new File("./Screenshots/"+result.getName()+".JPG");
		String absolutePath= file.getAbsolutePath();
		try {
			FileUtils.copyFile(old_file, file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		test.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(absolutePath).build());
	
		//System.out.println("****onTestFailure*****"+result.getName());
	}


	@Override
	public void onTestSkipped(ITestResult result) {
		test=extend.createTest(result.getName());
		test.log(Status.SKIP, "Test case skip :"+result.getName());
		//System.out.println("****onTestSkipped*****"+result.getName());
	}

	@Override
	public void onFinish(ITestContext context) {
		extend.flush();
		//System.out.println("****onFinish*****"+context.getName());
	}

	
}
