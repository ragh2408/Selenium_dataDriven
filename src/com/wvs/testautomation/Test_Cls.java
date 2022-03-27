package com.wvs.testautomation;

import java.io.IOException;

import com.wvs.genericmethods.Generic_Methods;

public class Test_Cls extends Generic_Methods{
	
	public Test_Cls() throws IOException{
		hmarr=storedatainhashmaparr(dwbookpath, dsheetname);
	}
	
	public static void main(String[] args) throws IOException{
		
		new Test_Cls().openapp("FF", "http://localhost:8888/");
		
		int l=hmarr.length;
		for (int i=0;i<l;i++){
			
			inputvalue("Username_ED", i);
             inputvalue("Password_ED", i);
             click("Signin_BT");
             click("Marketing_LK");
			click("Leads_LK");
			click("CreateLead_BT");
			inputvalue("Lastname_ED", i);
			inputvalue("Comname_ED", i);
			click("Save_BT");
			click("Signout_LK");
		}
		
		
		
	}
	
	
	
	
	
	
	
	

}
