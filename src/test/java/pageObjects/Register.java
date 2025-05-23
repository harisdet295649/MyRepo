package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Register extends Basepage {
	
	public Register(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement txtFirstname;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement txtLastname;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement txtTelephone;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtPassword;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement txtConfirmPassword;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement chkPolicy;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement btnContinue;
	
	@FindBy(xpath="//h1[text()='Your Account Has Been Created!']")
	WebElement msgConfirmation;
	
	public void setFirstName(String fname) 
	{
		txtFirstname.sendKeys(fname);
	}
	
	public void setLastName(String lname) 
	{
		txtLastname.sendKeys(lname);
	}
	
	public void setEmail(String email) 
	{
		txtEmail.sendKeys(email);
	}
	
	public void setTelephone(String telephone) 
	{
		txtTelephone.sendKeys(telephone);
	}
	
	public void setPassword(String pwd) 
	{
		txtPassword.sendKeys(pwd);
	}
	
	public void setConfirmPassword(String pwd) 
	{
		txtConfirmPassword.sendKeys(pwd);
	}
	
	public void setPrivacyPolicy() 
	{
		chkPolicy.click();
	}
	
	public void clickContinue() 
	{
		btnContinue.click();
		
		//some times click method does not work it will throw element interception exception then use following methods
		
		// 1) btnContinue.submit();
		
		// 2) btn.Continue.sendkeys(keys.RETURN);
		
		// 3) JavascriptExecutor js = (JavascriptExecutor)driver;
		//    executeScript("arguments[0].click();", btnContinue);
		
		// 4) WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//    mywait.untill(ExpectedConditions.elementToBeClickable(btnContinue)).click();
		 
	}
	
	public String getConfirmationMsg()
	{
		
		try {
		return (msgConfirmation.getText());
		}
		catch(Exception e) 
		{
			return(e.getMessage());
		}	
	}
	
		
}
	
	


	
	


