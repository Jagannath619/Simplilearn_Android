package com.api.apps.simplilearn.menu;

import java.util.NoSuchElementException;

import com.api.android.Android;
import com.api.interfaces.Activity;
import com.foundation.core.MyLogger;

public class MyCourseMenu implements Activity {
	
	public MyCourseMenuUiObjects myCourseMenuUiObjects = new MyCourseMenuUiObjects();
	
	public void tapCarrerEdge(){
		try{
			MyLogger.log.info("Tapping on CarrerEdge");
			myCourseMenuUiObjects.carrerEdge().tap();
		}catch(NoSuchElementException e){
			throw new AssertionError("Can not tap on carrerEdge , element absent or blocked ");
		}
	}

	public void tapeExploreCourse(){
		try{
			MyLogger.log.info("Tapping on ExploreCourse");
			myCourseMenuUiObjects.exploreCourse().tap();
		}catch(NoSuchElementException e){
			throw new AssertionError("Can not tap on exploreCourse from menu , element absent or blocked ");
		}
	}

	public void tapFaqs(){
		try{
			MyLogger.log.info("Tapping on FAQs");
			myCourseMenuUiObjects.faqs().tap();
		}catch(NoSuchElementException e){
			throw new AssertionError("Can not tap on faqs from menu , element absent or blocked ");
		}
	}

	public void tapMyCourse(){
		try{
			MyLogger.log.info("Tapping on MyCourse");
			myCourseMenuUiObjects.myCourse().tap();
		}catch(NoSuchElementException e){
			throw new AssertionError("Can not tap on myCourse from menu , element absent or blocked ");
		}
	}

	public void tapHelpAndSupport(){
		try{
			MyLogger.log.info("Tapping on HelpAndSupport");
			myCourseMenuUiObjects.helpAndSupport().tap();
		}catch(NoSuchElementException e){
			throw new AssertionError("Can not tap on helpAndSupport from menu , element absent or blocked ");
		}
	}

	public void tapMyAccount(){
		try{
			MyLogger.log.info("Tapping on MyAccount");
			myCourseMenuUiObjects.myAccount().tap();
		}catch(NoSuchElementException e){
			throw new AssertionError("Can not tap on myAccount from menu  , element absent or blocked ");
		}
	}

	public void tapMenuIcon(){
		try{
			MyLogger.log.info("Tapping on MenuIcon");
			myCourseMenuUiObjects.menuIcon().tap();
		}catch(NoSuchElementException e){
			throw new AssertionError("Can not tap on MenuIcon on home page  , element absent or blocked ");
		}
	}

	public MyCourseMenu waitToLoad() {
		 try{
			 MyLogger.log.info("Waiting for MyCourseMenu activity");
			 myCourseMenuUiObjects.menuIcon().waitToAppear(40);
			 return Android.app.simplilearn.courseMenu;
		 }catch(AssertionError e){
			throw new AssertionError("MyCourseMenu activity fails to load/open");
		 }
		
	}

}
