package com.cs.listeners;

import java.util.Arrays;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.cs.annotations.FrameworkAnnotations;

import reports.ExtentLogger;
import reports.ExtentReport;

public class TestListener implements ITestListener {

	// when every test case starts
	public void onTestStart(ITestResult result) {
		// to log a test name
		// ExtentReport.createTest(result.getName());
		ExtentReport.createTest(result.getMethod().getDescription());
		ExtentReport.assignAuthor(result.getMethod().getConstructorOrMethod().getMethod()
				.getAnnotation(FrameworkAnnotations.class).author());

		ExtentReport.assignCategory(result.getMethod().getConstructorOrMethod().getMethod()
				.getAnnotation(FrameworkAnnotations.class).category());

	}

	public void onTestSuccess(ITestResult result) {
		ExtentLogger.pass(result.getName() + " is passed");
	}

	public void onTestFailure(ITestResult result) {
		ExtentLogger.fail(result.getName() + " is failed");
		ExtentLogger.fail(result.getThrowable().getMessage());
		ExtentLogger.fail(Arrays.toString(result.getThrowable().getStackTrace()));
	}

	// suite starts
	public void onStart(ITestContext context) {
		ExtentReport.initReports();
	}

	public void onFinish(ITestContext context) {
		ExtentReport.flushReport();
	}
}