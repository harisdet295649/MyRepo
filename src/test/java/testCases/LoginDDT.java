package testCases;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Homepage;
import pageObjects.Loginpage;
import pageObjects.Myaccountpage;
import utilities.DataProviders;

public class LoginDDT extends BaseClass {
	
	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class)
	public void verify_loginDDT(String uname, String pwd, String exp) 
	{
		
		try {
			
	  logger.info("**starting loginDDT test");
		
		//Home page
		Homepage hp = new Homepage(driver);
		hp.clickMyaccount();
		hp.clickLogin();
		
		//Login page
		Loginpage lp= new Loginpage(driver);
		lp.setEmail(uname);
		lp.setPassword(pwd);
		lp.clickLogin();
		
		//Myaccount page
		Myaccountpage mcp = new Myaccountpage(driver);
		boolean targetpage =mcp.isMyAccountPageExists();
		
		//Valid  login success -  test passed
		//       login failed - test failed
		
		
		//Invalid login success -  test failed
	   //         login failed -   test passed
		
		
		if(exp.equalsIgnoreCase("Valid"))
		{
			if(targetpage==true)
			{
				mcp.clickLogout();
				Assert.assertTrue(true);
			}
			else 
			{
				Assert.assertTrue(false);
			}
			
		}
		
		if(exp.equalsIgnoreCase("Invalid"))
		{
			if(targetpage==true)
			{
				mcp.clickLogout();
				Assert.assertTrue(false);
			}
			else 
			{
				Assert.assertTrue(true);
			}
			
		}
		
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("**Finished login DDT test**");
			
	}
	
	

}
