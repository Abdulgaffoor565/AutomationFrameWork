package WebPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
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
	public WebElement Return__UserName_After_Login()
	{
		return User_name_after_login;
	}
	public String Get_UserName_After_Login()
	{
		return User_name_after_login.getText();
	}
	public void Click_On_Create_an_AccountButton()
	{
		Create_an_AccountButton.click();
	}
	public boolean Create_an_AccountButton_isDisplayed()
	{
		return Create_an_AccountButton.isDisplayed();
	}
	public WebElement Return_Create_an_AccountButton()
	{
		return Create_an_AccountButton;
	}
}
