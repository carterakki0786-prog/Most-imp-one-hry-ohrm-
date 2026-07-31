package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class DashboardPage extends BasePage {
	private By dashboardHeading = By.xpath("//h6[text()='Dashboard']");

	public DashboardPage(WebDriver driver) {
		super(driver);

	}

	public boolean isDashboardDisplayed() {
		return isDisplayed(dashboardHeading);

	}

	private By profileMenu = By.className("oxd-userdropdown-name");

	public void clickProfileMenu() {
		click(profileMenu);

	}

	private By logoutButton = By.xpath("//a[text()='Logout']");

	public void clickLogoutButton() {
		click(logoutButton);
	}

	public void logout() {
		clickProfileMenu();
		clickLogoutButton();

	}
}
