package com.saucedemo.testng.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.saucedemo.testng.base.BaseTest;


public class ProductsTest extends BaseTest {
	static WebDriverWait wait;
	
	private void login() {
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("standard_user");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	}
  @Test(priority=1)
  public void verifyProductsPageLoads() {
	  
	  login();
	  Assert.assertTrue(driver.findElement(By.className("inventory_container")).isDisplayed());
	  }
  @Test
  public void verifyMenuButtonisClickable() throws InterruptedException {
	  wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	  login();
	  driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']")).click();
	  Thread.sleep(2000);
	  WebElement navbar=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='menu_button_container']/div/div[2]")));
	  Assert.assertTrue(navbar.isDisplayed());
  }
  
  
  
}
