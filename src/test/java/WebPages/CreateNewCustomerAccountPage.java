package WebPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewCustomerAccountPage {
	WebDriver driver;
	@FindBy(xpath = "//input[@id='firstname']") private WebElement FirstName;
	@FindBy(xpath = "//div[@id='firstname-error']") private WebElement FirstName_Error_message;
	@FindBy(xpath = "//input[@id='lastname']") private WebElement LastName;
	@FindBy(xpath = "//div[@id='lastname-error']") private WebElement LastName_Error_message;
	@FindBy(xpath = "//input[@id='email_address']") private WebElement Email;
		@FindBy(xpath = "//div[@id='email_address-error']") private WebElement InvalidEmail_ErrorMessage;
	@FindBy(xpath = "//input[@id='password']") private WebElement Password;
		@FindBy(xpath = "//span[@id='password-strength-meter-label']") private WebElement Password_StatusAs_Medium;
		@FindBy(xpath = "//span[@id='password-strength-meter-label']") private WebElement Password_StatusAs_Strong;
		@FindBy(xpath = "//span[@id='password-strength-meter-label']") private WebElement Password_StatusAs_VeryStrong;
	@FindBy(xpath = "//input[@id='password-confirmation']") private WebElement ComfirmPassword;
	@FindBy(xpath = "//button[@title='Create an Account']//span[contains(text(),'Create an Account')]") private WebElement CreateAnAccount_button;
	
	@FindBy(xpath = "//span[@class='base']") private WebElement MainPageTitle;
	@FindBy(xpath = "//span[normalize-space()='Personal Information']") private WebElement SubTitle_PersonalInformation;
	@FindBy(xpath = "//span[normalize-space()='Sign-in Information']") private WebElement SubTitle_SignInInformation;
	
	
	public CreateNewCustomerAccountPage(WebDriver driver)
		{this.driver=driver;
		PageFactory.initElements(driver, this);}
	
	public boolean FirstNameTextBox_IsDisplayed()
		{return FirstName.isDisplayed();}
	public void Enter_FirstNameTextBox(String text)
		{ FirstName.sendKeys(text); }
	public String Return_FirstName_ErrorMessage()
		{return FirstName_Error_message.getText(); }
	public boolean LastNameTextBox_IsDisplayed()
		{return LastName.isDisplayed();}
	public void Enter_LastNameTextBox(String text)
		{ LastName.sendKeys(text); }
	public String Return_LastName_ErrorMessage()
		{return LastName_Error_message.getText(); }
	public boolean EmailTextBox_IsDisplayed()
	{return Email.isDisplayed();}
		public void EnterEmail_In_EmailTextBox(String email)
		{ Email.sendKeys(email);}
		public WebElement Return_InvalidEmail_ErrorMessage_Element()
		{ return InvalidEmail_ErrorMessage;}
	public boolean PasswordTextBox_IsDisplayed()
	{return Password.isDisplayed();}
		public void EnterPassword_In_PasswordTextBox(String pwd)
		{ Password.sendKeys(pwd);}
		public String GetText_Password_StatusAs_Medium()
		{ return Password_StatusAs_Medium.getText();}
		public String GetText_Password_StatusAs_Strong()
		{ return Password_StatusAs_Strong.getText();}
		public String GetText_Password_StatusAs_VeryStrong()
		{ return Password_StatusAs_VeryStrong.getText();}
	public boolean ComfirmPasswordTextBox_IsDisplayed()
		{return ComfirmPassword.isDisplayed();}
	public void Enter_ComfirmPasswordTxtBox(String pwd)
		{ ComfirmPassword.sendKeys(pwd); }
	public boolean CreateAnAccount_button_IsDisplayed()
	{return CreateAnAccount_button.isDisplayed();}
		public void ClickOn_CreateAnAccount_button()
		{CreateAnAccount_button.click();}
	public String GetText_MainPageTitle()
		{return MainPageTitle.getText();}
	public String GetText_SubTitle_PersonalInformation()
		{return SubTitle_PersonalInformation.getText();}
	public String GetText_SubTitle_SignInInformation()
		{return SubTitle_SignInInformation.getText();}
}
