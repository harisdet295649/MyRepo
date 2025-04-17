package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Homepage;
import pageObjects.Register;


public class AccountRegistration extends BaseClass {
	

	@Test
	public void Verify_AccountRegistration()
	{
		logger.info("Starting AccountRegistration Test");
		
		try {
			
		Homepage hp = new Homepage(driver);
		hp.clickMyaccount();
		logger.info("Clicked on my account link");
		
		hp.clickRegister();
		logger.info("Clicked on Register link");
		
		Register rp = new Register(driver);
		
		logger.info("Providing customer details");
		rp.setFirstName(randomstring().toUpperCase());
		rp.setLastName(randomstring().toUpperCase());
		rp.setEmail(randomstring()+"@gmail.com");
		rp.setTelephone(randomNumber());
		
		String pwd = randomAlphaNumeric();
		
		rp.setPassword(pwd);
		rp.setConfirmPassword(pwd);
		rp.setPrivacyPolicy();
		rp.clickContinue();
		
		logger.info("Validating expected message");
		String cfmmsg = rp.getConfirmationMsg();
		
		if(cfmmsg.equals("Your Account Has Been Created!"))
			
		{
			Assert.assertTrue(true);
		}
		
		else 
			{
			logger.error("error logs");
			logger.debug("debug logs");	
			Assert.assertTrue(false);
			}
		}
		
		catch(Exception e) 
		{
			Assert.fail();
		}
		
		logger.info("Finished AccountRegistration Test");
	}
			

}
