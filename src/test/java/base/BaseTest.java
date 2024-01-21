package base;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.google.common.io.Files;

import WebPages.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public static WebDriver driver;
	public static Properties prop=new Properties();
	public static Properties loc=new Properties();
	public static FileReader fr;
	public static FileReader fr1;
	
	public BaseTest() throws IOException{
		
		fr=new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\configfiles\\config.properties");
		prop.load(fr);
	}
	
	
	
	@BeforeMethod
	public WebDriver setUp() throws IOException
	{
		
		if(prop.getProperty("browser").equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			driver.get(prop.getProperty("testurl"));
			driver.manage().window().maximize();
	
		}
		else if(prop.getProperty("browser").equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			driver.get(prop.getProperty("testurl"));
		}
		
		WebDriverWait wt = new WebDriverWait(driver,Duration.ofSeconds(30));
		return driver;
	}
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	
	public static void ScrollTillElement(WebElement iframe) 
	{
       Actions act= new Actions(driver);
       act.scrollToElement(iframe).perform();
    }
	
	public static void TakeScreenShort(String Filename) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File fis = ts.getScreenshotAs(OutputType.FILE);
		Files.copy(fis, new File("C:\\Users\\DELL\\git\\repository\\TestAutomationFrameWork\\src\\test\\resources\\TakeScreenShort\\"+Filename+".png"));
	}
	
    public static String createRandomWord() {
        String name = "";
        for (int i = 0; i < 10; i++) {
            int v = 1 + (int) (Math.random() * 26);
            char c = (char) (v + (i == 0 ? 'A' : 'a') - 1);
            name += c;
        }
        return name;
    }
    
    public static String FirstName() {
    	return BaseTest.createRandomWord();
    }
    public static String LastName() {
    	return BaseTest.createRandomWord()+"last";
    }
    public static String Emai() {
    	return BaseTest.createRandomWord()+"Email@gmail.com";
    }
    public static String Password() {
    	return BaseTest.createRandomWord()+"Aa123!@#";
    }
}








