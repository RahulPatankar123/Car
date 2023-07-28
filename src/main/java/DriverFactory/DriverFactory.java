package DriverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public final class DriverFactory {
	private DriverFactory() {};
	
	static WebDriver driver;
	
	public static WebDriver getDriver(String browser)
	{
		if (browser.equals("chrome"))
			driver = new ChromeDriver();
		else if (browser.equals("edge"))
			driver = new EdgeDriver();
		else if (browser.equals("firefox"))
			driver = new FirefoxDriver();
		else 
			throw new RuntimeException("Invalid Browser : " + browser);
		return driver;
}
}
