package StepDefinition;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import com.qaclick.FinalProject.BaseClass;
import com.qaclick.FinalProject.LandingValidateMenu;

import PageObject.LandingPage;
import PageObject.LearningPage;
import PageObject.LoginPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

public class StepDefinitions extends BaseClass {

	private static final Logger logger = LogManager.getLogger(LandingValidateMenu.class.getName());

	@Given("^Open Chrome browser$")
	public void open_chrome_browser() throws Throwable {
		openBrowser();
		logger.info("Open browser");
	}

	@Given("^Go to \"([^\"]*)\"$")
	public void go_to_something(String strArg1) throws Throwable {
		driver.get(strArg1);
		logger.info("Go to QA CLick Academy success");
		
		System.out.println("Call me by your name");
		
		
		
		System.out.println("Call me maybe");
		
	}

	@Given("^Go to Login page$")
	public void go_to_login_page() throws Throwable {
		LandingPage landingPage = new LandingPage(driver);

		if (landingPage.getPopup().size() > 0) {
			logger.debug("Close Popup");
			landingPage.getClosePopupBtn().click();
			logger.info("Close Popup successfully");
		}

		logger.debug("Click on Login button");
		landingPage.getLoginBtn().click();
		logger.info("Redirect to Log In page");
	}

	@When("^Input username (.+) and password (.+)$")
	public void input_username_and_password(String user, String pass) throws Throwable {
		LoginPage loginPage = new LoginPage(driver);
		logger.debug("Input username");
		loginPage.email.sendKeys(user);
		logger.debug("Input password");
		loginPage.password.sendKeys(pass);
	}

	@When("^Click on Login button$")
	public void click_on_login_button() throws Throwable {
		LoginPage loginPage = new LoginPage(driver);
		logger.debug("Click on Log in button");
		loginPage.logInBtn.click();
	}

	@Then("^Redirect to Learning page and Verify Searchbox$")
	public void redirect_to_learning_page_and_verify_searchbox() throws Throwable {
		//Thread.sleep(5000);
		LearningPage learningPage = new LearningPage(driver);
		Assert.assertTrue(learningPage.getSearchBox().isDisplayed());
	}

	@Then("^Close browser$")
	public void close_browser() throws Throwable {
		driver.close();
		logger.info("Browser is closed");
	}

}