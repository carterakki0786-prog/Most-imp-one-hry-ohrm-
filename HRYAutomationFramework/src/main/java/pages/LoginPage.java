package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

	// Locators
	private By usernameTextbox = By.name("username");
	private By passwordTextbox = By.name("password");
	private By loginButton = By.xpath("//button[@type='submit']");

	// Constructor
	public LoginPage(WebDriver driver) {
		super(driver);
	}

	// Actions
	public void enterUsername(String username) {
		type(usernameTextbox, username);

	}

	public void enterPassword(String password) {
		type(passwordTextbox, password);

	}

	public void clickLogin() {
		click(loginButton);

	}

	public void login(String username, String password) {
		enterUsername(username);
		enterPassword(password);
		clickLogin();

	}

	public boolean isLoginButtonDisplayed() {
		return isDisplayed(loginButton);

	}

}
