package com.qaclick.FinalProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {

	public static WebDriver driver;
	public Properties prop;

	public void openBrowser() throws IOException {
		FileInputStream fis = new FileInputStream("src/main/java/resources/DataDriven.properties");
		prop = new Properties();
		prop.load(fis);

		String browserName = prop.getProperty("browser");
		System.getProperty("user.dir");

		// String browserName = System.getProperty("browser");
		if (browserName.contains("chrome")) {
			System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
			ChromeOptions option = new ChromeOptions();

			if (browserName.contains("headless")) {
				option.addArguments("headless");
				driver = new ChromeDriver(option);
			} else
				driver = new ChromeDriver();

		} else if (browserName.contentEquals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "driver/geckodriver.exe");
			driver = new FirefoxDriver();
		}

		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	public void getScreenShot(String result) throws IOException {
		File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(f, new File("D://Evidence//" + result + "_Fail.png"));
	}

}
