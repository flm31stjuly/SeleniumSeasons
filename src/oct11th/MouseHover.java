package oct11th;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseHover {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setUp()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.icicibank.com/");
		driver.manage().window().maximize();
	}
	
	@Test
	public void mouseHoverTest() throws InterruptedException
	{
		
		Actions action=new Actions(driver);
		
		action.moveToElement(driver.findElement(By.xpath("//span[text()='Loans']")))
				  .pause(3000)
		          .moveToElement(driver.findElement(By.xpath("//label[text()='Agri and Rural Finance']")))
		          .pause(3000)
		          .click(driver.findElement(By.xpath("//a[text()='Tractor Loan ']")))
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
