package lemonade.pages;

import org.openqa.selenium.WebDriver;

import lemonade.utils.AppLibrary;

public class Footer {
	
	WebDriver driver;
	
	public static String termsAndCondition = "//a[text()='Terms Of Service']";
	public static String privacyPolicy = "//a[text()='Privacy Policy']";
	public static String legalStuff = "//a[text()='Legal Stuff']";
	public static String lemonadeNationwide = "//a[text()='Lemonade Nationwide']";
	public static String lemonadeInsuranceAgency = "//p[@class='legal']";
	public static String facebookIcon = "//footer[@class='main-footer']//ul[@class='social-links-round']//a[@class='fb js-track-event']";
	public static String instagramIcon = "//footer[@class='main-footer']//ul[@class='social-links-round']//a[@class='instagram js-track-event']";
	public static String twitterIcon = "//footer[@class='main-footer']//ul[@class='social-links-round']//a[@class='twitter js-track-event']";

	public Footer(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	public void verifyfooterLinksUi() {
		AppLibrary.FindElement(driver, termsAndCondition);
		AppLibrary.FindElement(driver, privacyPolicy);
		AppLibrary.FindElement(driver, legalStuff);
		AppLibrary.FindElement(driver, lemonadeNationwide);
		AppLibrary.FindElement(driver, lemonadeInsuranceAgency);
		AppLibrary.FindElement(driver, facebookIcon);
		AppLibrary.FindElement(driver, instagramIcon);
		AppLibrary.FindElement(driver, twitterIcon);
	}

}
