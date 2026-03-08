package testWebStepDefination;

import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import webPages.DashBoard;
import webPages.LoginPage;

public class LoginPageStepDefination {
    private WebDriver driver;
    private LoginPage loginPage;
    private DashBoard dashboard;
    private static String title;
    
    public LoginPageStepDefination() {
        driver = DriverFactory.getDriver();
        loginPage = new LoginPage(driver);
        dashboard = new DashBoard(driver);
    }
    
    @Given("user navigate to the portal")
	public void user_navigate_to_the_portal() {
		System.out.println("Testing Started");
		driver.get("https://www.automationexercise.com/login");
	}

	@Given("user entered the credentials to Login and Click on the login button")
	public void user_entered_the_credentials_to_login() {
		loginPage.login();
	
	}

	@When("user gets the title of the LoginPage")
	public void user_gets_the_title_of_the_login_page() {
		title = loginPage.getTitle();
		System.out.println("The Login is page title is : "+ title );
		
	}
	
	@Then("page title should be {string}")
	public void page_title_should_be(String exceptedPageTitle) {
		Assert.assertTrue(title.contains(exceptedPageTitle));	 
	    
	}

	@Then("user should navigate to the Dashboard page and validate {string} text")
	public void user_should_navigate_to_the_dashboard_page(String pageTitle) {
		String homePagetitle = loginPage.getTitle();
		System.out.println("The Home page title is : "+ homePagetitle );
		Assert.assertTrue(homePagetitle.contains(pageTitle));
		
	}
}
