package oct16th;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultipleWindows2 {
	
	
WebDriver driver;

	private void switchToWindow(String expectedTitle) {
	
		Set<String>  windowIds=driver.getWindowHandles();
		
		Iterator<String> it=windowIds.iterator();
		
		while(it.hasNext())
		{
			
			driver.switchTo().window(it.next());
			
			if(driver.getTitle().equalsIgnoreCase(expectedTitle))
			{
				break;
			}
			
		}
		
	}		

	
	@BeforeMethod
	public void setUp()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.salesforce.com/in/");
		driver.manage().window().maximize();
	}
	
	@Test
	public void multipleWindowsTest() throws InterruptedException
	{
		
		
		String homeWindowId=driver.getWindowHandle();
		
		driver.findElement(By.xpath("(//a[contains(text(),'Start free trial')])[1]")).click();
		
		Thread.sleep(3000);
		
		switchToWindow("Free CRM Trial: Salesforce 30-Day Trial - Salesforce IN");
		
			
		driver.findElement(By.xpath("//input[@name='UserFirstName']")).sendKeys("reyaz");
		
		Thread.sleep(3000);
		
		driver.switchTo().window(homeWindowId);
		
		Thread.sleep(3000);
		
		
		driver.findElement(By.xpath("(//a[contains(text(),'Start free trial')]/parent::pbc-button/following-sibling::pbc-button/a[contains(text(),'Watch demo')])[1]")).click();
		
		Thread.sleep(3000);
		
		switchToWindow("Salesforce Overview Demos - Salesforce IN");
				
		driver.findElement(By.xpath("//input[@name='UserFirstName']")).sendKeys("shaik");
		
		driver.switchTo().window(homeWindowId);
		
		Thread.sleep(3000);
		
	}
	
	
	@AfterMethod
	public void teardown() throws InterruptedException
	{
		Thread.sleep(3000);
		
		driver.quit();
	}


}
