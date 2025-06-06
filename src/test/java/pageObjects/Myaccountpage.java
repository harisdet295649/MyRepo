package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Myaccountpage extends Basepage {
	
	public Myaccountpage(WebDriver driver) 
	{
		super(driver);
	}
	
	
	@FindBy (xpath="//h2[normalize-space()='My Account']")
	WebElement msgHeading;
	
	@FindBy (xpath="//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement lnkLogout;
	
	public void clickLogout() 
	{
		lnkLogout.click();
	}
	
	public boolean isMyAccountPageExists() 
	{
		try {
		return(msgHeading.isDisplayed());
		}
		catch(Exception e)
		{
			return false;
		}
	}
	

}
