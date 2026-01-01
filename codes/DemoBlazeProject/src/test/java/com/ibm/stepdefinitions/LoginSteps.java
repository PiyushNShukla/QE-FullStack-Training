package com.ibm.stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ibm.hooks.Hooks;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	WebDriver driver;
	WebDriverWait wait;
	
	public  LoginSteps() {
		this.driver=Hooks.driver;
		this.wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		
	}
	@Given("User is on the home page and clicks on Login")
	public void user_is_on_the_home_page_and_clicks_on_login() {
		System.out.println("Executing Given step...");
		driver.get("https://www.demoblaze.com/index.html");
		driver.findElement(By.xpath("//a[@id='login2']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='logInModal']")));
		
		
	    
	}

	@When("User enters valid username {string}")
	public void user_enters_valid_username(String username) {
		driver.findElement(By.id("loginusername")).sendKeys(username);
		
	    
	}

	@When("User enters valid password {string}")
	public void user_enters_valid_password(String password) {
		driver.findElement(By.id("loginpassword")).sendKeys(password);
	}

	@When("User clicks on the Login button")
	public void user_clicks_on_the_login_button() {
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
	    
	}

	@Then("User should be logged in successfully")
	public void user_should_be_logged_in_successfully() {
		WebElement logOut=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='logout2']")));
		if(!logOut.isDisplayed())
		{
			throw new AssertionError("Login failed");
		}
	    	}

	

	@When("User enters invalid username {string}")
	public void user_enters_invalid_username(String username) {
		driver.findElement(By.id("loginusername")).sendKeys(username);
	}

	@Then("alert message {string} should be displayed")
	public void alert_message_should_be_displayed(String expectedMessage) {
		Alert alert=wait.until(ExpectedConditions.alertIsPresent());
		String actualMessage=alert.getText();
		if(!actualMessage.equals(expectedMessage))
		{
			throw new AssertionError("Expected: "+expectedMessage +" but got: "+actualMessage);
		}
		alert.accept();
		
	 
	}

	@When("User enters invalid password {string}")
	public void user_enters_invalid_password(String password) {
		driver.findElement(By.id("loginpassword")).sendKeys(password);
	}

}
