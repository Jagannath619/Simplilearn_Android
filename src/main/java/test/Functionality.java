package test;

import junit.framework.Assert;

import org.junit.Test;

import com.api.android.Android;
import com.api.apps.simplilearn.Simplilearn;
import com.foundation.coreManager.TestManager;

public class Functionality extends TestManager {
	
	private static Simplilearn simplilearn = Android.app.simplilearn;
	@Test
	public void test4(){
		testInfo.id("test4").suite("Funtionality").name("Verifying Functionality ");
		simplilearn.courseMenu.tapMenuIcon();
		simplilearn.courseMenu.tapFaqs();
		}

}
