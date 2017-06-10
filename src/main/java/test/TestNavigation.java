package test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.net.MalformedURLException;

import com.api.android.Android;
import com.api.apps.simplilearn.Simplilearn;
import com.api.apps.simplilearn.menu.Home;
import com.api.apps.simplilearn.menu.MyAccount;
import com.api.apps.simplilearn.menu.MyCourseMenu;
import com.foundation.coreManager.DriverManager;
import com.foundation.coreManager.TestManager;
import com.relevantcodes.extentreports.LogStatus;
import com.test.reportFoundtion.Owners;
import com.test.reportFoundtion.TestCaseInfo;
import com.test.reportFoundtion.TestCategory;
import com.test.reportFoundtion.TestClass;

import java.lang.reflect.Executable;
import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.IInvokedMethod;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;

import com.test.reportFoundtion.TestRunner;


public class TestNavigation extends TestManager{
	//static TestRunner runner = new TestRunner();
	
	private static Simplilearn simplilearn = Android.app.simplilearn;
	TestExtentManager extentManager = new TestExtentManager();

	@BeforeClass
	public static void beforeClass() throws InterruptedException, MalformedURLException{
		simplilearn.open();
    	Thread.sleep(10000);
    	
	//runner.testSummary();
	}
	@BeforeTest
	public  void beforeTest(){
		extentManager.setExtentConfig();
		}
	
	@BeforeMethod
	public void beforeMethod(Method m){
		
       TestCaseInfo manno= m.getAnnotation(TestCaseInfo.class);
		
		System.out.println("Testing test Runner before");
		System.out.println("==========================================================================================================");
		System.out.println("TestID is: "+manno.TestId()+", owner is: "+manno.Owner()+" ,Priority is: "+manno.Priority()+", TestCategory is: "+manno.TestCategory());
		System.out.println("==========================================================================================================");
	}
	
	
	@Test(groups = { "" })
	@TestCaseInfo(TestId = "KM-001", Owner = Owners.TestsOwner, Priority = 0, TestCategory = TestCategory.smokeTest)
	public void verifyLoginElements(){
		try{
			testInfo.id("test1").name("Verify that home activity has all elements");
		extentManager.startExtentTest("Login elements verification");
		extentManager.setExtentPass();
		//Assert.assertTrue(simplilearn.home.homeScreenUiObjects.startLogin().exist());
		}catch (Exception e) {
			extentManager.setExtentFail();
			throw new RuntimeException(e.getMessage());
		}
	}
	
	
	@Test(priority = 1)
	@TestCaseInfo(TestId = "KM-002", Owner = Owners.TestsOwner, Priority = 0, TestCategory = TestCategory.smokeTest)
	public void loginToApp() throws InterruptedException {

		try {
			// testInfo.id("test2").name("Entering credentials for login");

			extentManager.startExtentTest("Entering credentials for login");

			Home home = Android.app.simplilearn.home;

			home.tapHomeLogin();
			home.typeUserName();
			home.typePassword();
			home.tapLogin();
			extentManager.setExtentPass();
		} catch (Exception e) {
			extentManager.setExtentFail();
			throw new RuntimeException(e.getMessage());
		}
	}
	
	
	@Test(priority=2)
	@TestCaseInfo(TestId = "KM-003", Owner = Owners.TestsOwner, Priority = 0, TestCategory = TestCategory.smokeTest)
	public void verifyMyCourse() throws InterruptedException{
		try{
		testInfo.id("test3").name("Testing MyCourse menu");
		extentManager.startExtentTest("Testing MyCourse menu");
		MyCourseMenu courseMenu = Android.app.simplilearn.courseMenu;
		//Assert.assertTrue(simplilearn.courseMenu.myCourseMenuUiObjects.menuIcon().exist());
		Thread.sleep(5000);
		extentManager.setExtentPass();
		} catch (Exception e) {
			extentManager.setExtentFail();
			throw new RuntimeException(e.getMessage());
		}
		}
	
	@Test(priority=3)
	@TestCaseInfo(TestId = "KM-004", Owner = Owners.TestsOwner, Priority = 0, TestCategory = TestCategory.smokeTest)
	public void verifyLogout() throws InterruptedException, IOException{
		
		try{
			extentManager.startExtentTest("Testing Logout");
		testInfo.suite("Logout");
		MyCourseMenu courseMenu = Android.app.simplilearn.courseMenu;
		MyAccount myAccount = new MyAccount();
		courseMenu.tapMenuIcon();
		courseMenu.tapMyAccount();
		Thread.sleep(5000);
		myAccount.tapSignOut();
		myAccount.tapSignOutOk();
		Thread.sleep(5000);
		DriverManager.killDriver();
		extentManager.setExtentPass();
		} catch (Exception e) {
			extentManager.setExtentFail();
			throw new RuntimeException(e.getMessage());
		}
		
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			extentManager.setExtentScreenShot("screenshotForextentReport");
			TestExtentManager.test.log(LogStatus.FAIL, result.getThrowable());
			
		}
		TestExtentManager.extent.endTest(TestExtentManager.test);
	}

	@AfterTest
	public void afterTest(){
		TestExtentManager.extent.flush();
		TestExtentManager.extent.close();
	}
	
	
}



