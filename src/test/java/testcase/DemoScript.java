package testcase;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import utilities.ReadXLSdata;

public class DemoScript extends BaseTest {

	@Test(dataProviderClass =ReadXLSdata.class, dataProvider = "bvtdata")
	public static void LoginTest(String username, String password) throws InterruptedException 
	{
		driver.findElement(By.cssSelector(loc.getProperty("HomePage_signup_button"))).click();
		Thread.sleep(4000);
		driver.findElement(By.cssSelector(loc.getProperty("Signup_page_email_textfield"))).sendKeys(username);
		Thread.sleep(4000);
		driver.findElement(By.xpath(loc.getProperty("Next_Button"))).click();
		Thread.sleep(4000);
		driver.findElement(By.cssSelector(loc.getProperty("password"))).sendKeys(password);
		Thread.sleep(2000);
		driver.findElement(By.xpath(loc.getProperty("SignupPage_signupButtopn"))).click();
		Thread.sleep(4000);
		//driver.findElement(By.xpath(loc.getProperty("zoho_logo_button"))).isDisplayed()
		System.out.println(driver.findElement(By.cssSelector(loc.getProperty("zoho_logo_button"))).isDisplayed());
	}
	
//	@DataProvider(name="testdata")
//	public Object[][] testdata()
//	{
//		return new Object[][] {
//			{"dfgdg","dfgdfgd"},
//			{"gaffoorhalgeri@gmail.com","Abdul@123Abdul@123"},
//		};
//	}

}
