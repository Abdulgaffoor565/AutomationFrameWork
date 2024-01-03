package testcase;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import base.BaseTest;

public class CreateAccountTC extends BaseTest {

	@Test
	public static void TC_CreateAccount_01() throws InterruptedException
	{
		driver.findElement(By.xpath(loc.getProperty("Create_Account_Link_in_Home_page"))).click();
		BaseTest.ScrollTillElement(driver.findElement(By.xpath(loc.getProperty("Create_Account_Button_in_AccountCreation_page"))));
		driver.findElement(By.xpath(loc.getProperty("Create_Account_Button_in_AccountCreation_page"))).click();
		BaseTest.ScrollTillElement(driver.findElement(By.cssSelector(loc.getProperty("FirstName_Error_Message"))));
		Thread.sleep(2000);
		assertEquals(prop.getProperty("FirstName_Error_Message"), driver.findElement(By.cssSelector(loc.getProperty("FirstName_Error_Message"))).getText(), "First name error message is incorrect");
		assertEquals(prop.getProperty("LastName_Error_Message"), driver.findElement(By.cssSelector(loc.getProperty("LastName_Error_Message"))).getText(), "Last name error message is incorrect");
		assertEquals(prop.getProperty("Email_TextField_ErrorMessage"), driver.findElement(By.cssSelector(loc.getProperty("Email_TextField_ErrorMessage"))).getText(), "Email error message is incorrect");
		
		BaseTest.ScrollTillElement(driver.findElement(By.xpath(loc.getProperty("Create_Account_Button_in_AccountCreation_page"))));
		
		assertEquals(prop.getProperty("Password_Error_Message"), driver.findElement(By.cssSelector(loc.getProperty("Password_Error_Message"))).getText(), "Password error message is incorrect");
		assertEquals(prop.getProperty("Confirm_Password_Error_Message"), driver.findElement(By.cssSelector(loc.getProperty("Confirm_Password_Error_Message"))).getText(), "Comfirm password error message is incorrect");
	}
}
