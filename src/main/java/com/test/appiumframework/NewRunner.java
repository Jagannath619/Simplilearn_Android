package com.test.appiumframework;

import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;

import org.apache.log4j.Level;

import com.api.android.Android;
import com.foundation.core.MyLogger;
import com.foundation.core.UiObject;
import com.foundation.core.UiSelector;
import com.foundation.coreManager.DriverManager;

public class NewRunner {
	public static void main(String[] args) throws MalformedURLException, InterruptedException{

		//Android.app.simplilearn.home.homeScreenUiObjects.startLogin();
			MyLogger.log.setLevel(Level.INFO);
			//AndroidDriver driver=null;
			try{
			DriverManager.createDriver();
			Android.adb.openAppActivity("com.mobile.simplilearn","com.mobile.simplilearn.view.activity.SplashActivity");
			
			UiObject homeLogin= new UiSelector().xPath("//android.widget.Button[@text='LOGIN']").makeUiObject();
			UiObject username= new UiSelector().xPath("//android.widget.EditText[@text='Email']").makeUiObject();
			UiObject password= new UiSelector().xPath("//android.widget.EditText[@resource-id='com.mobile.simplilearn:id/idPassword']").makeUiObject();
			UiObject loginButton= new UiSelector().xPath("//android.widget.Button[@text='LOGIN']").makeUiObject();
			UiObject Mycourses= new UiSelector().text("My Courses").makeUiObject();
			UiObject GoOffline= new UiSelector().text("Go Offline").makeUiObject();
			
	
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
			}finally{
			//if(driver!= null) driver.quit();
				DriverManager.killDriver();
			}
	}

}
