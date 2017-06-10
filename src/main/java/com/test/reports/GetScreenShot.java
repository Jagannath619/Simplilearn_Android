package com.test.reports;

import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.api.android.Android;

public class GetScreenShot {
	
	public static String capture(AndroidDriver driver,String screenShotName) throws IOException{
	
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String dest = System.getProperty("user.dir")+"/ErrorScreenShot/"+ screenShotName+".png";
		
		File destination = new File (dest);
		FileUtils.copyFile(source, destination);
		return dest;
	}

}
