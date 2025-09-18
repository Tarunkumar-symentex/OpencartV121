package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass
{
	
	
	@Test(groups={"Regression","Master"})
	public void verify_account_registrtion()
	{
		logger.info("*****Starting TC001_AccountRegistrationTest*****");
		
		try
		{
		HomePage hp= new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on MyAccount Link");
		
		hp.clickRegister();
		logger.info("Clicked on Register Link");
		
		AccountRegistrationPage accregpage = new AccountRegistrationPage(driver);
		logger.info("Providing Customer Details.....");
		
		accregpage.setFirstName(randomeString().toUpperCase());
		accregpage.setLastName(randomeString().toUpperCase());
		accregpage.setEmail(randomeString()+"@gmail.com");//randomly generated the email
		accregpage.setTelephone(randomeNumber());
		
		String password=randomAlphaNumeric();
		
		accregpage.setPassword(password);
		accregpage.setConfirmPassword(password);
		
		accregpage.setPrivacyPolicy();
		accregpage.clickContinue();
		logger.info("Validating expected message....");
		String confmsg= accregpage.getConfirmationMsg();
		Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		
		}
		catch(Exception e)
		{
			logger.error("Test Failed...");
			logger.debug("Debug logs....");
			Assert.fail();
		}
		
		logger.info("*****Finished TC001_AccountRegistrationTest*****");

	}
	
	
}
