package com.ibm.WebApp;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ibm.WebApp.util.PictureUtility;

public class TestMyWebApp {
	static WebDriver driver;
	static Alert al;
	static Action act;
	static Actions acts;
	static JavascriptExecutor js;
	public static void setup()
	{
		driver =new FirefoxDriver();
		driver.manage().window().maximize();
		acts =  new Actions(driver);
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
	
	public static void getApp()
	{
		driver.get("file:///C:/Users/PiyushShukla/Desktop/Training/Git/QE-FullStack-Training/codes/DemoAutomation/MyWebApp/index.html");
		al=driver.switchTo().alert();
		String alText=al.getText();
		System.out.println(alText);
		al.accept();
	}
	
	public static void navigate() throws IOException
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		String parentWin=driver.getWindowHandle();
//	System.out.println(parentWin);
		driver.findElement(By.partialLinkText("Google")).click();
		driver.findElement(By.partialLinkText("Yahoo")).click();
		driver.findElement(By.partialLinkText("Facebook")).click();
		
		Set<String> wins=driver.getWindowHandles();
		for(String win:wins)
		{
			System.out.println(win);
		}
		
//		SortedSet<String> sortwins=new TreeSet<>(wins);
		
		int i=0;
		for(String win:wins)
		{
			i++;
			if(i==2) {
				driver.switchTo().window(win);
				wait.until(driver->!driver.getTitle().isEmpty());
				
				PictureUtility.takePic(driver, "./src/test/resources/");
				System.out.println("Title is:"+driver.getTitle());
				break;
			}
//			driver.switchTo().window(win);
//			wait.until(driver->!driver.getTitle().isEmpty());
			//System.out.println("TItle is:"+driver.getTitle());
			
		}
		driver.switchTo().window(parentWin);
		
		}
	
		public static void selectFromDropDown()
		{
			Select car=new Select(driver.findElement(By.id("cars")));
			List<WebElement> cars=car.getOptions();
			System.out.println("The no. of cares are: "+cars.size());
			System.out.println("The available cars are:");
			for(WebElement item: cars)
				//System.out.println(item.getText());
			car.selectByValue("xuv");
				
		}
		public static void readTableData()
		{
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
			List<WebElement> trs=new ArrayList<WebElement>();
			List<WebElement> tds=new ArrayList<WebElement>();
			WebElement table=driver.findElement(By.id("t1"));
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("t1")));
			if(table.isDisplayed()) {
				trs=table.findElements(By.tagName("tr"));
				for(WebElement tr:trs) {
					tds=tr.findElements(By.tagName("td"));
					for(WebElement td:tds)
						System.out.print(td.getText()+" ");
					System.out.println();	
				}
				
			}
		}
		
		public static void handleKeyboard() throws InterruptedException {
			js = (JavascriptExecutor) driver;
			
			js.executeScript("window.scrollBy(0, 450)");
			
			Action a =  acts	.click(driver.findElement(By.name("un"))).keyDown(Keys.SHIFT).sendKeys("piyush13232").build();
			
			Thread.sleep(5000);
			a.perform();
		}
		
		
		
		public static void tearDown() throws InterruptedException
		{
			Thread.sleep(3000);
			driver.quit();
		}
	
	public static void main(String[] args) throws IOException, InterruptedException {
		setup();
		getApp();
		Thread.sleep(3000);
		//navigate();
		//selectFromDropDown();
		//readTableData();
		handleKeyboard();
		
		tearDown();
	}
}

