package lemonade.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import lemonade.utils.AppLibrary;

public class BuyInsurancePage {

	WebDriver driver;
	
	public static String introPageHeader = "//h3[text()=\"Hey! I'm Maya. I'll get you an awesome price in seconds. Ready to go?\"]";
	public static String firstName = "//input[@name='user_first_name']";
	public static String lastName = "//input[@name='user_last_name']";
	public static String letsDothisButton = "//a[text()=\"Let's do this\"]";
	
	public static String addressPageHeader = "//h3[text()=\"Great to meet you firstName! What's your home address?\"]";
	public static String addressInput = "//input[@name='place_id']";
	public static String geoSuggest = "(//ul[@class='geosuggest__suggests']//li)[1]";
	public static String helpyourNameLabel = "//div[text()='Your name']";
	public static String apartmentInput = "//input[contains(@class,'input-apt')]";
	public static String nextButton = "//a[text()='Next']";
	
	public static String rentOrOwnPageHeader = "//h3[text()='Do you rent or own it?']";
	public static String renterOption = "//label[input[@value='renter']]";
	public static String ownerOption = "//label[input[@value='owner']]";
	
	
	public static String doYouHavePageHeader = "//h3[text()='Do you have any of the following?']";
	public static String roommates = "//label[input[@name='roommates']]";
	public static String fireAlarm = "//label[input[@name='local_fire_alarm']]";
	public static String burglarAlarm = "//label[input[@name='local_burglar_alarm']]";

	public static String jwelleryPageHeader = "//h3[contains(text(),'jewelry')]";
	public static String jwelleryYes = "//label[input[@name='expensive_items'][@value='true']]";
	public static String jwelleryNo = "//label[input[@name='expensive_items'][@value='false']]";
	
	public static String doYouHaveIsuarancePageHeader = "//h3[text()='Do you currently have an active renters insurance policy?']";
	public static String insuredYes = "//label[input[@name='currently_insured'][@value='true']]";
	public static String insuredNo = "//label[input[@name='currently_insured'][@value='false']]";
	
	public static String quotePageHeader = "//h3[text()=\"Alright! Let's get you a quote\"]";
	public static String userEmail = "//input[@name='user_email']";
	public static String dobMonth = "//input[@name='birth_month']";
	public static String dobDate = "//input[@name='birth_day']";
	public static String dobYear = "//input[@name='birth_year']";
	public static String termsAndServiceInput = "//label[input[@name='terms_of_service_approved']]";
	
	public static String insurancePageHeader = "//h1[text()='HEADER']";
	public static String priceContainer = "//div[@class='price-container']";
	public static String priceBox = "//span[@id='gtm_quotepage_pricebox']";
	public static String priceValue = "//em[@data-decimal='.00'][contains(text(),'$PRICE')]";
	public static String perMonth = "//small[text()='Per month']";
	public static String payButton = "//a[@id='gtm_button_pay_main']";
	
	public static String paymentPopup = "//div[@class='lightbox-content']";
	public static String paymentPopupCancel = "//div[@class='lightbox-content']//i[@class='btn-close']";
	
	public BuyInsurancePage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public BuyInsurancePage enterNames(String firstNameVal, String lastNameVal) {
		AppLibrary.FindElement(driver, introPageHeader);
		AppLibrary.enterText(driver, firstName, firstNameVal);
		AppLibrary.enterText(driver, lastName, lastNameVal);
		AppLibrary.FindElement(driver, letsDothisButton).click();
		return new BuyInsurancePage(driver);
	}

