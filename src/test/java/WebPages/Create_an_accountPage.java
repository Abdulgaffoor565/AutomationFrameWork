package WebPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Create_an_accountPage {

	WebDriver driver;
	
	@FindBy(xpath = "(//span[text()='Create an Account'])[1]")
	private WebElement Create_an_account_button;
	@FindBy(css = "div[for='firstname']")
	private WebElement First_name_errorMessage;
	@FindBy(css = "div[for='lastname']")
	private WebElement LastName_Error_Message;
	@FindBy(css = "div[for='email_address']")
	private WebElement Email_TextField_ErrorMessage;
	@FindBy(css="div[for='password']")
	private WebElement Password_Error_Message;
	@FindBy(css="div[for='password-confirmation']")
	private WebElement Confirm_Password_Error_Message;
	@FindBy(css="div[id='password-strength-meter']")
	private WebElement Password_Strength_message;
	@FindBy(css = "div[for='password-confirmation']")
	private WebElement Confirm_Password_NotSimilar_Error_Message;
	@FindBy(css="input[id='firstname']")
	private WebElement First_Name_TextField;
	@FindBy(css="input[id='lastname']")
	private WebElement Last_Name_TextField;
	@FindBy(css="input[name='email']")
	private WebElement Email_TextField;
	@FindBy(css="input[id='password']")
	private WebElement Password_TextField;
	@FindBy(css="input[name='password_confirmation']")
	private WebElement Confirm_Password_TextField;
	
	public Create_an_accountPage(WebDriver driver)
	{
		this.driver=driver;
		//PageFactory.initElements(driver, this);
	}
	
	public void Create_A_new_Account(String first_name,String last_name,String Email,String Password,String Conf_psw)
	{

		First_Name_TextField.sendKeys(first_name);
		//BaseTest.ScrollTillElement(Create_an_account_button);
		Last_Name_TextField.sendKeys(last_name);
		Email_TextField.sendKeys(Email);
		Password_TextField.sendKeys(Password);
		Confirm_Password_TextField.sendKeys(Conf_psw);
		Create_an_account_button.click();
	}
	
	public void SendKey_Confirm_Password_TextField(String Text)
	{
		Confirm_Password_TextField.sendKeys(Text);
	}
	public void SendKey_Password_TextField(String Text)
	{
		Password_TextField.sendKeys(Text);
	}
	public void SendKey_Email_TextField(String Text)
	{
		Email_TextField.sendKeys(Text);
	}
	public void SendKey_Last_Name_TextField(String Text)
	{
		Last_Name_TextField.sendKeys(Text);
	}
	public void SendKey_First_Name_TextField(String Text)
	{
		First_Name_TextField.sendKeys(Text);
	}
	public String Get_Confirm_Password_Error_Message()
	{
		return Confirm_Password_Error_Message.getText();
	}
	public String Get_Password_Strength_message()
	{
		return Password_Strength_message.getText();
	}
	public String Get_Confirm_Password_NotSimilar_Error_Message()
	{
		return Confirm_Password_NotSimilar_Error_Message.getText();
	}
	public String Get_Password_Error_Message()
	{
		return Password_Error_Message.getText();
	}
	public String Get_Email_TextField_ErrorMessage()
	{
		return Email_TextField_ErrorMessage.getText();
	}
	public String Get_LastName_Error_Message()
	{
		return LastName_Error_Message.getText();
	}
	public WebElement Return_First_name_errorMessage_element()
	{
		return First_name_errorMessage;
	}
	public String Get_First_name_errorMessage()
	{
		return First_name_errorMessage.getText();
	}
	public WebElement Return_Create_an_account_button()
	{
		return Create_an_account_button;
	}
	public void Click_on_Create_an_account_button()
	{
		Create_an_account_button.click();
	}
}
