package pageObjects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class TablePage extends BasePage{

	public TablePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css="input[name='lang']")
	List<WebElement> languageItems;
	
	@FindBy(xpath="//*[@type='checkbox']")
	List<WebElement> levelItems;
	
	@FindBy(css="div.dropdown-button")
	WebElement dropDown;
	
	@FindBy(css="li[role='option']")
	List<WebElement> enrollments;
	
	@FindBy(xpath="//select[@id='sortBy']")
	WebElement sortingOptions;
	
	@FindBy(xpath="//table[@id='courses_table']/tbody")
	WebElement table;
	
	@FindBy(xpath="//table[@id='courses_table']/tbody/tr")
	List<WebElement> tableRows;
	
	@FindBy(xpath="//div[contains(text(),'No matching courses')]")
	WebElement noMatchMessage;
	
	@FindBy(xpath="//button[@id='resetFilters']")
	WebElement resetButton;
	public void selectJavaRadio() {
		languageItems.get(1).click();
	}
	
	public void selectPythonRadio() {
		languageItems.get(2).click();
	}
	
	public void scrollToTable() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);",table);
	}
	public boolean areAllCoursesJava() {
		scrollToTable();
		for(WebElement row:tableRows)
		{
			String lang=row.findElement(By.xpath("./td[@data-col='language']")).getText();
			if(!row.isDisplayed())
				continue;
			if(!lang.equalsIgnoreCase("Java"))
				return false;
		}
		return true;
		
	}
	public void deselectIntermediateAndAdvanced() {
		
		for(int i=1;i<levelItems.size();i++)
			levelItems.get(i).click();
	}
	
	public void deselectBeginner() {
		levelItems.get(0).click();
	}
	
	public boolean areAllCoursesBeginner() {
		scrollToTable();
		for(WebElement row:tableRows)
		{
			String level=row.findElement(By.xpath("./td[@data-col='level']")).getText();
			if(!row.isDisplayed())
				continue;
			if(!level.equalsIgnoreCase("Beginner"))
				return false;
		}
		return true;
		
	}
	
	public void clickEnrollments() {
		dropDown.click();
	}
	
	public void selectEnrollmentOption() {
		enrollments.get(2).click();
	}
	
	public boolean areUnder10k() {
		scrollToTable();
		for(WebElement row:tableRows)
		{
			String enr=row.findElement(By.xpath("./td[@data-col='enrollments']")).getText();
			System.out.println(enr);
			if(!row.isDisplayed())
				continue;
			if(Integer.parseInt(enr)<10000)
				return false;
		}
		return true;
	}
	
	public boolean mixedCondition() {
		scrollToTable();
		for(WebElement row:tableRows)
		{
			String lang=row.findElement(By.xpath("./td[@data-col='language']")).getText();
			String level=row.findElement(By.xpath("./td[@data-col='level']")).getText();
			String enr=row.findElement(By.xpath("./td[@data-col='enrollments']")).getText();
			System.out.println(lang+"\t"+level+"\t"+enr);
			if(!row.isDisplayed())
				continue;
			if(Integer.parseInt(enr)<10000 || !(lang.equalsIgnoreCase("Python")) || !(level.equalsIgnoreCase("Beginner")))
				return false;
		}
		return true;
	}
	
	public boolean isBlockDisplayed() {
		return (noMatchMessage.isDisplayed());
	}
	
	public void isResetButtonDisplayed()
	{
		System.out.println("Reset button dispalyed:"+resetButton.isDisplayed());
		
	}
	public void clickResetButton() {
		resetButton.click();
	}
	public boolean isButtonHidden() {
		return (!resetButton.isDisplayed());
		
	}
	public boolean areFiltersReset() {
		boolean langAny=languageItems.get(0).isSelected();
		boolean levelAll=true;
		for(WebElement items:levelItems)
		{
			if(!items.isSelected()) {
				levelAll=false;
				break;
			}
		}
		WebElement enrollmentType=driver.findElement(By.xpath("//div[@class='dropdown-button']"));
		boolean enroll=enrollmentType.getText().equalsIgnoreCase("Any");
		if(langAny && levelAll && enroll)
			return true;
		else
			return false;
	}
	public boolean areAllRowsvisible() {
		int counter=0;
		scrollToTable();
		for(WebElement row:tableRows)
		{
			if(row.isDisplayed())
				counter++;
		}
		return (counter==9);
	}
	
	public void selectEnrollments() {
		
		Select options=new Select(sortingOptions);
		options.selectByContainsVisibleText("Enrollments");
		
	}
	
	public List<Integer> getEnrollmentList(){
		List<Integer> enroll=new ArrayList<Integer>();
		for(WebElement row:tableRows)
		{
			int  en=Integer.parseInt(row.findElement(By.xpath("./td[@data-col='enrollments']")).getText());
			enroll.add(en);
		}
		return enroll;
	}
	public List<Integer> sortedEnrollment() {
		List<Integer> enroll=getEnrollmentList();
		List<Integer> sortedList=new ArrayList<Integer>(enroll);
		Collections.sort(sortedList);
		return sortedList;
	}
	
   public void selectCourseName() {
		
		Select options=new Select(sortingOptions);
		options.selectByContainsVisibleText("Course Name");
		
	}

   public List<String> getCourseList(){
		List<String> courseList=new ArrayList<String>();
		for(WebElement row:tableRows)
		{
			String  course=row.findElement(By.xpath("./td[@data-col='course']")).getText().trim();
			courseList.add(course);
		}
		return courseList;
	}
	public List<String> sortedCourseList() {
		List<String> course=getCourseList();
		List<String> sortedList=new ArrayList<String>(course);
		Collections.sort(sortedList);
		return sortedList;
	}

	

}
