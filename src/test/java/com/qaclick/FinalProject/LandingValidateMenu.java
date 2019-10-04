package com.qaclick.FinalProject;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import PageObject.LandingPage;

public class LandingValidateMenu extends BaseClass {

	private static final Logger logger = LogManager.getLogger(LandingValidateMenu.class.getName());

	@BeforeClass
	public void initiation() throws IOException {
		openBrowser();
		logger.info("Open browser");
		driver.get(prop.getProperty("url"));
		logger.info("Go to QA CLick Academy success");
	}

	@Test
	public void validateMenu() {
		LandingPage landingPage = new LandingPage(driver);

		Assert.assertTrue(landingPage.getMenu().isDisplayed());
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
		logger.info("Close browser");
	}

}
