package WebPages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Men_Top_Jacket_Page {
	
WebDriver driver;
	
	public Men_Top_Jacket_Page(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "div[data-role='title']")
	private List<WebElement> All_the_ShoppingOptions_Elements;
	@FindBy(xpath = "//div[normalize-space()='Style']")
	private WebElement Men_Jacket_StyleDropDown;
	@FindBy(xpath = "//div[@id='narrow-by-list']//div[1]//div[2]//ol[1]//li[1]//a[1]")
	private WebElement Men_Jacket_StyleDropDown_Insulated;
	
	public int Get_CountOf_All_The_ShoppingOptions_Elements()
	{
		int count=0;
		for(WebElement ele:All_the_ShoppingOptions_Elements)
		{
			count++;
		}
		return count;
	}
	
	public void ClickOn_Men_Jacket_StyleDropDown()
	{
		Men_Jacket_StyleDropDown.click();
	}
	public void ClickOn_Men_Jacket_StyleDropDown_Insulated()
	{
		Men_Jacket_StyleDropDown_Insulated.click();
	}
	public  ArrayList Get_All_The_ShoppingOptions_ElementsText()
	{
		ArrayList<String> val=new ArrayList();
		for(WebElement ele:All_the_ShoppingOptions_Elements)
		{
			val.add(ele.getText());
		}
		return val;
	}
	
}
