package lemonade.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import lemonade.pages.BuyInsurancePage;
import lemonade.pages.HomePage;
import lemonade.utils.AppLibrary;

public class BasicRentererInsuranceTest {

	WebDriver driver;

	@Test
	public void BasicRentererInsurance() throws Exception {
		AppLibrary al = new AppLibrary();
		driver = al.launchBrowser("BasicRentererInsurance");
		al.launchApp();

		String rand = AppLibrary.randInt() + "";

		BuyInsurancePage bip = new BuyInsurancePage(driver);

		AppLibrary.FindElement(driver, HomePage.CheckOurPrices).click();

		bip.enterNames("FN" + rand, "LN" + rand)
				.enterAddress("411 Grand Street, New York, NY, United States", "1408", "Fn" + rand).rentOrOwn("rent")
				.fillDoYouHave(true, true, true).fillJewelllery(true).fillExistingInsurance(true)
				.fillGetQuotePage("FN" + rand + "@mailinator.com", "12", "12", "1986")
				.verifyQuote("Lemonade Renters Insurance", "5");

	}

	@AfterMethod
	public void afterMethod() {
		driver.close();
		driver.quit();
	}

}
