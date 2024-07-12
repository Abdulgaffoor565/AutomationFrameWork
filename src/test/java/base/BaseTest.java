//package base;
//
//import java.io.File;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.Properties;
//
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.ie.InternetExplorerDriver;
//import org.openqa.selenium.interactions.Actions;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//
//import com.google.common.io.Files;
//
//public class BaseTest {
//	
//	public static WebDriver driver;
//	public static Properties prop=new Properties();
//	public static FileReader fr;
//	
//	public BaseTest() throws IOException{
//		
//		fr=new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\configfiles\\config.properties");
//		prop.load(fr);
//		//WebDriverWait wt = new WebDriverWait(driver,Duration.ofSeconds(30));
//	}
//	
//	
//	
//	@BeforeMethod
//	public WebDriver setUp() throws IOException
//	{
//		if(prop.getProperty("browser").equalsIgnoreCase("chrome")) {
//			//ChromeOptions options= new ChromeOptions();
//		//options.addArguments("--headless");
//			driver=new ChromeDriver();
////			driver.manage().window().maximize();
//		}
//		else if(prop.getProperty("browser").equalsIgnoreCase("firefox")) {
//			driver=new FirefoxDriver();
//			//driver.get(prop.getProperty("testurl"));
//		} else {
//			driver=new InternetExplorerDriver();
//			//driver.get(prop.getProperty("testurl"));
//		}
//		return driver;
//	}
//	@AfterMethod
//	public void tearDown() {
//		driver.quit();
//	}
//	
//	public static void ScrollTillElement(WebElement ele) 
//	{
//       Actions act= new Actions(driver);
//       act.scrollToElement(ele).perform();
//    }
//	
//	public static void TakeScreenShort(String Filename) throws IOException
//	{
//		TakesScreenshot ts=(TakesScreenshot)driver;
//		File fis = ts.getScreenshotAs(OutputType.FILE);
//		Files.copy(fis, new File("C:\\Users\\DELL\\git\\repository\\TestAutomationFrameWork\\src\\test\\resources\\TakeScreenShort\\"+Filename+".png"));
//	}
//	
//    public static String createRandomWord() {
//        String name = "";
//        for (int i = 0; i < 10; i++) {
//            int v = 1 + (int) (Math.random() * 26);
//            char c = (char) (v + (i == 0 ? 'A' : 'a') - 1);
//            name += c;
//        }
//        return name;
//    }
//    
//    public static String FirstName() {
//    	return BaseTest.createRandomWord();
//    }
//    public static String LastName() {
//    	return BaseTest.createRandomWord()+"last";
//    }
//    public static String Email() {
//    	return BaseTest.createRandomWord()+"Email@gmail.com";
//    }
//    public static String Password() {
//    	return BaseTest.createRandomWord()+"Aa123!@#";
//    }
//}