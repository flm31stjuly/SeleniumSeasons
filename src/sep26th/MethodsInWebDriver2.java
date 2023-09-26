package sep26th;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MethodsInWebDriver2 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://adactinhotelapp.com/");
		
		//to maximize the window 
		
		driver.manage().window().maximize();
		
		System.out.println(driver.getWindowHandle());
		
		driver.findElement(By.xpath("//img[contains(@src,'ios-button')]")).click();
		
		Thread.sleep(3000);
		
		System.out.println(driver.getWindowHandles());
		
		driver.quit();

	}

}
