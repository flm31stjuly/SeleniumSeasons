package sep26th;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MethodsInWebDriver1 {

	public static void main(String[] args) throws InterruptedException {
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		
		//get(String):void  this method will launch the app 
		
		driver.get("https://adactinhotelapp.com/");
		
		//driver.findElement(By.xpath("//img[contains(@src,'ios-button')]")).click();
		
		Thread.sleep(3000);
		
		System.out.println(driver.getTitle());
		
		System.out.println(driver.getCurrentUrl());
		
		driver.findElement(By.linkText("New User Register Here")).click();
		
		Thread.sleep(3000);
		
		System.out.println(driver.getTitle());
		
		System.out.println(driver.getCurrentUrl());
		
		//System.out.println(driver.getPageSource());
		
		//close():void  this method will close the tab or window on which webdriver focus is 
		
		//driver.close();
		
		driver.quit();
		
		
		
		

	}

}
