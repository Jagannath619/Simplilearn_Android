package com.test.reportFoundtion;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

@TestClass(Module = Modules.Sanity)
public class P0TestCases  {
	TestRunner runner = new TestRunner();
	
	
	@BeforeMethod
	public void before(){
		runner.testSummary();
		
		
	}
	
	@Test(groups = { "" })
	@TestCaseInfo(TestId = "KM-394", Owner = Owners.TestsOwner, Priority = 0, TestCategory = TestCategory.smokeTest)
	public void newRunner1() {
		try {
			Object info =	new Object(){}.getClass().getEnclosingMethod().getAnnotation(TestCaseInfo.class);
			getMethod(info);
			System.out.println("Testing test Runner");
			
		} catch (Exception exe) {
			exe.printStackTrace();
			
		} catch (Error exe) {
			exe.printStackTrace();
			
		}
	}
	
	@Test(groups = { "" })
	@TestCaseInfo(TestId = "KM-222", Owner = Owners.TestsOwner, Priority = 1, TestCategory = TestCategory.smokeTest)
	public void newRunner2() {
		try {
			Object info =	new Object(){}.getClass().getEnclosingMethod().getAnnotation(TestCaseInfo.class);
			getMethod(info);
			System.out.println("Testing test Runner2");
			
		} catch (Exception exe) {
			exe.printStackTrace();
			
		} catch (Error exe) {
			exe.printStackTrace();
			
		}
	}
	@Test(groups = { "" })
	@TestCaseInfo(TestId = "KM-333", Owner = Owners.TestsOwner, Priority = 1, TestCategory = TestCategory.smokeTest)
	public void newRunner3() {
		
			Object info =	new Object(){}.getClass().getEnclosingMethod().getAnnotation(TestCaseInfo.class);
			getMethod(info);
			System.out.println("Testing test Runner3");
			Assert.assertEquals(true, false);
			
		
	}
	public static void getMethod(Object info){
		
		// info =	new Object(){}.getClass().getEnclosingMethod().getAnnotation(TestCaseInfo.class);
	       
	    TestCaseInfo manno= (TestCaseInfo) info;
		System.out.println("TestID is: "+manno.TestId()+", owner is: "+manno.Owner()+" ,Priority is: "+manno.Priority()+", TestCategory is: "+manno.TestCategory());
		
		}
}



