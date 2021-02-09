package Utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport {
	
	static ExtentReports extent;
	
	public static ExtentReports ExtentreportGenerator() {
		
		String Path=System.getProperty("user.dir")+"//Reports//index.html";
		ExtentSparkReporter reporter =new ExtentSparkReporter(Path);
		reporter.config().setDocumentTitle("API Automation Results");
		reporter.config().setTheme(Theme.DARK);
		reporter.config().setTimeStampFormat("MMM dd, yyyy HH:mm:ss");
		reporter.config().setReportName("Functional Testing");
		reporter.config().setEncoding("utf-8");
		reporter.config().setCss("css-string");
		
		extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("OS", System.getProperty("os.name"));
		extent.setSystemInfo("Tester", "Jenkin User");
		
		
		
		return extent;
	}
}
