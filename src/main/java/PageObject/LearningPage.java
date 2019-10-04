package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LearningPage {

	private WebDriver driver;

	public LearningPage(WebDriver driver) {
		this.driver = driver;
	}

	private By searchBox = By.id("search-courses");

	public WebElement getSearchBox() {
		return driver.findElement(searchBox);
	}

}
