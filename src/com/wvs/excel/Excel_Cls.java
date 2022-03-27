package com.wvs.excel;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_Cls {

	
	public static HashMap[] storedatainhashmaparr(String wpath,String sname) throws IOException{
	       FileInputStream		fis=new FileInputStream(wpath);
			Workbook          wbook=new XSSFWorkbook(fis);
			Sheet sheetobj=wbook.getSheet(sname);
		int rcnt=	sheetobj.getLastRowNum();
		HashMap[]       hmarr  =new HashMap[rcnt];
			Row firstrowobj =sheetobj.getRow(0);
			for (int j=1;j<=rcnt;j++){
				HashMap<String ,String >		hm=  new HashMap<String ,String >();
				Row rowobj=sheetobj.getRow(j);
				int collcnt=rowobj.getLastCellNum();
			for (int i=0;i<=collcnt-1;i++){
			String coll_name=	firstrowobj.getCell(i).getStringCellValue().trim();
			String cellval=	rowobj.getCell(i).getStringCellValue().trim();	
			 hm.put(coll_name, cellval);
			}
			
			hmarr[j-1]=hm;
			}
			
			
			return hmarr;
			
		}
	
	
	
	public static String getxpath(String wpath,String sname,String elementname) throws IOException{
FileInputStream		fis=new FileInputStream(wpath);
	Workbook          wbook=new XSSFWorkbook(fis);
	Sheet sheetobj=wbook.getSheet(sname);
	String xpath="";
	int rcnt=sheetobj.getLastRowNum();
for (int i=1;i<=rcnt;i++){
	Row rowobj=sheetobj.getRow(i);
	
	Cell cellobj=rowobj.getCell(0);
	String  wename=	cellobj.getStringCellValue().trim();
	
if (wename.equalsIgnoreCase(elementname)==true){
	 cellobj	=rowobj.getCell(1);
	  xpath=cellobj.getStringCellValue().trim();
	 break;

}

	}
return xpath;
	}

	
	
	
	
	
	


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
