package oct18th;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClickUsingJS2 {
	

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
	public void clickJSTest() throws InterruptedException, IOException
	{
		
				
		//WebElement element=driver.findElement(By.xpath("//a[text()='Sell on Pepperfry']"));
		
		WebElement block=driver.findElement(By.xpath("//p[text()='Partner With Us']/parent::div"));
		
		List<WebElement> allLinks=block.findElements(By.tagName("a"));
		
		System.out.println("No of Links "+allLinks.size());
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		
		
		  for(int i=0;i<allLinks.size();i++) 
		  {
		  
		  js.executeScript("arguments[0].click();", allLinks.get(i));
		  
		  Thread.sleep(3000); 
		  }
		 
		
		/*
		 * js.executeAsyncScript("arguments[0].click();", allLinks);
		 * js.executeAsyncScript("arguments[1].click();", allLinks);
		 * js.executeAsyncScript("arguments[2].click();", allLinks);
		 * js.executeAsyncScript("arguments[3].click();", allLinks);
		 * js.executeAsyncScript("arguments[4].click();", allLinks);
		 * js.executeAsyncScript("arguments[5].click();", allLinks);
		 */
		
		
		
		
	}
	
	@AfterMethod
	public void teardown() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.quit();
	}



}
