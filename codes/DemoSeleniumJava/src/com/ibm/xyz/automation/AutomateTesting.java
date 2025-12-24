package com.ibm.xyz.automation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutomateTesting {

	static WebDriver driver;
	static WebDriverWait wait;

	
	public static void setUp()
	{
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		
	}
	
	public static void getApp(String url) {
		driver.get(url);
	}
	
	public static void verifyHomePage() {
		String actTitle=driver.getTitle();
		String expTitle="Practice Test Automation | Learn Selenium WebDriver";
		if(expTitle.equalsIgnoreCase(actTitle))
			System.out.println("The test pass as we are landing on intended page");
		else
			System.out.println("The test fails...");
	}
	
	public static void verifyNavBar()
	{
		
	    wait.until(ExpectedConditions.elementToBeClickable(By.linkText("PRACTICE"))).click();
	    wait.until(ExpectedConditions.titleContains("Practice"));
	    System.out.println("Reached Practice page");

	   
	    wait.until(ExpectedConditions.elementToBeClickable(By.linkText("COURSES"))).click();
	    wait.until(ExpectedConditions.titleContains("Courses"));
	    System.out.println("Reached Courses page");

	   
	    wait.until(ExpectedConditions.elementToBeClickable(By.linkText("BLOG"))).click();
	    wait.until(ExpectedConditions.titleContains("Blog"));
	    System.out.println("Reached Blog page");

	   
	    wait.until(ExpectedConditions.elementToBeClickable(By.linkText("CONTACT"))).click();
	    wait.until(ExpectedConditions.titleContains("Contact"));
	    System.out.println("Reached Contact page");
		
		
		
	}
	
	
	public static void tearDown() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.quit();
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		setUp();
		getApp("https://practicetestautomation.com/");
		verifyHomePage();
		verifyNavBar();
		tearDown();
	}
	
}
