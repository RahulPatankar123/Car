package tests;

import java.lang.reflect.Method;
import java.util.Properties;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.cs.Driver.Driver;
import com.cs.ReadProperties.ReadPropertiesFile;

public class BaseTest {
	static Properties prop = null;

	@BeforeSuite
	public static void loadPropertyFile() {
		prop = ReadPropertiesFile.readPropertyFile();
	}

	@BeforeMethod
	public static void tearUp(Method method) {
		Driver.initDriver();
	}

	@AfterMethod
	public void tearDown() {
		Driver.quitBrowser();
	}
}
