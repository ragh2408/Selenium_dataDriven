package com.wvs.genericmethods;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.wvs.excel.Excel_Cls;

public class Generic_Methods extends Excel_Cls{
	public static String wbookpath="E:/classb/ramselclasses/sel12.30pm/datadriven/DataDrivenFramework/src/com/wvs/xlresources/repo.xlsx";
	public static String sheetname="xpath";
	public static String dwbookpath="E:/classb/ramselclasses/sel12.30pm/datadriven/DataDrivenFramework/src/com/wvs/xlresources/data.xlsx";

	public static String dsheetname="data";
	public static WebDriver driver;
	
	public static HashMap[] hmarr;
	
	public Generic_Methods() throws IOException{
		hmarr=storedatainhashmaparr(dwbookpath, dsheetname);
	}
	
	
	
	
	public static WebElement getelement(String elementname) throws IOException{
		String xpath=getxpath(wbookpath, sheetname, elementname);
		String[] arr=xpath.split("#");
		WebElement we=null;
		if (arr[1].equalsIgnoreCase("NM")==true){
			 we=driver.findElement(By.name(arr[0]));
			
		}else if (arr[1].equalsIgnoreCase("LL")){
			
			we=driver.findElement(By.linkText(arr[0]));
		}else if (arr[1].equalsIgnoreCase("XP")){
			
			we=driver.findElement(By.xpath(arr[0]));
		}
		
		return we;  
	}
	
public static void click(String elementname) throws IOException{
	WebElement we=getelement(elementname);
	we.click();
}


public static void inputvalue(String wname,int hmapindex) throws IOException{
	WebElement we=getelement(wname);
String val=	(String) hmarr[hmapindex].get(wname);
	we.sendKeys(val);
}
	
	
public  void openapp(String brname,String url){
	
	if (brname.equalsIgnoreCase("FF")==true){
		
			driver=new FirefoxDriver();
		
	}else if (brname.equalsIgnoreCase("CH")==true){
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		   driver      = new ChromeDriver();
	}else if (brname.equalsIgnoreCase("IE")==true){
		System.setProperty("webdriver.ie.driver", "drivers/IEDriverServer.exe");
		       driver      =new InternetExplorerDriver();
	}
			
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();		
}	
	

}
