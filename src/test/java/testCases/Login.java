package testCases;



import org.testng.Assert;

import org.testng.annotations.Test;

import pageObjects.Homepage;
import pageObjects.Loginpage;
import pageObjects.Myaccountpage;

public class Login extends BaseClass{
	
	@Test
	public void verify_login()
	
	{
		
	logger.info("**starting log in page**");
	
	
	try {
	//Home page
	Homepage hp = new Homepage(driver);
	hp.clickMyaccount();
	hp.clickLogin();
	
	//Login page
	Loginpage lp= new Loginpage(driver);
	lp.setEmail(p.getProperty("email"));
	lp.setPassword(p.getProperty("password"));
	lp.clickLogin();
	
	//Myaccount page
	Myaccountpage mcp = new Myaccountpage(driver);
	boolean targetpage =mcp.isMyAccountPageExists();
	
	Assert.assertTrue(targetpage);
	
	}
	
	catch(Exception e) 
	{
		Assert.fail();
		
	}
	
	logger.info("**Finished the loginpage");

	}
	  

}
