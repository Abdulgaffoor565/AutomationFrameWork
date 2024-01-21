package testcase;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.time.Duration;

import org.bouncycastle.math.ec.WTauNafMultiplier;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import WebPages.Create_an_accountPage;
import WebPages.HomePage;
import WebPages.Login_Page;
import base.BaseTest;

public class CreateAccountTC extends BaseTest {
	
	CreateAccountTC() throws IOException
	{
		super();
	}
	
	@Test(priority = 1)
	public static void TC_CreateAccount_01() throws InterruptedException, IOException
	{
		//VAlidate error message without entering any data.
		
		HomePage homePage=new HomePage(driver);
		Create_an_accountPage create_an_accountPage=new Create_an_accountPage(driver);
		
		homePage.Click_On_Create_an_AccountButton();
		
		BaseTest.ScrollTillElement(create_an_accountPage.Return_Create_an_account_button());
		create_an_accountPage.Click_on_Create_an_account_button();
		
		
		BaseTest.ScrollTillElement(create_an_accountPage.Return_First_name_errorMessage_element());
		Thread.sleep(2000);
		assertEquals(prop.getProperty("FirstName_Error_Message"), create_an_accountPage.Get_First_name_errorMessage(), "First name error message is incorrect");
		
		assertEquals(prop.getProperty("LastName_Error_Message"), create_an_accountPage.Get_LastName_Error_Message(), "Last name error message is incorrect");
		
		assertEquals(prop.getProperty("Email_TextField_ErrorMessage"), create_an_accountPage.Get_Email_TextField_ErrorMessage(), "Email error message is incorrect");
		
		BaseTest.ScrollTillElement(create_an_accountPage.Return_Create_an_account_button());
		
		assertEquals(prop.getProperty("Password_Error_Message"),create_an_accountPage.Get_Password_Error_Message() , "Password error message is incorrect");
		
		assertEquals(prop.getProperty("Confirm_Password_Error_Message"), create_an_accountPage.Get_Confirm_Password_Error_Message(), "Comfirm password error message is incorrect");
		BaseTest.TakeScreenShort("ErrorMessage");
	}
	
	//Create complete account and verify username display in home page
	@Test(priority = 2)
	public static void TC_CreateAccount_02() throws InterruptedException
	{
		HomePage homePage=new HomePage(driver);
		Create_an_accountPage create_an_accountPage=new Create_an_accountPage(driver);
		
	//click on create account button
		homePage.Click_On_Create_an_AccountButton();
		String FirstName = BaseTest.FirstName();
		String LastName = BaseTest.LastName();
		String verify = prop.getProperty("TextAtStartOfUserNameInHomePage")+" "+FirstName+" "+LastName+prop.getProperty("TextAtEndOfUserNameInHomePage");
		
	//enter first name
		create_an_accountPage.SendKey_First_Name_TextField(FirstName);
		
	//scroll down
		BaseTest.ScrollTillElement(create_an_accountPage.Return_Create_an_account_button());
		
	//enter last name
		create_an_accountPage.SendKey_Last_Name_TextField(LastName);
		
	//enter email
		create_an_accountPage.SendKey_Email_TextField(BaseTest.Emai());
		
	//enter password
		String password = BaseTest.Password();
		create_an_accountPage.SendKey_Password_TextField(password);
		
	//enter confirm password
		create_an_accountPage.SendKey_Confirm_Password_TextField(password);
		
	//click  on create account button
		create_an_accountPage.Click_on_Create_an_account_button();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(homePage.Return__UserName_After_Login()));
		
	//verify username display after account creation
		Assert.assertEquals(homePage.Get_UserName_After_Login(), verify);
	}
	
//------Create an account , verify, logout
	@Test(priority = 3)
	public static void TC_CreateAccount_03() throws InterruptedException
	{
		HomePage homePage=new HomePage(driver);
		Create_an_accountPage create_an_accountPage=new Create_an_accountPage(driver);
		
	//click on create account button
		homePage.Click_On_Create_an_AccountButton();
		String FirstName = BaseTest.FirstName();
		String LastName = BaseTest.LastName();
		String verify = prop.getProperty("TextAtStartOfUserNameInHomePage")+" "+FirstName+" "+LastName+prop.getProperty("TextAtEndOfUserNameInHomePage");
		
	//enter first name
		create_an_accountPage.SendKey_First_Name_TextField(FirstName);
		
	//scroll down
		BaseTest.ScrollTillElement(create_an_accountPage.Return_Create_an_account_button());
		
	//enter last name
		create_an_accountPage.SendKey_Last_Name_TextField(LastName);
		
	//enter email
		create_an_accountPage.SendKey_Email_TextField(BaseTest.Emai());
		
	//enter password
		String password = BaseTest.Password();
		create_an_accountPage.SendKey_Password_TextField(password);
		
	//enter confirm password
		create_an_accountPage.SendKey_Confirm_Password_TextField(password);
		
	//click  on create account button
		create_an_accountPage.Click_on_Create_an_account_button();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(homePage.Return__UserName_After_Login()));
		
	//verify username display after account creation
		Assert.assertEquals(homePage.Get_UserName_After_Login(), verify);
		
	//Click on Dropdown_Beside_UserName
		homePage.Click_On_Dropdown_Beside_UserName();
		
	//click on Sign out
		homePage.Click_On_Sign_Out_Button();
		
	//Verify logout
		wait.until(ExpectedConditions.visibilityOf(homePage.Return_Create_an_AccountButton()));
		Assert.assertEquals(homePage.Create_an_AccountButton_isDisplayed() , true);
	}
	
	// Create an account from sign up screen create account button.
	@Test(priority = 4)
	public static void TC_CreateAccount_04()
	{
		HomePage homePage=new HomePage(driver);
		Create_an_accountPage create_an_accountPage=new Create_an_accountPage(driver);
		Login_Page Login_Page=new Login_Page(driver);
		
	//click on sign in link text.
		homePage.Click_On_Sign_in_button();
		
	//Click on Account create button
		Login_Page.Click_On_Create_an_Account_Button();
		
		String FirstName = BaseTest.FirstName();
		String LastName = BaseTest.LastName();
		String verify = prop.getProperty("TextAtStartOfUserNameInHomePage")+" "+FirstName+" "+LastName+prop.getProperty("TextAtEndOfUserNameInHomePage");
		
	//enter first name
		create_an_accountPage.SendKey_First_Name_TextField(FirstName);
		
	//scroll down
		BaseTest.ScrollTillElement(create_an_accountPage.Return_Create_an_account_button());
		
	//enter last name
		create_an_accountPage.SendKey_Last_Name_TextField(LastName);
		
	//enter email
		create_an_accountPage.SendKey_Email_TextField(BaseTest.Emai());
		
	//enter password
		String password = BaseTest.Password();
		create_an_accountPage.SendKey_Password_TextField(password);
		
	//enter confirm password
		create_an_accountPage.SendKey_Confirm_Password_TextField(password);
		
	//click  on create account button
		create_an_accountPage.Click_on_Create_an_account_button();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(homePage.Return__UserName_After_Login()));
		
	//verify user name display after account creation
		Assert.assertEquals(homePage.Get_UserName_After_Login(), verify);
	}
}
