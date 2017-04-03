package com.foundation.core;

import java.util.ArrayList;
import java.util.Arrays;

import org.testng.annotations.Test;

import com.foundation.coreManager.ServerManager;

public class ADB {
	
	private String ID;
	
	public ADB(String deviceID){ID=deviceID;}
	
	public static String command(String command){
		MyLogger.log.info("Formating ADB command: "+command);
		if(command.startsWith("adb")) 
			command= command.replace("adb", ServerManager.getAndroidHome()+"/platform-tools/adb");
		else throw new  RuntimeException("This method is designed to run ADB command only");
		MyLogger.log.info("Formated ADB command: "+command);
		String output= ServerManager.runCommand(command);
		MyLogger.log.info("Output of ADB command: "+command);
	if(output==null) return "" ;
	else return output;
	}
	
	@Test
	public void test(){
		System.out.println(command("adb devices"));
		
	}
	
	public static void killServer(){
		command("adb kill-server");
	}
	public static void startServer(){
		command("adb start-server");
	}
	public static ArrayList getConnectedDevices(){
		ArrayList devices= new ArrayList();
		String output= command("adb devices");
		for(String line:output.split("\n")){
			line=line.trim();
			if(line.endsWith("device")) devices.add(line.replace("device", "").trim());
		}
		return devices;
		
		}
	public String getForegroundActivity(){
		return command("adb -s "+ID+" shell dumpsys window windows | grep mCurrentFocus");
	}
	
	public String getAndroidVersionAsString(){
		String output=command("adb -s "+ID+" shell getprop ro.build.version.release");
		if(output.length()==3) output+=".0";
		return output;
	}
	public int getAndroidVersion(){
		return Integer.parseInt(getAndroidVersionAsString().replaceAll("\\.", ""));
	}
	public ArrayList getInstalledPackages(){
		ArrayList packages= new ArrayList();
		String[] output= command("adb -s "+ID+" shell pm list packages").split("\n");
	for(String packageID:output) packages.add(packageID.replace("package:", "").trim());
	return packages;
	}
	public void openAppActivity(String packageID,String activityID){
		command("adb -s"+ID+" shell am start -c api.android.intent.category.LAUNCHER -a api.android.intent.action.MAIN -n "+packageID+"/"+activityID);
	}
	public void clearAppsData(String packageID){
		command("adb -s "+ID+" shell pm clear "+packageID);
	}
	public void forceStopApp(String packageID){
		command("adb -s "+ID+" shell am force-stop "+packageID);
	}
	public void uninstallApp(String packageID){
		command("adb -s "+ID+" uninstall "+packageID);
	}
   public void clearLogBuffer(){
	   command("adb -s "+ID+" shell -c");
   }
   public void pushFile(String source,String target){
	   command("adb -s "+ID+" push "+source+" "+target);
   }
   public void pullFile(String source,String target){
	   command("adb -s "+ID+" pull "+source+" "+target);
   }	
   public void deleteFile(String target){
	   command("adb -s "+ID+" shell rm "+target);
   }
   public void moveFile(String source,String target){
	   command("adb -s "+ID+" shell mv "+source+" "+target);
   }
   public void takeScreenshot(String target){
	   command("adb -s "+ID+" shell screencap "+target);
   }
   public void rebootDevice(){
	   command("adb -s "+ID+" reboot");
   }
   public String getDeviceModel(){
	   return command("adb -s "+ID+" shell getprop ro.product.model");
   }
   public String getDeviceSerialNumber(){
	   return command("adb -s "+ID+" shell getprop ro.serialno");
   }
   public String getDeviceCarrier(){
	   return command("adb -s "+ID+" shell getprop gsm.operator.alpha");
   }
   public ArrayList getLogcatProcesses(){
	   String[] output= command("adb -s "+ID+" shell top -n 1 | grep -i 'logcat'").split("\n");
	   ArrayList process = new ArrayList();
	   for(String line:output){
		   process.add(line.split(" ")[0]);
		   process.removeAll(Arrays.asList("",null));
	   }
	   return process;
   }
   public Object startLogcat(final String logID,final String grep){
	   ArrayList pidBefore= getLogcatProcesses();
	   
	   Thread logcat= new Thread(new Runnable(){
		   public void run(){
			   if(grep==null) command("adb -s "+ID+" shell logcat -v threadtime > /sdcard/"+logID+".txt");
			   else command("adb -s "+ID+" shell logcat -v threadtime | grep -i '"+grep+"' > /sdcard/"+logID+".txt");}
	   });
		  
		logcat.setName(logID);  
        logcat.start();
        logcat.interrupt();
        ArrayList pidAfter= getLogcatProcesses();
        Timer timer= new Timer();
        timer.start();
        while(!timer.expired(5)){
        	if(pidBefore.size()>0) pidAfter.removeAll(pidBefore);
        	if(pidAfter.size()>0)  break;
        	pidAfter= getLogcatProcesses();
          }
        if(pidAfter.size()==1) return pidAfter.get(0);
        else if(pidAfter.size()>1) throw new RuntimeException("Multiple logcat processes were started when only one is required ");
        else throw new RuntimeException("Failed to start logcat processes");
   }
   
   public void stopLogcat(Object PID){
	   command("adb -s "+ID+" shell kill "+PID);
   }
   
   @Test
   public void test2(){
	   ArrayList arr=ADB.getConnectedDevices();
	   System.out.println(arr.size());
	   for (Object i:arr){
		   System.out.println(i.toString());
	   }
//	   ID="03de9dc6213ebc2d";
//	   System.out.println("processes prior to start new logcat : "+getLogcatProcesses());
//	   
//	   Object PID=startLogcat("1", null);
//	   System.out.println("Started logcat on PID :"+PID);
//	   System.out.println("processes after starting new logcat : "+getLogcatProcesses());
//	   stopLogcat(PID);
//	   System.out.println("processes after stopping new logcat : "+getLogcatProcesses());
	 //  System.out.println(command("adb shell ps |grep settings"));
   }
   
   }
   
   
   
   
   
