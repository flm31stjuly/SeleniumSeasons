package oct16th;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameHandling2 {
	
	
WebDriver driver;
	
	@BeforeMethod
	public void setUp()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.angelfire.com/super/badwebs/");
		driver.manage().window().maximize();
	}
	
	@Test
	public void mouseHoverTest() throws InterruptedException
	{
		
		driver.switchTo().frame("main");
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//a[contains(@href,'monkeyspaw')]")).click();
		
		Thread.sleep(3000);
		
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame("contents");
		
		driver.findElement(By.xpath("//font[contains(text(),'Hate Frames Page')]/parent::a")).click();
		
		
		Thread.sleep(3000);
		
	}
	
	@AfterMethod
	public void teardown()
	{
		
		driver.quit();
	}


}
