package WebPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotYourPasswordPage {
	WebDriver driver;
	
	@FindBy(xpath = "//input[@id='email_address']") private WebElement EmailTextFiled;
	@FindBy(xpath = "//span[normalize-space()='Reset My Password']") private WebElement ResetMyPassword_Button;
	@FindBy(xpath = "//div[@id='email_address-error']") private WebElement InvalidEmail_Address_ErrorMessage;
	@FindBy(xpath = "//div[@id='email_address-error']") private WebElement EmptyEmail_Address_ErrorMessage;
	
	public ForgotYourPasswordPage(WebDriver driver)
	{this.driver=driver;
	PageFactory.initElements(driver, this);}
	
	public void Enter_EmailInside_EmailTextFiled(String email)
		{EmailTextFiled.sendKeys(email);}
	public void Clear_EmailTextFiled()
		{EmailTextFiled.clear();}
	public boolean EmailTextFiled_IsDisplayed()
		{return EmailTextFiled.isDisplayed();}
	public boolean ResetMyPassword_Button_IsDisplayed()
		{return ResetMyPassword_Button.isDisplayed();}
	public void ClickOn_ResetMyPassword_Button()
		{ResetMyPassword_Button.click();}
	public String getText_InvalidEmail_Address_ErrorMessage()
		{return InvalidEmail_Address_ErrorMessage.getText();}
	public boolean InvalidEmail_Address_ErrorMessage_IsDisplayed()
		{return InvalidEmail_Address_ErrorMessage.isDisplayed();}
	public WebElement ReturnElement_InvalidEmail_Address_ErrorMessage()
		{return InvalidEmail_Address_ErrorMessage;}
	public String getText_EmptyEmail_Address_ErrorMessage()
		{return EmptyEmail_Address_ErrorMessage.getText();}
}
