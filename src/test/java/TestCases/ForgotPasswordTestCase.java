package TestCases;

import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.BaseClass;
import Utilities.ExcelLibrary;
import WebPages.CustomerLoginPage;
import WebPages.ForgotYourPasswordPage;
import WebPages.HomePage;

public class ForgotPasswordTestCase extends BaseClass{
	
	ForgotPasswordTestCase() throws IOException
	{super();};

    @Test(priority = 1)
	public void ForgotPwd_TC_001_ForgetPasswordPageNavigation()
	{
		HomePage HomePage=new HomePage(driver);
		CustomerLoginPage CustomerLoginPage=new CustomerLoginPage(driver);
		HomePage.ClickOn_Sign_In_TextLink();
		CustomerLoginPage.ClickOn_Forgot_Your_Password_TextLink();
		Assert.assertEquals(HomePage.Get_Title_Of_Page(), prop.getProperty("ForgotPageTitle"));
	}
    
    @Test(priority = 2)
   	public void ForgotPwd_TC_002_ForgetPasswordPage_AllTheElements()
   	{
   		HomePage HomePage=new HomePage(driver);
   		ForgotYourPasswordPage ForgotYourPasswordPage=new ForgotYourPasswordPage(driver);
   		CustomerLoginPage CustomerLoginPage=new CustomerLoginPage(driver);
   		HomePage.ClickOn_Sign_In_TextLink();
   		CustomerLoginPage.ClickOn_Forgot_Your_Password_TextLink();
   		Assert.assertEquals(ForgotYourPasswordPage.EmailTextFiled_IsDisplayed(), true);
   		Assert.assertEquals(ForgotYourPasswordPage.ResetMyPassword_Button_IsDisplayed(), true);
   	}
    
    @Test(priority = 3,dataProvider = "data1")
   	public void ForgotPwd_TC_007_ValidEmail_Verification(String email, String password)
   	{
   		HomePage HomePage=new HomePage(driver);
   		ForgotYourPasswordPage ForgotYourPasswordPage=new ForgotYourPasswordPage(driver);
   		CustomerLoginPage CustomerLoginPage=new CustomerLoginPage(driver);
   		HomePage.ClickOn_Sign_In_TextLink();
   		CustomerLoginPage.ClickOn_Forgot_Your_Password_TextLink();
   		ForgotYourPasswordPage.Enter_EmailInside_EmailTextFiled(email);
   		ForgotYourPasswordPage.ClickOn_ResetMyPassword_Button();
   		String Act = HomePage.GetText_ConfirmationMessage_OfValidForgotPwd();
   		String exp="If there is an account associated with "+email+" you will receive an email with a link to reset your password.";
   		Assert.assertEquals(Act, exp);
   	}
    @DataProvider(name = "data1")
    public Object[][] ValidEmail() throws Exception{
        return new ExcelLibrary().getData("data");
    }
    
    @Test(priority = 4,dataProvider = "data2")
   	public void ForgotPwd_TC_017_InvalidEmail_ErrorMessage_validation(String email)
   	{
   		HomePage HomePage=new HomePage(driver);
   		ForgotYourPasswordPage ForgotYourPasswordPage=new ForgotYourPasswordPage(driver);
   		CustomerLoginPage CustomerLoginPage=new CustomerLoginPage(driver);
   		HomePage.ClickOn_Sign_In_TextLink();
   		CustomerLoginPage.ClickOn_Forgot_Your_Password_TextLink();
   		ForgotYourPasswordPage.Enter_EmailInside_EmailTextFiled(email);
   		ForgotYourPasswordPage.ClickOn_ResetMyPassword_Button();
   		String act = ForgotYourPasswordPage.getText_InvalidEmail_Address_ErrorMessage();
   		String exp=prop.getProperty("InvalidEmail_Address_ErrorMessage");
   		Assert.assertEquals(act, exp);
   	}
    @DataProvider(name = "data2")
    public Object[][] InValidEmail() throws Exception{
        return new ExcelLibrary().getData("invalid email");
    }
    
    @Test(priority = 5)
   	public void ForgotPwd_TC_027_EmptyEmailErrorMessage_validation()
   	{
    	HomePage HomePage=new HomePage(driver);
   		ForgotYourPasswordPage ForgotYourPasswordPage=new ForgotYourPasswordPage(driver);
   		CustomerLoginPage CustomerLoginPage=new CustomerLoginPage(driver);
   		HomePage.ClickOn_Sign_In_TextLink();
   		CustomerLoginPage.ClickOn_Forgot_Your_Password_TextLink();
   		ForgotYourPasswordPage.ClickOn_ResetMyPassword_Button();
   		String act1 = ForgotYourPasswordPage.getText_EmptyEmail_Address_ErrorMessage();
   		String exp1=prop.getProperty("EmptyEmail_Address_ErrorMessage");
   		Assert.assertEquals(act1, exp1);
   	}
    
