package com.qaclick.FinalProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import PageObject.LandingPage;

public class LandingValidateText extends BaseClass {
	
	private static final Logger logger = LogManager.getLogger(LandingValidateText.class.getName());

	LandingPage landingPage;
	@BeforeClass
	public void initiation() throws IOException {
		openBrowser();
		logger.info("Browser is opened");
		driver.get(prop.getProperty("url"));
		logger.info("Go to QA Click Academy");
	}

	@Test
	public void validateText() {
		landingPage = new LandingPage(driver);
		
		Assert.assertEquals(landingPage.getBigText().getText(), "FEATURED COURSES");
		logger.error("Big text is not displayed correctly");
	}
	
	@Test
	public void validateHeader() {
		landingPage = new LandingPage(driver);
		Assert.assertEquals(landingPage.getHeader().getText(), "An Academy to learn Everything about Testing");
		logger.error("Header text is not displayed correctly");
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
		logger.info("Close browser");
	}

}
