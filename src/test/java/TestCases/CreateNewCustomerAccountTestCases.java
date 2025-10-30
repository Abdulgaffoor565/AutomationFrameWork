package TestCases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.BaseClass;
import Utilities.ExcelLibrary;
import WebPages.CreateNewCustomerAccountPage;
import WebPages.HomePage;

public class CreateNewCustomerAccountTestCases extends BaseClass{

	public CreateNewCustomerAccountTestCases() throws IOException {
		super();
	}
	
	//Test cases
	
	@Test(priority = 1)
	public void AccountCreation_TC_001_AllTheTextBox_Verification()
	{
		HomePage HomePage=new HomePage(driver);
		CreateNewCustomerAccountPage CreateNewCustomerAccountPage=new WebPages.CreateNewCustomerAccountPage(driver);
		HomePage.ClickOn_CreateAnAccount_TextLink();
		Assert.assertTrue(CreateNewCustomerAccountPage.FirstNameTextBox_IsDisplayed());
		Assert.assertTrue(CreateNewCustomerAccountPage.LastNameTextBox_IsDisplayed());
		Assert.assertTrue(CreateNewCustomerAccountPage.EmailTextBox_IsDisplayed());
		Assert.assertTrue(CreateNewCustomerAccountPage.PasswordTextBox_IsDisplayed());
		Assert.assertTrue(CreateNewCustomerAccountPage.ComfirmPasswordTextBox_IsDisplayed());
	}
	@Test(priority = 2)
	public void AccountCreation_TC_002_CreateAnAccountButton_Verification()
	{
		HomePage HomePage=new HomePage(driver);
		CreateNewCustomerAccountPage CreateNewCustomerAccountPage=new WebPages.CreateNewCustomerAccountPage(driver);
		HomePage.ClickOn_CreateAnAccount_TextLink();
		Assert.assertTrue(CreateNewCustomerAccountPage.CreateAnAccount_button_IsDisplayed());
	}
	@Test(priority = 3)
	public void AccountCreation_TC_003_PageTitle_Verification()
	{
		HomePage HomePage=new HomePage(driver);
		HomePage.ClickOn_CreateAnAccount_TextLink();
		Assert.assertEquals(HomePage.Get_Title_Of_Page(), prop.getProperty("CreateNewCustomerAccountPage_PageTitle"));
	}
	@Test(priority = 4)
	public void AccountCreation_TC_004_PageMainHeading_Verification()
	{
		HomePage HomePage=new HomePage(driver);
		HomePage.ClickOn_CreateAnAccount_TextLink();
		CreateNewCustomerAccountPage CreateNewCustomerAccountPage=new WebPages.CreateNewCustomerAccountPage(driver);
		Assert.assertEquals(CreateNewCustomerAccountPage.GetText_MainPageTitle(), prop.getProperty("MainPageTitle"));
	}
	@Test(priority = 5)
	public void AccountCreation_TC_005_PageSubHeading_Verification()
	{
		HomePage HomePage=new HomePage(driver);
		HomePage.ClickOn_CreateAnAccount_TextLink();
		CreateNewCustomerAccountPage CreateNewCustomerAccountPage=new WebPages.CreateNewCustomerAccountPage(driver);
		Assert.assertEquals(CreateNewCustomerAccountPage.GetText_SubTitle_PersonalInformation(), prop.getProperty("SubTitle_PersonalInformation"));
		Assert.assertEquals(CreateNewCustomerAccountPage.GetText_SubTitle_SignInInformation(), prop.getProperty("SubTitle_SignInInformation"));
	}
	@Test(priority = 6,dataProvider = "data1")
	public void AccountCreation_TC_006_EmailTextBox_ValidationWith_ValidEmail(String email, String pwd)
	{
		HomePage HomePage=new HomePage(driver);
		HomePage.ClickOn_CreateAnAccount_TextLink();
		CreateNewCustomerAccountPage CreateNewCustomerAccountPage=new WebPages.CreateNewCustomerAccountPage(driver);
		CreateNewCustomerAccountPage.EnterEmail_In_EmailTextBox(email);
		CreateNewCustomerAccountPage.ClickOn_CreateAnAccount_button();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		Boolean ele = wait.until(ExpectedConditions.invisibilityOf(CreateNewCustomerAccountPage.Return_InvalidEmail_ErrorMessage_Element()));
		Assert.assertTrue(ele);
	}	
	@DataProvider(name = "data1")
    public Object[][] ValidEmails() throws Exception{
        return new ExcelLibrary().getData("data");
    }
	@Test(priority = 7,dataProvider = "data16")
	public void AccountCreation_TC_016_PasswordTextBox_ValidationFor_MediumStaus(String pswd) throws Exception
	{
		HomePage HomePage=new HomePage(driver);
		HomePage.ClickOn_CreateAnAccount_TextLink();
		CreateNewCustomerAccountPage CreateNewCustomerAccountPage=new WebPages.CreateNewCustomerAccountPage(driver);
		CreateNewCustomerAccountPage.EnterPassword_In_PasswordTextBox(pswd);
		Assert.assertEquals(CreateNewCustomerAccountPage.GetText_Password_StatusAs_Medium(), prop.getProperty("PasswordStrengh"));
	}
	@DataProvider(name = "data16")
    public Object[][] MediumPasswordStatus() throws Exception{
        return new ExcelLibrary().getData("Medium pwd");
    }
	
