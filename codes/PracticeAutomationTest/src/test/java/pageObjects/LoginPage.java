package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
	
	}
	
	@FindBy(xpath="//input[@name='username']")
	WebElement userName;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath="//button[@id='submit]")
	WebElement loginSubmitButton;
	
	public void setUserName(String user) {
		userName.clear();
		userName.sendKeys(user);
	}
	
	public void setPassword(String pass) {
		password.clear();
		password.sendKeys(pass);
    }
	public void clickButton() {
		loginSubmitButton.click();
	}

}
