package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	
	public HomePage(WebDriver driver) {
		super(driver);
		
	
	}
	@FindBy(xpath="//*[@id='site-title']/a/img")
	WebElement logo;
	@FindBy(xpath="//a[text()='Home']")
	WebElement home;
	@FindBy(xpath="//a[text()='Practice']")
	WebElement practice;
	@FindBy(xpath="//a[text()='Courses']")
	WebElement courses;
	@FindBy(xpath="//a[text()='Blog']")
	WebElement blog;
	@FindBy(xpath="//a[text()='Contact']")
	WebElement contact;
	@FindBy(xpath="//input[@title='Name']")
	public WebElement name;
	@FindBy(xpath="//input[@title='Email Address']")
	WebElement email;
	@FindBy(xpath="//input[@type='submit']")
	WebElement submitButton;
	
	public void clickLogo() {
		logo.click();
	}
	public void clickHome() {
		home.click();
	}
	public void clickPractice() {
		practice.click();
	}
	public void clickCourses() {
		courses.click();
	}
	public void clickBlog() {
		blog.click();
	}
	public void clickContact() {
		contact.click();
	}
	public void setName() {
		name.sendKeys("John");
	}
	public void setEmail() {
		email.sendKeys("abc@example.com");
	}
	public void clickSubmit() {
		submitButton.click();
	}
	
	
}
