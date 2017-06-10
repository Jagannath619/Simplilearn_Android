package com.test.reportFoundtion;

import java.lang.reflect.Method;

public class CommonTestRunner {
	public static void main(String args[])throws Exception{  
		  
		Class h = P0TestCases.class;
		
		  Method[] methods = h.getMethods();
		  
		  for (Method m : methods) {
              Object info = m.getAnnotation(TestCaseInfo.class);
              if (info == null) {
                  continue;
              }
              TestCaseInfo manno= (TestCaseInfo) info;
      		System.out.println("TestID is: "+manno.TestId()+", owner is: "+manno.Owner()+" ,Priority is: "+manno.Priority()+", TestCategory is: "+manno.TestCategory());
		  }
		
		
		  
		
		
		
		}
	
}
