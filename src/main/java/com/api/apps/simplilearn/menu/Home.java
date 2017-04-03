package com.api.apps.simplilearn.menu;

import java.util.NoSuchElementException;

import com.api.android.Android;
import com.api.interfaces.Activity;
import com.foundation.core.MyLogger;

public class Home implements Activity {
	public HomeScreenUiObjects homeScreenUiObjects = new HomeScreenUiObjects();
	
	public void tapHomeLogin(){
		try{
			MyLogger.log.info("Tapping on Login button");
			homeScreenUiObjects.startLogin().tap();
			}catch(NoSuchElementException e){
			throw new AssertionError("Can not tap on Login button , element absent or blocked ");
		}
	}
	public void typeUserName(){
		try{
			MyLogger.log.info("Typing User name");
			homeScreenUiObjects.username().typeText("androidtester02@simplilearn.com"+"\n");
		}catch(NoSuchElementException e){
			throw new AssertionError("Can not type username , element absent or blocked ");
		}
	}
	public void typePassword(){
		try{
			MyLogger.log.info("Typing password");
			homeScreenUiObjects.password().typeText("tester123"+"\n");
		}catch(NoSuchElementException e){
			throw new AssertionError("Can not type password , element absent or blocked ");
		}
	}
	public MyCourseMenu tapLogin() throws InterruptedException{
		try{
			MyLogger.log.info("Tapping on Login button");
			if(homeScreenUiObjects.logingButton().isFocusable())
			 homeScreenUiObjects.logingButton().tap();
			Thread.sleep(6000);
			return Android.app.simplilearn.courseMenu.waitToLoad();
			
		}catch(NoSuchElementException e){
			throw new AssertionError("Can not tap on Login button , element absent or blocked ");
		}
	}
	public Home waitToLoad() {
		 try{
			 MyLogger.log.info("Waiting for Home activity");
			 homeScreenUiObjects.startLogin().waitToAppear(20);
			 return Android.app.simplilearn.home;
		 }catch(AssertionError e){
			throw new AssertionError("MyCourseMenu activity fails to load/open");
		 }
		}

}
