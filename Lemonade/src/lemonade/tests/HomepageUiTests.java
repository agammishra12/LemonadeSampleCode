package lemonade.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import lemonade.pages.Footer;
import lemonade.pages.Header;
import lemonade.pages.HomePage;
import lemonade.utils.AppLibrary;

public class HomepageUiTests {
	
	WebDriver driver;

	@Test
	public void homePageUiTest() throws Exception{
		AppLibrary al = new AppLibrary();
		driver = al.launchBrowser("homePageUiTest");
		al.launchApp();
		new Header(driver).verifyHeadersLinksUi();
		new Footer(driver).verifyfooterLinksUi();
		new HomePage(driver).verifyPageContentUi();
		new HomePage(driver).verifyHelpUi();		
	}



	@AfterMethod
	public void afterMethod() {
		driver.close();
		driver.quit();
	}

}



