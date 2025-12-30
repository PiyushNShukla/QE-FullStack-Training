package com.saucedemo.testng.tests;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.saucedemo.testng.base.BaseTest;



public class LoginTest extends BaseTest {
	
	
	
  @Test
  public void loginWithInvalidUsernameAndValidPassword() throws InterruptedException {
	  driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("user");
	  driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("secret_sauce");
	  driver.findElement(By.xpath("//input[@type='submit']")).click();
	  Thread.sleep(2000);
	  WebElement error=driver.findElement(By.xpath("//h3[contains(text(),'do not match')]"));
	  System.out.println("Error message displayed:"+error.isDisplayed());
	  assertTrue(error.isDisplayed());
  }
  @Test
  public void loginWithValidUsernameAndInvalidPassword() throws InterruptedException {
	  driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("standard_user");
	  driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("secret");
	  driver.findElement(By.xpath("//input[@type='submit']")).click();
	  Thread.sleep(2000);
	  WebElement error=driver.findElement(By.xpath("//h3[contains(text(),'do not match')]"));
	  System.out.println("Error message displayed:"+error.isDisplayed());
	  assertTrue(error.isDisplayed());
  }
  
  @Test(priority=1)
  public void loginWithValidCredentials() throws InterruptedException {
	  WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
	  driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("standard_user");
	  driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("secret_sauce");
	  driver.findElement(By.xpath("//input[@type='submit']")).click();
	  Thread.sleep(2000);
	  WebElement header=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='app_logo']")));
	  assertTrue(header.isDisplayed());
  }
	  
  
  
}
