package Utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
public class ExtentReportListner  implements ITestListener{
	ExtentTest test;
	ExtentReports reports=ExtentReport.ExtentreportGenerator();
	private static ThreadLocal<ExtentTest> extentTest=new ThreadLocal<ExtentTest>();

	public void onTestStart(ITestResult result) {
		test=reports.createTest(result.getMethod().getMethodName());
		test.log(Status.INFO, result.getMethod().getMethodName());
		extentTest.set(test);

	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test is pass");

	}

	public void onTestFailure(ITestResult result) {
		extentTest.get().fail(result.getThrowable());
		test.log(Status.FAIL, "Test is fail");

	}

	public void onTestSkipped(ITestResult result) {
		extentTest.get().skip(result.getThrowable());
		test.log(Status.SKIP, "Test is skipped");

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {

	}

	public void onFinish(ITestContext context) {
		reports.flush();

	}
	

}