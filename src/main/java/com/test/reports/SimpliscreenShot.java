package com.test.reports;

import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
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

public class SimpliscreenShot extends TestManager {

	ExtentReports extent;
	ExtentTest test;
	
	
	private static Simplilearn simplilearn = Android.app.simplilearn;
	
	
	@BeforeTest
	public void beforeTest(){
		
try {
	extent =  new ExtentReports(System.getProperty("user.dir")+"/test-output/ExtentScreenshot.html");
	extent.addSystemInfo("HostName","Jagan")
	.addSystemInfo("Enviroment","QA")
	.addSystemInfo("Username","Jagan");
	extent.loadConfig(new File(System.getProperty("user.dir")+"extent-config.xml"));
			simplilearn.open();
			Thread.sleep(10000);
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Assert failed as condition false");
			throw new RuntimeException(e.getMessage());
		}
	}
	
	@Test(priority=1)
	public void loginToApp() throws InterruptedException{
		//testInfo.id("test2").name("Entering credentials for login");
		try {
			test=extent.startTest("loginToApp");
			Home home = Android.app.simplilearn.home;
			
			home.tapHomeLogin();
			home.typeUserName();
			home.typePassword();
			home.tapLogin();
			test.log(LogStatus.PASS, "Assert Pass as condition true");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Assert failed as condition false");
			throw new RuntimeException(e.getMessage());
		}
		}
	@Test(priority=2)
	public void verifyMyCourse() throws InterruptedException{
		try {
			test=extent.startTest("verifyMyCourse");
			testInfo.id("test3").name("Testing MyCourse menu");
			MyCourseMenu courseMenu = Android.app.simplilearn.courseMenu;
			//Assert.assertTrue(simplilearn.courseMenu.myCourseMenuUiObjects.menuIcon().exist());
			Thread.sleep(5000);
//	courseMenu.tapMenuIcon();
			//Assert.assertTrue(simplilearn.courseMenu.myCourseMenuUiObjects.myCourse().exist());
//		courseMenu.tapMyCourse();
//		Thread.sleep(10000);
//		courseMenu.tapMenuIcon();
//		Thread.sleep(5000);
//		courseMenu.tapeExploreCourse();
			test.log(LogStatus.PASS, "Assert Pass as condition true");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Assert failed as condition false");
			throw new RuntimeException(e.getMessage());
		}
		}
	
	@Test(priority=3)
	public void verifyLogout() throws InterruptedException, IOException{
		try {
			test=extent.startTest("verifyLogout");
			testInfo.suite("Logout");
			MyCourseMenu courseMenu = Android.app.simplilearn.courseMenu;
			MyAccount myAccount = new MyAccount();
			courseMenu.tapMenuIcon();
			courseMenu.tapMyAccount();
			Thread.sleep(5000);
			myAccount.tapSignOut();
			myAccount.tapSignOutOk();
			Thread.sleep(5000);
			test.log(LogStatus.FAIL, "Assert Pass as condition true");
			
			
			String screenshotPath = GetScreenShot.capture(Android.driver, "screenshotForextentReport");
			
			test.log(LogStatus.FAIL, "Screenshot below:  "+ test.addScreenCapture(screenshotPath));
			
			DriverManager.killDriver();
			
					} catch (Exception e) {
			test.log(LogStatus.FAIL, "Assert failed as condition false");
			throw new RuntimeException(e.getMessage());
		}
		
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException{
		if(result.getStatus()==ITestResult.FAILURE)
		{
//			String screenshotPath = "/Users/jagannathpanda/Documents/eclipse 2/com.mobile.simplilearn/ErrorScreenShot/SimpliError.png";
//			Android.adb.takeScreenshot(screenshotPath);
			
			String screenshotPath = GetScreenShot.capture(Android.driver, "screenshotForextentReport");
			test.log(LogStatus.FAIL, result.getThrowable());
			test.log(LogStatus.FAIL, "Screenshot below:  "+ test.addScreenCapture(screenshotPath));
			
			
			
			
		}
		extent.endTest(test);
	}
	
	@AfterTest
	public void afterTest(){
		
		extent.flush();
		extent.close();
	}

	
}
