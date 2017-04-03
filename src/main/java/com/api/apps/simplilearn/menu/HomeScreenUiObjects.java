package com.api.apps.simplilearn.menu;

import com.foundation.core.UiObject;
import com.foundation.core.UiSelector;

public class HomeScreenUiObjects {
	
	private static UiObject 
	    startLogin,
	    username,
	    password,
	    logingButton;
	
	public UiObject startLogin(){
	if(startLogin == null) startLogin = new UiSelector().text("LOGIN").makeUiObject();
   return startLogin;
			
	}
	
	public UiObject username(){
		if(username == null) username = new UiSelector().text("Email").makeUiObject();
	   return username;
				
		}
	 
	public UiObject password(){
		if(password == null) password = new UiSelector().xPath("//android.widget.EditText[@resource-id='com.mobile.simplilearn:id/idPassword']").makeUiObject();
	   return password;
				
		}
	 
	public UiObject logingButton(){
		if(logingButton == null) logingButton = new UiSelector().text("LOGIN").makeUiObject();
	   return startLogin;
				
		}
	 
 
	
	
}


