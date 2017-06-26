package com.test.reportFoundtion;

import org.testng.annotations.Test;



public class RunYouMail {
	
		public static void sendMail(){
			YouMail a1 = new YouMail();
			a1.SendEmail("jagannath.panda619@gmail.com", "Simplilearn Automation", "Android Automation");
			//a1.SendEmail("nilabh.p@simplilearn.net", "Simplilearn Automation", "Android Automation");
			//a1.SendEmail("preetham.b@simplilearn.net", "Simplilearn Automation", "Android Automation");
			a1.SendEmail("jagannath.panda@simplilearn.net", "Simplilearn Automation", "Android Automation");
			
			
		}
	}

