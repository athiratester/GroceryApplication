package reportgeneration;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import utilities.ExtentReportUtility;

public class Listeners implements  ITestListener{
	ExtentTest test;
	ExtentReports extent = ExtentReportUtility.createExtentReports();
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
//extentt report utility class is configured in  listners class
	public void onTestStart(ITestResult result) { // ontest start will execute before execution of each TC, it fetch the method name

	ITestListener.super.onTestStart(result);
	test = extent.createTest(result.getMethod().getMethodName());
	extentTest.set(test);

	}

	public void onTestSuccess(ITestResult result) {// method run when tc is success

	ITestListener.super.onTestSuccess(result);
	extentTest.get().log(Status.PASS, "Test Passed");

	}

	public void onTestFailure(ITestResult result) { // method run when tc is failed

	ITestListener.super.onTestFailure(result);

	extentTest.get().log(Status.FAIL, "Test Failed");
	extentTest.get().fail(result.getThrowable());

	WebDriver driver = null;

	String testMethodName = result.getMethod().getMethodName();

	try {

	driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
	.get(result.getInstance());
	} catch (IllegalArgumentException e) {

	e.printStackTrace();
	} catch (IllegalAccessException e) {

	e.printStackTrace();
	} catch (NoSuchFieldException e) {

	e.printStackTrace();
	} catch (SecurityException e) {

	e.printStackTrace(); // to print the exception . by using this error will print on the report
	}

	try {
	driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
	.get(result.getInstance());
	} catch (Exception e) {
	}
	}

	public void onTestSkipped(ITestResult result) { // method runs when method is skipped

	ITestListener.super.onTestSkipped(result);
	extentTest.get().log(Status.SKIP, "Test Skipped");
	String testMethodName = result.getMethod().getMethodName();

	}  

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) { //before reaching the success percentage test case is failed

	ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	public void onTestFailedWithTimeout(ITestResult result) {  // tc failed due to timeout issue

	ITestListener.super.onTestFailedWithTimeout(result);
	}

	public void onStart(ITestContext context) {// method which execute before the execution of Tc

	ITestListener.super.onStart(context);
	}

	public void onFinish(ITestContext context) {// method which execute after the execution of  Tc
	ITestListener.super.onFinish(context);
	extent.flush(); //flush ()-fetched details from each methods are correctly logged to the report
	}

}
