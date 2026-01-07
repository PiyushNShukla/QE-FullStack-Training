package baseTest;

import java.net.MalformedURLException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {

	protected WebDriver driver;
//	@Parameters("browser")
	@BeforeClass
	public void setup() throws MalformedURLException {
		
//		MutableCapabilities options;
//		if (browser.equalsIgnoreCase("chrome")) {
//            options = new ChromeOptions();
//        } else if (browser.equalsIgnoreCase("edge")) {
//            options = new EdgeOptions();
//        } else {
//            throw new RuntimeException("Unsupported browser");
//        }
		
//		driver = new RemoteWebDriver(
//                new URL("http://192.168.1.2:4444/"),
//                options
	//);
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://practicetestautomation.com/");
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
	
	
}
