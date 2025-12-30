package com.saucedemo.testng.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
  protected WebDriver driver;
  
  @BeforeMethod
  public void setUp() {
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://www.saucedemo.com/");
  }
  
  @AfterMethod
  public void tearDown()
  {
	  
		  driver.quit();
  }
}
