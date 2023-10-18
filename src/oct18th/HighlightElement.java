package oct18th;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HighlightElement {
	

WebDriver driver;
	
	@BeforeMethod
	public void setUp()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://adactinhotelapp.com/");
		driver.manage().window().maximize();
	}
	
	@Test
	public void clickJSTest() throws InterruptedException, IOException
	{
		
				
		findElementBy(("//input[@name='username']")).sendKeys("reyaz009");
		
		Thread.sleep(3000);
		
		findElementBy(("//input[@name='password']")).sendKeys("reyaz123");
		
		Thread.sleep(3000);
		
		findElementBy(("//input[@name='login']")).click();
		
		Thread.sleep(3000);
		
		Assert.assertEquals(driver.getTitle(), "Adactin.com - Search Hotel");
		
		
		
	}
	
	private WebElement findElementBy(String xpath) {
		
		WebElement element=null;
		
		element=driver.findElement(By.xpath(xpath));
		
		JavascriptExecutor js = (JavascriptExecutor)driver;

		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",element);
		
		
		return element;
		
		
	}

	@AfterMethod
	public void teardown() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.quit();
	}


}
