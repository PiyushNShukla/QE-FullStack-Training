package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ExceptionsPage extends BasePage{

	public ExceptionsPage(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(xpath="//button[@name='Add']")
	WebElement addButton;
	
	@FindBy(xpath="//button[@name='Save']")
	WebElement saveButton;
	
	@FindBy(xpath="//button[@name='Remove']")
	WebElement removeButton;
	
	@FindBy(xpath="//label[text()='Row 2']/following-sibling::input")
	WebElement inputField;
	
	public void clickAdd() {
		addButton.click();
		
	}
	public void setInput(String str) {
		inputField.sendKeys(str);
	}
	
	public void clickRemove() {
		removeButton.click();
	}

}
