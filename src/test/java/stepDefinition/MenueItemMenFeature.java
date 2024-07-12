package stepDefinition;

import java.util.HashSet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import WebPages.HomePage;
import WebPages.Login_Page;
import WebPages.Men_Top_Jacket_Page;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MenueItemMenFeature {

	WebDriver driver=new ChromeDriver();
	HomePage Home_Page=new HomePage(driver);
	Login_Page Login_Page=new Login_Page(driver);
	Men_Top_Jacket_Page JacketPage=new Men_Top_Jacket_Page(driver);
	
	
	@Given("user accessing login page")
	public void user_accessing_login_page() {
		driver.get("https://magento.softwaretestingboard.com/");
		driver.manage().window().maximize();
		
	}

	@When("user enter valid email as {string} and valid password as {string}")
	public void user_enter_valid_email_as_and_valid_password_as(String email, String password) {
		Home_Page.Click_On_Sign_in_button();
		Login_Page.EnterEmail(email);
		Login_Page.EnterPassword(password);
	}

	@When("click on Login Button")
	public void click_on_login_button() {
		Login_Page.ClickOnLoginButton();
	}

	@Then("user is navigated to home page and title as {string}")
	public void user_is_navigated_to_home_page_and_title_as(String title) {
		Assert.assertEquals(Login_Page.GetPageTitle(), title);
	}

	@Then("Hover the mouse to Men Menue")
	public void hover_the_mouse_to_men_menue() {
		Actions act=new Actions(driver);
		act.moveToElement(Home_Page.Return_MenueBar_Men_Option()).perform();
	}

	@Then("Hover mouse to Top and select jachet option")
	public void hover_mouse_to_top_and_select_jachet_option() {
		Actions act=new Actions(driver);
		act.moveToElement(Home_Page.Return_MenueBar_MenOption_TopOption()).perform();
		Home_Page.ClickOn_MenueBar_MenOption_TopOption_JacketsOptions();
	}

	@Then("Verify the page title should be shown as {string}")
	public void verify_the_page_title_should_be_shown_as(String title) {
		Assert.assertEquals(Login_Page.GetPageTitle(), title);
	}
	
	@And("Hover mouse to Top and select 'Hoodies & Sweatshirts' option")
	public void hover_mouse_to_top_and_select_hoodies_sweatshirts_option() {
		Actions act=new Actions(driver);
		act.moveToElement(Home_Page.Return_MenueBar_MenOption_TopOption()).perform();
		Home_Page.ClickOn_MenueBar_MenOption_TopOption_HoodiesAndSweatshirtsOption();
	}
	
	@And("Close the browser")
	public void Close_the_browser()
	{
		driver.close();
	}
	
	@And("Hover mouse to Top and select 'Tees' option")
	public void hover_mouse_to_top_and_select_Tees_option() {
		Actions act=new Actions(driver);
		act.moveToElement(Home_Page.Return_MenueBar_MenOption_TopOption()).perform();
		Home_Page.ClickOn_MenueBar_MenOption_TopOption_TeesOption();
	}
	
	@And("Hover mouse to Top and select 'Tanks' option")
	public void hover_mouse_to_top_and_select_Tanks_option() {
		Actions act=new Actions(driver);
		act.moveToElement(Home_Page.Return_MenueBar_MenOption_TopOption()).perform();
		Home_Page.ClickOn_MenueBar_MenOption_TopOption_TanksOption();
	}
	
	@And("Hover mouse to 'Bottoms' and select 'Pants' option")
	public void hover_mouse_to_Bottoms_and_select_Pants_option() {
		Actions act=new Actions(driver);
		act.moveToElement(Home_Page.Return_MenueBar_MenOption_BottomsOption()).perform();
		Home_Page.ClickOn_MenueBar_MenOption_BottomsOption_PantsOption();
	}
	
	@And("Hover mouse to 'Bottoms' and select 'Shorts' option")
	public void hover_mouse_to_Bottoms_and_select_Shorts_option() {
		Actions act=new Actions(driver);
		act.moveToElement(Home_Page.Return_MenueBar_MenOption_BottomsOption()).perform();
		Home_Page.ClickOn_MenueBar_MenOption_BottomsOption_ShortsOption();
	}
	
	@Then("Verify inside jacket page at the bottom of Shopping Optiond {string} dropdown option should be present.")
	public void Verifying_All_ShoppingOption_Should_Be_Present_Inside_Men_top_jacketPage(String num) {
		JacketPage.Get_CountOf_All_The_ShoppingOptions_Elements();
		Assert.assertEquals(JacketPage.Get_CountOf_All_The_ShoppingOptions_Elements(), num);
	}
	
	@And("Click on 'Style' Dropdown.")
	public void click_on_dropdown() {
		JacketPage.ClickOn_Men_Jacket_StyleDropDown();
	}
	@And("Click on 'Insulated' option.")
	public void click_on_option() {
		JacketPage.ClickOn_Men_Jacket_StyleDropDown_Insulated();
	}
	@Then("Verify the {string} Option Should be removed from 'Shopping Options'")
	public void verify_the_option_should_be_removed_from(String str) {
		boolean ele = JacketPage.Get_All_The_ShoppingOptions_ElementsText().contains(str);
		Assert.assertEquals(ele, false);
	}
}
