package com.saucedemo.testng.listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.saucedemo.testng.base.BaseTest;
import com.saucedemo.testng.utils.ScreenshotUtil;

public class TestListener extends BaseTest implements ITestListener{
	
	@Override
	public void onTestSuccess(ITestResult result)
	{
		ScreenshotUtil.captureScreeenshot(driver, result.getName(),"pass" );
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		ScreenshotUtil.captureScreeenshot(driver, result.getName(), "fail");
	}
}

