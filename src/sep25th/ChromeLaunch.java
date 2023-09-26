package sep25th;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeLaunch {

	public static void main(String[] args) {
		
		
		//System.setProperty("webdriver.chrome.driver", "D:\\FLM31stJuly\\softwares\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		new ChromeDriver();

	}

}
