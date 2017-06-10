package com.test.reportFoundtion;

import java.lang.annotation.Annotation;
import java.lang.reflect.Executable;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.IMethodInstance;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.annotations.Test;

public class TestRunner {

	public  void testSummary(){
		  
		List<Class<?>> classes = ClassFinder.find("com.test.reportFoundtion");
		
			
			
			for (Class c : classes) {
	        
	            Object obj = c.getAnnotation(TestClass.class);
	            if (obj == null) {
	                
	            	//System.out.println("class name is:"+classes.get(i).getName() );
	            	continue;
	            }
	            TestClass moduleObj = (TestClass) obj;
	            System.out.println("TestClass  is: "+moduleObj.Module());

	          
			}
		}
		
		
		}

	

