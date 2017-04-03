package com.foundation.simplilearn.constants;

import io.appium.java_client.service.local.flags.ServerArgument;

public enum Arg implements ServerArgument{
	
	TIMEOUT("--command-timeout"),
	LOCAL_TIME_ZONE("--local-timezone"),
	LOG_LEVEL("--log-level"),
	PLATFORM_NAME("--platform-name"),
	PLATFORM_VERSION("--platform-version"),
	AUTOMATION_NAME("--automation-name"),
	FULL_RESET("--full-reset"),
	NO_RESET("--no-reset");
	
	
	private final String arg;
	
	Arg(String arg){
		this.arg= arg;
	}

	public String getArgument() {
		
		
		return arg;
	}

}
