package com.test.reportFoundtion;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class PrintHtml {
public static String htmlString(){
	
	 
	StringBuilder contentBuilder = new StringBuilder();
	String replaceString;
	try { 
	    BufferedReader in = new BufferedReader(new FileReader("/Users/jagannathpanda/Documents/eclipse 2/com.mobile.simplilearn/test-output/emailable-report.html"));
	    String str;
	    while ((str = in.readLine()) != null) {
	        contentBuilder.append(str);
	    } 
	    in.close();
	} catch (IOException e) {
	} 
	String content = contentBuilder.toString();
	System.out.println(content);
	 replaceString = content.replace('"','\"');
	 //System.out.println(replaceString);
	 return replaceString;
}

}
