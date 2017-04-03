package com.foundation.coreManager;

import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

import com.foundation.core.MyLogger;
import com.foundation.core.Retry;
import com.foundation.core.TestInfo;

public class TestManager {
	public static TestInfo testInfo = new TestInfo();
	
	/*@Rule
	public Retry retry = new Retry(1);

	@Before
	public void before(){
		testInfo.reset();
	}
	
	@Rule
	public TestRule listen = new TestWatcher(){
		
		public void failed(Throwable t,Description description){
			MyLogger.log.info("Test Failed");
			TestInfo.printResults();
			
		}
      public void succeded(Description description){
    	  MyLogger.log.info("Test Passed");
			TestInfo.printResults();
		}
	};*/
}
