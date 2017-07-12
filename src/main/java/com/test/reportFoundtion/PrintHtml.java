package com.test.reportFoundtion;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import test.TestNavigation;

public class PrintHtml {
	public static int passed,failed,skipped;
	public static String htmlString(){
	StringBuilder contentBuilder = new StringBuilder();
	String replaceString;
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
	
	
		String image = "<!DOCTYPEhtml><html><body><h2>SpectacularMountain</h2>"
				+ "<img src=\"https://tse4.mm.bing.net/th?id=ORT.TH_470633631&pid=1.12&eid=G.470633631\" alt=\"Mountain View\" "
				+ "style=\"width:304px;height:228px;\">  </body> </html>";
		String pie2 = "<!DOCTYPEhtml><html><body><h2>Android Suite</h2><img src=\"http://chart.apis.google.com/chart?"
				+ "cht=pc&chs=500x250&chdl=Passed%7CFailed%7CSkipped&chco=32CD32|FF0000|F0E68C&chtt=Google+Chart&chts=000000,"
				+ "24&chd=t:"
				+ PrintHtml.passed
				+ ","
				+ PrintHtml.failed
				+ ","
				+ PrintHtml.skipped + "\" />  </body> </html>";
		// String pieHtml =
		// "http://chart.apis.google.com/chart?cht=pc&chs=500x250&chdl=Passed%7CFailed%7CSkipped&chco=32CD32|FF0000|F0E68C&chtt=My+Google+Chart&chts=000000,24&chd=t:"+
		// PrintHtml.passed+","+PrintHtml.failed+","+PrintHtml.skipped+"";
		String headerAndImage = "<html><body><h1>Simplilearn_Automation_Android</h1></body></html>";
		String newHtmlString = headerAndImage
				+ content.substring(content.indexOf("<html"), content
						.indexOf("<h2>Simplilearn Android Automation</h2>"))
				+ "<h2>TestNg Execution Report</h2></body></html>";

		replaceString = newHtmlString.replace('"', '\"');

		String appImge = "<a href=\"https://www.simplilearn.com/\"> <img src=\"http://c1590022.cdn.cloudfiles.rackspacecloud.com/d0e867a739d8eb9eec29d101c8b16158.jpg\" "
				+ "alt=\"Mountain\" style=\"width:90;height:50;\"> </a>  ";
				
		String lastStr = newHtmlString.substring(
				newHtmlString.indexOf("<html"),
				newHtmlString.indexOf("colspan=\"4\">Suite"))
				+ "colspan=\"4\">Suite"
				+ pie2
				+ newHtmlString
						.substring(
								newHtmlString
										.indexOf("</th></tr></tbody><tbody id=\"t0\">"),
								newHtmlString
										.indexOf("<h2>TestNg Execution Report</h2></body></html>"))
				+ "<h2>TestNg Execution Report</h2></body></html>"+appImge;

		// replaceString = replaceString+pie2+image;
		// System.out.println(replaceString);
	 
	  return lastStr;
}
	

}
