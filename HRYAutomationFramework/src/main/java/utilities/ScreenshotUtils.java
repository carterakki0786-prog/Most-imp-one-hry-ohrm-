package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtils {

	public static String captureScreenshot(WebDriver driver, String testName) {

		// Convert WebDriver to TakesScreenshot
		TakesScreenshot ts = (TakesScreenshot) driver;

		// Capture screenshot into a temporary file
		File sourceFile = ts.getScreenshotAs(OutputType.FILE);

		// Generate unique timestamp
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

		// Create Screenshots folder if it doesn't exist
		File folder = new File("test-output/Screenshots");
		if (!folder.exists()) {
			folder.mkdirs();
		}

		// Create unique file name
		String fileName = testName + "_" + timeStamp + ".png";

		// Final destination of the screenshot
		File destinationFile = new File("test-output/Screenshots/" + fileName);

		try {

			// Copy screenshot from temporary location to project folder
			FileUtils.copyFile(sourceFile, destinationFile);

		} catch (IOException e) {

			e.printStackTrace();

		}

		// Return relative path
		return "Screenshots/" + fileName;

	}

}