package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	private static Properties properties = new Properties();

	static {
		try {
			FileInputStream fis = new FileInputStream("src/test/resource/config/congig.properties");
			properties.load(fis);
			System.out.println(properties);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static String getProperty(String key) {
		return properties.getProperty(key);

	}

}

