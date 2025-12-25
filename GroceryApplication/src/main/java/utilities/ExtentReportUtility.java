package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportUtility {
	
	public static final ExtentReports extentReports = new ExtentReports();// static instance of extentreports that can
	// be shared accross the application

	public synchronized static ExtentReports createExtentReports() {

	ExtentSparkReporter reporter = new ExtentSparkReporter("./extent-reports/extent-report.html");  // file will create  
	reporter.config().setReportName("7RMartSupermarketProject");
	extentReports.attachReporter(reporter);

	extentReports.setSystemInfo("Organization", "Obsqura");
	extentReports.setSystemInfo("Name", " Athira"); // provides context of the report
	return extentReports;
	}

}

// report generation is done extent report and extent spark report
