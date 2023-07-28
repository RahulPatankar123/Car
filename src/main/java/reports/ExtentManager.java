package reports;

import com.aventstack.extentreports.ExtentTest;

public final class ExtentManager {

	private ExtentManager() {
	};

	private final static ThreadLocal<ExtentTest> threadLocal = new ThreadLocal<ExtentTest>();

	public static void setExtentTest(ExtentTest extentTest) {
		threadLocal.set(extentTest); // thread
	}

	public static ExtentTest getExtentTest() {
		return threadLocal.get();
	}
}
