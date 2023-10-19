package oct19th;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.awt.*;
import java.awt.event.KeyEvent;

import java.awt.datatransfer.StringSelection;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileUpload {
	

WebDriver driver;
	
	@BeforeMethod
	public void setUp()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://imgur.com/");
		driver.manage().window().maximize();
		
	}
	
	@Test
	public void fileUploadTest() throws InterruptedException, IOException, AWTException
	{
		
		
		driver.findElement(By.xpath("//a[@class='Button upload']")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//label[text()='Choose Photo/Video']/img")).click();
		
		Thread.sleep(3000);
		
		StringSelection sel = new StringSelection("D:\\FLM31stJulWS\\SeleniumSeasons\\Adactin1.png");

		   // Copy to clipboard
		 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel,null);
		 
		 Robot robot= new Robot();
		 
		// Press CTRL+V
		 robot.keyPress(KeyEvent.VK_CONTROL);
		 robot.keyPress(KeyEvent.VK_V);

		// Release CTRL+V
		 robot.keyRelease(KeyEvent.VK_CONTROL);
		 robot.keyRelease(KeyEvent.VK_V);
		 Thread.sleep(1000);
		 
		 
		 robot.keyPress(KeyEvent.VK_ENTER);
		 robot.keyRelease(KeyEvent.VK_ENTER);
		 
		 
		 
		Thread.sleep(3000);
		
	     
	}
	
	@AfterMethod
	public void teardown() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.quit();
	}



}
