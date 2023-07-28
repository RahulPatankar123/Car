package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.cs.constants.FrameworkConstants;

public final class ExtentReport {

	public static ExtentReports extent;
	public static ExtentTest extentTest;

	private ExtentReport() {
	}

	public static void initReports() {
		extent = new ExtentReports(); // not thread safe
		ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkConstants.getReportPath());
		extent.attachReporter(spark);

	}

	public static void flushReport() {
		extent.flush();
	}

	public static void createTest(String testCaseName) {
		extentTest = extent.createTest(testCaseName);

		ExtentManager.setExtentTest(extentTest);
	}

	public static void assignAuthor(String author) {
		ExtentManager.getExtentTest().assignAuthor(author);
	}

	public static void assignCategory(String category) {
		ExtentManager.getExtentTest().assignCategory(category);
	}
}
