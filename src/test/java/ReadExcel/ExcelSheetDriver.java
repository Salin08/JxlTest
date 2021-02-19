package ReadExcel;
import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ExcelSheetDriver {

	static Sheet wrksheet;
	static Workbook wrkbook =null;
	static Hashtable dict= new Hashtable();
	//Create a Constructor
	public ExcelSheetDriver(String excelSheetPath) throws BiffException, IOException
	{
		//Initialize
		wrkbook = Workbook.getWorkbook(new File(excelSheetPath));
		//For Demo purpose the excel sheet path is hard coded, but not recommended :)
		wrksheet = wrkbook.getSheet("Sheet1");
		System.out.println(wrksheet);
	}

	//Returns the Number of Rows
	public static int RowCount()
	{
		return wrksheet.getRows();
	}
	public static int ColumnCount() {
		return wrksheet.getColumns();
	}

	//Returns the Cell value by taking row and Column values as argument
	public static String ReadCell(int column,int row)
	{
		return wrksheet.getCell(column,row).getContents();
	}

	//Create Column Dictionary to hold all the Column Names
	public static void ColumnDictionary()
	{
		//Iterate through all the columns in the Excel sheet and store the value in Hashtable
		for(int col=0;col < wrksheet.getColumns();col++)
		{
			dict.put(ReadCell(col,0), col);
		}
	}

	//Read Column Names
	public static int GetCell(String colName){
		try {
			int value;
			value = ((Integer) dict.get(colName)).intValue();
			return value;
		} catch (NullPointerException e) {
			return (0);
			}
	}
//	public static void main(String[] args) throws BiffException, IOException {
//		ExcelSheetDriver excelSheetDriver = new ExcelSheetDriver("C://Users/SALIN/Desktop");
//		  //Load the Excel Sheet Col in to Dictionary for Further use
//		excelSheetDriver.ColumnDictionary();
//	}
//	 @BeforeTest
//	  public void EnvironmentalSetup()
//	  {
//		  driver.get("http://www.gmail.com");
//	  }
}
