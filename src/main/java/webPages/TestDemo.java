package webPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class TestDemo {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/bibhudatta/eclipse-workspace/CucumberFramework/driver/chromedriver");
//		ChromeOptions options = new ChromeOptions();
//        options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		driver.quit();
	}

}
