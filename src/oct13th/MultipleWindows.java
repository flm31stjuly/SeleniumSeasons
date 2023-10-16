package oct13th;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultipleWindows {
	
	
WebDriver driver;
	
	@BeforeMethod
	public void setUp()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.pepperfry.com/");
		driver.manage().window().maximize();
	}
	
	@Test
	public void multipleWindowsTest() throws InterruptedException
	{
		
		String homeWindowId=driver.getWindowHandle();
		
		
		
		/*
		 * new Actions(driver).moveToElement(driver.findElement(By.
		 * xpath("//a[text()='Sell on Pepperfry']")))
		 * .click(driver.findElement(By.xpath("//a[text()='Sell on Pepperfry']")))
		 * .build() .perform();
		 */
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		
		js.executeScript("window.scrollBy(0,7000);");
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//a[text()='Sell on Pepperfry']")).click();
		
		Set<String>  windowIds=driver.getWindowHandles();
		
		Iterator<String> it=windowIds.iterator();
		
		while(it.hasNext())
		{
			
			driver.switchTo().window(it.next());
			
			if(driver.getCurrentUrl().contains("partners-partnerwithus.html"))
			{
				break;
			}
			
		}
		
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Reyaz");
		
		Thread.sleep(3000);
		
		driver.switchTo().window(homeWindowId);
		
		
		Thread.sleep(3000);
		
		
	}
	
	@AfterMethod
	public void teardown()
	{
		
		driver.quit();
	}

}
