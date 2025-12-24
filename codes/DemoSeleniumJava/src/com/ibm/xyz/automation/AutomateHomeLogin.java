package com.ibm.xyz.automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutomateHomeLogin {

	static WebDriver driver;
	static WebDriverWait wait;

	public static void setUp()
	{
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
	}
	
	public static void getApp(String url) {
		driver.get(url);
	}
	
	public static void verifyHomeLogin() {
		//wait.until(ExceptedConditions.elementTo)
	}
}
