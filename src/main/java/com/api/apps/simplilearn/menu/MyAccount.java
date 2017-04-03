package com.api.apps.simplilearn.menu;

import java.util.NoSuchElementException;

import com.api.android.Android;
import com.api.interfaces.Activity;
import com.foundation.core.MyLogger;

public class MyAccount implements Activity {
	
	MyAccountUiObjects accountUiObjects = new MyAccountUiObjects();
	
	
	public void tapSignOut(){
		try{
			MyLogger.log.info("Tapping on SignOut button");
			accountUiObjects.signOut().tap();
		}catch(NoSuchElementException e){
			throw new AssertionError("Can not tap on SIGNOUT button , element absent or blocked ");
		}
	}
	
	public void tapSignOutOk(){
		try{
			MyLogger.log.info("Tapping on SignOut Ok button");
			accountUiObjects.signOutOk().tap();
		}catch(NoSuchElementException e){
			throw new AssertionError("Can not tap on SIGNOUT OK button , element absent or blocked ");
		}
	}
	
	
	
	public MyAccount waitToLoad() {
		 try{
			 MyLogger.log.info("Waiting for MyAccount activity");
			 accountUiObjects.signOut().waitToAppear(50);
			 return Android.app.simplilearn.myAccount;
		 }catch(AssertionError e){
			throw new AssertionError("MyAccount activity fails to load/open");
		 }
		
	}

}
