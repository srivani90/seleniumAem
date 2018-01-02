package library;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataConfig {
	
	XSSFWorkbook wb;
	XSSFSheet sheet1;

	public ExcelDataConfig(String excelpath) {
		try {
			File src = new File(excelpath);
			FileInputStream fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}


	public Row getRow(int rowNumber) {
		sheet1 = wb.getSheetAt(0);
		if (sheet1 != null) {
			return sheet1.getRow(rowNumber);
		} else {
			return null;
		}
	}
	

	public String readdata(int sheetnumber, int row,int column) {
		System.out.println("----- ---- " + row + " ---- ----" + column);
		sheet1 = wb.getSheetAt(sheetnumber);
		String data = sheet1.getRow(row).getCell(column).getStringCellValue();
		return data;
	}
	
	
	
	
	
	
	
//WE WRITE THE BELOW CODE IF EXCEL SHEET DATA IS IN NUMERIC FORMAT:
	/*public String readdata(int sheetnumber, int row,int column) {
		System.out.println("----- ---- " + row + " ---- ----" + column);
		sheet1 = wb.getSheetAt(sheetnumber);
		
		String data = "";
		
		Cell oneCell = sheet1.getRow(row).getCell(column);
		
		//Check the type of the Cell. If it is String type, use string method to read value
		if (oneCell.getCellTypeEnum().equals(CellType.STRING)) {
			data = sheet1.getRow(row).getCell(column).getStringCellValue();
		} else if (oneCell.getCellTypeEnum().equals(CellType.NUMERIC)) {
			data = sheet1.getRow(row).getCell(column).getNumericCellValue() + "";
		}
		
		System.out.println("Data ---- " + data);
		return data;
	}*/

	public int getrowcount(int sheetindex) {
		int row = wb.getSheetAt(sheetindex).getLastRowNum();
		row = row + 1;
		return row;
	}

}
	


