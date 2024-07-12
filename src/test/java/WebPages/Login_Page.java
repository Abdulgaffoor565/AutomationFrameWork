package WebPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page {
	
	WebDriver driver;
	
	public Login_Page(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath  = "//input[@id='email']")
	private WebElement EmailTextField;
	@FindBy(xpath = "//fieldset[@class='fieldset login']//input[@id='pass']")
	private WebElement PasswordTextField;
	@FindBy(css="button[class='action login primary']")
	private WebElement LoginButton;
	
	public void EnterEmail(String email)
	{
		EmailTextField.clear();
		EmailTextField.sendKeys(email);
	}
	public void EnterPassword(String password)
	{
		PasswordTextField.clear();
		PasswordTextField.sendKeys(password);
	}
	public void ClickOnLoginButton()
	{
		LoginButton.click();
	}
	public String GetPageTitle()
	{
		return driver.getTitle();
	}
	public void Click_On_Create_an_Account_Button() {
		// TODO Auto-generated method stub
		
	}
}