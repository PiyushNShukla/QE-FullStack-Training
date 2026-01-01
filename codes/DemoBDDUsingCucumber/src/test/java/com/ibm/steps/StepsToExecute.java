package com.ibm.steps;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
		Thread.sleep(1000);
		driver.quit();
	}
	

	@Given("User in Login Page")
	public void user_in_login_page() {
		driver.get("https://practicetestautomation.com/practice-test-login/");
	    
	}

	@When("User enters {string} and {string}")
	public void user_enters_and(String user, String pass) {
		System.out.println("Username:"+user+"\n"+"Password:"+pass);
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.name("username")).sendKeys(user);
		driver.findElement(By.id("password")).sendKeys(pass);
	}

//	@When("User enters correct username and password")
//	public void user_enters_correct_username_and_password() {
//		driver.findElement(By.name("username")).sendKeys("student");
//		driver.findElement(By.id("password")).sendKeys("Password123");
//	    
//	}

	@When("User clicks login button")
	public void user_clicks_login_button() {
		driver.findElement(By.id("submit")).click();
	    
	}

	@Then("User lands on Welcome Page")
	public void user_lands_on_welcome_page() {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement logOut=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Log out')]")));
	    Assert.assertTrue(logOut.isDisplayed());
	}
}
