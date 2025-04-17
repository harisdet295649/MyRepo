package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	//DataProvider1
	
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException
	{
		String path=".\\TestData\\testdata.xlsx"; //taking xl file from testdata
		UtilitiesExcel xlutils = new UtilitiesExcel(path); // creating an object for xlutility
		
		int totalrows=xlutils.getRowCount("sheet1");
		int totalcols=xlutils.getCellCount("sheet1", 1);
		
		String logindata[][]= new String[totalrows][totalcols];// created for two dimension array which can store
		
		for(int i=1;i<=totalrows;i++)
		{
			for(int j=0;j<=totalcols;j++) 
			{
				logindata[i-1][j]=xlutils.getcelldata("sheet1", i, j);
			}
			
		}
		
		return logindata;
	}
	
	

}
