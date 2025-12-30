package com.saucedemo.testng.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {

	public static void captureScreeenshot(WebDriver driver,String testName,String status)
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		
		String path="src/test/resources/screenshots/"+status+"/"+testName+".png";
		try {
			FileUtils.copyFile(src,new File(path));
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
}
