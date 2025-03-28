package ListnerPackage;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import BasePackage.BassClass;

public class listnerClass extends BassClass implements ITestListener {

	public ExtentSparkReporter sparkRepoter;
	public ExtentReports extend;
	public ExtentTest test;
	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		sparkRepoter=new ExtentSparkReporter("./Reports/firstreport.html");
		sparkRepoter.config().setDocumentTitle("OrangHRM");
		sparkRepoter.config().setReportName("Create admin");
		sparkRepoter.config().setTheme(Theme.STANDARD);
		
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
		System.out.println(ts);
		File old_file = ts.getScreenshotAs(OutputType.FILE);
		File file=new File("./Screnshoots/imaige.png");
		old_file.renameTo(file);
		
		System.out.println("****onTestFailure*****"+result.getName());
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
