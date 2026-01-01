package com.ibm.hooks;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

	public static WebDriver driver;
	
	@Before
	public void setUp() {
		System.out.println("Launching browser...");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
	@After
	public void tearDown() throws InterruptedException {
		Thread.sleep(2000);
		System.out.println("Closing browser...");
		if(driver!=null)
			driver.quit();
	}
}
