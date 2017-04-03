package com.test.appiumframework;

import java.net.MalformedURLException;

import org.apache.log4j.Level;

import com.api.android.Android;
import com.api.apps.simplilearn.menu.Home;
import com.api.apps.simplilearn.menu.MyCourseMenu;
import com.foundation.core.MyLogger;
import com.foundation.core.UiObject;
import com.foundation.core.UiSelector;
import com.foundation.coreManager.DriverManager;

public class Runner1 {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		MyLogger.log.setLevel(Level.INFO);
		
		try{
		DriverManager.createDriver();
		Android.app.simplilearn.open();
		Home home = Android.app.simplilearn.home.waitToLoad();
		home.tapHomeLogin();
		home.typeUserName();
		home.typePassword();
		MyCourseMenu courseMenu = Android.app.simplilearn.home.tapLogin();
		courseMenu.tapMenuIcon();
		courseMenu.tapMyCourse();
		Thread.sleep(10000);
		courseMenu.tapMenuIcon();
		courseMenu.tapMyAccount();
		Thread.sleep(10000);
		}finally{
		
			DriverManager.killDriver();
		}


	}

}
