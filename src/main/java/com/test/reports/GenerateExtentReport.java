package com.test.reports;

import java.io.File;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class GenerateExtentReport   {
	
	ExtentReports extent;
	ExtentTest test;
	
	
@BeforeTest
public void startReport(){
	extent = new ExtentReports(System.getProperty("user.dir")+"/test-output/SimpliReport.html",true);
	extent.addSystemInfo("HostName","Jagan")
	.addSystemInfo("Enviroment","QA")
	.addSystemInfo("Username","Jagan");
	extent.loadConfig(new File(System.getProperty("user.dir")+"extent-config.xml"));
	
}

@Test
public void SIMPLI1(){
	test=extent.startTest("SIMPLI1");
	Assert.assertTrue(true);
	test.log(LogStatus.PASS, "Assert Pass as condition true");
	
}
@Test
public void SIMPLI2(){
	test=extent.startTest("SIMPLI2");
	Assert.assertTrue(false);
	test.log(LogStatus.FAIL, "Assert failed as condition false");
	
}

@AfterMethod
public void afterMethod(ITestResult result){
	if(result.getStatus()==ITestResult.FAILURE)
	{
		
		test.log(LogStatus.FAIL, result.getThrowable());
	}
	extent.endTest(test);
}

@AfterTest
public void afterTest(){
	extent.flush();
	extent.close();
}


}
