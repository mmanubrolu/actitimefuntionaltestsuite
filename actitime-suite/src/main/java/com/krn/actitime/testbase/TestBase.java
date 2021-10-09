package com.krn.actitime.testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.krn.actitime.util.Util;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;

	public TestBase() {

		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream(
					"C:\\Users\\malli\\workspace\\actitimeproject\\actitimefuntionaltestsuite\\actitime-suite\\src\\test\\resource\\com\\krn\\actitime\\config\\config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void initilization() {
		String browser = prop.getProperty("chromeBrowser");
		if (!browser.isEmpty()) {
			if (browser.equals("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						"C:\\Users\\malli\\workspace\\actitimeproject\\actitimefuntionaltestsuite\\actitime-suite\\drivers\\chromedriver.exe");
				driver = new ChromeDriver();
			}

			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(Util.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(Util.IMPLICIT_LOAD_TIMEOUT, TimeUnit.SECONDS);
			driver.get(prop.getProperty("url"));
		} else {

			Assert.assertTrue(false, "Not able to load the browser ");

		}

	}
}
