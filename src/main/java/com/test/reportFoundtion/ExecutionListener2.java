package com.test.reportFoundtion;

import org.testng.IExecutionListener;

import com.test.reportFoundtion.RunYouMail;

public class ExecutionListener2 implements IExecutionListener {

	public void onExecutionStart() {
		System.out.println("Mail be sent after suite got executed");	
		System.out.println("==========================================");	
	}

	
	public void onExecutionFinish() {
		RunYouMail mail = new RunYouMail();
		mail.sendMail();
		System.out.println("Suite execution completed and Mail has sent successfully ");
		System.out.println("==========================================");	
	
	}
	
	
}