	@Test(priority = 8,dataProvider = "data026")
	public void AccountCreation_TC_026_PasswordTextBox_ValidationFor_StrongStaus(String pswd) throws Exception
	{
		HomePage HomePage=new HomePage(driver);
		HomePage.ClickOn_CreateAnAccount_TextLink();
		CreateNewCustomerAccountPage CreateNewCustomerAccountPage=new WebPages.CreateNewCustomerAccountPage(driver);
		CreateNewCustomerAccountPage.EnterPassword_In_PasswordTextBox(pswd);
		Assert.assertEquals(CreateNewCustomerAccountPage.GetText_Password_StatusAs_Strong(), prop.getProperty("StrongPasswordStrengh"));
	}
	@DataProvider(name = "data026")
    public Object[][] StrongPasswordStatus() throws Exception{
        return new ExcelLibrary().getData("strong pwd");
    }
	
	@Test(priority = 9,dataProvider = "data036")
	public void AccountCreation_TC_036_PasswordTextBox_ValidationFor_VeryStrongStaus(String pswd) throws Exception
	{
		HomePage HomePage=new HomePage(driver);
		HomePage.ClickOn_CreateAnAccount_TextLink();
		CreateNewCustomerAccountPage CreateNewCustomerAccountPage=new WebPages.CreateNewCustomerAccountPage(driver);
		CreateNewCustomerAccountPage.EnterPassword_In_PasswordTextBox(pswd);
		Assert.assertEquals(CreateNewCustomerAccountPage.GetText_Password_StatusAs_VeryStrong(), prop.getProperty("VeryStrongPasswordStrengh"));
	}
	@DataProvider(name = "data036")
    public Object[][] VeryStrongPasswordStatus() throws Exception{
        return new ExcelLibrary().getData("Very Strong pwd");
    }
	
