package com.test.appiumframework;

import java.io.IOException;
import java.net.MalformedURLException;

import org.apache.log4j.Level;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.JUnitCore;

import com.api.android.Android;
import com.api.apps.simplilearn.menu.Home;
import com.api.apps.simplilearn.menu.MyCourseMenu;
import com.foundation.core.MyLogger;
import com.foundation.coreManager.DriverManager;

import test.TestPrimer;

public class Runner2Test {

//public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		
	
		@Test
		@Category(SampleTest.class)
	public void run() throws InterruptedException, IOException{
			MyLogger.log.setLevel(Level.INFO);
		try{
		//DriverManager.createDriver();
		JUnitCore.runClasses(TestPrimer.class);
		Thread.sleep(10000);
		}finally{
		
			DriverManager.killDriver();
		}
	}
}
//}
