package testCases;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseTest.BaseClass;
import pageObjects.HomePage;
import pageObjects.PracticePage;
import pageObjects.TablePage;

public class TablePageTest extends BaseClass{
	HomePage hp;
	PracticePage pp;
	TablePage tp;
	
	@BeforeMethod
	private void setUpPage() {
		hp=new HomePage(driver);
		pp=new PracticePage(driver);
		tp=new TablePage(driver);
	}
	
	public void moveToPage() {
		 hp.clickPractice();
		 pp.clickTestTable();
	}
  @Test(priority=1)
  public void verifyJavaCourses() {
	  moveToPage();
	  tp.selectJavaRadio();
	  assertTrue(tp.areAllCoursesJava(),"Non Java courses found");
	  
  }
  
  @Test(priority=2)
  public void verifyBeginnerCourses() {
	  moveToPage();
	  tp.deselectIntermediateAndAdvanced();
	  assertTrue(tp.areAllCoursesBeginner(),"Non beginner courses found");
  }
  
  @Test(priority=3)
  public void verifyEnrollment() {
	  moveToPage();
	  tp.clickEnrollments();
	  tp.selectEnrollmentOption();
	  assertTrue(tp.areUnder10k(),"Courses with less than 10000 enrollments found");
  }
  
  @Test(priority=4)
  public void verifyMixedCondition() {
	  moveToPage();
	  tp.selectPythonRadio();
	  tp.deselectIntermediateAndAdvanced();
	  tp.clickEnrollments();
	  tp.selectEnrollmentOption();
	  assertTrue(tp.mixedCondition(),"Condition not satisfied");
  }
  
  @Test(priority=5)
  public void verifyNoMatchingCase() {
	  moveToPage();
	  tp.selectPythonRadio();
	  tp.deselectBeginner();
	  assertTrue(tp.isBlockDisplayed(),"error message not found");
  }
  
  @Test(priority=6)
  public void verifyResetButton() {
	  moveToPage();
	  tp.deselectBeginner();
	  tp.isResetButtonDisplayed();
	  tp.clickResetButton();
	 if(tp.isButtonHidden() && tp.areFiltersReset() && tp.areAllRowsvisible())
		 assertTrue(true);
	 else
		 assertTrue(false);
  }
  
  @Test(priority=7)
  public void verifyEnrollmentSort() {
	  moveToPage();
	  List<Integer> sortedList=tp.sortedEnrollment();
	  tp.selectEnrollments();
	  List<Integer> actList=tp.getEnrollmentList();
	  Assert.assertEquals(sortedList, actList,"Did not match");
  }
  
  @Test(priority=8)
  public void verifyCourseNameSort() {
	  moveToPage();
	  List<String> sortedList=tp.sortedCourseList();
	  tp.selectCourseName();
	  List<String> actList=tp.getCourseList();
	  Assert.assertEquals(sortedList, actList,"Did not match");
  }

}
