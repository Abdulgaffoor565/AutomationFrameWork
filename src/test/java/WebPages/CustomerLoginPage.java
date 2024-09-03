package WebPages;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerLoginPage {

	WebDriver driver;
	@FindBy(xpath = "//input[@id='email']") private WebElement Email_TextField;
	@FindBy(xpath = "//fieldset[@class='fieldset login']//input[@id='pass']") private WebElement Password_TextField;
	@FindBy(xpath = "//fieldset[@class='fieldset login']//span[contains(text(),'Sign In')]") private WebElement SignIn_Button;
	@FindBy(xpath = "//a[@class='action create primary']//span[contains(text(),'Create an Account')]") private WebElement Create_an_Account_Button;
	@FindBy(xpath = "//a[@class='action remind']//span[contains(text(),'Forgot Your Password?')]") private WebElement Forgot_Your_Password_TextLink;
	@FindBy(xpath = "//div[@class='login-container']//strong[@id='block-customer-login-heading']") private WebElement RegisterCustomer_Heading;
	@FindBy(xpath = "//div[@class='field note']") private WebElement RegisterCustomer_InfoText;
	@FindBy(xpath = "//div[@class='login-container']//strong[@id='block-new-customer-heading']") private WebElement NewCustomer_Heading;
	@FindBy(xpath = "//p[contains(text(),'Creating an account has many benefits: check out f')]") private WebElement NewCustomer_InfoText;
	@FindBy(xpath = "//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']") private WebElement VaildEmailInvalidPasswordErrorMessage;
	@FindBy(xpath = "//div[@id='email-error']") private WebElement InvalidEmailErrorMessage;
	@FindBy(xpath = "//div[@id='pass-error']") private WebElement EmptyPasswordErrorMessage;
	
	public CustomerLoginPage(WebDriver driver)
	{this.driver=driver;
	PageFactory.initElements(driver, this);}
	
	public boolean Email_TextField_IsDisplayed()
		{return Email_TextField.isDisplayed();}
	public void SendKeys_Email_TextField(String email)
		{Email_TextField.sendKeys(email);}
	public boolean Password_TextField_IsDisplayed()
		{return Password_TextField.isDisplayed();}
	public void SendKeys_Password_TextField(String password)
		{Password_TextField.sendKeys(password);}
	public boolean SignIn_Button_IsDisplayed()
		{return SignIn_Button.isDisplayed();}
	public void ClickOn_SignIn_Button()
		{SignIn_Button.click();}
	public boolean Create_an_Account_Button_IsDisplayed()
		{return Create_an_Account_Button.isDisplayed();}
	public boolean Forgot_Your_Password_TextLink_IsDisplayed()
		{return Forgot_Your_Password_TextLink.isDisplayed();}
	public void ClickOn_Forgot_Your_Password_TextLink()
		{ Forgot_Your_Password_TextLink.click();}
	public ArrayList<String> Get_RegisterCustomerAndNewCustomer_HeadingAndInfoText()
	{
		ArrayList<String> Text=new ArrayList<String>();
		Text.add(RegisterCustomer_Heading.getText());
		Text.add(RegisterCustomer_InfoText.getText());
		Text.add(NewCustomer_Heading.getText());
		Text.add(NewCustomer_InfoText.getText());
		return Text;
	}
	public String Get_VaildEmailInvalidPasswordErrorMessage()
	{return VaildEmailInvalidPasswordErrorMessage.getText();}
	public String Get_InvalidEmailErrorMessage()
	{return InvalidEmailErrorMessage.getText();}
	public boolean IsDisplayed_InvalidEmailErrorMessage()
	{return InvalidEmailErrorMessage.isDisplayed();}
	public String Get_EmptyPasswordErrorMessage()
	{return EmptyPasswordErrorMessage.getText();}
}
