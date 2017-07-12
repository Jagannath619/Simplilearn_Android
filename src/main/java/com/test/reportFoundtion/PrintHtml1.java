package com.test.reportFoundtion;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PrintHtml1 {

	public static String htmlString(){
		StringBuilder contentBuilder = new StringBuilder();
		String replaceString;
		try { 
		    BufferedReader in = new BufferedReader(new FileReader("/Users/jagannath/Documents/eclipse 3/com.mobile.simplilearn/src/main/java/test/testhtml.html"));
		    String str;
		    while ((str = in.readLine()) != null) {
		        contentBuilder.append(str);
		    } 
		    in.close();
		} catch (IOException e) {
		} 
		String content = contentBuilder.toString();
		System.out.println(content);
		
		
					

//		String headerAndImage = "<html><body><h1>Simplilearn_Automation_Android</h1></body></html>";
//		String newHtmlString = headerAndImage+content.substring(content.indexOf("<html"), content.indexOf("<h2>Simplilearn Android Automation</h2>"))+"<h2>TestNg Execution Report</h2></body></html>";
		// replaceString = content.replace('"','\"');
		
		 //System.out.println(replaceString);
		 return content;
	}

}
