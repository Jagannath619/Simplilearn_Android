package com.api.apps.simplilearn;

import java.net.MalformedURLException;

import com.api.android.Android;
import com.api.apps.simplilearn.menu.Home;
import com.api.apps.simplilearn.menu.MyAccount;
import com.api.apps.simplilearn.menu.MyCourseMenu;
import com.api.apps.simplilearn.menu.MyCourseMenuUiObjects;
import com.api.interfaces.Application;
import com.foundation.coreManager.DriverManager;

public class Simplilearn implements Application {

	public Home home= new Home();
	public MyCourseMenu courseMenu = new MyCourseMenu();
	public MyAccount myAccount = new MyAccount();
	public void forceStop() {
		
		Android.adb.forceStopApp(packageID());
		
	}

	public void clearData() {
		Android.adb.clearAppsData(packageID());
		
	}

	public Object open() throws MalformedURLException {
		DriverManager.createDriver();
		//Android.adb.openAppActivity(packageID(),activityID());
		return null;
	}

	public String packageID() {
		// TODO Auto-generated method stub
		return "com.mobile.simplilearn";
	}

	public String activityID() {
		
		return "com.mobile.simplilearn.view.activity.SplashActivity";
	}

	

}
