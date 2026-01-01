package com.ibm.steps;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class StepsToExecute {
	
	WebDriver driver;
	
	//hooks 1.@Before  2.@After  3.@BeforeStep   4.@AfterStep   5.@BeforeAll  6.@AfterAll
	//Before,After- Each feature file
	//All-All feature files
	//Step=Each Step
	
	@Before
	public void setUp() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
	@After
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
	

	@Given("User in Login Page")
	public void user_in_login_page() {
		driver.get("https://practicetestautomation.com/practice-test-login/");
	    
	}

	@When("User enters correct username and password")
	public void user_enters_correct_username_and_password() {
		driver.findElement(By.name("username")).sendKeys("student");
		driver.findElement(By.id("password")).sendKeys("Password123");
	    
	}

	@When("User clicks login button")
	public void user_clicks_login_button() {
		driver.findElement(By.id("submit")).click();
	    
	}

	@Then("User lands on Welcome Page")
	public void user_lands_on_welcome_page() {
	    Assert.assertTrue(driver.findElement(By.xpath("//a[contains(text(),'Log out')]")).isDisplayed());
	}
}