	public BuyInsurancePage enterAddress(String addressVal, String apartmentVal, String firstNameVal) {
		
		AppLibrary.FindElement(driver, addressPageHeader.replace("firstName", firstNameVal));
		AppLibrary.sleep(3000);
		AppLibrary.FindElement(driver, addressInput).click();
		AppLibrary.sleep(3000);
		AppLibrary.FindElement(driver, addressInput).sendKeys(addressVal);
		AppLibrary.sleep(3000);
		
		WebElement icon = AppLibrary.FindElement(driver, addressInput);
		Actions ob = new Actions(driver);
		ob.moveToElement(icon);
		ob.click(icon);
		Action action  = ob.build();
		action.perform();
		
		AppLibrary.FindElement(driver, geoSuggest).click();
		AppLibrary.enterText(driver, apartmentInput, apartmentVal);
		AppLibrary.FindElement(driver, nextButton).click();
		return new BuyInsurancePage(driver);
	}

	public BuyInsurancePage rentOrOwn(String rentOROwn) {
		AppLibrary.FindElement(driver, rentOrOwnPageHeader);
		if(rentOROwn.equalsIgnoreCase("rent")){
			AppLibrary.FindElement(driver, renterOption).click();
		}else{
			AppLibrary.FindElement(driver, ownerOption).click();
		}
		
		AppLibrary.FindElement(driver, nextButton).click();
		return new BuyInsurancePage(driver);
	}

	public BuyInsurancePage fillDoYouHave(boolean roommate, boolean firealarm, boolean burglaralarm) {
		
		AppLibrary.FindElement(driver, doYouHavePageHeader);
		if(roommate){
			AppLibrary.FindElement(driver, roommates).click();
		}
		
		if(firealarm){
			AppLibrary.FindElement(driver, fireAlarm).click();
		}
		
		if(burglaralarm){
			AppLibrary.FindElement(driver, burglarAlarm).click();
		}
		
		AppLibrary.FindElement(driver, nextButton).click();
		return new BuyInsurancePage(driver);
	}

	public BuyInsurancePage fillJewelllery(boolean jewellery) {
		
		AppLibrary.FindElement(driver, jwelleryPageHeader);
		if(jewellery){
			AppLibrary.FindElement(driver, jwelleryYes).click();
		}else{
			AppLibrary.FindElement(driver, jwelleryNo).click();
		}
		
		AppLibrary.FindElement(driver, nextButton).click();
		return new BuyInsurancePage(driver);
	}

	public BuyInsurancePage fillExistingInsurance(boolean existingInsurance) {
		
		AppLibrary.FindElement(driver, doYouHaveIsuarancePageHeader);
		if(existingInsurance){
			AppLibrary.FindElement(driver, insuredYes).click();
		}else{
			AppLibrary.FindElement(driver, insuredNo).click();
		}
		
		AppLibrary.FindElement(driver, nextButton).click();
		return new BuyInsurancePage(driver);
	}

	public BuyInsurancePage fillGetQuotePage(String email, String dobM, String dobD, String dobY) {

		AppLibrary.FindElement(driver, quotePageHeader);
		AppLibrary.enterText(driver, userEmail, email);
		AppLibrary.enterText(driver, dobMonth, dobM);
		AppLibrary.enterText(driver, dobDate, dobD);
		AppLibrary.enterText(driver, dobYear, dobY);
		AppLibrary.FindElement(driver, termsAndServiceInput).click();
		AppLibrary.sleep(1000);
		AppLibrary.FindElement(driver, nextButton).click();
		return new BuyInsurancePage(driver);
	}

	public void verifyQuote(String pageHeaderVal, String price) {
		AppLibrary.sleep(10000);
		AppLibrary.FindElement(driver, insurancePageHeader.replace("HEADER", pageHeaderVal));
		AppLibrary.FindElement(driver, priceContainer);
		AppLibrary.FindElement(driver, priceBox);
		AppLibrary.FindElement(driver, priceValue.replace("PRICE", price));
		AppLibrary.FindElement(driver, perMonth);
		AppLibrary.FindElement(driver, payButton).click();
		
		AppLibrary.FindElement(driver, paymentPopup);
		AppLibrary.sleep(4000);
		AppLibrary.FindElement(driver, paymentPopupCancel).click();
	}
	
	

}
