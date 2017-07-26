package lemonade.pages;

import org.openqa.selenium.WebDriver;

import lemonade.utils.AppLibrary;

public class HomePage {

	WebDriver driver;
	
	public static String helpButtonIframe = "//iframe[@id='launcher']";
	public static String helpIframe = "//iframe[@id='ticketSubmissionForm']";
	public static String helpLabel = "//div[@id='Embed']";
	public static String helpcrossButton = "//div[@class='Button Button--nav u-posAbsolute u-posStart--vertFlush u-posEnd--flush u-paddingR ']";
	public static String helpleaveUsAMessageLabel = "//div[text()='Leave us a message']";
	public static String helpyourNameLabel = "//div[text()='Your name']";
	public static String helpYourNameBox = "//input[@name='name']";
	public static String helpEmailAddressLabel = "//div[text()='Email address']";
	public static String helpEmailAddressBox = "//input[@type='email']";
	public static String helpHowCanWeHelpYouLabel = "//div[text()='How can we help you?']";
	public static String helpHowCanWeHelpYouBox = "//div[@class='Form-field u-isSelectable u-posRelative']//textarea[@name='description']";
	public static String helpAttachmentLabel = "//label[text()='Attachments']";
	public static String helpAddFileOrDropHereLabel = "//div[text()='Add file or drop here']";
	public static String helpCancelButton = "//div[text()='Cancel']";
	public static String helpSubmitButton = "//input[@type='submit']";

	public static String CheckOurPrices = "//a[@id='gtm_button_main_check_prices']";
	public static String forgetEverythingYouKnowAboutInsuranceLabel = "//div[@class='inner']//h1[text()='Forget Everything You Know About Insurance']";
	public static String InstantEverythingKillerPricesBigHeartLabel = "//div[@class='inner']//p[text()='Instant everything. Killer prices. Big heart.']";
	public static String watchTheVideoLink = "//a[@id='gtm_link_watch_the_video_above_the_fold']";
	public static String clientsBanner = "//div[@class='in-the-press']";
	public static String RentersAndHomeInsuranceForUrbanDwellersLabel = "//div[@class='inner']//h2[text()='Renters and Home Insurance For Urban Dwellers']";
	public static String LemonadesAmazingCoverageProtectsLabel = "//section[@class='hp-section section-2 js-section-2']//div[@class='inner']//p";
	public static String instantEverythingLabel = "//h2[text()='Instant everything']";
	public static String mayaOurCharmingArtificialLabel = "//section[@class='hp-section section-3 js-section-3']//div[@class='inner']//p";
	public static String seeLamonadeAppInActionLink = "//a[@id='gtm_link_watch_the_video_instant_everything']";
	public static String killerPricesMonthlySubscriptionLabel = "//section[@class='hp-section section-4']//div[@class='inner']//h2";
	public static String renterInsuranceLabel = "//h3[text()='Renters Insurance']";
	public static String monthlyFromLabel = "(//ul[@class='list-insurance']//li//small[text()='Monthly, from'])[1]";
	public static String $5Label = "//ul[@class='list-insurance']//li//em[text()='$5']";
	public static String getRenterInsuranceLabel = "//a[text()='Get renters insurance']";
	public static String HomeownersInsuranceLabel = "//h3[text()='Homeowners Insurance']";
	public static String $25Label = "(//ul[@class='list-insurance']//li//small[text()='Monthly, from'])[2]";
	public static String getHomeinsuranceLabel = "//a[text()='Get home insurance']";
	public static String alreadyInsuredLabel = "//strong[text()='Already insured?']";
	public static String alreadyInsuredWellTakeCareOfTheSwitchingHassleLabel = "//div[@class='inner']//span";
	public static String alreadyInsuredSwitchToLemonadeInstantlyLabel = "//h2[text()='Already Insured? Switch To Lemonade Instantly']";
	public static String peopleLeftTheseInsuranceCompaniesToJoinLemonadeLabel = "//p[text()='People left these insurance companies to join Lemonade']";
	public static String checkPricesAndSwitchLink = "//a[text()='check prices and switch']";
	public static String howLemonadeWorksLabel = "//h2[text()='How Lemonade Works']";
	public static String LemonadeReversesLabel = "(//section[@class='hp-section section-5']//div[@class='inner']//p)[1]";
	public static String TheScienceBehindLemonadeLink = "//a[@id='gtm_link_watch_science_video']";
	public static String SubjectToBoardDiscretionLabel = "(//section[@class='hp-section section-5']//div[@class='inner']//p)[2]";
	public static String DesignedforSocialImpactLabel = "//section[@class='hp-section section-6']//div[@class='inner']//h4[text()='Designed for Social Impact']";
	public static String LemonadeIncIsAPublicLabel = "(//section[@class='hp-section section-6']//div[@class='inner']//p)[1]";
	public static String ARatedAndBackedByGiantsLabel = "//section[@class='hp-section section-6']//div[@class='inner']//h4[text()='A-rated and backed by giants']";
	public static String LemonadeIsRatedAExceptionalLabel = "(//section[@class='hp-section section-6']//div[@class='inner']//p)[2]";

	
	public HomePage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	public void verifyHelpUi() {
		driver.switchTo().frame(AppLibrary.FindElement(driver, helpButtonIframe));
		AppLibrary.FindElement(driver, helpLabel).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame(AppLibrary.FindElement(driver, helpIframe));
		AppLibrary.FindElement(driver, helpcrossButton);
		AppLibrary.FindElement(driver, helpleaveUsAMessageLabel);
		AppLibrary.FindElement(driver, helpyourNameLabel);
		AppLibrary.FindElement(driver, helpYourNameBox);
		AppLibrary.FindElement(driver, helpEmailAddressLabel);
		AppLibrary.FindElement(driver, helpEmailAddressBox);
		AppLibrary.FindElement(driver, helpHowCanWeHelpYouLabel);
		AppLibrary.FindElement(driver, helpHowCanWeHelpYouBox);
		AppLibrary.FindElement(driver, helpAttachmentLabel);
		AppLibrary.FindElement(driver, helpAddFileOrDropHereLabel);
		AppLibrary.FindElement(driver, helpCancelButton);
		AppLibrary.FindElement(driver, helpSubmitButton);
		AppLibrary.FindElement(driver, helpcrossButton).click();
		driver.switchTo().defaultContent();
	}

