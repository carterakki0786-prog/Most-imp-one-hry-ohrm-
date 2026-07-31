package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.WaitUtils;

public class BasePage {
	protected WebDriver driver;

	public BasePage(WebDriver driver) {
		this.driver = driver;

	}

	protected void clear(By locator) {
		WaitUtils.waitForVisibility(driver, locator, 10);
		driver.findElement(locator).clear();
	}

	protected void click(By locator) {
		WaitUtils.waitForVisibility(driver, locator, 10);
		driver.findElement(locator).click();

	}

	protected void type(By locator, String text) {
		clear(locator);
		driver.findElement(locator).sendKeys(text);

	}

	protected boolean isDisplayed(By locator) {
		WaitUtils.waitForVisibility(driver, locator, 10);
		return driver.findElement(locator).isDisplayed();

	}

	protected String getText(By locator) {
		WaitUtils.waitForVisibility(driver, locator, 10);
		return driver.findElement(locator).getText();

	}
}
