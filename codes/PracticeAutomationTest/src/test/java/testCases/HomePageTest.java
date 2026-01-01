package testCases;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseTest.BaseClass;
import pageObjects.HomePage;

public class HomePageTest extends BaseClass{
	HomePage hp;
	
	@BeforeMethod
	private void setUpPage() {
		hp=new HomePage(driver);
	}
	 
  @Test
  public void verifyLogo() {
	  
	  
	  hp.clickLogo();
	  System.out.println(driver.getTitle());
	  String expTitle="Practice Test Automation | Learn Selenium WebDriver";
	  Assert.assertEquals(driver.getTitle(), expTitle);
	  
  }
  
  @Test
  public void verifyNewsLetter() throws InterruptedException {
	  
	  JavascriptExecutor js = (JavascriptExecutor) driver;
	  js.executeScript("arguments[0].scrollIntoView(true);", hp.name);
	  hp.setName();
	  hp.setEmail();
	  hp.clickSubmit();
	  WebDriverWait wait=new  WebDriverWait(driver,Duration.ofSeconds(10));
	  wait.until(ExpectedConditions.titleContains("MailPoet"));
	  String expTitle="MailPoet Page | Practice Test Automation";
	  Assert.assertEquals(driver.getTitle(),expTitle);

  }
  
}
