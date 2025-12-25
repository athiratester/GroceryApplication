package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import constants.Constant;

public class ExcelUtilities {

	static FileInputStream f;// to open file
	static XSSFWorkbook w;// to read the entire workbook
	static XSSFSheet sh;// to read the specific sheet

	public static String readStringData1(int row, int col, String sheet) throws IOException {
		f = new FileInputStream(Constant.TESTDATA);
		w = new XSSFWorkbook(f);
		sh = w.getSheet(sheet);
		XSSFRow r = sh.getRow(row);
		XSSFCell c = r.getCell(col);
		return c.getStringCellValue();

	}

	public static String readIntegerData(int row, int col, String sheet) throws IOException {
		f = new FileInputStream(Constant.TESTDATA);
		w = new XSSFWorkbook(f);
		sh = w.getSheet(sheet);
		XSSFRow r = sh.getRow(row);
		XSSFCell c = r.getCell(col);
		int val =   (int) c.getNumericCellValue();  //convert double to int using typecasting
		return String.valueOf(val);   //convert int to string using valueOf() method
		//return val;
	
	}
}
