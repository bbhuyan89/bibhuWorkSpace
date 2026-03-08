package com.qa.factory;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.qa.util.ConfigReader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public WebDriver driver;
	private ConfigReader configReader;
	Properties prop;
	

	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
	
	public WebDriver init_driver(String browserName) {
		System.out.println("The passed Browser is: " + browserName);
		
		WebDriver driver = null;

		if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();			
		} 
		
		else if (browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

		else if (browserName.equals("EDGE")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}

		else if (browserName.equals("safari")) {
			driver = new SafariDriver();
		}

		else {
			System.out.println("Please pass the correct browser :" + browserName);
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		tlDriver.set(driver);
		return getDriver();

	}
	
	public static WebDriver getDriver() {
		return tlDriver.get();
	}
	
	public static void setDriver(WebDriver driver) {
		tlDriver.set(driver);
	}

}