	@Test(priority = 10)
	public void AccountCreation_TC_046_FirstNameErrorMessage_While_Empty() throws Exception
	{
		HomePage HomePage=new HomePage(driver);
		HomePage.ClickOn_CreateAnAccount_TextLink();
		CreateNewCustomerAccountPage CreateNewCustomerAccountPage=new WebPages.CreateNewCustomerAccountPage(driver);
		CreateNewCustomerAccountPage.Enter_LastName_InLastNametextBox(prop.getProperty("Valid_LastName"));
		CreateNewCustomerAccountPage.EnterEmail_In_EmailTextBox(prop.getProperty("Valid_Email"));
		CreateNewCustomerAccountPage.EnterPassword_In_PasswordTextBox(prop.getProperty("Valid_Password"));
		CreateNewCustomerAccountPage.Enter_Password_InComfirmPasswordTextBox(prop.getProperty("Valid_ComPwd"));
		CreateNewCustomerAccountPage.ClickOn_CreateAnAccount_button();
		Assert.assertEquals(CreateNewCustomerAccountPage.ReturnFirstNameTextBox_ErrorMessage_WhenItIsEmpty(), prop.getProperty("ErrorMessage_WhenEmpty"));
	}
	@Test(priority = 11)
	public void AccountCreation_TC_047_LastNameErrorMessage_While_Empty() throws Exception
	{
		HomePage HomePage=new HomePage(driver);
		HomePage.ClickOn_CreateAnAccount_TextLink();
		CreateNewCustomerAccountPage CreateNewCustomerAccountPage=new WebPages.CreateNewCustomerAccountPage(driver);
		CreateNewCustomerAccountPage.Enter_FirstName_InFirstNameTextBox(prop.getProperty("Vaild_FirstName"));
		CreateNewCustomerAccountPage.EnterEmail_In_EmailTextBox(prop.getProperty("Valid_Email"));
		CreateNewCustomerAccountPage.EnterPassword_In_PasswordTextBox(prop.getProperty("Valid_Password"));
		CreateNewCustomerAccountPage.Enter_Password_InComfirmPasswordTextBox(prop.getProperty("Valid_ComPwd"));
		CreateNewCustomerAccountPage.ClickOn_CreateAnAccount_button();
		Assert.assertEquals(CreateNewCustomerAccountPage.ReturnLastNameTextBox_ErrorMessage_WhenItIsEmpty(), prop.getProperty("ErrorMessage_WhenEmpty"));
	}
	@Test(priority = 12)
	public void AccountCreation_TC_048_EmailErrorMessage_While_Empty() throws Exception
	{
		HomePage HomePage=new HomePage(driver);
		HomePage.ClickOn_CreateAnAccount_TextLink();
		CreateNewCustomerAccountPage CreateNewCustomerAccountPage=new WebPages.CreateNewCustomerAccountPage(driver);
		CreateNewCustomerAccountPage.Enter_FirstName_InFirstNameTextBox(prop.getProperty("Vaild_FirstName"));
		CreateNewCustomerAccountPage.Enter_LastName_InLastNametextBox(prop.getProperty("Valid_LastName"));
		CreateNewCustomerAccountPage.EnterPassword_In_PasswordTextBox(prop.getProperty("Valid_Password"));
		CreateNewCustomerAccountPage.Enter_Password_InComfirmPasswordTextBox(prop.getProperty("Valid_ComPwd"));
		CreateNewCustomerAccountPage.ClickOn_CreateAnAccount_button();
		Assert.assertEquals(CreateNewCustomerAccountPage.Return_Email_ErrorMessage_WhenEmpty(), prop.getProperty("ErrorMessage_WhenEmpty"));
		}
	@Test(priority = 13)
	public void AccountCreation_TC_049_PasswordErrorMessage_While_Empty() throws Exception
	{
		HomePage HomePage=new HomePage(driver);
		HomePage.ClickOn_CreateAnAccount_TextLink();
		CreateNewCustomerAccountPage CreateNewCustomerAccountPage=new WebPages.CreateNewCustomerAccountPage(driver);
		CreateNewCustomerAccountPage.Enter_FirstName_InFirstNameTextBox(prop.getProperty("Vaild_FirstName"));
		CreateNewCustomerAccountPage.Enter_LastName_InLastNametextBox(prop.getProperty("Valid_LastName"));
		CreateNewCustomerAccountPage.EnterEmail_In_EmailTextBox(prop.getProperty("Valid_Email"));
		CreateNewCustomerAccountPage.Enter_Password_InComfirmPasswordTextBox(prop.getProperty("Valid_ComPwd"));
		CreateNewCustomerAccountPage.ClickOn_CreateAnAccount_button();
		Assert.assertEquals(CreateNewCustomerAccountPage.GetText_Password_ErrorMessage_WhenEmpty(), prop.getProperty("ErrorMessage_WhenEmpty"));
	}
	@Test(priority = 14)
	public void AccountCreation_TC_050_ConfirmPassword_ErrorMessage_While_Empty() throws Exception
	{
		HomePage HomePage=new HomePage(driver);
		HomePage.ClickOn_CreateAnAccount_TextLink();
		CreateNewCustomerAccountPage CreateNewCustomerAccountPage=new WebPages.CreateNewCustomerAccountPage(driver);
		CreateNewCustomerAccountPage.Enter_FirstName_InFirstNameTextBox(prop.getProperty("Vaild_FirstName"));
		CreateNewCustomerAccountPage.Enter_LastName_InLastNametextBox(prop.getProperty("Valid_LastName"));
		CreateNewCustomerAccountPage.EnterEmail_In_EmailTextBox(prop.getProperty("Valid_Email"));
		CreateNewCustomerAccountPage.EnterPassword_In_PasswordTextBox(prop.getProperty("Valid_Password"));
		CreateNewCustomerAccountPage.ClickOn_CreateAnAccount_button();
		Assert.assertEquals(CreateNewCustomerAccountPage.GetText_ConfirmPassword_ErrorMesaage_WhenEmpty(), prop.getProperty("ErrorMessage_WhenEmpty"));
	}
	@Test(priority = 15)
	public void AccountCreation_TC_051_Create_Account_With_AllValid_Data() throws Exception
	{
		HomePage HomePage=new HomePage(driver);
		HomePage.ClickOn_CreateAnAccount_TextLink();
		CreateNewCustomerAccountPage CreateNewCustomerAccountPage=new WebPages.CreateNewCustomerAccountPage(driver);
		CreateNewCustomerAccountPage.Enter_FirstName_InFirstNameTextBox(prop.getProperty("Abdul"));
		CreateNewCustomerAccountPage.Enter_LastName_InLastNametextBox(prop.getProperty("Gaffur"));
		//CreateNewCustomerAccountPage.EnterEmail_In_EmailTextBox("");
		CreateNewCustomerAccountPage.EnterPassword_In_PasswordTextBox(prop.getProperty("Valid_Password"));
		CreateNewCustomerAccountPage.ClickOn_CreateAnAccount_button();
		Assert.assertEquals(CreateNewCustomerAccountPage.GetText_ConfirmPassword_ErrorMesaage_WhenEmpty(), prop.getProperty("ErrorMessage_WhenEmpty"));
	}
}
