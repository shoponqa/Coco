package stepsDefinations;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginPage;

public class StepsDefination {
	
	public WebDriver driver;
	public LoginPage lp;
	
	@Given("User Lunch Chrome browser")
	public void user_lunch_chrome_browser() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		
		lp = new LoginPage(driver);
		
	    
	}

	@When("User opens URL {string}")
	public void user_opens_url(String url)  {
		driver.manage().window().maximize();
		driver.get(url);
		
		
	    
	}

	@When("User enter Email as {string} and Password as {string}")
	public void user_enter_email_as_and_password_as(String email, String password) {
		lp.setUserName(email);
		lp.setPassword(password);
	   
	}

	@When("Click on Login")
	public void click_on_login() {
		lp.clickLogin();
	   
	}

	@Then("page Title should be {string}")
	public void page_title_should_be(String title) {
		
		if (driver.getPageSource().contains("Login was unsuccessful.")) {
			driver.close();
			Assert.assertTrue(false);
		}else {
			Assert.assertEquals(title, driver.getTitle());
		}
	    
	}
	
	@When("User click on Log out link")
	public void user_click_on_log_out_link() throws InterruptedException {
		Thread.sleep(3000);
	   lp.clickLogout();
	}

	

	@Then("close browser")
	public void close_browser() {
		driver.quit();
	    
	}
}
