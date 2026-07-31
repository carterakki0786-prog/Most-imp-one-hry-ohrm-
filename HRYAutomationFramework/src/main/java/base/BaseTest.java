package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import utilities.ConfigReader;
import java.time.Duration;

public class BaseTest {
	protected static WebDriver driver;
	public static WebDriver getDriver() {
	    return driver;
	}

	@BeforeMethod
	public void setup() {
		String browser = ConfigReader.getProperty("browser");

		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else {
			throw new IllegalArgumentException("Unsupported browser" + browser);
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(ConfigReader.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			driver.quit();

		}

	}
}
