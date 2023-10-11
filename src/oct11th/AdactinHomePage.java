package oct11th;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AdactinHomePage {
	
	@Test(priority=1)
	public void loginTest()
	{
		System.out.println("Browser started ...");
		System.out.println("App launched");
		Assert.assertTrue(false);
		System.out.println("Login Successful");
		System.out.println("browser closed..");
	}

	
	@Test(priority=0)
	public void registrationTest()
	{
		System.out.println("Browser started ...");
		System.out.println("App launched");
		System.out.println("Registration Successful");
		System.out.println("browser closed..");
		
	}
	
	
	@Test(priority=2)
	public void forgotPasswordTest()
	{
		System.out.println("Browser started ...");
		System.out.println("App launched");
		System.out.println("forgot password Successful");
		System.out.println("browser closed..");
	}
	
	@Test(priority=3,dependsOnMethods="loginTest")
	public void changePasswordTest()
	{
		System.out.println("Browser started ...");
		System.out.println("App launched");
		System.out.println("change password Successful");
		System.out.println("browser closed..");
	}
}
