package com.api.apps.simplilearn.menu;

import com.foundation.core.UiObject;
import com.foundation.core.UiSelector;

public class MyAccountUiObjects {
	
	private static UiObject 
	            signOut, 
	            shareApp,
	            rateApp,
	            notification,
	            userLocation,
	            downloadOverWifi,
	            clearDownloadedData,
	            signOutOk,
	            signOutCancel;
	            

	public UiObject signOut(){
		if(signOut == null) signOut = new UiSelector().xPath("//android.widget.Button[@text='SIGN OUT']").makeUiObject();
	   return signOut;
				
		} 
	
	public UiObject shareApp(){
		if(shareApp == null) shareApp = new UiSelector().text("Share App").makeUiObject();
	   return shareApp;
				
		}
	public UiObject rateApp(){
		if(rateApp == null) rateApp = new UiSelector().text("Rate App").makeUiObject();
	   return rateApp;
				
		} 
	public UiObject notification(){
		if(notification == null) notification = new UiSelector().text("Notifications").makeUiObject();
	   return notification;
				
		} 
	public UiObject userLocation(){
		if(userLocation == null) userLocation = new UiSelector().xPath("//android.widget.LinearLayout[@index='5']/android.widget.TextView[@index=''0]").makeUiObject();
	   return userLocation;
				
		} 
	public UiObject downloadOverWifi(){
		if(downloadOverWifi == null) downloadOverWifi = new UiSelector().text("Download over wi-fi only").makeUiObject();
	   return downloadOverWifi;
				
		} 
	public UiObject clearDownloadedData(){
		if(clearDownloadedData == null) clearDownloadedData = new UiSelector().xPath("//android.widget.TextView[contains(@text,'Clear downloaded data')]").makeUiObject();
	   return clearDownloadedData;
				
		} 
	public UiObject signOutOk(){
		if(signOutOk == null) signOutOk = new UiSelector().text("OK").makeUiObject();
	   return signOutOk;
				
		} 
	public UiObject signOutCancel(){
		if(signOutCancel == null) signOutCancel = new UiSelector().text("Cancel").makeUiObject();
	   return signOutCancel;
				
		} 
}
