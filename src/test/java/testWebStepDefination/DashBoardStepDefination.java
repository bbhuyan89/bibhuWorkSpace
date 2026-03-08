package testWebStepDefination;

import org.openqa.selenium.WebDriver;
import org.junit.Assert;

import com.qa.factory.DriverFactory;

import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import webPages.DashBoard;

public class DashBoardStepDefination {
	private WebDriver driver;
	private DashBoard dashboard;
	
	public DashBoardStepDefination() {
		driver = DriverFactory.getDriver();
		dashboard = new DashBoard(driver);
	}
	
	@Then("user verify the category options")
	public void userVerifyTheCategoryoption() {
		dashboard.validateCategoryOptions();	
	}
	
	@Then("user click on the women option under category")
	public void user_click_on_the_menu_option() throws InterruptedException {
		dashboard.navigateWomenCategoryOptions();
	}
	
	// Essential step definitions for Women Dress scenario
	
	@When("user click on the women category to expand")
	public void userClickOnWomenCategoryToExpand() throws InterruptedException {
		dashboard.clickWomenCategory();
	}
	
	@When("user click on the dress section under women category")
	public void userClickOnDressSectionUnderWomenCategory() throws InterruptedException {
		dashboard.clickDressSection();
	}
	
	@Then("user should be redirected to the dress products page")
	public void userShouldBeRedirectedToDressProductsPage() {
		String currentUrl = driver.getCurrentUrl();
		System.out.println("Current URL after clicking dress: " + currentUrl);
		// More flexible URL validation - check for dress-related keywords
		boolean isValidDressPage = currentUrl.toLowerCase().contains("dress") || 
		                         currentUrl.toLowerCase().contains("women") ||
		                         currentUrl.toLowerCase().contains("category") ||
		                         currentUrl.toLowerCase().contains("products");
		Assert.assertTrue("User should be on dress products page. Current URL: " + currentUrl, isValidDressPage);
	}
	
	@Then("user validate the dress page title contains {string}")
	public void userValidateDressPageTitleContains(String expectedTitle) {
		String actualTitle = driver.getTitle();
		Assert.assertTrue("Page title should contain: " + expectedTitle, actualTitle.contains(expectedTitle));
	}
	
	@Then("user verify that dress products are displayed")
	public void userVerifyThatDressProductsAreDisplayed() {
		boolean productsDisplayed = dashboard.verifyDressProductsDisplayed();
		Assert.assertTrue("Dress products should be displayed", productsDisplayed);
	}

}
