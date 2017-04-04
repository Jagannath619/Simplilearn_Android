package test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;









import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.api.android.Android;
import com.api.apps.simplilearn.Simplilearn;
import com.api.apps.simplilearn.menu.Home;
import com.api.apps.simplilearn.menu.MyAccount;
import com.api.apps.simplilearn.menu.MyCourseMenu;
import com.foundation.coreManager.DriverManager;
import com.foundation.coreManager.TestManager;

public class TestNavigation extends TestManager{
	
	private static Simplilearn simplilearn = Android.app.simplilearn;

	@BeforeClass
	public static void beforeClass() throws InterruptedException, MalformedURLException{
		simplilearn.open();
    	Thread.sleep(10000);
	}
	
	@BeforeTest
	public  void before(){
		
		testInfo.suite("Navigation");
		}
	
	@Test
	public void test1(){
		testInfo.id("test1").name("Verify that home activity has all elements");
		//Assert.assertTrue(simplilearn.home.homeScreenUiObjects.startLogin().exist());
		}
	@Test
	public void test2() throws InterruptedException{
		//testInfo.id("test2").name("Entering credentials for login");
		Home home = Android.app.simplilearn.home;
		
		home.tapHomeLogin();
		home.typeUserName();
		home.typePassword();
		home.tapLogin();
		}
	@Test
	public void test3() throws InterruptedException{
		testInfo.id("test3").name("Testing MyCourse menu");
		MyCourseMenu courseMenu = Android.app.simplilearn.courseMenu;
		//Assert.assertTrue(simplilearn.courseMenu.myCourseMenuUiObjects.menuIcon().exist());
		Thread.sleep(5000);
		courseMenu.tapMenuIcon();
		//Assert.assertTrue(simplilearn.courseMenu.myCourseMenuUiObjects.myCourse().exist());
		courseMenu.tapMyCourse();
		Thread.sleep(10000);
		courseMenu.tapMenuIcon();
		courseMenu.tapeExploreCourse();
		}
	
	@AfterTest
	public void after(){
		testInfo.suite("Logout");
		MyCourseMenu courseMenu = Android.app.simplilearn.courseMenu;
		MyAccount myAccount = new MyAccount();
		courseMenu.tapMenuIcon();
		courseMenu.tapMyAccount();
		myAccount.tapSignOut();
		myAccount.tapSignOutOk();
		
	}
	
	@AfterClass
	public void afterClass(){
		DriverManager.killDriver();
		
	}

}



