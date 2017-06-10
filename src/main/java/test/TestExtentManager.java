package test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import org.testng.ITestResult;
import org.testng.annotations.Test;

import com.api.android.Android;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.test.reports.GetScreenShot;

public class TestExtentManager {

	static ExtentReports extent;
	static ExtentTest test;

public void setExtentConfig(){
	extent = new ExtentReports(System.getProperty("user.dir")+"/test-output/SimpliReport.html",true);
	extent.addSystemInfo("HostName","Jagan")
	.addSystemInfo("Enviroment","QA")
	.addSystemInfo("Username","Jagan");
	extent.loadConfig(new File(System.getProperty("user.dir")+"extent-config.xml"));
}
public void startExtentTest(String str){
	test=extent.startTest(str);
}

public void setExtentPass(){
	test.log(LogStatus.PASS, "Assert Pass as condition true");
}
public void setExtentFail(){
	test.log(LogStatus.FAIL, "Assert failed as condition false");
}

public void setExtentScreenShot(String screenShotName) throws IOException{
	String screenshotPath = GetScreenShot.capture(Android.driver, screenShotName);
	
	test.log(LogStatus.FAIL, "Screenshot below:  "+ test.addScreenCapture(screenshotPath));
}
}
