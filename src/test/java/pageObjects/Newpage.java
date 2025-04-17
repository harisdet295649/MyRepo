package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Newpage extends Basepage{
	
	public Newpage(WebDriver driver) 
	{
		super(driver);
	}
	
	@FindBy (xpath="//input[@id='username']")
	WebElement txtusername;
	
	@FindBy (xpath="//input[@id='password']")
	WebElement txtpassword;
	
	
	public void setusername(String username) 
	{
		txtusername.sendKeys(username);
		
	}
	
	public void setpassword(String password) 
	
	{
		txtpassword.sendKeys(password);
	}

}
