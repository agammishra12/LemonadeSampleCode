package lemonade.pages;

import org.openqa.selenium.WebDriver;

import lemonade.utils.AppLibrary;

public class Header {
	
	WebDriver driver;
	
	public static String fundraise = "//ul[@class='header-menu']//a[@id='gtm_menu_fundraise']";
	public static String faq = "//ul[@class='header-menu']//a[text()='FAQ']";
	public static String blog = "//ul[@class='header-menu']//a[text()='Blog']";
	public static String lemonadeLabel = "(//div[@class='main-header']//a[@id='gtm_top_logo'])[2]";
	
	public Header(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	public void verifyHeadersLinksUi() {
		AppLibrary.FindElement(driver, fundraise);
		AppLibrary.FindElement(driver, faq);
		AppLibrary.FindElement(driver, blog);
		AppLibrary.FindElement(driver, lemonadeLabel);

	}

}
