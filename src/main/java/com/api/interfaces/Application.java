package com.api.interfaces;

import java.net.MalformedURLException;

public interface Application {
	void forceStop();
	void clearData();
	Object open() throws MalformedURLException;
	String packageID();
	String activityID();
	

}
