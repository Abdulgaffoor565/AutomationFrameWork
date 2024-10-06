package WebPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	@FindBy(xpath = "//div[@class='panel header']//a[contains(text(),'Sign In')]") private WebElement Sign_In_TextLink;
	@FindBy(xpath = "//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']") private WebElement ConfirmationMessage_OfValidForgotPwd;
	@FindBy(xpath = "//div[@class='panel header']//a[normalize-space()='Create an Account']") private WebElement CreateAnAccount_TextLink;
	@FindBy(xpath  = "//div[@class='panel header']//span[@class='logged-in']") 
	private WebElement UserName_OnTop;
	@FindBy(xpath = "//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']") private WebElement NewAccountCreation_ComfirmationMessage;
	
	public HomePage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);}

	public String Get_Title_Of_Page()
		{return driver.getTitle();}
	public void ClickOn_Sign_In_TextLink() 
		{Sign_In_TextLink.click();}
	public String GetText_ConfirmationMessage_OfValidForgotPwd() 
		{return ConfirmationMessage_OfValidForgotPwd.getText();}
	public void ClickOn_CreateAnAccount_TextLink() 
		{CreateAnAccount_TextLink.click();}
	public String Get_CustomerName() 
		{return UserName_OnTop.getText();}
	public String Get_NewAccountCreation_ConfirmationMessage() 
	{return NewAccountCreation_ComfirmationMessage.getText();}

}
