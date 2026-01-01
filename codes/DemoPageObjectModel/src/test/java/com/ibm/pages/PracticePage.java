package com.ibm.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PracticePage {
	
	WebDriver driver;

	WebElement testLoginPage;
	WebElement testExceptions;
	WebElement testTable;
	
	public PracticePage() {
		driver=new ChromeDriver();
		driver.get("https://practicetestautomation.com/practice/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		testLoginPage=driver.findElement(By.linkText("Test Login Page"));
		testExceptions=driver.findElement(By.linkText("Test Exceptions"));
		testTable=driver.findElement(By.linkText("Test Table"));
		
	}
	
	public void clickTestLoginPage() {
		testLoginPage.click();
	}
	
	public void clickTestExceptions() {
		testExceptions.click();
		
	}
	
	public void clickTestTable() {
		testTable.click();
	}
}
