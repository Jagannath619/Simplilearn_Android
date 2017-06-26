package test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SubHtml {
	static StringBuilder contentBuilder = new StringBuilder();
	public static void main(String args[]){  
		try { 
		    BufferedReader in = new BufferedReader(new FileReader("/Users/jagannath/Documents/eclipse 3/com.mobile.simplilearn/test-output/emailable-report.html"));
		    String str;
		    while ((str = in.readLine()) != null) {
		        contentBuilder.append(str);
		    } 
		    in.close();
		} catch (IOException e) {
		} 
		String content = contentBuilder.toString();
		System.out.println(content);
		System.out.println(content.indexOf("<html"));
		System.out.println(content.indexOf("<h2>Simplilearn</h2>"));
		System.out.println(content.indexOf("<body>"));
		content.replace("<body>", "<body><h2>Simplilearn_Android_Automation</h2>");
		System.out.println(content.indexOf("<body><h2>Simplilearn_Android_Automation</h2>"));
		
		content.replace("<body>", "<body><h2>Simplilearn_Android_Automation</h2>");
		String header = "<html><body><h1>Simplilearn_Automation_Android</h1></body></html>";
		System.out.println(content.substring(content.indexOf("<html"), content.indexOf("<body><table>"))+"<body><h2>Smplilearn_Android_Automation</h2><table>");
		System.out.println(header+content.substring(content.indexOf("<html"), content.indexOf("<h2>Simplilearn Android Automation</h2>"))+"<h2>TestNg Execution Report</h2></body></html>");
		
		

}
}