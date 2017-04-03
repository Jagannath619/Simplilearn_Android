package com.test.appiumframework;

import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;



import org.openqa.selenium.remote.DesiredCapabilities;

import com.api.android.Android;
import com.foundation.core.ADB;
import com.foundation.core.MyLogger;
import com.foundation.core.UiObject;
import com.foundation.core.UiSelector;
import com.foundation.coreManager.DriverManager;

public class Runner {

	public static void main(String[] args) throws MalformedURLException, InterruptedException{
//	new UiSelector().resourceId("hello").text("1").makeUiObject();
//	new UiSelector().resourceId("hello").text("2").makeUiObject();
//	new UiSelector().resourceId("hello").text("3").makeUiObject();
		//BasicConfigurator.configure();
//		MyLogger.log.setLevel(Level.INFO);
//		MyLogger.log.debug("Test Debug");
//		MyLogger.log.error("Test error");
//		MyLogger.log.info("Test info");
//		MyLogger.log.warn("Test warning");
		
		MyLogger.log.setLevel(Level.INFO);
		AndroidDriver driver=null;
		/*File classpathRoot = new File(System.getProperty("user.dir"));
		File appDir = new File(classpathRoot, "/apps/");
		File app = new File(appDir, "Simplilearn_com.mobile.simplilearn.apk");
       // File app= new File("/Users/jagannathpanda/Documents/Simplilearn_com.mobile.simplilearn.apk");
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		//capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
		capabilities.setCapability("deviceName", "Nexus 5");
		capabilities.setCapability("platformVersion", "6.0.1");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("app", app.getAbsolutePath());
		//capabilities.setCapability("appPackage", "com.mobile.simplilearn");
		//capabilities.setCapability("appActivity", "com.mobile.simplilearn.view.activity.SplashActivity");
		//capabilities.setCapability("appActivity", "com.mobile.simplilearn.view.activity.MainActivity");	
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		
		//driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		Android.driver=driver;
		ADB adb = new ADB("03de9dc6213ebc2d");*/
		
		DriverManager.createDriver();
		Android.adb.openAppActivity("com.mobile.simplilearn","com.mobile.simplilearn.view.activity.SplashActivity");
		
		UiObject homeLogin= new UiSelector().xPath("//android.widget.Button[@text='LOGIN']").makeUiObject();
		UiObject username= new UiSelector().xPath("//android.widget.EditText[@text='Email']").makeUiObject();
		UiObject password= new UiSelector().xPath("//android.widget.EditText[@resource-id='com.mobile.simplilearn:id/idPassword']").makeUiObject();
		UiObject loginButton= new UiSelector().xPath("//android.widget.Button[@text='LOGIN']").makeUiObject();
		UiObject Mycourses= new UiSelector().text("My Courses").makeUiObject();
		UiObject GoOffline= new UiSelector().text("Go Offline").makeUiObject();
		
	/*	
		driver.findElementByXPath("//android.widget.Button[@text='LOGIN']").click();
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		driver.findElementByXPath("//android.widget.EditText[@text='Email']").clear();
		driver.findElementByXPath("//android.widget.EditText[@text='Email']").sendKeys("androiddev@simplilearn.com"+"\n");
		//driver.findElementByXPath("//android.widget.TextView[@text='Welcome back!Login with your registered email ID']").click();
		driver.findElementByXPath("//android.widget.EditText[@resource-id='com.mobile.simplilearn:id/idPassword']").clear();
		driver.findElementByXPath("//android.widget.EditText[@resource-id='com.mobile.simplilearn:id/idPassword']").sendKeys("tester123"+"\n");
		//driver.findElementByXPath("//android.widget.TextView[@text='Welcome back!Login with your registered email ID']").click();
		driver.findElementByXPath("//android.widget.Button[@text='LOGIN']").click();
				Thread.sleep(50000);*/
				
		//homeLogin.waitToAppear(10).waitToDisappear(5);
		Thread.sleep(5000);
		homeLogin.tap();
		username.clearText();
		username.typeText("androidtester02@simplilearn.com"+"\n");
		password.clearText();
		password.typeText("tester123"+"\n");
		loginButton.tap();
		Thread.sleep(12000);
		Mycourses.waitToAppear(5);
		MyLogger.log.info("Elements present in UI after login :"+Mycourses.getText()+","+GoOffline.getText());
		//loginButton.waitToDisappear(5);
		
		driver.quit();
}
}