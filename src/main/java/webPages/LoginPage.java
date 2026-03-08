package webPages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {
	 
   private WebDriver driver;
   
   private By emailAddress = By.xpath("//form[@action='/login']/input[@type='email']");
   private By password = By.xpath("//form[@action='/login']/input[@type='password']");
   private By loginBtn = By.xpath("//form[@action='/login']/button[@type='submit']");
   
   // Ad popup locators
   private By adPopup = By.xpath("//div[contains(@class,'ad') or contains(@class,'popup') or contains(@class,'modal') or contains(@class,'overlay')]");
   private By adCloseButton = By.xpath("//button[contains(@class,'close') or contains(@class,'dismiss') or contains(@class,'cancel') or text()='×' or text()='Close']");
   
   public LoginPage(WebDriver driver) {
       this.driver=driver;
   }
   
   public String getTitle() {
	   return driver.getTitle();
	   
   }
   
   public void login() {
	   driver.findElement(emailAddress).sendKeys("bbhuyan892@gmail.com");
	   driver.findElement(password).sendKeys("Test@123");
	   driver.findElement(loginBtn).click();
	   
	   // Handle ad popup after login
	   handleAdPopup();
   }
   
   public void handleAdPopup() {
	   try {
		   // Wait for potential ad popup to appear
		   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		   
		   // Check if ad popup is present
		   if (driver.findElements(adPopup).size() > 0) {
			   System.out.println("Ad popup detected, attempting to close...");
			   
			   // Try to find and click close button
			   try {
				   WebElement closeButton = wait.until(ExpectedConditions.elementToBeClickable(adCloseButton));
				   closeButton.click();
				   System.out.println("Ad popup closed successfully");
			   } catch (Exception e) {
				   // If close button not found, try to click outside popup or press ESC
				   try {
					   driver.findElement(adPopup).click(); // Click on popup itself
					   Thread.sleep(500);
					   // Try ESC key to close
					  Actions actions = new Actions(driver);
					   actions.sendKeys(Keys.ESCAPE).perform();
					   System.out.println("Ad popup closed using ESC key");
				   } catch (Exception ex) {
					   System.out.println("Could not close ad popup: " + ex.getMessage());
				   }
			   }
		   }
	   } catch (Exception e) {
		   System.out.println("No ad popup detected or could not handle: " + e.getMessage());
	   }
   }
}
