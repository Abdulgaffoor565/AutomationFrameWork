package TestCases;

import java.io.IOException;
import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Base.BaseClass;
import Utilities.ExcelLibrary;
import WebPages.CustomerLoginPage;
import WebPages.ForgotYourPasswordPage;
import WebPages.HomePage;

public class SignIn_TestCases extends BaseClass {
	
	

	SignIn_TestCases() throws IOException
	{super();};
	
	
	
	@Test(priority = 1)
	public void SignIn_TC_001_EmailAndPasswordTextField_PresenceChecking()
	{
		HomePage HomePage=new HomePage(driver);
		CustomerLoginPage CustomerLoginPage=new CustomerLoginPage(driver);
		HomePage.ClickOn_Sign_In_TextLink();
		Assert.assertEquals(CustomerLoginPage.Email_TextField_IsDisplayed(), true);
		Assert.assertEquals(CustomerLoginPage.Password_TextField_IsDisplayed(), true);
	}
	
	@Test(priority = 2)
	public void SignIn_TC_002()
	{
		HomePage HomePage=new HomePage(driver);
		CustomerLoginPage CustomerLoginPage=new CustomerLoginPage(driver);
		HomePage.ClickOn_Sign_In_TextLink();
		Assert.assertEquals(CustomerLoginPage.SignIn_Button_IsDisplayed(), true);
		Assert.assertEquals(CustomerLoginPage.Create_an_Account_Button_IsDisplayed(), true);
		Assert.assertEquals(CustomerLoginPage.Forgot_Your_Password_TextLink_IsDisplayed(), true);
	}
	@Test(priority = 3)
	public void SignIn_TC_003()
	{
		HomePage HomePage=new HomePage(driver);
		CustomerLoginPage CustomerLoginPage=new CustomerLoginPage(driver);
		HomePage.ClickOn_Sign_In_TextLink();
		ArrayList<String> texts = CustomerLoginPage.Get_RegisterCustomerAndNewCustomer_HeadingAndInfoText();
		SoftAssert soft =new SoftAssert();
		soft.assertEquals(texts.get(0), prop.getProperty("RegisterCustomer_Heading"),"RegisterCustomer_Heading Text Is Incorrect");
		soft.assertEquals(texts.get(1), prop.getProperty("RegisterCustomer_InfoText"),"RegisterCustomer_InfoText Text Is Incorrect");
		soft.assertEquals(texts.get(2), prop.getProperty("NewCustomer_Heading"),"NewCustomer_Heading Text Is Incorrect");
		soft.assertEquals(texts.get(3), prop.getProperty("NewCustomer_InfoText"),"NewCustomer_InfoText Text Is Incorrect");
	}
	@Test(priority = 4,dataProvider = "data")
	public void SignIn_TC_008_Login_With_Valid_Creadential(String email,String pwd)
	{
		HomePage HomePage=new HomePage(driver);
		CustomerLoginPage CustomerLoginPage=new CustomerLoginPage(driver);
		HomePage.ClickOn_Sign_In_TextLink();
		CustomerLoginPage.SendKeys_Email_TextField(email);
		CustomerLoginPage.SendKeys_Password_TextField(pwd);
		CustomerLoginPage.ClickOn_SignIn_Button();
		Assert.assertEquals(HomePage.Get_Title_Of_Page(), prop.getProperty("HomePageTitle"),"Not redirected to home page after");
	}
    @DataProvider(name = "data")
    public Object[][] validData() throws Exception{
        return new ExcelLibrary().getData("data");
    }
    
    @Test(priority = 5,dataProvider = "data1")
	public void SignIn_TC_019_Login_With_Valid_emailAndInvalidPassword(String email,String pawd)
	{
		HomePage HomePage=new HomePage(driver);
		CustomerLoginPage CustomerLoginPage=new CustomerLoginPage(driver);
		HomePage.ClickOn_Sign_In_TextLink();
		CustomerLoginPage.SendKeys_Email_TextField(email);
		CustomerLoginPage.SendKeys_Password_TextField(pawd);
		CustomerLoginPage.ClickOn_SignIn_Button();
		Assert.assertEquals(CustomerLoginPage.Get_VaildEmailInvalidPasswordErrorMessage(),prop.getProperty("VaildEmailInvalidPasswordErrorMessage"));
	}
    @DataProvider(name = "data1")
    public Object[][] InValidData() throws Exception{
        return new ExcelLibrary().getData("invalid data");
    }
    
