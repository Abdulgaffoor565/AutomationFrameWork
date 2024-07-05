package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginFeature {
	
//	WebDriver driver=new ChromeDriver();
//	HomePage Home_Page=new HomePage(driver);
//	Login_Page Login_Page=new Login_Page(driver);
	
	@Given("user launch the chrome browser.")
	public void user_launch_the_chrome_browser() {
		//driver.manage().window().maximize();
	}

	@When("user open URL")
	public void user_open_url() {
		//driver.get("https://magento.softwaretestingboard.com/");
	}

	@When("user enter email {string} and password as {string}")
	public void user_enter_email_and_password_as(String email, String password) {
		//Home_Page.Click_On_Sign_in_button();
		//Login_Page.EnterEmail(email);
		//Login_Page.EnterPassword(password);
	}

	@And("click on login button")
	public void click_on_login_button() {
		//Login_Page.ClickOnLoginButton();
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String expected) {
		 //String actual = Login_Page.GetPageTitle();
		 //Assert.assertEquals(actual, expected);
	}
}
