package com.qaclick.FinalProject;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import resources.ExtentManager;

public class ExtentReportsListeners implements ITestListener {

	private static ExtentReports extent = ExtentManager.createInstance(".//test-output//ReportHTML.html");
	private static ThreadLocal<ExtentTest> parentTest = new ThreadLocal<ExtentTest>();
	private static ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();

	public synchronized void onStart(ITestContext context) {
		ExtentTest parent = extent.createTest(context.getName());
		System.out.println(context.getName());
		parentTest.set(parent);
	}

	public synchronized void onFinish(ITestContext context) {
		extent.flush();
	}

	public synchronized void onTestStart(ITestResult result) {
		ExtentTest child = ((ExtentTest) parentTest.get()).createNode(result.getMethod().getMethodName());
		test.set(child);
	}

	public synchronized void onTestSuccess(ITestResult result) {
		((ExtentTest) test.get()).pass("Test passed");
	}

	public synchronized void onTestFailure(ITestResult result) {
		((ExtentTest) test.get()).fail(result.getThrowable());

	}

	public synchronized void onTestSkipped(ITestResult result) {
		((ExtentTest) test.get()).skip(result.getThrowable());
	}

	public synchronized void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

}