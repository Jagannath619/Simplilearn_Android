package test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.api.android.Android;
import com.api.apps.simplilearn.Simplilearn;
import com.api.apps.simplilearn.menu.Home;
import com.api.apps.simplilearn.menu.MyAccount;
import com.api.apps.simplilearn.menu.MyCourseMenu;
import com.foundation.coreManager.DriverManager;
import com.foundation.coreManager.TestManager;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestExtentReport1 extends TestManager {

	private static Simplilearn simplilearn = Android.app.simplilearn;
	
	
	TestExtentManager extentManager = new TestExtentManager();
	@BeforeClass
	public static void beforeClass() throws InterruptedException, MalformedURLException{
		try {
			
			simplilearn.open();
			Thread.sleep(10000);
		} catch (Exception e) {
			
//			TestExtentManager extentManager1= new TestExtentManager();
//			extentManager1.setExtentFail();
			throw new RuntimeException(e.getMessage());
		}
	}
	
	@BeforeTest
	public  void before(){
		extentManager.setExtentConfig();
		}
	
	@Test
	public void verifyLoginElements(){
		try {
			extentManager.startExtentTest("Login elements verification");
			extentManager.setExtentPass();
		} catch (Exception e) {
			extentManager.setExtentFail();
			throw new RuntimeException(e.getMessage());
		}
		
		}
	@Test(priority=1)
	public void loginToApp() throws InterruptedException{
		//testInfo.id("test2").name("Entering credentials for login");
		try {
			extentManager.startExtentTest("Login to app");
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
	public void verifyMyCourse() throws InterruptedException{
		try {
			extentManager.startExtentTest("Verify My Course");
			
			MyCourseMenu courseMenu = Android.app.simplilearn.courseMenu;
		
			Thread.sleep(5000);

			extentManager.setExtentPass();
		} catch (Exception e) {
			extentManager.setExtentFail();
			throw new RuntimeException(e.getMessage());
		}
		}
	
	@Test(priority=3)
	public void verifyLogout() throws InterruptedException, IOException{
		try {
			extentManager.startExtentTest("Verify Logout");
			
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

