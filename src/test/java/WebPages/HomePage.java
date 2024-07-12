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
	@FindBy(xpath = "//span[normalize-space()='Men']")
	private WebElement MenueBar_Men_Option;
	@FindBy(xpath = "//a[@id='ui-id-17']")
	private WebElement MenueBar_MenOption_TopOption;
	@FindBy(xpath = "//a[@id='ui-id-19']//span[contains(text(),'Jackets')]")
	private WebElement MenueBar_MenOption_TopOption_JacketsOptions;
	@FindBy(xpath = "//a[@id='ui-id-20']//span[contains(text(),'Hoodies & Sweatshirts')]")
	private WebElement MenueBar_MenOption_TopOption_HoodiesAndSweatshirtsOption;
	@FindBy(xpath = "//a[@id='ui-id-21']//span[contains(text(),'Tees')]")
	private WebElement MenueBar_MenOption_TopOption_TeesOption;
	@FindBy(xpath = "//a[@id='ui-id-22']")
	private WebElement MenueBar_MenOption_TopOption_TanksOption;
	@FindBy(xpath = "//a[@id='ui-id-18']")
	private WebElement MenueBar_MenOption_BottomsOption;
	@FindBy(xpath = "//a[@id='ui-id-23']")
	private WebElement MenueBar_MenOption_BottomsOption_PantsOption;
	@FindBy(xpath = "//a[@id='ui-id-24']//span[contains(text(),'Shorts')]")
	private WebElement MenueBar_MenOption_BottomsOption_ShortsOption;
	
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
	public WebElement Return_MenueBar_Men_Option()
	{
		return MenueBar_Men_Option;
	}
	public WebElement Return_MenueBar_MenOption_TopOption()
	{
		return MenueBar_MenOption_TopOption;
	}
	public void ClickOn_MenueBar_MenOption_TopOption_JacketsOptions()
	{
		 MenueBar_MenOption_TopOption_JacketsOptions.click();
	}
	public void ClickOn_MenueBar_MenOption_TopOption_HoodiesAndSweatshirtsOption()
	{
		MenueBar_MenOption_TopOption_HoodiesAndSweatshirtsOption.click();
	}
	public void ClickOn_MenueBar_MenOption_TopOption_TeesOption()
	{
		MenueBar_MenOption_TopOption_TeesOption.click();
	}
	public void ClickOn_MenueBar_MenOption_TopOption_TanksOption()
	{
		MenueBar_MenOption_TopOption_TanksOption.click();
	}
	public WebElement Return_MenueBar_MenOption_BottomsOption()
	{
		return MenueBar_MenOption_BottomsOption;
	}
	public void ClickOn_MenueBar_MenOption_BottomsOption_PantsOption()
	{
		MenueBar_MenOption_BottomsOption_PantsOption.click();
	}
	public void ClickOn_MenueBar_MenOption_BottomsOption_ShortsOption()
	{
		MenueBar_MenOption_BottomsOption_ShortsOption.click();
	}
}
