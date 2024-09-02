package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelLibrary {
	XSSFWorkbook wb;
	XSSFSheet sheet;
	
	public ExcelLibrary() throws Exception
	{
		String excelpath=System.getProperty("user.dir")+"\\TestData\\DataDriven.xlsx";
		File file=new File(excelpath);
		FileInputStream fis=new FileInputStream(file);
		wb=new XSSFWorkbook(fis);
	}
	
	public String ReadData(String sheetName, int row, int col)
	{
		sheet=wb.getSheet(sheetName);
		String data = sheet.getRow(row).getCell(col).getStringCellValue();
		return data;
	}
	
	public Object[][] getData(String sheetName){
		sheet=wb.getSheet(sheetName);

        int rowCount = sheet.getPhysicalNumberOfRows();
        int colCount = sheet.getRow(0).getPhysicalNumberOfCells();

        Object[][] data = new Object[rowCount - 1][colCount];

        for (int i = 1; i < rowCount; i++) {
            Row row = sheet.getRow(i);
            for (int j = 0; j < colCount; j++) {
                data[i - 1][j] = row.getCell(j).toString();
            }
        }
        return data;
    }
}
