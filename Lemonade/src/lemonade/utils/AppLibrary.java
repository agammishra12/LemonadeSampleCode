package lemonade.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Reporter;

public class AppLibrary {
	public WebDriver driver;

	public static String getProp(String propertyName) {

		Properties prop = new Properties();
		InputStream input = null;

		try {

			input = new FileInputStream("config.properties");

			// load a properties file
			prop.load(input);

			// get the property value
			return (prop.getProperty(propertyName));

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;

	}

	public WebDriver launchBrowser(String testName) throws Exception {
		DesiredCapabilities caps = new DesiredCapabilities();
		String browser = getProp("browser.name");

		if (getProp("isbrowserstack.execution").equalsIgnoreCase("true")) {

			String os = getProp("browserstack.os");
			String osVersion = getProp("browserstack.osversion");

			if (browser.equalsIgnoreCase("chrome")) {
				caps.setCapability("browser", "Chrome");
			} else if (browser.equalsIgnoreCase("firefox")) {
				caps.setCapability("browser", "Firefox");
			} else if (browser.equalsIgnoreCase("IE")) {
				caps.setCapability("browser", "IE");
			} else {
				caps.setCapability("browser", "Safari");
			}

			if (osVersion != null && !(browser.equalsIgnoreCase("android"))) {
				caps.setCapability("os", os);
				if (os.toLowerCase().startsWith("win")) {
					caps.setCapability("os", "Windows");
				} else if (os.toLowerCase().startsWith("mac-") || os.toLowerCase().startsWith("os x-")) {
					caps.setCapability("os", "OS X");
				}

				caps.setCapability("resolution", "1920x1080");
				caps.setCapability("browserstack.debug", "true");

				caps.setCapability("build", System.getProperty("Build"));
				caps.setCapability("project", System.getProperty("Suite"));
				caps.setCapability("name", testName);

				try {
					driver = new RemoteWebDriver(new URL("http://" + getProp("browserstack.username") + ":"
							+ getProp("browserstack.authkey") + "@hub.browserstack.com/wd/hub"), caps);
					((RemoteWebDriver) driver).setFileDetector(new LocalFileDetector());
				} catch (Exception e) {
					Reporter.log("Issue creating new driver instance due to following error: " + e.getMessage() + "\n"
							+ e.getStackTrace(), true);
					throw e;
				}

			}
		} else {
			switch (browser) {
			case "chrome":
				System.setProperty("webdriver.chrome.driver", getProp("chromeDriverPath"));
				driver = new ChromeDriver();
				break;

			case "firefox":
				DesiredCapabilities cap = DesiredCapabilities.firefox();
				cap.setCapability("marionette", true);
				driver = new FirefoxDriver(cap);
				break;

			default:
				System.setProperty("webdriver.chrome.driver", getProp("chromeDriverPath"));
				driver = new ChromeDriver();
				break;
			}
		}
		return driver;

	}

	public void launchApp() {
		// Delete cookies and Launch the Application
		driver.manage().deleteAllCookies();

		driver.get(getProp("url"));

		// Maximize the browser
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

	public static WebElement FindElement(WebDriver driver, String locator) {
		System.out.println("Finding element - " + locator);
		return driver.findElement(By.xpath(locator));
	}

	public static int randInt() {
		int min = 20;
		int max = 32000;
		Random rand = new Random();
		int randomNum = (rand.nextInt((max - min) + 1) + rand.nextInt((max - min) + 1)) / 2;
		return randomNum;
	}

	public static void enterText(WebDriver driver, String locator, String text) {

		AppLibrary.FindElement(driver, locator).click();
		AppLibrary.FindElement(driver, locator).clear();
		AppLibrary.sleep(100);
		AppLibrary.FindElement(driver, locator).sendKeys(text);

		if (text.contains(Keys.TAB)) {
			new Actions(driver).sendKeys(Keys.TAB).perform();
		}
	}

	public static void sleep(long milliSeconds) {
		try {
			Thread.sleep(milliSeconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