    @Test(priority = 6)
   	public void ForgotPwd_TC_028_ErrorMessages_ValidAndEmptyEmail()
   	{
   		HomePage HomePage=new HomePage(driver);
   		ForgotYourPasswordPage ForgotYourPasswordPage=new ForgotYourPasswordPage(driver);
   		CustomerLoginPage CustomerLoginPage=new CustomerLoginPage(driver);
   		HomePage.ClickOn_Sign_In_TextLink();
   		CustomerLoginPage.ClickOn_Forgot_Your_Password_TextLink();
   		ForgotYourPasswordPage.Enter_EmailInside_EmailTextFiled("abcdef");
   		ForgotYourPasswordPage.ClickOn_ResetMyPassword_Button();
   		String act = ForgotYourPasswordPage.getText_InvalidEmail_Address_ErrorMessage();
   		String exp=prop.getProperty("InvalidEmail_Address_ErrorMessage");
   		Assert.assertEquals(act, exp);
   		ForgotYourPasswordPage.Clear_EmailTextFiled();
   		ForgotYourPasswordPage.ClickOn_ResetMyPassword_Button();
   		String act1 = ForgotYourPasswordPage.getText_EmptyEmail_Address_ErrorMessage();
   		String exp1=prop.getProperty("EmptyEmail_Address_ErrorMessage");
   		Assert.assertEquals(act1, exp1);
   	}
    
    @Test(priority = 7)
   	public void ForgotPwd_TC_029_InvalidEmailErrorMessage_AfterPageNavigation()
   	{
    	HomePage HomePage=new HomePage(driver);
   		ForgotYourPasswordPage ForgotYourPasswordPage=new ForgotYourPasswordPage(driver);
   		CustomerLoginPage CustomerLoginPage=new CustomerLoginPage(driver);
   		HomePage.ClickOn_Sign_In_TextLink();
   		CustomerLoginPage.ClickOn_Forgot_Your_Password_TextLink();
   		ForgotYourPasswordPage.Enter_EmailInside_EmailTextFiled("abcdef");
   		ForgotYourPasswordPage.ClickOn_ResetMyPassword_Button();
   		String act = ForgotYourPasswordPage.getText_InvalidEmail_Address_ErrorMessage();
   		String exp=prop.getProperty("InvalidEmail_Address_ErrorMessage");
   		Assert.assertEquals(act, exp);
   		driver.navigate().back();
   		driver.navigate().forward();
   		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
   		Boolean isErrorMessageInvisible = wait.until(ExpectedConditions.invisibilityOf(ForgotYourPasswordPage.ReturnElement_InvalidEmail_Address_ErrorMessage()));
   		if (isErrorMessageInvisible) {
            System.out.println("Error message is not displayed after refresh.");
        } else {
            System.out.println("Error message is still displayed after refresh.");
        }
   	}
    
    @Test(priority = 8)
   	public void ForgotPwd_TC_030_InvalidEmailErrorMessage_AfterPageRefresh()
   	{
    	HomePage HomePage=new HomePage(driver);
   		ForgotYourPasswordPage ForgotYourPasswordPage=new ForgotYourPasswordPage(driver);
   		CustomerLoginPage CustomerLoginPage=new CustomerLoginPage(driver);
   		HomePage.ClickOn_Sign_In_TextLink();
   		CustomerLoginPage.ClickOn_Forgot_Your_Password_TextLink();
   		ForgotYourPasswordPage.Enter_EmailInside_EmailTextFiled("abcdef");
   		ForgotYourPasswordPage.ClickOn_ResetMyPassword_Button();
   		String act = ForgotYourPasswordPage.getText_InvalidEmail_Address_ErrorMessage();
   		String exp=prop.getProperty("InvalidEmail_Address_ErrorMessage");
   		Assert.assertEquals(act, exp);
   		driver.navigate().refresh();
   		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
   		Boolean isErrorMessageInvisible = wait.until(ExpectedConditions.invisibilityOf(ForgotYourPasswordPage.ReturnElement_InvalidEmail_Address_ErrorMessage()));
   		if (isErrorMessageInvisible==true) {
            System.out.println("Error message is not displayed after refresh.");
        } else {
            System.out.println("Error message is still displayed after refresh.");
        }
   	}
}
