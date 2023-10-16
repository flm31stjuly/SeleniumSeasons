package oct16th;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameHandling {
	
	
WebDriver driver;
	
	@BeforeMethod
	public void setUp()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();
	}
	
	@Test
	public void mouseHoverTest() throws InterruptedException
	{
		
		
		
		//driver.switchTo().frame(0);
		
		//driver.switchTo().frame("demo-frame");
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
		
	   Actions action=new Actions(driver);
	   
	   action.dragAndDrop(driver.findElement(By.xpath("//div[@id='draggable']")), driver.findElement(By.xpath("//div[@id='droppable']")))
	             .build()
	             .perform();
		
		Thread.sleep(3000);
		
	}
	
	@AfterMethod
	public void teardown()
	{
		
		driver.quit();
	}


}
