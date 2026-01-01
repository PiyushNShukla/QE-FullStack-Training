package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PracticePage extends BasePage{

	public PracticePage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath="//a[text()='Test Login Page']")
	WebElement testLogin;
	@FindBy(xpath="//a[text()='Test Exceptions']")
	WebElement testExceptions;
	@FindBy(xpath="//a[text()='Test Table']")
	WebElement testTable;
	
	public void clickTestLoginPage() {
		testLogin.click();
	}
	
	public void clickTestExceptions() {
		testExceptions.click();
	}
	
	public void clickTestTable() {
		testTable.click();
	}

	
}
