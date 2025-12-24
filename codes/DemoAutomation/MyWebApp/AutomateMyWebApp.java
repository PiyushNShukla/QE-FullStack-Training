package MyWebApp;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutomateMyWebApp {

	static WebDriver driver;
	static Alert al;
	public static void setup()
	{
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(45));
		
		
	}
	
	public static void getApp() throws InterruptedException
	{
		driver.get("file:///C:/Users/PiyushShukla/Desktop/Training/Git/QE-FullStack-Training/codes/DemoSeleniumJava/src/MyWebApp/index.html");
		al=driver.switchTo().alert();
		System.out.println(al.getText());
		Thread.sleep(2000);
		al.accept();		
	}
	
	public static void navigate() throws InterruptedException
	{
		String parentWindow=driver.getWindowHandle();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.findElement(By.partialLinkText("Yahoo")).click();
		driver.findElement(By.partialLinkText("Google")).click();
		driver.findElement(By.partialLinkText("Facebook")).click();
		Set<String> wins=driver.getWindowHandles();
		int i=0;
		for(String win:wins)
		{
			i++;
			if(i==2)
			{
				driver.switchTo().window(win);

				wait.until(driver->!driver.getTitle().isEmpty());
				System.out.println("title is:"+driver.getTitle());
				break;
			}
		}
		Thread.sleep(4000);
		driver.switchTo().window(parentWindow);
		Thread.sleep(4000);
		System.out.println("Back to:"+driver.getTitle());
		}
	
	public static void tearDown()
	{ 
		driver.quit();
	}
	public static void main(String[] args) throws InterruptedException {
		setup();
		getApp();
		navigate();
		tearDown();
	}
	
	}

