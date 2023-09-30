package assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropdownTesting {

	public static void main(String[] args) throws InterruptedException {
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
		
		driver.manage().window().maximize();
		
		//driver.findElement(By.linkText("Create new account")).click();
		
		driver.findElement(By.xpath("//a[contains(@class,'_42ft _4jy0 _6lti _4jy6 _4jy2')]")).click();
		
		//driver.findElement(By.xpath("//a[text()='Create new account']")).click();
		
		Thread.sleep(3000);
		
		new Select(driver.findElement(By.name("birthday_day"))).selectByIndex(1);
		
		Thread.sleep(3000);
		
		new Select(driver.findElement(By.id("month"))).selectByValue("10");
		
		Thread.sleep(3000);
		
		new Select(driver.findElement(By.id("year"))).selectByVisibleText("1984");
		
		Thread.sleep(3000);
		
		
		driver.quit();

	}

}
