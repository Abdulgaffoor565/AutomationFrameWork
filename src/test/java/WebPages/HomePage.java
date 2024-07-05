package WebPages;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;
	
	@FindBy(xpath = "(//a[text()='Create an Account'])[1]")
	private WebElement Create_an_AccountButton;
	@FindBy(xpath = "(//span[@class='logged-in'])[1]")
	private WebElement User_name_after_login;
	@FindBy(xpath = "(//button[@data-action='customer-menu-toggle' and @type='button'])[1]")
	private WebElement Dropdown_Beside_UserName;
	@FindBy(xpath = "(//li[@data-label='or'])[1]")
	private WebElement Sign_Out_Button;
	@FindBy(xpath = "(//li[@class='authorization-link' and @data-label='or'])[1]")
	private WebElement Sign_in_button;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void sign_out_Account()
	{
		try {
		Dropdown_Beside_UserName.click();
		}catch(StaleElementReferenceException e)
		{
			PageFactory.initElements(driver, this);
		}
		Sign_Out_Button.click();
	}
	
	public void Click_On_Sign_in_button()
	{
		Sign_in_button.click();
	}
	public void Click_On_Sign_Out_Button()
	{
		Sign_Out_Button.click();
	}
	public void Click_On_Dropdown_Beside_UserName()
	{
		Dropdown_Beside_UserName.click();
	}
	public WebElement Return_webElement_UserName_After_Login()
	{
		try {
		return User_name_after_login;
		}
		catch(StaleElementReferenceException e){
		PageFactory.initElements(driver, this);
		return User_name_after_login;
		}
	}
	public String Get_UserName_After_Login()
	{
		try {
		return User_name_after_login.getText();
		}catch(StaleElementReferenceException e) {
			PageFactory.initElements(driver, this);
			return User_name_after_login.getText();
		}
	}
	public void Click_On_Create_an_AccountButton()
	{
		Create_an_AccountButton.click();
	}
	public boolean Create_an_AccountButton_isDisplayed()
	{
		try {
		return Create_an_AccountButton.isDisplayed();
		}catch(StaleElementReferenceException e) {
			PageFactory.initElements(driver, this);
			return Create_an_AccountButton.isDisplayed();
		}
	}
	public WebElement Return_Create_an_AccountButton()
	{
		try {
		return Create_an_AccountButton;
		}
		catch(StaleElementReferenceException e){
			PageFactory.initElements(driver, this);
			return Create_an_AccountButton;
		}	
	}
}
