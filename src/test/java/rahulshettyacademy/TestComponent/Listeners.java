package rahulshettyacademy.TestComponent;

import java.io.IOException;


import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.ITestContext;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import rahulshettyacademy.resources.ExtentReporterNG;

public class Listeners extends BaseTest implements ITestListener {

	ExtentTest test;
	ExtentReports extent = ExtentReporterNG.getReportObject();
	ThreadLocal<ExtentTest> extendTest = new ThreadLocal<ExtentTest>(); // thread safe

	public void onTestStart(ITestResult result) {

		test = extent.createTest(result.getMethod().getMethodName());
		extendTest.set(test); // unique thread id-> 
	}

	public void onTestSuccess(ITestResult result) {
		extendTest.get().log(Status.PASS, "Test Passed");
	}

	public void onTestFailure(ITestResult result) {
//		test.log(Status.FAIL, "Test Failed");
		extendTest.get().fail(result.getThrowable());
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String filePath = null;
		try {
			filePath = getScreenshot(result.getMethod().getMethodName(), driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		extendTest.get().addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());

		// screenshot, attach to the report
	}

	public void onFinish(ITestContext result) {

		extent.flush();

	}
}
