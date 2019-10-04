package com.qaclick.FinalProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObject.LandingPage;
import PageObject.LearningPage;
import PageObject.LoginPage;

public class LoginTest extends BaseClass {

	private static final Logger logger = LogManager.getLogger(LoginTest.class.getName());

	@BeforeClass
	public void initialize() throws IOException {
		openBrowser();
		logger.info("Browser is opened");
	}

	@Test(dataProvider = "accountData")
	public void loginTesting(String username, String password) throws IOException {
		driver.get(prop.getProperty("url"));
		logger.info("Go to QAClick Academy website");

		LandingPage landingPage = new LandingPage(driver);

		logger.debug("Click on Login button");
		landingPage.getLoginBtn().click();

		LoginPage loginPage = new LoginPage(driver);
		logger.info("Redirect to Log In page");

		logger.debug("Input username");
		loginPage.email.sendKeys(username);
		logger.debug("Input password");
		loginPage.password.sendKeys(password);
		logger.debug("Click on Log in button");
		loginPage.logInBtn.click();
		
		LearningPage learningPage = new LearningPage(driver);
		Assert.assertTrue(learningPage.getSearchBox().isDisplayed());
		
	}

	@DataProvider(name = "accountData")
	public Object[][] dataProvider() {
		return new Object[][] { { "test99@gmail.com", "123456" }, { "trannhuvinhloc@gmail.com", "vinhloc7" } };
	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
