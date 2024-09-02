package Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

public class BaseClass {
	
	public static WebDriver driver;
	public static Properties prop=new Properties();
	public static FileReader fr;
	
	XSSFWorkbook wb;
	XSSFSheet sheet;
	
	public BaseClass() throws IOException
	{
		fr=new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\ConfigFile");
		prop.load(fr);
		
		String excelpath=System.getProperty("user.dir")+"\\TestData\\DataDriven.xlsx";
		File file=new File(excelpath);
		FileInputStream fis=new FileInputStream(file);
		wb=new XSSFWorkbook(fis);
	}
	
	@BeforeMethod
	public WebDriver Setup() throws InterruptedException
	{
		if(prop.getProperty("BrowserName").equalsIgnoreCase("chrome"))
		{
			//WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			driver.get(prop.getProperty("url"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		}else if(prop.getProperty("BrowserName").equalsIgnoreCase("firefox"))
		{
			//WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			driver.get("url");
			driver.manage().window().maximize();
		}
			return driver;
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	public String ReadData(String sheetName, int row, int col)
	{
		sheet=wb.getSheet(sheetName);
		String data = sheet.getRow(row).getCell(col).getStringCellValue();
		return data;
	}
	
//	@DataProvider(name="Read_TwoCol_Data")
	public  ArrayList<String> Read_TwoCol_Data(String sheetName, int StartRow, int EndRow , int StartCol)
	{
		sheet=wb.getSheet(sheetName);
		ArrayList<String> arr=new ArrayList<String>();
		for(int i=StartRow;i<=EndRow;i++)
		{
			for(int j=StartCol;j<=StartCol+1;j++)
			{
				arr.add(sheet.getRow(i).getCell(j).getStringCellValue());
				
			}
		}
		return arr;
		
	}
	
}