    @Test(priority = 6)
	public void SignIn_TC_029_Login_With_Valid_emailAndEmptyPassword()
	{
		HomePage HomePage=new HomePage(driver);
		CustomerLoginPage CustomerLoginPage=new CustomerLoginPage(driver);
		HomePage.ClickOn_Sign_In_TextLink();
		CustomerLoginPage.SendKeys_Email_TextField("asasasasasasasas@gmail.com");
		CustomerLoginPage.ClickOn_SignIn_Button();
		Assert.assertEquals(CustomerLoginPage.Get_EmptyPasswordErrorMessage(),prop.getProperty("EmptyPasswordErrorMessage"));
	}
    
    @Test(priority = 7)
	public void SignIn_TC_030_Login_With_Empty_emailAnd_ValidPassword()
	{
		HomePage HomePage=new HomePage(driver);
		CustomerLoginPage CustomerLoginPage=new CustomerLoginPage(driver);
		HomePage.ClickOn_Sign_In_TextLink();
		CustomerLoginPage.SendKeys_Password_TextField("abdul@123");
		CustomerLoginPage.ClickOn_SignIn_Button();
		Assert.assertEquals(CustomerLoginPage.Get_InvalidEmailErrorMessage(),prop.getProperty("InvalidEmailErrorMessage"));
		//Assert.assertEquals(CustomerLoginPage.Get_InvalidPasswordErrorMessage(),prop.getProperty("InvalidPasswordErrorMessage"));
	}
    
    @Test(priority = 8)
	public void SignIn_TC_031_Login_With_Empty_emailAnd_EmptyPassword()
	{
		HomePage HomePage=new HomePage(driver);
		CustomerLoginPage CustomerLoginPage=new CustomerLoginPage(driver);
		HomePage.ClickOn_Sign_In_TextLink();
		CustomerLoginPage.ClickOn_SignIn_Button();
		Assert.assertEquals(CustomerLoginPage.Get_InvalidEmailErrorMessage(),prop.getProperty("InvalidEmailErrorMessage"));
		Assert.assertEquals(CustomerLoginPage.Get_EmptyPasswordErrorMessage(),prop.getProperty("EmptyPasswordErrorMessage"));
	}
    
    @Test(priority = 9)
	public void SignIn_TC_032_EmailErrorMessage_ShouldGetRemovedAfterEnteringValidEmail()
	{
		HomePage HomePage=new HomePage(driver);
		CustomerLoginPage CustomerLoginPage=new CustomerLoginPage(driver);
		HomePage.ClickOn_Sign_In_TextLink();
		CustomerLoginPage.ClickOn_SignIn_Button();
		Assert.assertEquals(CustomerLoginPage.Get_InvalidEmailErrorMessage(),prop.getProperty("InvalidEmailErrorMessage"));
		Assert.assertEquals(CustomerLoginPage.Get_EmptyPasswordErrorMessage(),prop.getProperty("EmptyPasswordErrorMessage"));
		CustomerLoginPage.SendKeys_Email_TextField("asasasasasasasas@gmail.com");
		CustomerLoginPage.ClickOn_SignIn_Button();
		Assert.assertEquals(CustomerLoginPage.IsDisplayed_InvalidEmailErrorMessage(), false);
	}
    @Test(priority = 10)
	public void SignIn_TC_033_EmailErrorMessage_ShouldBeShownWhenItIsEmpty()
	{
		HomePage HomePage=new HomePage(driver);
		CustomerLoginPage CustomerLoginPage=new CustomerLoginPage(driver);
		HomePage.ClickOn_Sign_In_TextLink();
		CustomerLoginPage.ClickOn_SignIn_Button();
		Assert.assertEquals(CustomerLoginPage.Get_InvalidEmailErrorMessage(),prop.getProperty("InvalidEmailErrorMessage"));
		Assert.assertEquals(CustomerLoginPage.Get_EmptyPasswordErrorMessage(),prop.getProperty("EmptyPasswordErrorMessage"));
		CustomerLoginPage.SendKeys_Password_TextField("abdul@123");
		CustomerLoginPage.ClickOn_SignIn_Button();
		Assert.assertEquals(CustomerLoginPage.IsDisplayed_InvalidEmailErrorMessage(), true);
	}
    
}