	public void verifyPageContentUi() {
		AppLibrary.FindElement(driver, CheckOurPrices);
		AppLibrary.FindElement(driver, forgetEverythingYouKnowAboutInsuranceLabel);
		AppLibrary.FindElement(driver, InstantEverythingKillerPricesBigHeartLabel);
		AppLibrary.FindElement(driver, watchTheVideoLink);
		AppLibrary.FindElement(driver, clientsBanner);
		AppLibrary.FindElement(driver, RentersAndHomeInsuranceForUrbanDwellersLabel);
		AppLibrary.FindElement(driver, LemonadesAmazingCoverageProtectsLabel);
		AppLibrary.FindElement(driver, instantEverythingLabel);
		AppLibrary.FindElement(driver, mayaOurCharmingArtificialLabel);
		AppLibrary.FindElement(driver, seeLamonadeAppInActionLink);
		AppLibrary.FindElement(driver, killerPricesMonthlySubscriptionLabel);
		AppLibrary.FindElement(driver, renterInsuranceLabel);
		AppLibrary.FindElement(driver, monthlyFromLabel);
		AppLibrary.FindElement(driver, $5Label);
		AppLibrary.FindElement(driver, getRenterInsuranceLabel);
		AppLibrary.FindElement(driver, HomeownersInsuranceLabel);
		AppLibrary.FindElement(driver, $25Label);
		AppLibrary.FindElement(driver, getHomeinsuranceLabel);
		AppLibrary.FindElement(driver, alreadyInsuredLabel);
		AppLibrary.FindElement(driver, alreadyInsuredWellTakeCareOfTheSwitchingHassleLabel);
		AppLibrary.FindElement(driver, alreadyInsuredSwitchToLemonadeInstantlyLabel);
		AppLibrary.FindElement(driver, peopleLeftTheseInsuranceCompaniesToJoinLemonadeLabel);
		AppLibrary.FindElement(driver, checkPricesAndSwitchLink);
		AppLibrary.FindElement(driver, howLemonadeWorksLabel);
		AppLibrary.FindElement(driver, LemonadeReversesLabel);
		AppLibrary.FindElement(driver, TheScienceBehindLemonadeLink);
		AppLibrary.FindElement(driver, SubjectToBoardDiscretionLabel);
		AppLibrary.FindElement(driver, DesignedforSocialImpactLabel);
		AppLibrary.FindElement(driver, LemonadeIncIsAPublicLabel);
		AppLibrary.FindElement(driver, ARatedAndBackedByGiantsLabel);
		AppLibrary.FindElement(driver, LemonadeIsRatedAExceptionalLabel);

	}

}
