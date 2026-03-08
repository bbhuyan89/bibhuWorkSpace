package webPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class DashBoard {
	private WebDriver driver;
	LoginPage loginPage  = new LoginPage(driver);
	String headerText = "Welcome";
	private By categoryOptions = By.xpath("//div[@class='panel-group category-products']/div/div/h4/a");
	private By womenDress = By.xpath("//div[@id='Women']//a[contains(text(),'Dress')]");
	private By viewProduct = By.cssSelector("a[href=/product_details/3]");
	
	// Additional locators for dress section
	private By dressProducts = By.xpath("//div[contains(@class,'productinfo')]//p[contains(text(),'Dress')]");

	public DashBoard(WebDriver driver) {
		this.driver = driver;
	}

	public String validateHeader(String text) {
		if (headerText.equalsIgnoreCase(text)) {
			System.out.println("The text on the Dashboard page is " + text);
		}
		return text;
	}

	public void clickOnMenu() {
		System.out.println("User click on the menu option");
	}

	public boolean validateCategoryOptions() {
		List<WebElement> category = driver.findElements(categoryOptions);
		for (int i = 0; i < category.size(); i++) {
			String name = category.get(i).getText();
			if (name.contains("WOMEN") || name.contains("MEN") || name.contains("KIDS"))
				System.out.println(name);
		}
		return true;
	}

	public void navigateWomenCategoryOptions() throws InterruptedException {
		List<WebElement> category = driver.findElements(categoryOptions);
		for (int i = 0; i < category.size(); i++) {
			String name = category.get(i).getText();
			if (name.contains("WOMEN")) {
				// Click on WOMEN category to expand
				category.get(i).click();
				Thread.sleep(2000); // Wait for sub-menu to expand
				
				// Wait for dress element to be visible and clickable
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				WebElement dressElement = wait.until(ExpectedConditions.elementToBeClickable(womenDress));
				
				// Click on dress option
				dressElement.click();
				break; // Exit loop after finding and clicking WOMEN
			}
		}
	}
	
	// New methods for Women Dress scenarios
	
	public void clickWomenCategory() throws InterruptedException {
		List<WebElement> category = driver.findElements(categoryOptions);
		for (int i = 0; i < category.size(); i++) {
			String name = category.get(i).getText();
			if (name.contains("WOMEN")) {
				category.get(i).click();
				Thread.sleep(2000); // Wait for sub-menu to expand
				break;
			}
		}
	}
	
	public void clickDressSection() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement dressElement = wait.until(ExpectedConditions.elementToBeClickable(womenDress));
		 loginPage.handleAdPopup();
		dressElement.click();
	    loginPage.handleAdPopup();
		Thread.sleep(2000); // Wait for page to load
	}
	
	public boolean verifyDressProductsDisplayed() {
		List<WebElement> products = driver.findElements(dressProducts);
		return products.size() > 0;
	}
}
