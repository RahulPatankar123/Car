package com.cs.utils;

import static com.cs.ReadProperties.ReadPropertiesFile.prop;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cs.enums.WaitTypes;

import DriverManager.DriverManager;
import reports.ExtentLogger;

public class SeleniumUtils {

	private static WebElement getElement(By by, WaitTypes waitType, WebElement element) {
		if (waitType == WaitTypes.PRESENCE)
			element = waitUnitlElementPresent().until(ExpectedConditions.presenceOfElementLocated(by));
		else if (waitType == WaitTypes.VISIBLE)
			element = waitUnitlElementPresent().until(ExpectedConditions.visibilityOfElementLocated(by));
		else if (waitType == WaitTypes.CLICKABLE)
			element = waitUnitlElementPresent().until(ExpectedConditions.elementToBeClickable(by));
		return element;
	}

	private static WebDriverWait waitUnitlElementPresent() {
		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(),
				Duration.ofSeconds(Integer.parseInt(prop.getProperty("timeout"))));
		return wait;
	}

	public static void click(By by, String elementName) {
		WebElement element = null;
		element = waitUnitlElementPresent().until(ExpectedConditions.presenceOfElementLocated(by));
		element.click();
		ExtentLogger.pass(elementName + " clicked successfully");
	}

	public static void click(By by, WaitTypes waitType, String elementName) {
		WebElement element = null;
		element = getElement(by, waitType, element);

		element.click();
		ExtentLogger.pass(elementName + " clicked successfully");
	}

	public static void sendKeys(By by, String value, WaitTypes waitType, String elementName) {
		WebElement element = null;
		element = getElement(by, waitType, element);

		element = waitUnitlElementPresent().until(ExpectedConditions.presenceOfElementLocated(by));
		element.sendKeys(value);
		ExtentLogger.pass(value + " entered successfully in " + elementName);
	}

	public static void sendKeys(By by, String value, String elementName) {
		WebElement element = null;
		element = waitUnitlElementPresent().until(ExpectedConditions.presenceOfElementLocated(by));

		element.sendKeys(value);
		ExtentLogger.pass(value + " entered successfully in " + elementName);
	}
}
