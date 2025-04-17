package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class UtilitiesExcel {
	
	public FileInputStream fi;  //reading file
	public FileOutputStream fo; //writing file
	public XSSFWorkbook workbook; //opening workbook
	public XSSFSheet sheet; //opening sheet
	public XSSFRow row; // opening row
	public XSSFCell cell; //opening cell
	public CellStyle style; //update cell style
	String path;
	
	public UtilitiesExcel(String path) 
	
	{
		this.path=path;
	}
	
	
	public int getRowCount(String sheetname) throws IOException 
	
	{
		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(sheetname);
		int rowcount = sheet.getLastRowNum();
		workbook.close();
		fi.close();
		return rowcount;
	}
	
    public int getCellCount(String sheetname, int rownum) throws IOException 
	
	{
    	fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(sheetname);
		row=sheet.getRow(rownum);
		int cellcount = row.getLastCellNum();
		workbook.close();
		fi.close();
		return cellcount;
	}
    
    public String getcelldata(String sheetname, int rownum, int colnum) throws IOException 
    
    {
    	fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(sheetname);
		row = sheet.getRow(rownum);
		cell = row.getCell(colnum);
		
		DataFormatter formatter = new DataFormatter();
		String data = null;
		
		try {
		formatter.formatCellValue(cell); // returns formatted value of a cell as a string 
		}
		
		catch(Exception e)
		{
			data="";
		}
		workbook.close();
		fi.close();
    	return data;
    } 

}
