package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TablePage extends BasePage{

	public TablePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css="input[name='lang']")
	List<WebElement> languageItems;
	
	@FindBy(css="input[name='level]")
	List<WebElement> levelItems;
	
	@FindBy(css="div.dropdown-button")
	WebElement dropDown;
	
	@FindBy(css="li[role='option']")
	List<WebElement> enrollments;
	
	@FindBy(xpath="//select[@id='sortBy']/option")
	List<WebElement> sortingOptions;
	
	
	

}
