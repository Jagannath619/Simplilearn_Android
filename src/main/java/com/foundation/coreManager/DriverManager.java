package com.foundation.coreManager;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.service.DriverService;

import com.api.android.Android;
import com.foundation.core.ADB;
import com.foundation.core.MyLogger;
import com.foundation.simplilearn.constants.Arg;

public class DriverManager {
	
	
	private static String nodeJS="/Applications/Appium.app/Contents/Resources/node/bin/node";
	//private static String appiumJS="/Applications/Appium.app/Contents/Resources/node_modules/appium/bin/ios-webkit-debug-proxy-launcher.js";
	//private static String appiumJS="/Applications/Appium.app/Contents/Resources/node_modules/appium/bin/appium.js";
	private static String appiumJS="/Applications/Appium.app/Contents/Resources/node_modules/appium/build/lib/main.js";
	private static AppiumDriverLocalService service;
	private static String deviceID;
	
	private static HashMap<String ,URL> hosts;
	private static String unlockPackage = "io.appium.unlock";
	 private static File classpathRoot = new File(System.getProperty("user.dir"));
	 private static File appDir = new File(classpathRoot, "/apps/");
	 private static File app = new File(appDir, "Simplilearn_com.mobile.simplilearn.apk");
	
	private static DesiredCapabilities getCaps(String deviceID){
		MyLogger.log.info("Creating desirecapabalities for device: "+deviceID);
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", deviceID);
		caps.setCapability("platfornName", "Android");
		caps.setCapability("app",app.getAbsolutePath());
		caps.setCapability("platfornName", "Android");
		caps.setCapability("noReset", "true");
		return caps;
	}
	
	private static URL host(String deviceID) throws MalformedURLException{
		if(hosts==null) {
			hosts= new HashMap<String, URL>();
			hosts.put(deviceID, new URL("http://127.0.0.1:4723/wd/hub"));
			
		}return hosts.get(deviceID);
	}
	
	private static ArrayList<String> getAvailableDevices(){
		MyLogger.log.info("Checking for available devices");
		ArrayList<String> availableDevices = new ArrayList();
		ArrayList connectedDevices = ADB.getConnectedDevices();
		for(Object connectedDevice: connectedDevices){
			String device=  connectedDevice.toString();
			ArrayList app= new ADB(device).getInstalledPackages();
			if(app.contains(unlockPackage)) {
				MyLogger.log.info("Device"+device+"has "+unlockPackage+" installed,assuming it is under testing");
				availableDevices.add(device);}
			else if(!app.contains(unlockPackage)) {
				availableDevices.add(device);
				MyLogger.log.info("Device"+device+"does not have "+unlockPackage+" installed,assuming it is removed");
			}
			
			
		}
		if(availableDevices.size()==0) throw new RuntimeException("Not a single device is available for testing");
		return availableDevices;
	}
	
	
	private static AppiumDriverLocalService createService() throws NumberFormatException, MalformedURLException{
	 service =   AppiumDriverLocalService.buildService( new AppiumServiceBuilder()
		          .usingDriverExecutable(new File(nodeJS))
		          .withAppiumJS(new File(appiumJS))
		          .withIPAddress("127.0.0.1").usingPort(4723).withCapabilities(getCaps(deviceID))
		         .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
		         .withArgument(GeneralServerFlag.LOG_LEVEL,"info"));
		         // .withIPAddress(host(deviceID).toString().split(":")[1].replace("//", ""))
		         // .usingPort(Integer.parseInt(host(deviceID).toString().split(":")[2].replace("/wd/hub", "")))
		        //  .withArgument(Arg.TIMEOUT,"120")
		        //  .withArgument(Arg.LOG_LEVEL,"debug")
		        //  .withArgument(Arg.NO_RESET,"true"));
		          //.withArgument(Arg.PLATFORM_NAME,"Android")
		          //.withArgument(Arg.PLATFORM_VERSION,"6.0")
		          //.withArgument(Arg.AUTOMATION_NAME, "Appium")
		           //.withArgument(Arg.FULL_RESET, "false"));
		      //    .build();
		
//		service=AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
//        .usingDriverExecutable(new File(nodeJS))
//        .withAppiumJS(new File(appiumJS))
//        .withIPAddress(host(deviceID).toString().split(":")[1].replace("//", ""))
//        .usingPort(Integer.parseInt(host(deviceID).toString().split(":")[2].replace("/wd/hub", "")))
//        .withArgument(Arg.TIMEOUT,"120"));
		return service;
	}
	
	
	
	public static void createDriver() throws MalformedURLException{
		ArrayList<String> devices= getAvailableDevices();
		for(String device:devices){
			try{
				deviceID=device;
			MyLogger.log.info("Trying to create a new Driver for device: "+device);
			stopAppium();
			createService().start();
			//startAppiumServer();
			//appiumShell();
			Android.driver = new AndroidDriver(host(device),getCaps(device));
			Android.adb = new ADB(device);
			break;
			}catch(Exception e){
				e.printStackTrace();
				//Ignore and try next device;
			}
		}
	}

	public static void killDriver() throws IOException{
		if(Android.driver != null){
			MyLogger.log.info("Killing Android driver");
			Android.driver.quit();
			Android.adb.uninstallApp(unlockPackage);
			//service.stop();
			stopAppium();
			//stopAppiumServer();
			}else MyLogger.log.info("Android driver is not initialised, nothing to kill");
	}
	
	//============
	private static void startAppiumServer(){
		CommandLine command = new CommandLine(
				"/Applications/Appium.app/Contents/Resources/node/bin/node");
		command.addArgument(
				"/Applications/Appium.app/Contents/Resources/node_modules/appium/build/lib/main.js",
				false);
		command.addArgument("--address");
	    command.addArgument("127.0.0.1");
		command.addArgument("--port");
		command.addArgument("4723");
		command.addArgument("--platform-name");
		command.addArgument("Android");
		command.addArgument("--platform-version");
		command.addArgument("6.0");
		
		
		
		//command.addArgument("--full-reset",false);
		command.addArgument("--no-reset",true);
		
		command.addArgument("--log-level");
		command.addArgument("info");
		DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();
		DefaultExecutor executor = new DefaultExecutor();
		executor.setExitValue(1);
		try {
			executor.execute(command, resultHandler);
			Thread.sleep(5000);
			System.out.println("Appium server started.");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
		
	
    private static void stopAppiumServer(){
    	String[] command = { "killall", "-KILL", "node" };
		try {
			Runtime.getRuntime().exec(command);
			System.out.println("Appium server stopped.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
    
    private static void stopAppium() throws IOException{
    	System.out.println("Trying to stop Appium Server");
    	try {
			createService().stop();
		} catch (Exception e) {
			System.out.println("No AppiumServer is running...Good to go");
			e.printStackTrace();
		}
    	System.out.println("Appium server is now shutdown...!!!");
    }
	
	
}
