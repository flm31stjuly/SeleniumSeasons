package oct19th;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import graphql.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StaticWebTable2 {
	

WebDriver driver;
	
	@BeforeMethod
	public void setUp()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.timeanddate.com/worldclock/");
		driver.manage().window().maximize();
		
	}
	
	@Test
	public void webTableTest() throws InterruptedException, IOException
	{
		
			String part1="//table/tbody/tr[";
			String part2="]/td[";
			String part3="]";
		
		for(int i=1;i<=36;i++)
		{
			for(int j=1;j<=8;j++)
			{
			System.out.print(driver.findElement(By.xpath(part1+i+part2+j+part3)).getText()+"\t");
			}
			System.out.println();
		}
	     
	}
	
	@AfterMethod
	public void teardown() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.quit();
	}



}
