package com.ibm.test;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest {	
	
	WebDriver driver;	
	
	@AfterMethod
	public void tearDownMethod() {
		System.out.println("Method is closed.... Let's release the method specific resources....");
		driver.close();
	}
	
	@AfterGroups ("sanityTests")
	public void tearDownGroups() {
		System.out.println("Let us release the groups related resources...");
	}
	
	@AfterClass
	public void tearDownClas() {
		System.out.println("It's time to release the class level resources...");
	}
	
	@AfterTest
	public void tearDownTest() {
		System.out.println("Let us release the test specific resources...");
	}
	
	@AfterSuite
	public void tearDownSuite() {
		System.out.println("We have to now release the suite related resources...");
		
	}
	
	//Suite-->Tests-->Classes ---> Groups --> Methods
	
	@BeforeMethod
	public void setup() {
		System.out.println("FInally it's time for the methods...");
		
		driver = new FirefoxDriver();
		driver.get("https://google.com/ncr");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
	
	@BeforeClass
	public void setupBefClass(){
		System.out.println("Now it's time for the class..");
	}
	
	@BeforeGroups ("smokeTests")
	public void setupBefGrps() {
		System.out.println("Now comes the groups...");
	}
	
	@BeforeTest
	public void setupBefTest() {
		System.out.println("Now the test would run....");
	}
	
	@BeforeSuite
	public void setupBefSuite() {
		System.out.println("I am the first coz I define the whole suite....");
	}
	
	
	//What is a test cycle??? 
	//Test Cycle is a logical grouping of tests - > SmokeTests, SanityTests, Regresssion Tests, End2EndTests etc
	
	@Test (groups = {"smokeTests", "sanityTests"})
	public void verifyRegistrationWithInvalidInfo() {
		System.out.println("registration fails... coz of invalid info...");
		
		assertTrue(true);
	}
	
	@Test (groups = {"smokeTests"})
	public void verifyRegistration() {
		
		System.out.println("Verifying the registration for a user...");
		
		//By assert, we are checking amounting to check point => Testing
		assertTrue(5>1);		
	}
	
  @Test (dependsOnMethods = {"verifyRegistration"} , 
		  groups = {"sanityTests"}, dependsOnGroups = {"smokeTests"})
  public void verifyLoginWithValidCredential() {
	  
	  System.out.println("Login works...");
  }
  
  @Test  (dependsOnMethods = {"verifyLoginWithValidCredential"}, 
		  	groups = {"regressionTests"}, dependsOnGroups = {"sanityTests"})
  public void verifyLoginWithValidUsernameAndInvalidPassword() {
	  
	  System.out.println("Invalid password... Try again...");
  }
  
  @Test (groups = {"end2endTests"}, 		  
		  dependsOnMethods = {"verifyLoginWithValidUsernameAndInvalidPassword", "verifyLoginWithValidCredential"})
  public void verifyLoginWithInvalidUsernameAndValidPassword() {
	  
	  System.out.println("Invalid username... Try again...");
	  
  }  
}