package com.ibm.xyz.automation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutomatePracticeApp {
	static WebDriver driver;
	
	
	public static void verifyLogin()
	{
		driver.findElement(By.linkText("T")).click();
		driver.findElement(By.id("username")).sendKeys("student");
		driver.findElement(By.name("password")).sendKeys("Password123");
		driver.findElement(By.id("submit")).click();
		
		String expTitle="Logged In Successfully | Practice Test Automation";
		String actTitle=driver.getTitle();
		if(expTitle.equalsIgnoreCase(actTitle))
			System.out.println("Login is successful");
		else
			System.out.println("Try login againas th login fails..");
		
	}
	
	public static void setup() 
	{
		driver=new ChromeDriver();
//		driver=new EdgeDriver();
//		driver=new FirefoxDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
	public static void getApp(String url)
	{
		driver.get(url);
//		driver.navigate().to(url);
		
	}
	public static void verifyHomePage() {
		String actTitle=driver.getTitle();
		String expTitle="Practice | Practice Test Automation";
		if(expTitle.equalsIgnoreCase(actTitle))
			System.out.println("The test pass as we are landing on intended page");
		else
			System.out.println("The test fails...");
	}
	
	public static void tearDown() throws InterruptedException {
		Thread.sleep(4000);
		driver.quit();
	}
	
	public static void main(String[] args) throws InterruptedException {
		setup();
		getApp("https://practicetestautomation.com//practice/");
		verifyHomePage();
		verifyLogin();
		tearDown();
				
	}
}
