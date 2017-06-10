package com.test.reportFoundtion;

import java.lang.annotation.Annotation;

public class ImplementAnnotationInterface  implements TestCaseInfo{

	public Class<? extends Annotation> annotationType() {
		// TODO Auto-generated method stub
		return ImplementAnnotationInterface.class;
	}

	public String Owner() {
		// TODO Auto-generated method stub
		return null;
	}

	public int Priority() {
		// TODO Auto-generated method stub
		return 0;
	}

	public String TestCategory() {
		// TODO Auto-generated method stub
		return null;
	}

	public String TestId() {
		// TODO Auto-generated method stub
		return null;
	}

}
