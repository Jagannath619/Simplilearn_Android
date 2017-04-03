package com.test.appiumframework;

import java.net.MalformedURLException;

import com.api.android.Android;
import com.api.apps.simplilearn.Simplilearn;
import com.foundation.coreManager.DriverManager;


public class Runner3 {
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
	  Simplilearn simplilearn = Android.app.simplilearn;
	//DriverManager.createDriver();
	simplilearn.open();
	Thread.sleep(10000);	
}
}