package PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	private WebDriver driver;

	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}

	private By LoginBtn = By.xpath("//a[contains(@href,'sign_in')]");
	private By BigText = By.xpath("//div[@class='text-center']/h2");
	private By Menu = By.xpath("//ul[@class='nav navbar-nav navbar-right']/li/a");
	private By header = By.xpath("//div[contains(@class,'video-banner')]/h3");
	private By closePopupBtn = By.xpath("//button[text()='No THANKS']");

	public WebElement getLoginBtn() {
		return driver.findElement(LoginBtn);
	}

	public WebElement getBigText() {
		return driver.findElement(BigText);
	}

	public WebElement getMenu() {
		return driver.findElement(Menu);
	}

	public WebElement getHeader() {
		return driver.findElement(header);
	}

	public List<WebElement> getPopup() {
		return driver.findElements(closePopupBtn);
	}
	
	public WebElement getClosePopupBtn() {
		return driver.findElement(closePopupBtn);
	}

	

}
