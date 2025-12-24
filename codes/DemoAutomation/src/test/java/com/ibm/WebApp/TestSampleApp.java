package com.ibm.WebApp;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class TestSampleApp {
	
	public static void main(String[] args) {
		
		WebDriver driver = new FirefoxDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		Actions acts = new Actions(driver);
		driver.get("https://bugbug.io/blog/testing-frameworks/best-selenium-practice-websites/");
		
		WebElement product = driver.findElement(By.id("_r_0_"));
		
		if(product.isDisplayed()) {
			acts.moveToElement(product).click().build().perform();
			driver.findElement(By.linkText("Features")).click();
		}
	}

}
