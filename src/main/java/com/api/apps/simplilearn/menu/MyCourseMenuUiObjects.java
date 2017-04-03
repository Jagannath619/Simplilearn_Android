package com.api.apps.simplilearn.menu;

import com.foundation.core.UiObject;
import com.foundation.core.UiSelector;

public class MyCourseMenuUiObjects {
	
	private static UiObject
	          menuIcon,
	          carrerEdge,
	          exploreCourse,
	          myCourse,
	          faqs,
	          helpAndSupport,
	          myAccount;
	          
	public UiObject carrerEdge(){
		if(carrerEdge == null) carrerEdge = new UiSelector().text("Career-Edge").makeUiObject();
	   return carrerEdge;
				
		} 
	public UiObject exploreCourse(){
		if(exploreCourse == null) exploreCourse = new UiSelector().text("Explore Courses").makeUiObject();
	   return exploreCourse;
				
		} 
	public UiObject myCourse(){
		if(myCourse == null) myCourse = new UiSelector().text("My Courses").makeUiObject();
	   return myCourse;
				
		} 
	public UiObject faqs(){
		if(faqs == null) faqs = new UiSelector().text("FAQs").makeUiObject();
	   return faqs;
				
		} 
	public UiObject helpAndSupport(){
		if(helpAndSupport == null) helpAndSupport = new UiSelector().text("Help & Support").makeUiObject();
	   return helpAndSupport;
				
		} 
	public UiObject myAccount(){
		if(myAccount == null) myAccount = new UiSelector().text("My Account").makeUiObject();
	   return myAccount;
				
		} 
	public UiObject menuIcon(){
		if(menuIcon == null) menuIcon = new UiSelector().className("android.widget.ImageButton").makeUiObject();
	   return menuIcon;
				
		} 

}
