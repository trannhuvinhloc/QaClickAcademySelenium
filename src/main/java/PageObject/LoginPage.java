package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "user_email")
	public WebElement email;

	@FindBy(id = "user_password")
	public WebElement password;

	@FindBy(name = "commit")
	public WebElement logInBtn;

}
