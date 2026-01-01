package testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseTest.BaseClass;
import pageObjects.HomePage;
import pageObjects.PracticePage;

public class PracticePageTest extends BaseClass{
	HomePage hp;
	PracticePage pp;
	@BeforeMethod
	private void setUpPage() {
		hp=new HomePage(driver);
		pp=new PracticePage(driver);
	}
  @Test
  public void testNavigation() {
	  hp.clickPractice();
	  pp.clickTestLoginPage();
	  Assert.assertEquals(driver.getTitle(), "Test Login | Practice Test Automation");
	  driver.navigate().back();
	  pp.clickTestExceptions();
	  Assert.assertEquals(driver.getTitle(), "Test Exceptions | Practice Test Automation");
	  driver.navigate().back();
	  pp.clickTestTable();
	  Assert.assertEquals(driver.getTitle(), "Test Table | Practice Test Automation");
	  driver.navigate().back();
	  
	  
  }
}
