package com.saucedemo.testng;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
	WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		driver=new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
  @Test
  public void openAppTest() {
	  
	  String expTitle="Swag Labs";
	  String actTitle=driver.getTitle();
	  boolean status=actTitle.equalsIgnoreCase(expTitle);
	  System.out.println("Status of App:"+status);
	  assertTrue(status);
	  
  }
  @Test(dependsOnMethods = {"openAppTest"})
  public void loginWithInvalidUsernameAndValidPassword() {
	  driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("user");
	  driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("secret_sauce");
	  driver.findElement(By.xpath("//input[@type='submit']")).click();
	  WebElement error=driver.findElement(By.xpath("//h3[contains(text(),'do not match')]"));
	  System.out.println("Error message displayed:"+error.isDisplayed());
	  assertTrue(error.isDisplayed());
  }
  @Test(dependsOnMethods = {"openAppTest"})
  public void loginWithValidUsernameAndInvalidPassword() {
	  driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("standard_user");
	  driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("secret");
	  driver.findElement(By.xpath("//input[@type='submit']")).click();
	  WebElement error=driver.findElement(By.xpath("//h3[contains(text(),'do not match')]"));
	  System.out.println("Error message displayed:"+error.isDisplayed());
	  assertTrue(error.isDisplayed());
  }
  
  @Test(dependsOnMethods = {"openAppTest"})
  public void loginWithValidCredentials() {
	  WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
	  driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("standard_user");
	  driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("secret_sauce");
	  driver.findElement(By.xpath("//input[@type='submit']")).click();
	  
	  WebElement header=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='app_logo']")));
	  assertTrue(header.isDisplayed());
  }
	  
  
  
}
