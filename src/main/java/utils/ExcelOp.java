package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import projectBase.Base;

public class ExcelOp {
	
	
	 public static final String ExcelLoc ="./src/main/resources/ExcelFiles/AIK.xlsx";
	 private static FileInputStream fis;
	 private static XSSFWorkbook workbook;
	 private static XSSFSheet sheet;
	 private static XSSFRow row;
	  
	 public static void loadExcel() throws Exception {
		 System.out.println("Loading excel...");
		 File file= new File(ExcelLoc);
		 fis= new FileInputStream(file);
		 workbook = new XSSFWorkbook(fis);
		 sheet=workbook.getSheet(Base.sheetname); 
		 fis.close();
	 }
	 
	 public static Map<String, Map<String,String>> getDataMap() throws Exception{
		 
		 if(sheet == null) {
			 loadExcel();
		 }
		 
		 Map<String, Map<String,String>> superMap= new HashMap<String, Map<String,String>>();
	     Map<String,String> myMap= new HashMap<String,String>();
	      
	     
	     for(int i=1; i<sheet.getLastRowNum() +1;i++) {
	    	row =sheet.getRow(i);
	    	String keyCell =row.getCell(0).getStringCellValue();
	    	
	    	
	    	int colNum = row.getLastCellNum();
	    	for (int j=1;j<colNum;j++) {
	    		String value=row.getCell(j).getStringCellValue();
	    		myMap.put(keyCell, value);
	    		
	    	}
	    	
	    	superMap.put("MasterData", myMap);
	     }
		 
		 
		return superMap;
		 
		 
	 
	 }
	 public static String getValue(String key) throws Exception {
		 Map<String,String> myVal=getDataMap().get("MasterData");
		 String retValue = myVal.get(key);
		 
		 
		 return retValue;
		 
	 }
	  public static void main(String[] args) throws Exception {
			System.out.println(getValue("email"));
		  
	  }
	 
	 
	 
	}


