package oct11th;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AdactinHomePage2 {
	
	
	@BeforeMethod
	public void setUp()
	{
		System.out.println("Browser started ...");
		System.out.println("App launched");
	}
	
	@AfterMethod
	public void teardown()
	{
		
		System.out.println("browser closed..");
	}
	
	@Test(priority=1)
	public void loginTest()
	{
		
		Assert.assertTrue(false);
		System.out.println("Login Successful");
		
	}

	
	@Test(priority=0)
	public void registrationTest()
	{
		
		System.out.println("Registration Successful");
		
		
	}
	
	
	@Test(priority=2)
	public void forgotPasswordTest()
	{
		
		System.out.println("forgot password Successful");
		
	}
	
	@Test(priority=3,dependsOnMethods="loginTest")
	public void changePasswordTest()
	{
				System.out.println("change password Successful");
		
	}
}
